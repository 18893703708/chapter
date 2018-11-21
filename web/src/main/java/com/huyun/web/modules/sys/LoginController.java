package com.huyun.web.modules.sys;

import com.huyun.utils.MD5Utils;
import com.huyun.utils.R;
import com.huyun.web.shiro.ShiroUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class LoginController  {

	@GetMapping("/login")
	String login(Map<String,Object> map) {
		map.put("hello","from TemplateController.helloHtml");
		return "login";
	}


	@PostMapping("/login")
	@ResponseBody
	R doLogin(String username, String password) {
		password = MD5Utils.encrypt(username, password);
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			return R.ok();
		} catch (UnknownAccountException e) {
			return R.error(e.getMessage());
		}
		catch (IncorrectCredentialsException e) {
			return R.error(e.getMessage());
		}
		catch (LockedAccountException e) {
			return R.error(e.getMessage());
		}
	}
	@GetMapping("/logout")
	String logout() {
		ShiroUtils.logout();
		return "redirect:/login";
	}
	@GetMapping("/403")
	String error403() {
		return "403";
	}

}
