package br.com.rafael.seminar;

import br.com.rafael.exceptions.*;
import br.com.rafael.place.Place;
import br.com.rafael.using_inheritance.concrete_classes.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Seminar {
    private String title;
    private LocalDate date;
    private Teacher host;
    private Place place;
    private Map<String, Student> students;

    public Seminar(String title, LocalDate date, Teacher host, Place place) {
        this.title = title;
        this.date = date;
        this.host = host;
        this.place = place;
        this.students = new HashMap<>();
    }

    public void addStudent(Student newStudent) throws IllegalArgumentException, StudentAlreadyEnrolledException, StudentAlreadyTakingSeminar, CrowdedPlaceException {
        if (newStudent == null) throw new IllegalArgumentException("Invalid Argument!");
        if (this.students.containsKey(newStudent.getName())) throw new StudentAlreadyEnrolledException();
        if (newStudent.isTakingSeminar()) throw new StudentAlreadyTakingSeminar();
        if (this.students.size() == this.place.getCapacity()) throw new CrowdedPlaceException();
        this.students.put(newStudent.getName(), newStudent);
    }

    public Student removeStudent(String name) throws StudentNotFoundException {
        Student toRemove = this.students.remove(name);
        if (toRemove == null) throw new StudentNotFoundException();
        return toRemove;
    }

    public String getTitle() {
        return this.title;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public Teacher getHost() {
        return this.host;
    }

    public Place getPlace() {
        return this.place;
    }

    public Map<String, Student> getStudents() {
        return this.students;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("{\"title\":\"%s\", \"date\":\"%s\", \"host\": \"%s\", \"place\": %s, \"students\": ", this.title, this.date.toString(), this.host.getName(), this.place));
        if (!this.students.isEmpty()) {
            Iterator<Student> it = this.students.values().iterator();
            if (this.students.size() > 1) result.append("{");
            result.append(it.next());
            while (it.hasNext()) result.append(", ").append(it.next());
        } else result.append("\"none\"");
        result.append("}");
        return result.toString();
    }
}
