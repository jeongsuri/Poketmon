package org.choongang.admin.member;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberDataMapper;

import java.util.List;

@Controller
@RequestMapping("/admin/member")
@RequiredArgsConstructor
public class AdminMemberController {

    private final MemberDataMapper mapper;
    private final HttpServletRequest request;

    //회원리스트
    @GetMapping()
    public String MemberList(){
        List<Member> items = mapper.getList();
        request.setAttribute("items", items);
        request.setAttribute("addCss", List.of("admin/member/member"));
        return "admin/member/index";
    }
}
