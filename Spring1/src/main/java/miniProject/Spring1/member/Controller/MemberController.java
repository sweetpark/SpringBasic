package miniProject.Spring1.member.Controller;

import miniProject.Spring1.member.Member;
import miniProject.Spring1.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new_form")
    public String showNewForm(){
        return "new_member";
    }

    @PostMapping("/members/new_form")
    public String join(@ModelAttribute Member member) {
        memberService.join(member);
        return "redirect:/members";
    }

    @GetMapping("/members")
    public String findAll(Model model) {
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "members";
    }
}
