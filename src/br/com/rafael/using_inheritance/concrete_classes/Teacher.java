package br.com.rafael.using_inheritance.concrete_classes;

import br.com.rafael.using_inheritance.abstract_class.RegisteredPerson;

import java.time.LocalDate;
import java.util.Objects;

public class Teacher extends RegisteredPerson {
    private String titration;

    public Teacher(String name, String registration, String titration) {
        super(name, registration);
        this.titration = titration;
    }

    public Teacher(String name, String registration, LocalDate dateOfBirth, String titration) {
        super(name, registration, dateOfBirth);
        this.titration = titration;
    }

    public String getTitration() {
        return this.titration;
    }

    @Override
    public String toString() {
        return super.toString().substring(0, super.toString().length()) + String.format(", \"titration\": \"%s\"}", this.titration);
    }

    @Override
    public boolean equals(Object toCompare) {
        if (!(toCompare instanceof Teacher casted)) return false;
        return super.equals(casted) && this.getTitration().equals(casted.getTitration());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getName(), super.getRegistration(), super.getDateOfBirth().toString(), this.titration);
    }
}
