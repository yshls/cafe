package com.shop.cafe.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.cafe.dto.Member;
import com.shop.cafe.service.MemberService;

@RestController
@CrossOrigin("http://127.0.0.1:5500/")
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@PostMapping("insertMember")
	@CrossOrigin("http://172.30.1.46:5500/")
	public Map<String, String> insertMember(@RequestBody  Member m) {
		Map<String,String> responseData=new HashMap();
		try {
			// 에러가 안날 경우
			memberService.insertMember(m);
			responseData.put("msg","ok");
		} catch (Exception e) {
			// 에러가 날 경우
			e.printStackTrace();
			responseData.put("msg",e.getMessage());
		}
		
		return responseData;
	}
	

}
