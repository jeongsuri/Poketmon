package org.choongang.global.validators;

public interface UserIdValidator {
    default boolean checkUserId(String userId) {
        // 정규 표현식 (영문자와 숫자로 구성된 8자 이상 20자 이하)
        String pattern = "^[a-zA-Z0-9]{8,20}$";

        return userId.matches(pattern);
    }
}
