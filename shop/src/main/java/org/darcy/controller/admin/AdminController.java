package org.darcy.controller.admin;

import java.util.List;

import org.darcy.eop.sdk.context.UserConext;
import org.darcy.framework.context.webcontext.ThreadContextHolder;
import org.darcy.service.resource.IAdminThemeManager;
import org.darcy.service.resource.IMenuManager;
import org.darcy.service.resource.model.AdminTheme;
import org.darcy.service.resource.model.AdminUser;
import org.darcy.service.resource.model.EopSite;
import org.darcy.service.resource.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 管理界面登录
 * @author lipeng
 */
@Controller 
@RequestMapping("/admin/")
public class AdminController {
	
 
	
	@Autowired
	private IAdminThemeManager adminThemeManager;
	
	@Autowired
	private IMenuManager menuManager;
	
	
	
	/**
	 * 后台登陆界面
	 * @return 后台登陆界面
	 */
	@RequestMapping(value="/login")
	public ModelAndView login(String referer) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("referer", referer);
		mv.setViewName("/adminthemes/"+this.getTheme()+"/login");
		// 存放站点信息
		return mv;
	}
	
 
	/**
	 * 跳转至后台主页面
	 * @param user 后台管理员
	 * @param version 版本
	 * @param product_type 程序模型：b2c、b2b2c、o2o
	 * @param ctx 虚拟目录
	 * @return 后台主页面
	 */
	@RequestMapping(value="/main")
	public ModelAndView main() {
		AdminUser user = UserConext.getCurrentAdminUser();
		List<Menu> menuList =null;
		// 判断当前管理员是否为超级管理员, 获取权限点列表
		if (user.getFounder() != 1) {
			menuList = this.menuManager.newMenutree(0, user);
		} else {
			menuList = this.menuManager.getMenuTree(0);
		}
	 
		ModelAndView view = new ModelAndView();
		view.addObject("menuList",menuList);
		view.setViewName("/adminthemes/"+this.getTheme()+"/main_page");
		return view;
	}
	
	
 
	public String getTheme() {
		
		EopSite site = this.getSite();
		
		// 读取后台使用的模板
		AdminTheme theTheme = adminThemeManager.get(site.getAdminthemeid());
		
		String theme = "default";
		if (theTheme != null) {
			theme = theTheme.getPath();
		}
		
		
		return theme;
	}

	@ModelAttribute("site")
	public EopSite getSite() {
		EopSite site = EopSite.getInstance().getInstance();
		return site;
	}

//	@ModelAttribute("version")
//	public String getVersion() {
//		return version;
//	}
//	
//	@ModelAttribute("user")
//	public AdminUser getUser() {
//		return user;
//	}

	@ModelAttribute("ctx")
	public String getCtx() {
		String ctx = ThreadContextHolder.getHttpRequest().getContextPath();
		
		// 获取虚拟目录
		if ("/".equals(ctx)) {
			ctx = "";
		}		
		return ctx;
	}
	
	@RequestMapping(value="/{errorPage}",method = RequestMethod.GET)  
    public String getLogin(@PathVariable("errorPage") String errorPage){  
        return "/adminthemes/"+this.getTheme()+"/" + errorPage;  
    } 
}
