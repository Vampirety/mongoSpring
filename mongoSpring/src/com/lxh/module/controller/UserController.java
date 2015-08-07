package com.lxh.module.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxh.module.base.Pagination;
import com.lxh.module.common.Constants;
import com.lxh.module.entity.Module;
import com.lxh.module.entity.User;
import com.lxh.module.service.ModuleService;
import com.lxh.module.service.UserService;
import com.lxh.module.utils.EncodeStringUtils;

@Controller
@RequestMapping("/user")
public class UserController{
	
	@Resource
	private UserService userService;
	@Resource
	private ModuleService moduleService;
	
	/**
	 * 登录跳转到主页面
	 * */
	@RequestMapping("/login")
	public String login(String account,String password,HttpServletRequest request, ModelMap modelMap){
		Map<String,Object> paraMap=new HashMap<String,Object>();
		if(!StringUtils.isEmpty(account)){
			paraMap.put("account", account);
		}
		if(!StringUtils.isEmpty(password)){
			paraMap.put("password", EncodeStringUtils.encodePassword(password,"MD5"));
		}
		User user=this.userService.getUserByMap(paraMap);
		if(user==null){
			modelMap.put("TSR_MSG_LOGINFAIL", Constants.LoginResult.TSR_MSG_LOGINFAIL);
			return "signin";
		}else{
			request.getSession().setAttribute(Constants.Session.current_user, user);
			List<Module> moduleList=this.moduleService.getAll();
			modelMap.put("moduleList", moduleList);
			return "/module/main";
		}
	}
	
	/**
	 * 登出
	 * */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,HttpServletResponse response){
		request.getSession().removeAttribute(Constants.Session.current_user);
		response.setHeader("Pragma","No-cache");//清除页面缓存
		response.setHeader("Cache-Control","no-cache"); 
		response.setDateHeader("Expires", 0); 
		return "/signin";
	}
	
	/**
	 * 保存用户
	 * */
	@RequestMapping("/saveUser")
	public String saveUser(@ModelAttribute("user")User user){
		if(user!=null){
			user.setAccount("123465@qq.com");
			user.setEmail("123465@qq.com");
			user.setFirstName("123465");
			user.setLastName("123465");
			user.setNickName("小123465");
			user.setPassword("e10adc3949ba59abbe56e057f20f883e");
			user.setPhone("18066123465");
			this.userService.saveUser(user);
		}
		return "/module/main";
	}
	
	/**
	 * 获得用户列表
	 * */
	@RequestMapping("/getUserPage")
	@ResponseBody
	public Object getUserPage(HttpServletRequest request,@ModelAttribute("user")User user){
		Pagination pagination =new Pagination(request);
		Map<String,Object> paraMap=new HashMap<String,Object>();
		if(user!=null){
			if(StringUtils.isNotEmpty(user.getAccount())){
				paraMap.put("account", user.getAccount());
			}
			if(StringUtils.isNotEmpty(user.getNickName())){
				paraMap.put("nickName", user.getNickName());
			}
			if(StringUtils.isNotEmpty(user.getPhone())){
				paraMap.put("phone", user.getPhone());
			}
		}
		pagination=this.userService.getUserPage(pagination,paraMap);
		return pagination;
	}
	
	/**
	 * 跳转到iframe
	 * */
	@RequestMapping("/toIframe")
	public String toIframe(){
		return "/module/iframe";
	}
	
	/**
	 * 跳转到编辑用户
	 * */
	@RequestMapping("/toEdit")
	public String toEdit(String userId,ModelMap modelMap){
		User user=this.userService.getUserById(userId);
		modelMap.put("user", user);
		return "/module/editUser";
	}

}
