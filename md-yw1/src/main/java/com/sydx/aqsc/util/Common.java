package com.sydx.aqsc.util;

import com.sydx.aqsc.entity.Admin.UserHeaderEntity;
import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common {

	/*
	 * 刘寿福 跨服务器上传文件
	 */
	public static final String PIC_HOST = "http://127.0.0.1:7001/a5adminFile";

	public static String getasc(String ceshi) {// 字符--->ascii
		char[] dd = ceshi.toCharArray();
		String pp = "";
		for (int i = 0; i < dd.length; i++) {
			pp = pp + (int) dd[i] + ",";
		}
		return pp;
	}

	public static String[] intersect(String[] arr1, String[] arr2) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		LinkedList<String> list = new LinkedList<String>();
		for (String str : arr1) {
			if (!map.containsKey(str)) {
				map.put(str, Boolean.FALSE);
			}
		}
		for (String str : arr2) {
			if (map.containsKey(str)) {
				map.put(str, Boolean.TRUE);
			}
		}

		for (Entry<String, Boolean> e : map.entrySet()) {
			if (e.getValue().equals(Boolean.TRUE)) {
				list.add(e.getKey());
			}
		}

		String[] result = {};
		return list.toArray(result);
	}
	// 刘寿福

	public static double formatsj2(double sj) {
		DecimalFormat df1 = new DecimalFormat("######0.0#");
		double rsj = Double.parseDouble(df1.format(sj));
		return rsj;
	}

	public static float formatsj4(float sj) {
		DecimalFormat df1 = new DecimalFormat("######0.0###");
		float rsj = Float.parseFloat(df1.format(sj));
		return rsj;
	}

	public static double formatsj4(double sj) {
		DecimalFormat df1 = new DecimalFormat("######0.0###");
		double rsj = Double.parseDouble(df1.format(sj));
		return rsj;
	}

	public static String returnasc(String pp) {// ascII--->字符
		String[] ddd = pp.split(",");
		char[] dd = new char[ddd.length];
		for (int i = 0; i < dd.length; i++) {
			dd[i] = (char) Integer.parseInt(ddd[i]);
		}
		return new String(dd);
	}

	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	public static String md5_2(String source) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(source.getBytes("utf-8"));
			byte[] digest = md5.digest();
			BigInteger code = new BigInteger(1, digest);
			return (code.toString(16)).toUpperCase();
		} catch (Exception e) {
			return null;
		}
	}

	public static List objectChangeList(List list) {
		List list1 = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			list1.add(objectChange(list.get(i)));// 调用下的转换方法，转换list里面的内容
		}
		return list1;
	}

	public static Object objectChange(Object aa) {
		Class aac = (Class) aa.getClass();// 获得对应对象的类类型
		Field[] fs = aac.getDeclaredFields();// 获得该对象的所有的属性
		for (int i = 0; i < fs.length; i++) {
			// 循环属性，只要string类型的。构造出首字母大写的属性名
			String shuxing = fs[i].toString();
			if (shuxing.indexOf("String") == -1)
				continue;
			String shuxingd = shuxing.substring(shuxing.lastIndexOf(".") + 1, shuxing.length());
			shuxingd = shuxingd.replaceFirst(shuxingd.substring(0, 1), shuxingd.substring(0, 1).toUpperCase());
			// System.out.println(shuxingd);
			Method m1;
			try {
				/* 获得get方法 */
				m1 = aac.getDeclaredMethod("get" + shuxingd);

				/* 获得set方法 */
				Method m2 = aac.getDeclaredMethod("set" + shuxingd, String.class);
				/* 当接受到前端页面传递过来的属性非空时转换。 */
				String msg = (String) m1.invoke(aa);
				if (msg != null) {
					msg = new String(msg.getBytes("ISO-8859-1"), "utf-8");
					m2.invoke(aa, msg);
				}
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return aa;
	}

	// 删除 2014-05-14 传入一个String字符，用utf8重新编码
	public static String ISO2UTF(String arg) {
		if (arg == null)
			return null;
		try {
			arg = new String(arg.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return arg.trim();
	}

	// 删除 2014-05-16 传入double数据四舍五入取小数点后两位
	public static double convert(double value) {
		long l1 = Math.round(value * 100); // 四舍五入
		double ret = l1 / 100.0; // 注意：使用 100.0 而不是 100
		return ret;
	}

	public static String fomateDateToString1(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(date);
	}

	public static String fomateDateToString2(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(date);
	}

	public static String getColor() {
		String r, g, b;
		Random random = new Random();
		r = Integer.toHexString(random.nextInt(256)).toUpperCase();
		g = Integer.toHexString(random.nextInt(256)).toUpperCase();
		b = Integer.toHexString(random.nextInt(256)).toUpperCase();
		r = r.length() == 1 ? "0" + r : r;
		g = g.length() == 1 ? "0" + g : g;
		b = b.length() == 1 ? "0" + b : b;
		return r + g + b;
	}

	// 功能：汉字转拼音缩写；说明：* @param str //要转换的汉字字符串;@return String //拼音缩写大写字母；
	public static String getPYString(String str) {
		String tempStr = "";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if ((int) c >= 33 && (int) c <= 126) {// 字母和符号原样保留
				tempStr += String.valueOf(c);
			} else {// 累加拼音声母
				tempStr += getPYChar(String.valueOf(c));
			}
		}
		return tempStr.toUpperCase();
	}

	// * 取单个字符的拼音声母* @param c //要转换的单个汉字* @return String 拼音声母
	public static String getPYChar(String c) {
		byte[] array = new byte[2];
		array = String.valueOf(c).getBytes();
		int i = (short) (array[0] - '\0' + 256) * 256 + ((short) (array[1] - '\0' + 256));
		if (i < 0xB0A1)
			return "*";
		if (i < 0xB0C5)
			return "a";
		if (i < 0xB2C1)
			return "b";
		if (i < 0xB4EE)
			return "c";
		if (i < 0xB6EA)
			return "d";
		if (i < 0xB7A2)
			return "e";
		if (i < 0xB8C1)
			return "f";
		if (i < 0xB9FE)
			return "g";
		if (i < 0xBBF7)
			return "h";
		if (i < 0xBFA6)
			return "j";
		if (i < 0xC0AC)
			return "k";
		if (i < 0xC2E8)
			return "l";
		if (i < 0xC4C3)
			return "m";
		if (i < 0xC5B6)
			return "n";
		if (i < 0xC5BE)
			return "o";
		if (i < 0xC6DA)
			return "p";
		if (i < 0xC8BB)
			return "q";
		if (i < 0xC8F6)
			return "r";
		if (i < 0xCBFA)
			return "s";
		if (i < 0xCDDA)
			return "t";
		if (i < 0xCEF4)
			return "w";
		if (i < 0xD1B9)
			return "x";
		if (i < 0xD4D1)
			return "y";
		if (i < 0xD7FA)
			return "z";
		return "*";
	}

	/**
	 * 
	 * @Title: replaceBlank @Description: TODO(使用正则表达式去除空格、回车) @param @param
	 *         str @param @return 设定文件 @return String 返回类型 @throws
	 */
	public static String replaceBlank(String str) {
		String after = "";
		if (str != null && str.length() > 0) {
			Pattern p = Pattern.compile("\\s*|\t|\r|\n");
			Matcher m = p.matcher(str);
			after = m.replaceAll("");
		}
		return after;
	}

	/**
	 * 
	 * @Title: isDecimal @Description: TODO(判断一个字符串是否是小数类型的格式) @param @param
	 *         str @param @return 设定文件 @return boolean 返回类型 @throws
	 */
	public static boolean isDecimal(String str) {
		if (str == null) {
			return false;
		} else if ("".equals(str)) {
			return false;
		} else {
			return Pattern.compile("([1-9]+[0-9]*|0)(\\.[\\d]+)?").matcher(str).matches();
		}

	}

	/**
	 * 
	 * @Title: isNumber @Description: TODO(判断一个字符串是否是整数类型的格式) @param @param
	 *         str @param @return 设定文件 @return boolean 返回类型 @throws
	 */
	public static boolean isNumber(String str) {
		return Pattern.compile("^[0-9]*[1-9][0-9]*$").matcher(str).matches();
	}

	public static int getNewID(Statement stmt, String tableName) throws Exception {
		int id = 0;
		ResultSet rs = stmt.executeQuery("SELECT MAX(ID) AS ID FROM " + tableName);
		String str = "";
		if (rs.next())
			str = rs.getString("ID");
		if (str == null || str.equals(""))
			str = "0";
		id = Integer.parseInt(str);
		return id + 1;
	}

	public static int getNewIDD(Statement stmt, String tableName) throws Exception {
		int id = 0;
		ResultSet rs = stmt.executeQuery("SELECT MAX(ID) AS ID FROM " + tableName);
		String str = "";
		if (rs.next())
			str = rs.getString("ID");
		if (str == null || str.equals(""))
			str = "0";
		id = Integer.parseInt(str);
		return id;
	}

	public String[] toArray(String str) {
		ArrayList list = new ArrayList();
		StringTokenizer st = new StringTokenizer(str, ",");
		int iIndex = 0;
		for (; st.hasMoreTokens(); list.add(iIndex++, st.nextToken()))
			;
		String reStr[] = new String[iIndex];
		for (int i = 0; i < iIndex; i++)
			reStr[i] = (String) list.get(i);

		return reStr;
	}

	public String[] toArray(String str, String token) {
		ArrayList list = new ArrayList();
		StringTokenizer st = new StringTokenizer(str, token);
		int iIndex = 0;
		for (; st.hasMoreTokens(); list.add(iIndex++, st.nextToken()))
			;
		String reStr[] = new String[iIndex];
		for (int i = 0; i < iIndex; i++)
			reStr[i] = (String) list.get(i);

		return reStr;
	}

	public String toLv(float f, int i) {
		String str = new String("");
		str = (new BigDecimal(f * 100F)).setScale(i, 5) + "%";
		return str;
	}

	public String toLv(double f, int i) {
		String str = new String("");
		str = (new BigDecimal(f * 100D)).setScale(i, 5) + "%";
		return str;
	}

	public String format(float f, int i) {
		String fTemp = new String("");
		fTemp = String.valueOf((new BigDecimal(f)).setScale(i, 5));
		if (Float.parseFloat(fTemp) == 0.0F)
			fTemp = "";
		return fTemp;
	}

	public String format(double f, int i) {
		String fTemp = new String("");
		fTemp = String.valueOf((new BigDecimal(f)).setScale(i, 5));
		if (Float.parseFloat(fTemp) == 0.0F)
			fTemp = "";
		return fTemp;
	}

	public String toGB2312(String s) throws UnsupportedEncodingException {
		String ss = s;
		if (ss != null) {
			ss = new String(ss.getBytes("ISO8859-1"), "GB2312");
			return ss;
		} else {
			return "";
		}
	}

	public String toISO8859_1(String s) throws UnsupportedEncodingException {
		String ss = s;
		if (ss != null) {
			ss = new String(ss.getBytes("GB2312"), "ISO8859-1");
			return ss;
		} else {
			return "";
		}
	}

	public static String isNull(String o) {
		if (o == null) {
			return "";
		} else {
			return o;
		}
	}

	public static String isNull(double o) throws UnsupportedEncodingException {
		if (o != 0.0D)
			return String.valueOf(o);
		else
			return "";
	}

	public static String isNull(float o) throws UnsupportedEncodingException {
		if (o != 0.0F)
			return String.valueOf(o);
		else
			return "";
	}

	public static String isNull(long o) throws UnsupportedEncodingException {
		if (o != 0L)
			return String.valueOf(o);
		else
			return "";
	}

	public static String isNull(int o) throws UnsupportedEncodingException {
		if (o != 0)
			return String.valueOf(o);
		else
			return "";
	}

	public static Integer isNullTo0(Integer data) {

		return data == null ? 0 : data;
	}

	public static Float isNullTo0(Float data) {

		return data == null ? 0.0f : data;
	}

	public String getAbsoluteFilename(HttpServletRequest request) {
		String absolutePath = request.getRealPath(request.getRequestURI().replaceFirst(request.getContextPath(), ""));
		return absolutePath;
	}

	public String getAbsolutePath(HttpServletRequest request) {
		String path = new String("");
		String absolutePath = request.getRealPath(request.getRequestURI().replaceFirst(request.getContextPath(), ""));
		path = (new File(absolutePath)).getParent();
		return path;
	}

	public String getFilename(HttpServletRequest request) {
		String url = request.getRequestURI();
		url = url.substring(url.lastIndexOf("/") + 1, url.length());
		return url;
	}

	public static String getAbsPath(HttpServletRequest request, ServletContext application) {
		String dbpath = request.getServletPath().substring(0, request.getServletPath().indexOf("/", 1) + 1);
		int pos = 0;
		for (; dbpath.indexOf("/") != -1; dbpath = dbpath.substring(0, pos) + "\\"
				+ dbpath.substring(pos != 0 ? pos + 1 : 1))
			pos = dbpath.indexOf("/");

		if (dbpath.trim().equals(""))
			dbpath = "\\";
		String file = request.getRequestURI();
		file = file.substring(file.lastIndexOf("/") + 1);
		String fileName = application.getRealPath("") + dbpath + file;
		return fileName;
	}

	public static String getAbsPath(HttpServletRequest request, ServletContext application, String file) {
		String dbpath = request.getServletPath().substring(0, request.getServletPath().indexOf("/", 1) + 1);
		int pos = 0;
		for (; dbpath.indexOf("/") != -1; dbpath = dbpath.substring(0, pos) + "\\"
				+ dbpath.substring(pos != 0 ? pos + 1 : 1))
			pos = dbpath.indexOf("/");

		if (dbpath.trim().equals(""))
			dbpath = "\\";
		String fileName = application.getRealPath("") + dbpath + file;
		return fileName;
	}

	public static String getTomcatHome(HttpServletRequest request) {
		String tomcatHome = "";
		tomcatHome = request.getRealPath("/");
		return tomcatHome;
	}

	public static String getFileName(HttpServletRequest request, String filename) {
		String fileName = "";
		fileName = getTomcatHome(request) + filename;
		return fileName;
	}

	public static String combineStringArray(String array[], String delim) {
		int length = array.length - 1;
		if (delim == null)
			delim = "";
		StringBuffer result = new StringBuffer(length * 8);
		for (int i = 0; i < length; i++) {
			result.append(array[i]);
			result.append(delim);
		}

		result.append(array[length]);
		return result.toString();
	}

	public static int contains(String strings[], String string) {
		return contains(strings, string, true);
	}

	public static int contains(String strings[], String string, boolean caseSensitive) {
		for (int i = 0; i < strings.length; i++)
			if (caseSensitive) {
				if (strings[i].equals(string))
					return i;
			} else if (strings[i].equalsIgnoreCase(string))
				return i;

		return -1;
	}

	public static int containsIgnoreCase(String strings[], String string) {
		return contains(strings, string, false);
	}

	public static String escapeCharacter(String source, HashMap escapeCharMap) {
		if (source == null || source.length() == 0)
			return source;
		if (escapeCharMap.size() == 0)
			return source;
		StringBuffer sb = new StringBuffer();
		StringCharacterIterator sci = new StringCharacterIterator(source);
		for (char c = sci.first(); c != '\uFFFF'; c = sci.next()) {
			String character = String.valueOf(c);
			if (escapeCharMap.containsKey(character))
				character = (String) escapeCharMap.get(character);
			sb.append(character);
		}

		return sb.toString();
	}

	public static String escapeString(String source, Map escapeStringMap) {
		if (source == null || source.length() == 0)
			return source;
		if (escapeStringMap.size() == 0)
			return source;
		Collection colValues = escapeStringMap.values();
		Collection colKeys = escapeStringMap.keySet();
		Iterator itValues = colValues.iterator();
		for (Iterator itKeys = colKeys.iterator(); itValues.hasNext() && itKeys.hasNext();)
			source = replace(source, (String) itKeys.next(), (String) itValues.next());

		return source;
	}

	public static String parseGBtoISO(String str) throws UnsupportedEncodingException {
		String ss = str;
		if (ss == null)
			ss = new String(ss.getBytes("GB2312"), "ISO8859-1");
		else
			ss = "";
		return ss;
	}

	public static String parseISOtoGB(String str) throws UnsupportedEncodingException {
		String ss = str;
		if (ss != null)
			ss = new String(ss.getBytes("ISO8859-1"), "GB2312");
		else
			ss = "";
		return str;
	}

	public static String putStringinQuote(String str) {
		if (str.startsWith("\"") && str.endsWith("\""))
			return str;
		else
			return "\"" + str + "\" ";
	}

	public static String replace(String strSource, String strFrom, String strTo) {
		if (strFrom == null || strFrom.equals(""))
			return strSource;
		String strDest = "";
		int intFromLen = strFrom.length();
		int i;
		while ((i = strSource.indexOf(strFrom)) != -1) {
			strDest = strDest + strSource.substring(0, i);
			strDest = strDest + strTo;
			strSource = strSource.substring(i + intFromLen);
		}
		strDest = strDest + strSource;
		return strDest;
	}

	public static String[] split(String source) {
		return split(source, ",");
	}

	public static String[] split(String source, char delim) {
		return split(source, String.valueOf(delim));
	}

	public static String[] split(String source, String delim) {
		String wordLists[];
		if (source == null) {
			wordLists = new String[1];
			wordLists[0] = source;
			return wordLists;
		}
		if (delim == null)
			delim = ",";
		StringTokenizer st = new StringTokenizer(source, delim);
		int total = st.countTokens();
		wordLists = new String[total];
		for (int i = 0; i < total; i++)
			wordLists[i] = st.nextToken();

		return wordLists;
	}

	public static String trimLeft(String value) {
		String result = value;
		if (result == null)
			return result;
		char ch[] = result.toCharArray();
		int index = -1;
		for (int i = 0; i < ch.length; i++) {
			if (!Character.isWhitespace(ch[i]))
				break;
			index = i;
		}

		if (index != -1)
			result = result.substring(index + 1);
		return result;
	}

	public static String trimRight(String value) {
		String result = value;
		if (result == null)
			return result;
		char ch[] = result.toCharArray();
		int endIndex = -1;
		for (int i = ch.length - 1; i > -1; i--) {
			if (!Character.isWhitespace(ch[i]))
				break;
			endIndex = i;
		}

		if (endIndex != -1)
			result = result.substring(0, endIndex);
		return result;
	}

	public static String StrToUTF(String str) {
		String utf = "";
		try {
			utf = URLEncoder.encode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return utf;
	}

	public static String UTFToStr(String str) {
		String str1 = "";
		try {
			str1 = URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return str1;
	}

	// 格式化数字
	public static String formatsj21(double f, int i) {
		String fTemp = "";
		fTemp = String.valueOf((new BigDecimal(f)).setScale(i, 5));
		// System.out.println((new BigDecimal(f)));
		if (Float.parseFloat(fTemp) == 0.0F)
			fTemp = "";
		return fTemp;
	}

	// RSA解密，私钥固定
	public static String decrypt(String str,String key) throws Exception {
		  String privateKey = key;
		// 64位解码加密后的字符串
		byte[] inputByte = Base64.decodeBase64(str.getBytes("UTF-8"));

		// base64编码的私钥
		byte[] decoded = Base64.decodeBase64(privateKey);
		RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA")
				.generatePrivate(new PKCS8EncodedKeySpec(decoded));
		// RSA解密
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, priKey);
		String outStr = new String(cipher.doFinal(inputByte));
		return outStr;
	}

	public static String getLastYear() {
		LocalDate today = LocalDate.now();
		today = today.minusYears(1);
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy");
		return formatters.format(today);
	}

	public static String getLastMonth() {
		LocalDate today = LocalDate.now();
		today = today.minusMonths(1);
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM");
		return formatters.format(today);
	}

	public static String resetNyA(String ny1, String ny2) {// 查ny1-ny2
		Date rq = null;

		try {
			rq = new SimpleDateFormat("yyyy-MM-dd").parse(ny1 + "-01");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(rq);
		calendar.add(Calendar.DATE, -2);
		String ss = new SimpleDateFormat("yyyy-MM").format(calendar.getTime()) + "-26";
		return ss + "A" + ny2 + "-25";
	}

	public static String getLastDay() {
		LocalDate today = LocalDate.now();
		today = today.minusDays(1);
		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return formatters.format(today);
	}

	/*** 图片、管柱图参数加密 */

	public static String encryption_pic(String str,String key) {
		// 获取当前时间戳,也可以是你自已给的一个随机的或是别人给你的时间戳(一定是long型的数据)
		long timeStamp = System.currentTimeMillis();
		// 这个是你要转成后的时间的格式
		SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 时间戳转换成时间
		String sd = sdff.format(new Date(timeStamp));
		// out.println(sd);//打印出你要的时间
		timeStamp = timeStamp + 60 * 60 * 1000;// 当前时间往后推一小时
		// sd = sdff.format(new Date(timeStamp));
		// out.println(sd);//打印出你要的时间
		// str=str+"|"+timeStamp+"|Gg0sqqtjxOxqGnwT";
		str = str + "|" + timeStamp;

		String publicKey = key;

		// base64编码的公钥
		byte[] decoded = Base64.decodeBase64(publicKey);
		RSAPublicKey pubKey;
		String outStr = "";
		try {
			pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
			// RSA加密
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.ENCRYPT_MODE, pubKey);
			outStr = Base64.encodeBase64String(cipher.doFinal(str.getBytes("UTF-8")));

			// outStr = Base64.encodeBase64String(cipher.doFinal(outStr.getBytes("UTF-8")));
			outStr = outStr.replace("+", "|A|");
			outStr = outStr.replace("/", ",");
			return outStr;
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return outStr;

	}

	

	public static String encryptAndDencrypt(String value, char secret) {
		// 获取当前时间戳,也可以是你自已给的一个随机的或是别人给你的时间戳(一定是long型的数据)
		long timeStamp = System.currentTimeMillis();
		// 这个是你要转成后的时间的格式
		SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// 时间戳转换成时间
		String sd = sdff.format(new Date(timeStamp));
		// out.println(sd);//打印出你要的时间
		timeStamp = timeStamp + 60 * 60 * 1000;// 当前时间往后推一小时
		// sd = sdff.format(new Date(timeStamp));
		// out.println(sd);//打印出你要的时间
		// str=str+"|"+timeStamp+"|Gg0sqqtjxOxqGnwT";
		value = value + "|" + timeStamp;
		byte[] bt = value.getBytes(); // 将需要加密的内容转换为字节数组
		for (int i = 0; i < bt.length; i++) {
			bt[i] = (byte) (bt[i] ^ (int) secret); // 通过异或运算进行加密
		}
		String newresult = new String(bt, 0, bt.length); // 将加密后的字符串保存到 newresult 变量中
		return newresult;
	}

	/*
	 * 生成密钥
	 */
	public static byte[] initKey() throws Exception {
		KeyGenerator keyGen = KeyGenerator.getInstance("DES");
		keyGen.init(56);
		SecretKey secretKey = keyGen.generateKey();
		return secretKey.getEncoded();
	}

	/*
     * DES 加密
     */
    public static byte[] encrypt(byte[] data, byte[] key) throws Exception{
        SecretKey secretKey = new SecretKeySpec(key, "DES");
        
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] cipherBytes = cipher.doFinal(data);
        return cipherBytes;
    }
    
    
    /*
     * DES 解密
     */
    public static byte[] decrypt(byte[] data, byte[] key) throws Exception{
        SecretKey secretKey = new SecretKeySpec(key, "DES");
        
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] plainBytes = cipher.doFinal(data);
        return plainBytes;
    }


    public static final String ALGORITHM_DES = "DES";  //指定算法名称

    /**
     * DES加密 
     * @param 要加密的字符串
     * @return 加密完成的字符串
     */
    public static String encode(String data,String myKey) {  
        if(data == null)  
            return null;  
        try{
        	long timeStamp = System.currentTimeMillis();
			// 这个是你要转成后的时间的格式
			SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// 时间戳转换成时间
			String sd = sdff.format(new Date(timeStamp));
			// out.println(sd);//打印出你要的时间
			timeStamp = timeStamp + 60 * 60 * 1000;// 当前时间往后推一小时
			// sd = sdff.format(new Date(timeStamp));
			// out.println(sd);//打印出你要的时间
			// str=str+"|"+timeStamp+"|Gg0sqqtjxOxqGnwT";
			data = data + "|" + timeStamp;
            String key = myKey;
            DESKeySpec dks = new DESKeySpec(key.getBytes());              
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
            //key的长度不能够小于8位字节  
            Key secretKey = keyFactory.generateSecret(dks);  
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);  
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);             
            byte[] bytes = cipher.doFinal(data.getBytes());              
            return byte2str(bytes);  
        }catch(Exception e){  
            e.printStackTrace();  
            return data;  
        }  
    }  


    /**
     * DES解密 
     * @param 要解密的字符串
     * @return 解密完成的字符串
     */
    public static String decode(String data,String myKey) {  
        if(data == null)  
            return null;  
        try {  
            String key = myKey;
            DESKeySpec dks = new DESKeySpec(key.getBytes());    
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");  
            //key的长度不能够小于8位字节  
            Key secretKey = keyFactory.generateSecret(dks);  //获取init需要的key
            Cipher cipher = Cipher.getInstance(ALGORITHM_DES);  
            cipher.init(Cipher.DECRYPT_MODE, secretKey);  
            return new String(cipher.doFinal(str2byte(data.getBytes())));  
        } catch (Exception e){  
            e.printStackTrace();  
            return data;  
        }  
    }  

    /** 
     * 字节数组转字符串 
     * @param //字节数组
     * @return 转换之后的字符串
     */  
    private static String byte2str(byte[] b) {  
        StringBuilder hs = new StringBuilder();  
        String stmp;  
        for (int n = 0; b!=null && n < b.length; n++) {  
            stmp = Integer.toHexString(b[n] & 0XFF);    //将int转换成base16的字符串,
                                                        //b[n] & 0XFF将会判断b[n]的值，如果为正，则不变化，如果为负，则转换成对应的byte 的1~255的值
            if (stmp.length() == 1)  
                hs.append('0');  
            hs.append(stmp);  
        }  
        return hs.toString().toUpperCase();  
    }  
     /**
      * 字符串转字节数组
      * @param //字符串的字节数组
      * @return 字节数组
      */
    private static byte[] str2byte(byte[] b) {  
        if((b.length%2)!=0)     //判断是否为偶数
            throw new IllegalArgumentException();  
        byte[] b2 = new byte[b.length/2];  
        for (int n = 0; n < b.length; n+=2) {  
            String item = new String(b,n,2);  
            b2[n/2] = (byte)Integer.parseInt(item,16);  //将字符串转换成16进制的byte
        }  
        return b2;  
    }

	public static String DataEncrypt(String str, byte[] key) {

		String encrypt = null;
		// 获取当前时间戳,也可以是你自已给的一个随机的或是别人给你的时间戳(一定是long型的数据)
				long timeStamp = System.currentTimeMillis();
				// 这个是你要转成后的时间的格式
				SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				// 时间戳转换成时间
				String sd = sdff.format(new Date(timeStamp));
				// out.println(sd);//打印出你要的时间
				timeStamp = timeStamp + 60 * 60 * 1000;// 当前时间往后推一小时
				// sd = sdff.format(new Date(timeStamp));
				// out.println(sd);//打印出你要的时间
				// str=str+"|"+timeStamp+"|Gg0sqqtjxOxqGnwT";
				str = str + "|" + timeStamp;
		try {

			byte[] ret = encrypt(str.getBytes("UTF-8"), key);

			encrypt = new String(Base64.encodeBase64(ret));

		} catch (Exception e) {

			System.out.print(e);

			encrypt = str;

		}

		return encrypt;

	}

	public static String DataDecrypt(String str, byte[] key) {

		String decrypt = null;

		try {

			byte[] ret = decrypt(Base64.decodeBase64(str), key);

			decrypt = new String(ret, "UTF-8");

		} catch (Exception e) {

			System.out.print(e);

			decrypt = str;

		}

		return decrypt;

	}
	/**
	 *
	 * @param str
	 * @return我方自己的解密
	 * @throws Exception
	 */
	public  static   String decrypt2(String str, String privateKey) throws Exception{
		str = str.replace("|A|", "+");

		//64位解码加密后的字符串
		byte[] inputByte = org.apache.tomcat.util.codec.binary.Base64.decodeBase64(str.getBytes("UTF-8"));

		//base64编码的私钥
		byte[] decoded = org.apache.tomcat.util.codec.binary.Base64.decodeBase64(privateKey);
		RSAPrivateKey priKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
		//RSA解密
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, priKey);
		String outStr = new String(cipher.doFinal(inputByte));
		return outStr;
	}

	//解析header中用户信息
	public static UserHeaderEntity getUserHeader(String user){

		JSONObject jsonObject = JSONObject.fromObject(user);
		UserHeaderEntity obj = (UserHeaderEntity)JSONObject.toBean(jsonObject, UserHeaderEntity.class);
		obj.setOilfield("pc0dq");
		obj.setAttribute("2");
		obj.setSearch("pc0dq");
		obj.setUnitid("pc0dq003009");
		return obj;
	}
}
