
package com.sydx.aqsc.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class HanZiToPinYin {
	public static String toPinYin(String str) {

		str=str.replace("-", "");
		str=str.replace("#", "");
		str=str.replace("--", "");
		str=str.replace("(hz)", "");
		str=str.replace("(", "");
		str=str.replace(")", "");
		str=str.replace("（", ""); 
		str=str.replace("）", ""); 
		String py = "";
		String jx = "";
		String[] t = new String[str.length()];
		
		char [] hanzi=new char[str.length()];
        for(int i=0;i<str.length();i++){
            hanzi[i]=str.charAt(i);
        	//}
        }
		
		net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat t1 = new HanyuPinyinOutputFormat();
        t1.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        t1.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        t1.setVCharType(HanyuPinyinVCharType.WITH_V);
        
		try {
			for (int i = 0; i < str.length(); i++) {
				if ((str.charAt(i) >= 'a' && str.charAt(i) < 'z')
						|| (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')
						|| (str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
					py += str.charAt(i);
					jx+=str.charAt(i);
				} else {
			            t = PinyinHelper.toHanyuPinyinStringArray(hanzi[i], t1);
			            py=py+t[0];
			            jx+=t[0].substring(0, 1);
			        }
				}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
		}

		return py.trim().toString()+"|"+jx.trim().toString();
	}
	

}