package br.com.rafael.using_composition.composing_class;

import java.time.LocalDate;
import java.util.Objects;

public class RegisteredPerson {
    private String name, registration;
    private LocalDate dateOfBirth;

    public RegisteredPerson(String name, String registration) {
        this.name = name;
        this.registration = registration;
    }

    public RegisteredPerson(String name, String registration, LocalDate dateOfBirth) {
        this(name, registration);
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return this.name;
    }

    public String getRegistration() {
        return this.registration;
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public int getAge() {
        int age = LocalDate.now().getYear() - this.dateOfBirth.getYear();
        if (LocalDate.now().isBefore(LocalDate.of(LocalDate.now().getYear(), this.dateOfBirth.getMonth().getValue(), this.dateOfBirth.getDayOfMonth()))) {
            return --age; //RegisteredPerson did not complete their yearly new age yet.
        }
        return age;
    }

    @Override
    public String toString() {
        return String.format("{\"name\":\"%s\", \"registration\":\"%s\", \"dateOfBirth\":\"%s\"", this.name, this.registration, this.dateOfBirth.toString());
    }

    @Override
    public boolean equals(Object toCompare) {
        if (!(toCompare instanceof RegisteredPerson casted)) return false;
        return (this.name.equals(casted.getName()) && this.registration.equals(casted.getRegistration()) && this.dateOfBirth.toString().equals(casted.getDateOfBirth().toString()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.registration, this.dateOfBirth.toString());
    }
}
