//package com.huyun.utils;
//
//import com.fs.common.model.BASE64DecodedMultipartFile;
//import org.apache.commons.lang.StringUtils;
//import org.springframework.web.multipart.MultipartFile;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.IOException;
//import java.io.InputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.GregorianCalendar;
//import java.util.UUID;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//
///**
// *
// * 静态化路径工具类
// *
// */
//public class UtilPath {
//
//	/**
//	 * 获取到classes目录
//	 * @return path
//	 */
//	public static String getClassPath(){
//		String systemName = System.getProperty("os.name");
//
//		//判断当前环境，如果是Windows 要截取路径的第一个 '/'
//		if(!StringUtils.isBlank(systemName) && systemName.indexOf("Windows") !=-1){
//			return UtilPath.class.getResource("/").getFile().toString().substring(1);
//		}else{
//			return UtilPath.class.getResource("/").getFile().toString();
//		}
//	}
//	/**
//	 * 获取当前对象的路径
//	 * @param object
//	 * @return path
//	 */
//	public static String getObjectPath(Object object){
//		return object.getClass().getResource(".").getFile().toString();
//	}
//	/**
//	 * 获取到项目的路径
//	 * @return path
//	 */
//	public static String getProjectPath(){
//		return System.getProperty("user.dir");
//	}
//	/**
//	 * 获取 root目录
//	 * @return path
//	 */
//	public static String getRootPath(){
//		return getWEB_INF().replace("WEB-INF/", "");
//	}
//	/**
//	 * 获取输出HTML目录
//	 * @return
//	 */
//	public static String getHTMLPath(){
//		return getFreePath() + "html/html/";
//	}
//	/**
//	 * 获取输出FTL目录
//	 * @return
//	 */
//	public static String getFTLPath(){
//		return getFreePath() + "html/ftl/";
//	}
//	/**
//	 * 获取 web-inf目录
//	 * @return path
//	 */
//	public static String getWEB_INF(){
//		return getClassPath().replace("classes/", "");
//	}
//	/**
//	 * 获取模版文件夹路径
//	 * @return path
//	 */
//	public static String getFreePath(){
//		return getWEB_INF() + "ftl/";
//	}
//	/**
//	 * 获取一个目录下所有的文件
//	 * @param path
//	 * @return
//	 */
//	public static  File[] getFiles(String path){
//		  File file = new File(path);
//		  File[] files = file.listFiles();
//		  return files;
//	}
//	/**
//	 * 获取当前时间 + 中国时区
//	 * @return
//	 */
//	public static String getDate(){
//		SimpleDateFormat sformart=new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
//		String result = sformart.format(new Date());
//		result = result.replace("_", "T");
//		result += "+08:00";
//		return result;
//	}
//	/**
//	 * 不带结尾的XmlSitemap头部
//	 * @return
//	 */
//	public static String getXmlSitemap(){
//		StringBuffer sb = new StringBuffer()
//		.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + nextLine())
//		.append("<?xml-stylesheet type=\"text/xsl\" href=\"sitemap.xsl\"?>"+ nextLine())
//		.append("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">"+ nextLine());
//		return sb.toString();
//	}
//	/**
//	 * 文本换行
//	 * @return
//	 */
//	public static String nextLine(){
//		 String nextLine = System.getProperty("line.separator");
//		 return nextLine;
//	}
//	/**
//	 * 获取domain
//	 * @param request
//	 * @return
//	 */
//	public static String getDomain(HttpServletRequest request) {
//		return  ((String) request.getSession().getAttribute("nowPath")).replaceAll("(www.)|(.com)|(.net)|(http://)", "").trim();
//	}
//	/**
//	 * 获取images 路径
//	 * @return
//	 */
//	public static String getImages(){
//		return getRootPath() + "images/" ;
//	}
//
//	/**
//	  * 手机号验证
//	  * @author:hulihua
//	  * 2016年12月5日下午4:34:46
//	  * @param  str
//	  * @return 验证通过返回true
//	  */
//	 public static boolean isMobile(String str) {
//	     Pattern p = null;
//	     Matcher m = null;
//	     boolean b = false;
//	     p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
//	     m = p.matcher(str);
//	     b = m.matches();
//	     return b;
//	 }
//
//
//	/**
//	 * 生成唯一token
//	 * @return
//	 */
//	public static  String createToken(){
//		try {
//			String token = UUID.randomUUID().toString();
//			return token;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//    //把经纬度转为度（°）
//    private static double rad(double d){
//        return d * Math.PI / 180.0;
//    }
//
//    /**
//     * 根据两点间经纬度坐标（double值），计算两点间距离，单位为米
//     * @param lng1
//     * @param lat1
//     * @param lng2
//     * @param lat2
//     * @return
//     */
//    public static double getDistance(double lng1, double lat1, double lng2, double lat2){
//        double radLat1 = rad(lat1);
//
//        double radLat2 = rad(lat2);
//
//        double a = radLat1 - radLat2;
//
//        double b = rad(lng1) - rad(lng2);
//
//        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
//
//                Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
//
//        s = s * 6378.137;
//
//        return s;
//    }
//    //base64转MultipartFile
//	public static MultipartFile base64ToMultipart(String base64) {
//		try {
//			String[] baseStrs = base64.split(",");
//
//			BASE64Decoder decoder = new BASE64Decoder();
//			byte[] b = new byte[0];
//			b = decoder.decodeBuffer(baseStrs[1]);
//
//			for(int i = 0; i < b.length; ++i) {
//				if (b[i] < 0) {
//					b[i] += 256;
//				}
//			}
//
//			return new BASE64DecodedMultipartFile(b, baseStrs[0]);
//		} catch (IOException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//
//	/**
//	 * 转换图片路径
//	 * @param picpath	图片文件名
//	 * @return
//	 */
//	public static String transPicpath(String picpath){
//
//		if(StringUtils.isBlank(picpath) || picpath.length() < 9){
//			return "http://www.gsspaqw.org/upload/licpic/noPic.jpg";
//		}else{
//			if("_".equals(picpath.substring(8,9))){
//				return "http://www.gsspaqw.org/upload/licpic/"+picpath.substring(0,6)+"/"+picpath.substring(6,8)+"/"+picpath;
//			} else {
//				return picpath="http://www.gsspaqw.org/upload/licpic/2011XX/"+picpath;
//			}
//		}
//		//return "/upload/licpic/noPic.jpg";
//	}
//	//将图片地址转成MultipartFile
//	public static String GetImageStrFromUrl(String imgURL) {
//		ByteArrayOutputStream  outPut = new ByteArrayOutputStream();
//		byte[] data = new byte[1024];
//		try {
//			// 创建URL
//			URL url = new URL(imgURL);
//			// 创建链接
//			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//			conn.setRequestMethod("GET");
//			conn.setConnectTimeout(10 * 1000);
//
//			if(conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
//				return "fail";//连接失败/链接失效/图片不存在
//			}
//			InputStream inStream = conn.getInputStream();
//			int len = -1;
//			while ((len = inStream.read(data)) != -1) {
//				outPut.write(data, 0, len);
//			}
//			inStream.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		// 对字节数组Base64编码
//		BASE64Encoder encoder = new BASE64Encoder();
//		return encoder.encode(outPut.toByteArray());
//	}
//	//获取当前时间前10天的日期
//	public static String getCurrentDate(int year, int month, int day, int beDay) {
//		GregorianCalendar newCal = new GregorianCalendar(year, month, day);
//		long milSec = newCal.getTimeInMillis() - beDay * 24 * 3600 * 1000;
//		GregorianCalendar other = new GregorianCalendar();
//		other.setTimeInMillis(milSec);
//		String newYear = String.valueOf(other.get(GregorianCalendar.YEAR));
//		String newMonth = String.valueOf(other.get(GregorianCalendar.MONTH) + 1);
//		newMonth = newMonth.length() == 1 ? "0" + newMonth : newMonth;
//		String newDay = String.valueOf(other.get(GregorianCalendar.DAY_OF_MONTH));
//		newDay = newDay.length() == 1 ? "0" + newDay : newDay;
//		String date = newYear + "-" + newMonth + "-" + newDay;
//		return date;
//	}
//}
