package com.moskalenko.bankcinema.api.DTO;


public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String nickname;


    public UserDTO() {
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
}
