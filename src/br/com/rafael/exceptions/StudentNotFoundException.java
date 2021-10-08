package br.com.rafael.exceptions;

public class StudentNotFoundException extends Exception {

    public StudentNotFoundException(){
        super("Student was not found enrolled in this seminar!");
    }
}
