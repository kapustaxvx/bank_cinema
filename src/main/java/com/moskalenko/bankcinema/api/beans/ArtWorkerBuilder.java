package com.moskalenko.bankcinema.api.beans;

import com.google.common.base.Preconditions;

import java.time.Instant;

public class ArtWorkerBuilder {
    private final ArtWorker artWorker = new ArtWorker();

    public static ArtWorkerBuilder create() {
        return new ArtWorkerBuilder();
    }

    public ArtWorkerBuilder withId(Long id) {
        artWorker.id = id;
        return this;
    }

    public ArtWorkerBuilder withName(String name) {
        artWorker.name = name;
        return this;
    }

    public ArtWorkerBuilder withSurname(String surname) {
        artWorker.surname = surname;
        return this;
    }

    public ArtWorkerBuilder withBirthDate(Instant birthDate) {
        artWorker.birthDate = birthDate;
        return this;
    }

    public ArtWorker build() {
        Preconditions.checkArgument(artWorker.id != null);
        Preconditions.checkArgument(artWorker.name != null);
        Preconditions.checkArgument(artWorker.surname != null);
        Preconditions.checkArgument(artWorker.birthDate != null);

        return artWorker;
    }
}
