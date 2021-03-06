package org.darcy.controller.admin.setting;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.darcy.app.base.core.model.PluginDataMapper;
import org.darcy.app.base.core.plugin.setting.SettingPluginBundle;
import org.darcy.eop.sdk.context.EopSetting;
import org.darcy.framework.action.GridController;
import org.darcy.framework.action.JsonResult;
import org.darcy.framework.action.WWAction;
import org.darcy.framework.context.webcontext.ThreadContextHolder;
import org.darcy.framework.util.JsonResultUtil;
import org.darcy.service.ISettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 1.系统设置
 */

@Scope("prototype")
@Controller 
@RequestMapping("/core/admin/setting")
public class SystemSettingController {
	
	@Autowired
	private ISettingService settingService;
	
	@Autowired
	private SettingPluginBundle settingPluginBundle;

	/**
	 * 跳转至系统设置页面
	 * @param settings 设置列表
	 * @param htmls 系统设置HTMl
	 * @param tabs 系统设置TAB 
	 */
	@RequestMapping(value="/edit-input")
	public ModelAndView editInput(){
		
		Map settings = settingService.getSetting();
		ModelAndView view=new ModelAndView();
		List<PluginDataMapper> tabTitleList= this.settingPluginBundle.getTabs();
		List<PluginDataMapper> tabHtmlList = this.settingPluginBundle.onInputShow(settings);
		
		view.addObject("tabs", tabTitleList);
		view.addObject("htmls", tabHtmlList);
		view.setViewName("/core/admin/setting/input");
		
		return view;
	}
	
	/**
	 * 保存配置
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/save")
	public JsonResult save(){
		//判断是否为演示站点
		if(EopSetting.IS_DEMO_SITE){
			return JsonResultUtil.getErrorJson(EopSetting.DEMO_SITE_TIP);
		}
		
		HttpServletRequest  request = ThreadContextHolder.getHttpRequest();
		Enumeration<String> names = request.getParameterNames();
		Map<String,Map<String,String>> settings = new HashMap<String, Map<String,String>>();
		
	    while(names.hasMoreElements()){

	    	String name= names.nextElement();
	    	String[]name_ar = name.split("\\.");
	    	if(name_ar.length!=2) continue;
	    	
	    	String groupName = name_ar[0];
	    	String paramName  = name_ar[1];
	    	String paramValue = request.getParameter(name);
	    	
	    	Map<String,String> params = settings.get(groupName);
	    	if(params==null){
	    		params = new HashMap<String, String>();
	    		settings.put(groupName, params);
	    	}
	    	params.put(paramName, paramValue);
	    }
	    
		settingService.save( settings );
		return JsonResultUtil.getSuccessJson("配置修改成功");
	}

	
}
