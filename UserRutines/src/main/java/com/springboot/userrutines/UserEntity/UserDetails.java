package com.springboot.userrutines.UserEntity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDetails {

    private int time;
    private String work;
    private boolean workSuccesfull;

}
