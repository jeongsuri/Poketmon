package org.choongang.mypage.advices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.global.Interceptor;
import org.choongang.global.config.annotations.ControllerAdvice;
import org.choongang.member.MemberUtil;

import java.io.IOException;

@RequiredArgsConstructor
@ControllerAdvice("org.choongang.mypage")
public class MypageControllerAdvice implements Interceptor {

    private final MemberUtil memberUtil;
    private final HttpServletRequest request;
    private final HttpServletResponse response;

    @Override
    public boolean preHandle() {

        if (!memberUtil.isLogin()) {


            try {
                response.sendRedirect(request.getContextPath() + "/member/login?redirectUrl=/mypage");
            } catch (IOException e) {}
            return false;
        }

        return true;
    }
}
