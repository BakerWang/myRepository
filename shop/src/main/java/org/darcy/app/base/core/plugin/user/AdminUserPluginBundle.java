package org.darcy.app.base.core.plugin.user;

import java.util.ArrayList;
import java.util.List;

import org.darcy.eop.processor.core.freemarker.FreeMarkerPaser;
import org.darcy.framework.plugin.AutoRegisterPluginsBundle;
import org.darcy.framework.plugin.IPlugin;
import org.darcy.service.resource.model.AdminUser;
import org.springframework.stereotype.Service;

/**
 * 管理员插件桩
 * 
 * @author kingapex
 * @version 2.0   6.0升级改造  wangxin
 */

@Service("adminUserPluginBundle")
public class AdminUserPluginBundle extends AutoRegisterPluginsBundle {
	/*
	 * (non-Javadoc)
	 * @see com.enation.framework.plugin.AutoRegisterPluginsBundle#getName()
	 */
	@Override
	public String getName() {
		return "管理员插件桩";
	}

	
	/**
	 * 激发攻取添加/修改页面html事件
	 * @param user
	 * @return
	 */

	public List<String> getInputHtml(AdminUser user) {
		List<String> list  = new ArrayList<String>();
		List<IPlugin> plugins = this.getPlugins();
		
		if (plugins != null) {
			FreeMarkerPaser freeMarkerPaser =FreeMarkerPaser.getInstance();
			
			for (IPlugin plugin : plugins) {
					if(plugin instanceof IAdminUserInputDisplayEvent){
						IAdminUserInputDisplayEvent event = (IAdminUserInputDisplayEvent)plugin;
						freeMarkerPaser.setClz(event.getClass());
						String html = event.getInputHtml(user);
						list.add(html);
					}
			}

		}
		return list;
	}
	
	
	
	/**
	 * 激发添加事件
	 * @param userid
	 */
	public void onAdd(Integer userid){
		List<IPlugin> plugins = this.getPlugins();
		
		if (plugins != null) {
			
			for (IPlugin plugin : plugins) {
					if(plugin instanceof IAdminUserOnAddEvent){
						IAdminUserOnAddEvent event = (IAdminUserOnAddEvent)plugin;
						event.onAdd(userid);
						 
					}
			}

		}
	}
	
	
	/**
	 * 激发修改事件
	 * @param userid
	 */
	public void onEdit(Integer userid){
		List<IPlugin> plugins = this.getPlugins();
		
		if (plugins != null) {
			
			for (IPlugin plugin : plugins) {
					if(plugin instanceof IAdminUserOnEditEvent){
						IAdminUserOnEditEvent event = (IAdminUserOnEditEvent)plugin;
						event.onEdit(userid);
					}
			}

		}
	}
	
	
	/**
	 * 激发修改事件
	 * @param userid
	 */
	public void onDelete(Integer userid){
		List<IPlugin> plugins = this.getPlugins();
		
		if (plugins != null) {
			
			for (IPlugin plugin : plugins) {
					if(plugin instanceof IAdminUserDeleteEvent){
						IAdminUserDeleteEvent event = (IAdminUserDeleteEvent)plugin;
						event.onDelete(userid);
					}
			}

		}
	}
	
	
	public void onLogin(AdminUser user){
		List<IPlugin> plugins = this.getPlugins();
		
		if (plugins != null) {
			
			for (IPlugin plugin : plugins) {
					if(plugin instanceof IAdminUserLoginEvent){
						IAdminUserLoginEvent event = (IAdminUserLoginEvent)plugin;
						event.onLogin(user);
					}
			}

		}
	}
	
	
}
