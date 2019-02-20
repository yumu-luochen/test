/**
 * 
 */
package com.rechen.hotelsys.config;

/**
 * @author Re.chen
 *
 */
public class VersionInfo {
	
    //application info
	public final static String APP_NAME="酒店客房管理系统";
    public final static String APP_VERSION="1.9";
    public final static String APP_STATUS="Beta";
    public final static String APP_BUILDATE="2019-02-04";
    public final static String APP_BUILDVER="#9";
    	
    //application author
    public final static String APP_AUTHOR="落尘开发";
    public final static String APP_WORKSTUDIO="至诚学院就业实训开发组";
    
    public final static String buildFooterStr()
    {
    	StringBuffer sb=new StringBuffer();

    	sb.append(APP_NAME);
    	sb.append(" "+"(版本:"+APP_STATUS+APP_VERSION);
    	sb.append(" &nbsp;&nbsp;Build:"+APP_BUILDVER);
    	sb.append(" "+APP_BUILDATE+")");
    	sb.append("&nbsp;&nbsp;&nbsp;&nbsp;开发团队:&nbsp;<a href=\"mailto:774569573@qq.com\">"+APP_AUTHOR+"</a><br/>");
    	sb.append("(C)&nbsp;"+APP_WORKSTUDIO+"&nbsp;&nbsp;");

    	return sb.toString();	
    }

}
