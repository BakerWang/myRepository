package org.darcy.service.solution.impl;

import org.apache.log4j.Logger;
import org.darcy.eop.sdk.IApp;
import org.darcy.eop.sdk.context.ConnectType;
import org.darcy.eop.sdk.context.EopSetting;
import org.darcy.framework.context.spring.SpringContextHolder;
import org.darcy.framework.database.IDaoSupport;
import org.darcy.service.resource.IAppManager;
import org.darcy.service.resource.model.EopApp;
import org.darcy.service.solution.IInstaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 应用安装器
 * @author kingapex
 * 2010-1-23下午03:17:08
 */
@Service
public class AppInstaller implements IInstaller {
	protected final Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private IAppManager appManager;
	
	@Autowired
	private IDaoSupport daoSupport;
	
 
	
	
	/**
	 * 初始化安装
	 * @param app
	 * @param el
	 */
	private void install(IApp app, Element el){

		//调用 应用的安装方法
		//因需要base应用创建表所以要先install再接入 
		app.install(); 
		

		//接入应用
		EopApp eopApp = new EopApp();
		eopApp.setApp_name(app.getName());
		eopApp.setAppid(app.getId());
		eopApp.setPath(app.getNameSpace());
		eopApp.setDeployment(ConnectType.local);
		eopApp.setDescript(app.getName());
		
		//v2.3.0新增：记录接入应用的版本
		eopApp.setVersion(el.getAttribute("version"));
		this.appManager.add(eopApp);
		

	}
	
	
	
	/**
     * 根据apps片断调用App进行安装
     */
	public void install(String productId, Node fragment) {
		/**
		 * 如果未安装清空应用表
		 */
		if(!EopSetting.INSTALL_LOCK.toUpperCase().equals("YES")){
			this.daoSupport.execute("truncate table eop_app");
		}
		
		
		//找出app结点进行安装
		NodeList nodeList  = fragment.getChildNodes();
		for(int i=0, len=nodeList.getLength();i<len;i++){
			Node node = nodeList.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){
				Element el = (Element)node;
				String appid = el.getAttribute("id");
				
				if(this.logger.isDebugEnabled()){
					this.logger.debug("安装应用["+appid+"]...");
				}
				
				IApp app =SpringContextHolder.getBean(appid);
				if(app!=null){
					
					//未安装，进行行初始化安装
					if(!EopSetting.INSTALL_LOCK.toUpperCase().equals("YES")){
						this.install(app,el);
					}
					
					 
				}
				
				if(this.logger.isDebugEnabled()){
					this.logger.debug("安装应用["+appid+"]完成.");
				}
			}
		}
	}
	
}
