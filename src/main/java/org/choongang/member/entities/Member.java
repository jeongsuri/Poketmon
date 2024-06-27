package org.choongang.member.entities;

import lombok.Builder;
import lombok.Data;
import org.choongang.member.constants.UserType;

import java.time.LocalDateTime;

@Data
@Builder
public class Member {
    private long userNo;
    private String userId;
    private String password;
    private UserType userType = UserType.USER;
    private String ninkName;

}
