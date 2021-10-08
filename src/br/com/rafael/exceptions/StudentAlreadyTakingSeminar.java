package br.com.rafael.exceptions;

public class StudentAlreadyTakingSeminar extends Exception {

    public StudentAlreadyTakingSeminar(){
        super("Student is already enrolled in another seminar!");
    }
}
