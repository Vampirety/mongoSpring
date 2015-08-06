package com.lxh.module.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lxh.module.entity.Module;
import com.lxh.module.service.ModuleService;

/**
 * ģ�����
 * */
@Controller
@RequestMapping("/module")
public class ModuleController {
	
	@Resource
	private ModuleService moduleService;
	
	/**
	 * ��ת����ҳ��
	 * */
	@RequestMapping("/toMain")
	public String toMain(ModelMap modelMap){
		List<Module> moduleList=this.moduleService.getAll();
		modelMap.put("moduleList", moduleList);
		return "/module/main";
	}
	
	/**
	 * ��ת����ҳ��
	 * */
	@RequestMapping("/toModule")
	public String toModule(){
		return "/module/moduleList";
	}
	
	/**
	 * ����
	 * */
	@RequestMapping("/saveModule")
	@ResponseBody
	public Object saveModule(){
		Map<String,Object> map=new HashMap<String,Object>();
		Module module=new Module();
		module.setModuleName("Ȩ�޹���");
		module.setModuleCode("003");
		module.setModuleUrl("right/toRight.action");
		module.setHasChild("N");
		module.setSort(1);
		module.setIconUrl("icon-chevron-down");
		module.setDelFlag("0");
		moduleService.saveModule(module);
		map.put("msg", "success");
		return map;
	}
	
	/**
	 * ��ȡ����ģ��
	 * */
	@RequestMapping("/getAllModule")
	@ResponseBody
	public Object getAllModule(){
		Map<String,Object> map=new HashMap<String,Object>();
		List<Module> moduleList=this.moduleService.getAll();
		map.put("moduleList", moduleList);
		return map;
	}
	
	/**
	 * ��ȡ����ģ��
	 * */
	@RequestMapping("/getOne")
	@ResponseBody
	public Object getOne(String id,String moduleName,String moduleCode){
		Map<String,Object> paraMap=new HashMap<String,Object>();
		Map<String,Object> map=new HashMap<String,Object>();
		if(!StringUtils.isEmpty(id)){
			paraMap.put("id", id);
		}
		if(!StringUtils.isEmpty(moduleName)){
			paraMap.put("moduleName", moduleName);
		}
		if(!StringUtils.isEmpty(moduleCode)){
			paraMap.put("moduleCode", moduleCode);
		}
		Module module=this.moduleService.getOne(paraMap);
		map.put("module", module);
		return map;
	}
	
	/**
	 * ɾ��ģ��
	 * */
	@RequestMapping("/delModule")
	@ResponseBody
	public Object delModule(String id){
		Map<String,Object> map=new HashMap<String,Object>();
		this.moduleService.delOne(id);
		map.put("msg", "success");
		return map;
	}
	
	/**
	 * ģ���ҳ
	 * */
	@RequestMapping("/getModulePage")
	@ResponseBody
	public String getModulePage(Integer pageIndex,Integer pageSize){
		//this.moduleService.getModulePage(pageIndex,pageSize);
		return null;
	}
	

}
