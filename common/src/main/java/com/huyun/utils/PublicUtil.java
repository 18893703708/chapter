package com.huyun.utils;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PublicUtil {

	public static boolean ismobile(HttpServletRequest request) {
		String mobileGateWayHeaders[]=new String[]{"ZXWAP","chinamobile.com","monternet.com","infoX","XMS 724Solutions HTG","wap.lizongbo.com","Bytemobile",};  
	    /**电脑上的IE或Firefox浏览器等的User-Agent关键词*/  
	    String[] pcHeaders=new String[]{ "Windows 98","Windows ME","Windows 2000","Windows XP","Windows NT","Ubuntu"};  
		/**手机浏览器的User-Agent里的关键词*/  
	    String[] mobileUserAgents=new String[]{"Nokia","SAMSUNG","MIDP-2","CLDC1.1","SymbianOS","MAUI","UNTRUSTED/1.0","Windows CE","iPhone","iPad","Android","BlackBerry","UCWEB","ucweb","BREW","J2ME","YULONG","YuLong","COOLPAD","TIANYU","TY-","K-Touch", "Haier","DOPOD","Lenovo","LENOVO","HUAQIN","AIGO-","CTC/1.0","CTC/2.0","CMCC","DAXIAN","MOT-","SonyEricsson","GIONEE","HTC","ZTE","HUAWEI","webOS","GoBrowser","IEMobile","WAP2.0"}; 
	  
	    boolean pcFlag = false;  
	    boolean mobileFlag = false;  
	    String via = request.getHeader("Via");  
	    String userAgent = request.getHeader("user-agent");  
	    for (int i = 0; via!=null && !via.trim().equals("") && i < mobileGateWayHeaders.length; i++) {  
	        if(via.contains(mobileGateWayHeaders[i])){  
	            mobileFlag = true;  
	            break;  
	        }  
	    }  
	    for (int i = 0;!mobileFlag && userAgent!=null && !userAgent.trim().equals("") && i < mobileUserAgents.length; i++) {  
	        if(userAgent.contains(mobileUserAgents[i])){  
	            mobileFlag = true;  
	            break;  
	        }  
	    }  
	    for (int i = 0; userAgent!=null && !userAgent.trim().equals("") && i < pcHeaders.length; i++) {  
	        if(userAgent.contains(pcHeaders[i])){  
	            pcFlag = true;  
	            break;  
	        }  
	    }  
	    if(mobileFlag==true && pcFlag==false){  
	    	return true;
	    }
	    return false;
    }

	/**
	 * 生成唯一订单编号
	 * @return 
	 */
	public static String getDDCode() {
		try {
			String orderNo = "" ;
			String trandNo = String.valueOf((Math.random() * 9 + 1) * 1000000);
			orderNo = trandNo.toString().substring(0, 4);//随机生成数字
			String sdf = new SimpleDateFormat("yyMMddHHmmss").format(new Date()); 

            return orderNo = sdf + orderNo ;
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
		
	}
}
