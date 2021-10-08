package br.com.rafael.exceptions;

public class StudentAlreadyEnrolledException extends Exception {

    public StudentAlreadyEnrolledException(){
        super("Student is already enrolled in this seminar!");
    }
}
