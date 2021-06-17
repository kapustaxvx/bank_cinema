package com.moskalenko.bankcinema.api.beans;

import com.google.common.base.Preconditions;

import java.time.LocalDate;


public class UserBuilder {
    private final User user = new User();

    public static UserBuilder create() {
        return new UserBuilder();
    }

    public UserBuilder withId(Long id) {
        user.id = id;
        return this;
    }

    public UserBuilder withName(String name) {
        user.name = name;
        return this;
    }

    public UserBuilder withSurname(String surname) {
        user.surname = surname;
        return this;
    }

    public UserBuilder withBirthDate(LocalDate birthDate) {
        user.birthDate = birthDate;
        return this;
    }

    public User build() {
        Preconditions.checkArgument(user.id != null);
        Preconditions.checkArgument(user.name != null);
        Preconditions.checkArgument(user.surname != null);
        Preconditions.checkArgument(user.birthDate != null);

        return user;
    }
}
