package org.choongang.global.validators;

public interface PasswordValidator {
    default boolean checkPassword(String password) {
        // 정규 표현식 (영문자와 숫자로 구성된 8자 이상 20자 이하)
        String pattern = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,20}$";

        return password.matches(pattern);
    }
}
