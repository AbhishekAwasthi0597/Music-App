package com.geekster.Music.Streaming.Api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpInput {
  String firstName;
    String   lastName;
    String   email;
    String  password;
    String   phoneNumber;

}
