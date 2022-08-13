package com.javainuse.FR24;

public class Flights
{
    private String reg_number;
    private String flag;
    private Double lat;
    private Double lng;
    private Double alt;
    private Double dir;
    private Double speed;
    private String flight_number;
    private String status;

    public Flights()
    {

    }

    public Flights(String reg_number, String flag, Double lat, Double lng, Double alt, Double dir, Double speed, String flight_number, String status) {
        this.reg_number = reg_number;
        this.flag = flag;
        this.lat = lat;
        this.lng = lng;
        this.alt = alt;
        this.dir = dir;
        this.speed = speed;
        this.flight_number = flight_number;
        this.status = status;
    }

    public String getReg_number() {
        return reg_number;
    }

    public void setReg_number(String reg_number) {
        this.reg_number = reg_number;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getAlt() {
        return alt;
    }

    public void setAlt(Double alt) {
        this.alt = alt;
    }

    public Double getDir() {
        return dir;
    }

    public void setDir(Double dir) {
        this.dir = dir;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public String getFlight_number() {
        return flight_number;
    }

    public void setFlight_number(String flight_number) {
        this.flight_number = flight_number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
