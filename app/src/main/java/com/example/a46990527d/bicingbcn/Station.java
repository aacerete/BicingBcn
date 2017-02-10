package com.example.a46990527d.bicingbcn;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 46990527d on 31/01/17.
 */

public class Station
{

    private int id;
    private String type;
    private double latitude;
    private double longitude;
    private String streetName;
    private String streetNumber;
    private double altitude;
    private int slots;
    private int bikes;
    private String nearbyStations;
    private String status;
    private boolean electric;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 2731682053254378586L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Station() {
    }

    /**
     *
     * @param id
     * @param status
     * @param bikes
     * @param nearbyStations
     * @param slots
     * @param altitude
     * @param streetNumber
     * @param streetName
     * @param longitude
     * @param latitude
     * @param type
     */
    public Station(int id, String type, double latitude, double longitude, String streetName, String streetNumber, double altitude, int slots, int bikes, String nearbyStations, String status) {
        super();
        this.id = id;
        this.type = type;
        this.latitude = latitude;
        this.longitude = longitude;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.altitude = altitude;
        this.slots = slots;
        this.bikes = bikes;
        this.nearbyStations = nearbyStations;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Station withId(int id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Station withType(String type) {
        this.type = type;
        return this;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Station withLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Station withLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Station withStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Station withStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
        return this;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public Station withAltitude(double altitude) {
        this.altitude = altitude;
        return this;
    }

    public int getSlots() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots = slots;
    }

    public Station withSlots(int slots) {
        this.slots = slots;
        return this;
    }

    public int getBikes() {
        return bikes;
    }

    public void setBikes(int bikes) {
        this.bikes = bikes;
    }

    public Station withBikes(int bikes) {
        this.bikes = bikes;
        return this;
    }

    public String getNearbyStations() {
        return nearbyStations;
    }

    public void setNearbyStations(String nearbyStations) {
        this.nearbyStations = nearbyStations;
    }

    public Station withNearbyStations(String nearbyStations) {
        this.nearbyStations = nearbyStations;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Station withStatus(String status) {
        this.status = status;
        return this;
    }

    public boolean isElectric() {
        return electric;
    }

    public void setElectric(boolean electric) {
        this.electric = electric;
    }

    public double getOcupacio () {

        double ocupacio = (this.getBikes()*100/(this.getBikes()+this.getSlots()));

        return ocupacio;
    }


    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", streetName='" + streetName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", altitude=" + altitude +
                ", slots=" + slots +
                ", bikes=" + bikes +
                ", nearbyStations='" + nearbyStations + '\'' +
                ", status='" + status + '\'' +
                ", electric=" + electric +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Station withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
