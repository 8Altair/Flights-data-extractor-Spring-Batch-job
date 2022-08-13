package com.javainuse.FR24;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Feed_data
{
    public static void main(String[] args)
    {
        try
        {

            URL url = new URL("https://airlabs.co/api/v9/flights?api_key=10bc6efc-394b-4d9a-bac9-300f7a6f9380");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Getting the response code
            int responsecode = conn.getResponseCode();

            if (responsecode != 200)
            {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            }
            else
            {
                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext())
                {
                    inline += scanner.nextLine();
                }

                //Close the scanner
                scanner.close();

                int i = 0;
                String response = "";
                while (true)
                {
                    response += inline.charAt(i);
                    if (response.contains("\"response\":")) break;
                    i++;
                }

                inline = inline.substring(response.length());
                inline = inline.substring(0, inline.length() - 213);

                JSONArray jsonArr = new JSONArray(inline);
                List<Flights> flightsData = new ArrayList<>();

                try
                {
                    for (int j = 0; j < jsonArr.length(); j++) {
                        JSONObject jsonObj = jsonArr.getJSONObject(j);

                        Flights flight = new Flights();

//                        flight.setHex(jsonObj.getString("hex"));

                        flight.setReg_number(jsonObj.getString("reg_number"));

                        flight.setFlag(jsonObj.getString("flag"));
                        flight.setLat(jsonObj.getDouble("lat"));
                        flight.setLng(jsonObj.getDouble("lng"));
                        flight.setAlt(jsonObj.getDouble("alt"));
                        flight.setDir(jsonObj.getDouble("dir"));
                        flight.setSpeed(jsonObj.getDouble("speed"));
//                        flight.setV_speed(jsonObj.getDouble("v_speed"));
//                        flight.setSquawk(jsonObj.getString("squawk"));
                        flight.setFlight_number(jsonObj.getString("flight_number"));
//                        flight.setFlight_icao(jsonObj.getString("flight_icao"));
//                        flight.setFlight_iata(jsonObj.getString("flight_iata"));
//                        flight.setDep_icao(jsonObj.getString("dep_icao"));
//                        flight.setDep_iata(jsonObj.getString("dep_iata"));
//                        flight.setArr_icao(jsonObj.getString("arr_icao"));
//                        flight.setArr_iata(jsonObj.getString("arr_iata"));
//                        flight.setAirline_icao(jsonObj.getString("airline_icao"));
//                        flight.setAirline_iata(jsonObj.getString("airline_iata"));
//                        flight.setAircraft_icao(jsonObj.getString("aircraft_icao"));
//                        flight.setUpdated(jsonObj.getLong("updated"));
                        flight.setStatus(jsonObj.getString("status"));

                        flightsData.add(flight);
                    }
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }

                System.out.println(inline);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
