package com.moskalenko.bankcinema.api.beans;

import java.time.Instant;
import java.util.Objects;

public class ArtWorker {
    Long id;
    String name;
    String surname;
    Instant birthDate;

    public ArtWorker() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtWorker artWorker = (ArtWorker) o;
        return Objects.equals(id, artWorker.id) && Objects.equals(name, artWorker.name) && Objects.equals(surname, artWorker.surname) && Objects.equals(birthDate, artWorker.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, birthDate);
    }

    @Override
    public String toString() {
        return "ArtWorker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
