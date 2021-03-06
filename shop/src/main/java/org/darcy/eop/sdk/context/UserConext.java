package org.darcy.eop.sdk.context;

import org.darcy.app.base.core.model.Member;
import org.darcy.framework.context.webcontext.ThreadContextHolder;
import org.darcy.framework.context.webcontext.WebSessionContext;
import org.darcy.service.resource.model.AdminUser;

/**
 * 用户上下文
 * @author kingapex
 *
 */
public abstract class UserConext {
	public static final String CURRENT_MEMBER_KEY="curr_member";
	public static final String CURRENT_ADMINUSER_KEY="curr_adminuser";
	
	/**
	 * 获取当前登录的会员
	 * @return 如果没有登录返回null
	 */
	public static Member getCurrentMember(){
		
		WebSessionContext<Member> sessonContext = ThreadContextHolder.getSessionContext();
		return sessonContext.getAttribute(UserConext.CURRENT_MEMBER_KEY);
	}
	
	/**
	 * 获取当前登录的管理员
	 * @return 如果没有登录返回null
	 */
	public static AdminUser getCurrentAdminUser(){
		
		WebSessionContext<AdminUser> sessonContext = ThreadContextHolder.getSessionContext();
		return sessonContext.getAttribute(UserConext.CURRENT_ADMINUSER_KEY);
	}
}
