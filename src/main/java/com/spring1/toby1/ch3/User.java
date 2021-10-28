package com.spring1.toby1.ch3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor  @NoArgsConstructor
@Getter @Setter
public class User {
    String id;
    String name;
    String password;
}
