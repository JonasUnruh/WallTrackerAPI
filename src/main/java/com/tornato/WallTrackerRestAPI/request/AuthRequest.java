package com.tornato.WallTrackerRestAPI.request;
import lombok.Data;

@Data
public class AuthRequest {

    private String firstName;

    private String lastName;

    private String emailId;

    private String password;
}
