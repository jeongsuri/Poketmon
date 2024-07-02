package org.choongang.member.tests;

import org.apache.ibatis.session.SqlSession;
import org.choongang.global.config.DBConn;
import org.choongang.member.mapper.MemberMapper;
import org.choongang.member.services.JoinService;
import org.choongang.member.services.LoginService;
import org.choongang.member.validators.JoinValidator;
import org.choongang.member.validators.LoginValidator;

public class MemberServiceProvider_temp {
    private static MemberServiceProvider_temp instance;

    private MemberServiceProvider_temp() {}

    public static MemberServiceProvider_temp getInstance() {
        if (instance == null) {
            instance = new MemberServiceProvider_temp();
        }

        return instance;
    }

    public SqlSession getSession() {
        return DBConn.getSession();
    }

    public MemberMapper memberMapper() {
        return getSession().getMapper(MemberMapper.class);
    }

    public JoinValidator joinValidator() {
        return new JoinValidator(memberMapper());
    }

    public JoinService joinService() {
        return new JoinService(joinValidator(), memberMapper());
    }

    public LoginValidator loginValidator() {
        return new LoginValidator(memberMapper());
    }

    public LoginService loginService() {
        return new LoginService(loginValidator(), memberMapper());
    }
}
