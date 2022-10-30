package com.toyproject.wrightwyatt.controller;

import com.toyproject.wrightwyatt.service.MemberService;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService = new MemberService();
}
