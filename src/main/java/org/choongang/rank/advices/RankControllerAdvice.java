package org.choongang.rank.advices;

import lombok.RequiredArgsConstructor;
import org.choongang.global.Interceptor;
import org.choongang.global.config.annotations.ControllerAdvice;
import org.choongang.global.exceptions.UnAuthorizedException;
import org.choongang.member.MemberUtil;


@RequiredArgsConstructor
@ControllerAdvice("org.choongang.rank")
public class RankControllerAdvice implements Interceptor {

    private final MemberUtil memberUtil;


    @Override
    public boolean preHandle() {
        if(memberUtil.isLogin() == false){
            throw new UnAuthorizedException();
        }
        return true;
    }
}