package org.choongang.admin.member;


import lombok.RequiredArgsConstructor;
import org.choongang.global.config.annotations.Controller;
import org.choongang.global.config.annotations.GetMapping;
import org.choongang.global.config.annotations.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/member")
@RequiredArgsConstructor
public class AdminMemberController {

    @GetMapping()
    public String MemberList(){
        return "admin/member/index";
    }
}
