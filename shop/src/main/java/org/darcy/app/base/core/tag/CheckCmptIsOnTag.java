package org.darcy.app.base.core.tag;

import java.util.Map;

import org.darcy.framework.taglib.BaseFreeMarkerTag;
import org.darcy.service.framework.component.ComponentView;
import org.darcy.service.framework.component.IComponentManager;
import org.springframework.stereotype.Component;

import freemarker.template.TemplateModelException;

/**
 * 检测组件是否启用
 * @author fenlongli
 * @date 2015-7-22 上午11:34:39
 */
@Component
public class CheckCmptIsOnTag extends BaseFreeMarkerTag{
	private IComponentManager componentManager;
	@Override
	protected Object exec(Map params) throws TemplateModelException {
		//获取组件视图 判断是否存在、是否启用
		String componentName = params.get("componentName").toString();
		ComponentView componentView= componentManager.getCmptView(componentName);
		if(componentView==null||componentView.getEnable_state()!=1){
			return "OFF";
		}
		return "ON";
	}
	public IComponentManager getComponentManager() {
		return componentManager;
	}
	public void setComponentManager(IComponentManager componentManager) {
		this.componentManager = componentManager;
	}
}
