package br.com.rafael.place;

import java.util.Objects;

public class Address {
    private String street, neighbourhood, city, state, country, complement;
    private int number;

    public Address(String street, String neighbourhood, String city, String state, String country) {
        this.street = street;
        this.neighbourhood = neighbourhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.complement = "without";
        this.number = 0;
    }

    public Address(String street, String neighbourhood, String city, String state, String country, String complement) {
        this.street = street;
        this.neighbourhood = neighbourhood;
        this.city = city;
        this.state = state;
        this.country = country;
        this.complement = complement;
        this.number = 0;
    }

    public Address(String street, String neighbourhood, String city, String state, String country, int number) {
        this(street, neighbourhood, city, state, country, "without");
        this.number = number;
    }

    public Address(String street, String neighbourhood, String city, String state, String country, int number, String complement) {
        this(street, neighbourhood, city, state, country, complement);
        this.number = number;
    }

    public void setStreet(String newStreet) {
        this.street = newStreet;
    }

    public void setNeighbourhood(String newNeighbourhood) {
        this.neighbourhood = newNeighbourhood;
    }

    public void setCity(String newCity) {
        this.city = newCity;
    }

    public void setState(String newState) {
        this.state = newState;
    }

    public void setCountry(String newCountry) {
        this.country = newCountry;
    }

    public void setNumber(int newNumber) {
        this.number = newNumber;
    }

    public void setComplement(String newComplement) {
        this.complement = newComplement;
    }

    @Override
    public String toString() {
        String result = String.format("{\"street\": \"%s\", \"neighbourhood\": \"%s\", \"city\": \"%s\", \"state\": \"%s\", \"country\": \"%s\", \"number\": ", this.street, this.neighbourhood, this.city, this.state, this.country);
        if (number <= 0) result += "\"without\"";
        else result += "\"" + this.number + "\"";
        result += ", \"complement\": \"" + this.complement + "\"}";
        return result;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.street, this.neighbourhood, this.city, this.state, this.country);
    }

    @Override
    public boolean equals(Object toCompare) {
        if (!(toCompare instanceof Address casted)) return false;
        return (this.toString().equals(casted.toString()));
    }
}
