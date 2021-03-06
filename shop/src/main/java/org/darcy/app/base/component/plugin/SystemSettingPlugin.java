package org.darcy.app.base.component.plugin;

import org.darcy.app.base.core.plugin.setting.IOnSettingInputShow;
import org.darcy.app.base.core.plugin.setting.IOnSettingSaveEnvent;
import org.darcy.eop.SystemSetting;
import org.darcy.framework.plugin.AutoRegisterPlugin;
import org.springframework.stereotype.Component;

/**
 * 系统设置插件
 * @author kingapex
 *
 */
@Component
public class SystemSettingPlugin extends AutoRegisterPlugin implements
		IOnSettingInputShow,IOnSettingSaveEnvent {

	
	@Override
	public String onShow() {
		
		return "system-setting";
	}

	
	@Override
	public void onSave() {
		SystemSetting.load();
	}
	
	
	@Override
	public String getSettingGroupName() {
		
		return SystemSetting.setting_key;
	}

	@Override
	public String getTabName() {
		
		return "系统设置";
	}

	@Override
	public int getOrder() {
		
		return 5;
	}

	

}
