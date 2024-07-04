package org.choongang.admin.member;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.*;
import org.choongang.member.entities.Member;
import org.choongang.member.services.MemberConfigInfoService;
import org.choongang.mypage.controllers.RequestProfile;
import org.choongang.mypage.services.ProfileService;

import java.util.List;

@Controller
@RequestMapping("/admin/member")
@RequiredArgsConstructor
public class AdminMemberController {

    private final HttpServletRequest request;
    private final MemberConfigInfoService infoService;
    private final ProfileService profileService;

    //회원리스트
    @GetMapping()
    public String MemberList() {
        List<Member> items = infoService.getList();
        request.setAttribute("items", items);
        request.setAttribute("addCss", List.of("admin/member/member"));
        return "admin/member/index";
    }

    //회원탈퇴
    @GetMapping("/delete/{userId}")
    public String deleteMember(@PathVariable("userId") String userId, HttpServletRequest request) {
        infoService.delete(userId);
        String script = String.format("parent.location.replace('%s');", request.getContextPath() + "/admin/member");
        System.out.println(script);
        request.setAttribute("script", script);
        return "commons/execute_script";
    }


    //회원정보수정
    @GetMapping("/update/{userId}")
    public String updateMember(@PathVariable("userId") String userId, HttpServletRequest request) {
        Member data = infoService.getMember(userId);
        request.setAttribute("data", data);
        request.setAttribute("addCss", List.of("admin/member/update"));
        request.setAttribute("actionUrl", List.of("/" + userId));
        return "admin/member/update";
    }

    @PostMapping("/update")
    public String updateMember(RequestProfile form, HttpServletRequest request) {
        System.out.println(form.getUserId());
        System.out.println(form.getNickName());
        System.out.println(form.getUserType());
        profileService.update(form, true);
        String script = String.format("parent.location.replace('%s');", request.getContextPath() + "/admin/member");
        request.setAttribute("script", script);
        return "commons/execute_script";


    }
}
