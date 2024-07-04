package org.choongang.member.validators;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Component;
import org.choongang.global.exceptions.AlertException;
import org.choongang.global.validators.PasswordValidator;
import org.choongang.global.validators.UserIdValidator;
import org.choongang.global.validators.RequiredValidator;
import org.choongang.global.validators.Validator;
import org.choongang.member.controllers.RequestJoin;
import org.choongang.member.mapper.MemberMapper;


@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator<RequestJoin>, RequiredValidator, UserIdValidator, PasswordValidator {
    private final MemberMapper mapper;

    @Override
    public void check(RequestJoin form) {
        String userId = form.getUserId();
        String password = form.getPassword();
        String confirmPassword = form.getConfirmPassword();
        String nickName = form.getNickName();
        int status = HttpServletResponse.SC_BAD_REQUEST;

        /* 필수 항목 유효성 검사 S */
        checkRequired(userId, new AlertException("아이디를 입력하세요", status));
        checkRequired(password, new AlertException("비밀번호를 입력하세요.", status));
        checkRequired(confirmPassword, new AlertException("비밀번호를 확인하세요.", status));
        checkRequired(nickName, new AlertException("닉네임을 입력하세요.", status));
        /* 필수 항목 유효성 검사 E */

        // 아이디 형식 체크
        checkTrue(checkUserId(userId), new AlertException("아이디 형식이 아닙니다.", status));

        // 아이디 중복 여부 체크 - 이미 가입된 회원인지 여부
        checkTrue(mapper.exists(userId) == 0L, new AlertException("이미 가입된 아이디입니다.", status));

        // 비밀번호 자리수는 8자리 이상
        checkTrue(checkPassword(password), new AlertException("비밀번호는 영문자와 숫자로 구성된 8자 이상 20자 이하로 입력해 주세요.", status));

        // 비밀번호와 비밀번호 확인의 일치 여부
        checkTrue(password.equals(confirmPassword), new AlertException("비밀번호가 일치하지 않습니다.", status));

        // 닉네임 중복 여부 체크 - 이미 사용중인 닉네임인지 여부
        checkTrue(mapper.existsNickName(nickName) == 0L, new AlertException("이미 사용중인 닉네임입니다.", status));
    }
}
