package com.huyun.web.modules.sys;


import com.huyun.model.JsonTreeData;
import com.huyun.sys.model.Role;
import com.huyun.sys.model.User;
import com.huyun.sys.service.PermissionService;
import com.huyun.sys.service.RoleService;
import com.huyun.sys.service.UserService;
import com.huyun.utils.MD5Utils;
import com.huyun.web.base.AbstractController;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import static com.huyun.web.shiro.ShiroUtils.getUser;

@Controller
public class IndexController extends AbstractController {
		@Autowired
		RoleService roleService;
		@Autowired
		PermissionService permissionService;
		@Autowired
		UserService userService;


	@RequestMapping("/")
	public ModelAndView showIndex() {

		return new ModelAndView("redirect:/index/index");

	}



	@GetMapping("/index")
	String login(Model model) {
		//测试
		SecurityUtils.getSubject().isPermitted("system:user:update");

		User user=getUser();
		//User user = new User();
		model.addAttribute("user", user);
		//user.setUserId(1);

		//超级管理员处理
		List<Role> roleList= roleService.selectByUserId(user.getUserId());
		model.addAttribute("role", roleList);
		Integer userId=user.getUserId();
		for (Role roleId : roleList) {
			if("888888".equals(roleId.getType()))
			{
				userId=0;
				break;
			}
		}
		List<JsonTreeData> json=permissionService.selectPermissionByUserId(userId);
		model.addAttribute("permission",json );
		return "index";
	}

	@GetMapping("/main")
	public ModelAndView main(ModelMap map) {

		return new ModelAndView("main",map);
	}


	//修改头像
	@RequestMapping(value="/portrait",method = RequestMethod.GET)
	public String portrait() {
		return "portrait";
	}

	@RequestMapping(value="/doPortrait",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doPortrait(User model){
		//获取当前登录用户信息
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		model.setUserId(user.getUserId());
		if(userService.updateByPrimaryKey(model)!=0){
			resultMap.put("status", 200);
			resultMap.put("message", "操作成功");
		}
		else
		{
			resultMap.put("status", 500);
			resultMap.put("message", "操作失败");
		}
		return resultMap;
	}

	//个人资料
	@RequestMapping(value="/userInfo",method =RequestMethod.GET)
	public ModelAndView userInfo(ModelMap map) {
		//获取当前登录用户信息
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		User userInfo = userService.findByPrimaryKey(user.getUserId().toString());
		map.put("users", userInfo);
		return new ModelAndView("/userInfo",map);

	}

	//修改密码
	@RequestMapping(value="/pwd",method =RequestMethod.GET)
	public String pwd() {
		return "pwd";
	}

	@RequestMapping(value="/doPwd",method =RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doPwd(String old_password,String password) {
		//获取当前登录用户信息
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		String username = user.getUsername();
		old_password =  MD5Utils.encrypt(username, old_password);
		User users = userService.findByAccountAndPwd(username, old_password);
		/*
		if("admin".equals(account)){
			resultMap.put("status", 300);
			resultMap.put("message", "管理员不准修改密码。");
			return resultMap;
		}*/
		if(null == users){
			resultMap.put("status", 500);
			resultMap.put("message", "原密码不正确！");
		}else{
			String pwd = MD5Utils.encrypt(username, password);
			users.setPassword(pwd);
			//修改密码
			userService.updateByPrimaryKey(users);
			resultMap.put("status", 200);
			resultMap.put("message", "修改成功!请重新登录");
		}
		return resultMap;
	}



      //重置密码
	@RequestMapping(value="/doCzpwd",method =RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> doCzpwd(String password) {
		//获取当前登录用户信息
		User user = (User)SecurityUtils.getSubject().getPrincipal();
		String username = user.getUsername();
		Integer userId = user.getUserId();
		User users = new User();
		users.setUserId(user.getUserId());
		String pwd = MD5Utils.encrypt(username, "123456");
		users.setPassword(pwd);
		//重置密码
		userService.updateByPrimaryKey(users);
		resultMap.put("status", 200);
			resultMap.put("message", "重置成功!初始密码为123456!");

		     return resultMap;
	}

}