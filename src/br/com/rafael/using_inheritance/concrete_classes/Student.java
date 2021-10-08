package br.com.rafael.using_inheritance.concrete_classes;

import br.com.rafael.using_inheritance.abstract_class.RegisteredPerson;

import java.time.LocalDate;

public class Student extends RegisteredPerson {
    private boolean takingSeminar;

    public Student(String name, String registration) {
        super(name, registration);
    }

    public Student(String name, String registration, LocalDate dateOfBirth) {
        super(name, registration, dateOfBirth);
    }

    public boolean isTakingSeminar(){
        return this.takingSeminar;
    }

    public void setTakingSeminar(boolean newBoolValue) {
        this.takingSeminar = newBoolValue;
    }

    @Override
    public String toString(){
        return super.toString().substring(0, super.toString().length()) + String.format(", \"takingSeminar\":\"%b\"}",this.takingSeminar);
    }
}
