package org.darcy.service;

import org.darcy.app.base.core.model.Help;


/**
 * 帮助内容维护类
 * @author kingapex
 * 2010-10-17下午10:09:24
 */
public interface IHelpManager {
	
	/**
	 * 根据id获取帮助内容
	 * @param helpid
	 * @return
	 */
	public Help get(String helpid);
	
}
