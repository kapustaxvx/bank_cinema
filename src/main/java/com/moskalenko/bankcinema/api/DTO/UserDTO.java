package com.moskalenko.bankcinema.api.DTO;


import com.moskalenko.bankcinema.api.entity.User;

import java.util.Objects;

public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String nickname;


    public UserDTO() {
    }

    public UserDTO(Long id, String name, String surname, String nickname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nickname = nickname;
    }

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.nickname = user.getNickname();
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

    public String getNickname() {
        return nickname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id) && Objects.equals(name, userDTO.name) && Objects.equals(surname, userDTO.surname) && Objects.equals(nickname, userDTO.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, nickname);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
