package com.tongyi.cms.account.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/account")
public class AccountController {
	
	@RequestMapping("/createAccount")
	/**
	 * 创建用户
	 * 
	 * @param userName 
	 *        用户名
	 * @param password
	 *        密码
	 * @param email
	 *        邮箱
	 * @param remark
	 *        备注
	 * @param mobile
	 *        手机号
	 */
	public void createAccount(@RequestParam String userName,@RequestParam String password,
			@PathVariable String email,@RequestParam String remark,@RequestParam String mobile,Model model){
	    model.addAttribute("you", "you");
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody Map<String,Object> testMap(@RequestParam(value="name",required=false,defaultValue="adsf") String userName) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("error","我爱你");
		map.put("info", userName);
		return map;
	}
	
	@RequestMapping(value="/test/{name}")
	public @ResponseBody long testMap1(@PathVariable String name){
		return 0;
	}
    
}
