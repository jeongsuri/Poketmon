package org.choongang.game.validators;

import jakarta.servlet.http.HttpServletRequest;
import org.choongang.global.validators.RequiredValidator;

public interface GameRequiredValidator extends RequiredValidator {


    // 참인지 체크
    default void checkTrue(boolean checked, RuntimeException e, HttpServletRequest request) {
        if (!checked) {
            request.
            throw e;
        }
    }
}