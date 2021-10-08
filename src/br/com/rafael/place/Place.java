package br.com.rafael.place;

public class Place {
    private Address address;
    private int capacity;
    private boolean reserved;

    public Place(Address address, int capacity) {
        this.address = address;
        this.capacity = capacity;
    }

    //Getters and setters
    public Address getAddress() {
        return this.address;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public boolean isReserved() {
        return this.reserved;
    }

    public void setAddress(Address newAddress) throws IllegalArgumentException {
        if (newAddress == null) throw new IllegalArgumentException("Illegal Argument!");
        this.address = newAddress;
    }

    public void setCapacity(int newCapacity) throws IllegalArgumentException {
        if (newCapacity <= 0) throw new IllegalArgumentException("Illegal Argument!");
        this.capacity = newCapacity;
    }

    @Override
    public String toString() {
        return "{" + this.address.toString().substring(0, this.address.toString().length()) + ", \"capacity\": \"" + this.capacity + "\"}";
    }

    public void setReserved(boolean newBoolValue) {
        this.reserved = newBoolValue;
    }
}
