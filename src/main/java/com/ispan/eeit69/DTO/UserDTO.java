package com.ispan.eeit69.DTO;

public class UserDTO {
    private String invitationCode;
    int id;
    private String username;


    private String password;

    public UserDTO() {
    }

    public UserDTO(String invitationCode, int id, String username, String password) {
        this.invitationCode = invitationCode;
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}