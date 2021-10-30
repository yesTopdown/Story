package com.example.test6day.web;
import com.example.test6day.Service.MemberService;
import com.example.test6day.pojo.AssessMember;
import com.example.test6day.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/assess")
public class AssessServlet {
   @Autowired
   MemberService memberService;
   List<AssessMember> assessMemberList=new ArrayList<>();
}
