package org.choongang.mypage.entities;

import lombok.Builder;
import lombok.Data;
import org.choongang.member.constants.UserType;

@Data
@Builder
public class MyPage {
    private long userNo;
    private String userId;
    private UserType userType = UserType.USER;
    private String nickName;
    private long pokemonNo;



}
