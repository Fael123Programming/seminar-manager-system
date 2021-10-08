package br.com.rafael.using_composition.composite_classes;

import br.com.rafael.using_composition.composing_class.RegisteredPerson;

import java.time.LocalDate;

public class Student {
    private boolean takingSeminar;
    private final RegisteredPerson generalObject;

    public Student(String name, String registration) {
        this.generalObject = new RegisteredPerson(name, registration);
    }

    public Student(String name, String registration, LocalDate dateOfBirth) {
        this.generalObject = new RegisteredPerson(name, registration, dateOfBirth);
    }

    public String getName(){
        return this.generalObject.getName();
    }

    public String getRegistration(){
        return this.generalObject.getRegistration();
    }

    public LocalDate getDateOfBirth(){
        return this.generalObject.getDateOfBirth();
    }

    public boolean isTakingSeminar(){
        return this.takingSeminar;
    }

    public void setTakingSeminar(boolean newBoolValue) {
        this.takingSeminar = newBoolValue;
    }

    public int getAge(){
        return this.generalObject.getAge();
    }

    @Override
    public String toString(){
        return this.generalObject.toString().substring(0, this.generalObject.toString().length()) + String.format(", \"takingSeminar\":\"%b\"}",this.takingSeminar);
    }

    @Override
    public boolean equals(Object toCompare) {
        if (!(toCompare instanceof Student casted)) return false;
        return this.generalObject.equals(casted.generalObject);
    }

    @Override
    public int hashCode(){
        return this.generalObject.hashCode();
    }
}
