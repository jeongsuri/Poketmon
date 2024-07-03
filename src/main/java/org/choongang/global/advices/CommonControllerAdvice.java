package org.choongang.global.advices;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.global.Interceptor;
import org.choongang.global.config.annotations.ControllerAdvice;
import org.choongang.global.config.annotations.ModelAttribute;
import org.choongang.global.config.containers.BeanContainer;
import org.choongang.global.exceptions.*;
import org.choongang.member.MemberUtil;
import org.choongang.member.entities.Member;
import org.choongang.pokemon.PokemonDetail;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@ControllerAdvice("org.choongang")
public class CommonControllerAdvice implements Interceptor {

    private final MemberUtil memberUtil;

    @ModelAttribute
    public boolean isLogin() {
        return memberUtil.isLogin();
    }

    @ModelAttribute
    public boolean isAdmin() {
        return memberUtil.isAdmin();
    }

    @ModelAttribute
    public Member loggedMember() {
        return memberUtil.getMember();
    }

    @ModelAttribute
    public PokemonDetail myProfile() {
        return memberUtil.getMyProfile();
    }




    /**
     * 공통 에러 페이지 처리
     * 
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(Exception.class)
    public String errorHandler(Exception e, HttpServletRequest request, HttpServletResponse response) {

        e.printStackTrace();

        if (e instanceof CommonException commonException) {
            int status = commonException.getStatus();
            response.setStatus(status);

            StringBuffer sb = new StringBuffer(1000);
            if (e instanceof AlertException) {
                sb.append(String.format("alert('%s');", e.getMessage()));
            }

            if (e instanceof AlertBackException alertBackException) {
                String target = alertBackException.getTarget();
                sb.append(String.format("%s.history.back();", target));
            }

            if (e instanceof AlertRedirectException alertRedirectException) {
                String target = alertRedirectException.getTarget();
                String url = alertRedirectException.getRedirectUrl();

                sb.append(String.format("%s.location.replace('%s');", target, url));
            }

            if (!sb.isEmpty()) {
                request.setAttribute("script", sb.toString());
                return "commons/execute_script";
            }
        } else {
            // CommonException으로 정의한 예외가 아닌 경우 - 응답 코드 500
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }


        return "errors/error";
    }

    @Override
    public boolean preHandle() {
        HttpServletResponse response = BeanContainer.getInstance().getBean(HttpServletResponse.class);
        HttpServletRequest request = BeanContainer.getInstance().getBean(HttpServletRequest.class);
        if (!memberUtil.isLogin()) {
            List<String> excludeUrls = List.of(
              "/member/login",
              "/member/join",
                    "/mypage"
            );

            boolean isMatch = false;
            for (String url : excludeUrls) {
                if (request.getRequestURI().contains(url)) {
                    isMatch = true;
                    break;
                }
            }

            if (!isMatch) {
                String url = request.getContextPath() + "/member/login";
                try {
                    response.sendRedirect(url);
                } catch (IOException e) {}
                return false; // /member/login만 제외하고 로그인 하지 않은 경우
            }
        }

        return true;
    }
}