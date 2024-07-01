package org.choongang.board.advices;

import lombok.RequiredArgsConstructor;
import org.choongang.global.Interceptor;
import org.choongang.global.config.annotations.ControllerAdvice;
import org.choongang.global.exceptions.UnAuthorizedException;
import org.choongang.member.MemberUtil;

@RequiredArgsConstructor
@ControllerAdvice("org.choongang.board")
public class BoardControllerAdvice implements Interceptor {

    private final MemberUtil memberUtil;


    @Override
    public boolean preHandle() {
        if(memberUtil.isLogin() == false){
            throw new UnAuthorizedException();
        }
        return false;
    }
}
