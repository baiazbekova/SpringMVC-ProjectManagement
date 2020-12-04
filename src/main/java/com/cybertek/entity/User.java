package com.cybertek.entity;

import com.cybertek.enums.Gender;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private boolean enabled;
    private String phone;
    private Role role;
    private Gender gender;

    public User(long id, LocalDateTime insertDateTime, Long insertUserId, LocalDateTime lastUpdatedDateTime, long lastUpdateUserId, String firstName, String lastName, String username, String password, boolean enabled, String phone, Role role, Gender gender) {
        super(id, insertDateTime, insertUserId, lastUpdatedDateTime, lastUpdateUserId);
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.phone = phone;
        this.role = role;
        this.gender = gender;
    }
}
