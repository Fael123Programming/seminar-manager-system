package br.com.rafael.using_composition.composite_classes;

import br.com.rafael.using_composition.composing_class.RegisteredPerson;

import java.time.LocalDate;
import java.util.Objects;

public class Teacher {
    private String titration;
    private final RegisteredPerson generalObject;

    public Teacher(String name, String registration, String titration) {
        this.generalObject = new RegisteredPerson(name, registration);
        this.titration = titration;
    }

    public Teacher(String name, String registration, LocalDate dateOfBirth, String titration) {
        this.generalObject = new RegisteredPerson(name, registration, dateOfBirth);
        this.titration = titration;
    }

    public String getTitration() {
        return this.titration;
    }

    public void setTitration(String newTitration) {
        this.titration = newTitration;
    }

    public int getAge(){
        return this.generalObject.getAge();
    }

    @Override
    public String toString() {
        return this.generalObject.toString().substring(0, this.generalObject.toString().length()) + String.format(", \"titration\": \"%s\"}", this.titration);
    }

    @Override
    public boolean equals(Object toCompare) {
        if (!(toCompare instanceof Teacher casted)) return false;
        return this.generalObject.equals(casted.generalObject) && this.getTitration().equals(casted.getTitration());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.generalObject.getName(), this.generalObject.getRegistration(), this.generalObject.getDateOfBirth().toString(), this.titration);
    }
}
