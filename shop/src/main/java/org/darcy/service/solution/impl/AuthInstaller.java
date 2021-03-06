package org.darcy.service.solution.impl;

import org.darcy.eop.sdk.context.EopSetting;
import org.darcy.framework.util.StringUtil;
import org.darcy.service.dbsolution.DBSolutionFactory;
import org.darcy.service.solution.IInstaller;
import org.springframework.stereotype.Service;
import org.w3c.dom.Node;

/**
 * 权限安装器
 * <p>
 * 自3.1后权限数据分离出数据文件，因数据安装放置在组件安装之后了。<br>
 * 原因是站点导出后，示例数据含有了组件创建的表或字段
 * </p>
 * @since 3.1
 * @author kingapex
 * 2012-10-11下午3:04:59
 */
@Service
public class AuthInstaller implements IInstaller {

	/**
	 * 调用解决方案下的auth.xml数据文件
	 */
	@Override
	public void install(String productId, Node fragment) {
		if(!"base".equals(productId)){
			System.out.println("install...");
			String app_apth = StringUtil.getRootPath();
			String dataSqlPath = app_apth+ "/products/" + productId +"/auth.xml";
			if(!DBSolutionFactory.dbImport(dataSqlPath,""))
				throw new RuntimeException("安装权限数据出错...");
		}
	}

}
