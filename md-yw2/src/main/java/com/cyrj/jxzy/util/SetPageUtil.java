package com.cyrj.jxzy.util;



import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.cyrj.jxzy.entity.Common.Pager;



/**
 * @ClassName: SetPageUtil
 * @Description: TODO(为实体的startRow和endRow两个属性设置值)
 */
public class SetPageUtil {
	public static void setPage(Object o, Pager pager) {
		try {
			// 取得设置开始行的方法
			Method ssr = o.getClass().getMethod("setStartRow", int.class);
			// 取得设置结束行的方法
			Method ser = o.getClass().getMethod("setEndRow", int.class);
			// 算出开始行的值和结束行的值
			int x = pager.getPageNo() * pager.getPageSize();
			int y = (pager.getPageNo() - 1) * pager.getPageSize() + 1;
			// 为传入的实体设置开始行和结束行的属性值
			ssr.invoke(o, y);
			ser.invoke(o, x);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
