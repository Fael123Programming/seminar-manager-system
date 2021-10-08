package br.com.rafael.exceptions;

public class CrowdedPlaceException extends Exception {
    public CrowdedPlaceException() {
        super("The place is already crowded!");
    }
}
