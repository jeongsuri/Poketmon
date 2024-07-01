package org.choongang.admin.member;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.*;
import org.choongang.member.entities.Member;
import org.choongang.member.mapper.MemberDataMapper;
import org.choongang.member.services.MemberConfigInfoService;

import java.util.List;

@Controller
@RequestMapping("/admin/member")
@RequiredArgsConstructor
public class AdminMemberController {

    private final HttpServletRequest request;
    private final MemberConfigInfoService infoService;

    //회원리스트
    @GetMapping()
    public String MemberList(){
        List<Member> items = infoService.getList();
        request.setAttribute("items", items);
        request.setAttribute("addCss", List.of("admin/member/member"));
        return "admin/member/index";
    }

    //회원탈퇴
    @GetMapping("/delete/{userId}")
    public String deleteMember(@PathVariable("userId") String userId, HttpServletRequest request){
        infoService.delete(userId);
        String script = String.format("parent.location.replace('%s');", request.getContextPath() + "/admin/member");
        request.setAttribute("script", script);
        return "commons/execute_script";
    }


    //회원정보수정
    @GetMapping("/updata/{userId}")
    public String updateMember(@PathVariable("userId") String userId, HttpServletRequest request){
        return null;
    }
}
