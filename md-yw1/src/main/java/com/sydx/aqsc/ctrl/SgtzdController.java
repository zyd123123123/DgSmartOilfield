package com.sydx.aqsc.ctrl;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.sydx.aqsc.entity.sgtzd.UserVo;
import com.sydx.aqsc.util.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.*;



@RestController
@RequestMapping("/user")
public class SgtzdController {

	private String remoteFile;
	public String[] pythonPath=new String[]{"C:\\Users\\Administrator\\AppData\\Local\\Programs\\Python\\Python38\\python.exe","D:\\dayt_py_data\\VUE-PYTHON\\PtoV\\代码\\main.py"};
	public String PATH=new String("D:\\dayt_py_data");
	public String[] args11=new String[]{"C:\\Users\\Administrator\\AppData\\Local\\Programs\\Python\\Python38\\python.exe", PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\diaoyong_data_baocunshujuku.py"};// python程序名
	public String[] args12=new String[]{"C:\\Users\\Administrator\\AppData\\Local\\Programs\\Python\\Python38\\python.exe", PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\model_training_1.2_optimization.py"};
	public String[] args13=new String[]{"C:\\Users\\Administrator\\AppData\\Local\\Programs\\Python\\Python38\\python.exe", PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\model_training_1.2.py"};
	public String[] args14=new String[]{"C:\\Users\\Administrator\\AppData\\Local\\Programs\\Python\\Python38\\python.exe", PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\model_forecast.py"};
	public String[] args20=new String[]{"C:\\Users\\Administrator\\AppData\\Local\\Programs\\Python\\Python38\\python.exe", PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\TEST.py"};

	// 特征处理部分

	// 保存起止时间
	@GetMapping("/get_total_date")
	public ResponseData get_total_date1(String startdate, String enddate) {
		try {
//			System.out.println("start");
			System.out.println(startdate);
			File writename1 = new File(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\start_date.txt");
			writename1.createNewFile();
			BufferedWriter out1 = new BufferedWriter(new FileWriter(writename1));
			out1.write(startdate+"\r\n"); // \r\n为换行
			out1.flush(); // 把缓存区内容压入文件
			out1.close();

			System.out.println(enddate);
			File writename2 = new File(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\end_date.txt");
			writename2.createNewFile();
			BufferedWriter out2 = new BufferedWriter(new FileWriter(writename2));
			out2.write(enddate + "\r\n"); // \r\n为换行
			out2.flush(); // 把缓存区内容压入文件
			out2.close();
			System.out.println("数据时间保存成功！");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseData.fail("识别数据保存失败！");
	}

	// 调用python来将数据导入数据库
	@RequestMapping("/diaoyong_shujuku")
	public ResponseData diaoyong_shujuku()  throws JsonParseException, JsonMappingException, IOException   {

		//调用python
		List<String> data_label11 = new ArrayList<String>();
		List<String> line1 = new ArrayList<String>();
		try {
			System.out.println("start");
			//环境和main
//			String[] args1=new String[]{"E:\\PYthon\\python.exe", PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\diaoyong_data_baocunshujuku.py"};// python程序名
			Process pr=Runtime.getRuntime().exec(args11);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					pr.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
//				training_label1.add(line);
				System.out.println(line);
			}
//			System.out.println(training_label1);
			in.close();
			pr.waitFor();
			System.out.println("数据库加载成功！");
			System.out.println("end");
			data_label11.add("数据加载完成！");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		};
		Map<String, Object> result = new HashMap();
		result.put("data_label11", data_label11);
		return ResponseData.ok(result);
	}

	// 获取特征数据
	@GetMapping("/getdataList")
	public ResponseData getdataListUsers() throws IOException {

		List<String> jh_list = new ArrayList<>();
		List<String> csrq_list = new ArrayList<>();
		List<String> sccdygfz_list = new ArrayList<>();
		List<String> scczhgfz_list = new ArrayList<>();
		List<String> xccdygfz_list = new ArrayList<>();
		List<String> xcczhgfz_list = new ArrayList<>();
		List<String> sccxl1_list = new ArrayList<>();
		List<String> sccxl2_list = new ArrayList<>();
		List<String> xccxl1_list = new ArrayList<>();
		List<String> xccxl2_list = new ArrayList<>();
		List<String> yxcc_list = new ArrayList<>();
		List<String> cmcd_list = new ArrayList<>();
		List<String> bs_list = new ArrayList<>();
		List<String> hsl_list = new ArrayList<>();
		List<String> ydfgbzh_list = new ArrayList<>();
		List<String> xccpjzh_list = new ArrayList<>();
		List<String> sccpjzh_list = new ArrayList<>();
		List<String> zdzh_list = new ArrayList<>();
		List<String> zxzh_list = new ArrayList<>();
		List<String> llszh_list = new ArrayList<>();
		List<String> llxzh_list = new ArrayList<>();
		List<String> zsnj_list = new ArrayList<>();
		List<String> gzz_list = new ArrayList<>();
		List<String> yzz_list = new ArrayList<>();
		List<String> sccc_list = new ArrayList<>();
		List<String> sccc2_list = new ArrayList<>();
		List<String> bmzh_list = new ArrayList<>();
		List<String> sxdl_list = new ArrayList<>();
		List<String> xxdl_list = new ArrayList<>();
		List<String> ty_list = new ArrayList<>();
		List<String> yy_list = new ArrayList<>();
		List<String> bx_list = new ArrayList<>();
		List<String> bj_list = new ArrayList<>();
		List<String> jspl_list = new ArrayList<>();
		List<String> rcyl_list = new ArrayList<>();
		List<String> llpl_list = new ArrayList<>();
		List<String> sgtmj_list = new ArrayList<>();
		List<String> sgtzdmj_list = new ArrayList<>();
		List<String> cmd_list = new ArrayList<>();
		List<String> dym_list = new ArrayList<>();
		List<String> jsdym_list = new ArrayList<>();
		List<String> xdydgl_list = new ArrayList<>();
		List<String> sgtlx_list = new ArrayList<>();
		List<String> gzlx_list = new ArrayList<>();
		List<String> fxjg_list = new ArrayList<>();
		List<String> slgl_list = new ArrayList<>();
		List<String> djgl_list = new ArrayList<>();
		List<String> xtxl_list = new ArrayList<>();
		List<String> sgtds_list = new ArrayList<>();
		List<String> sgtcc_list = new ArrayList<>();
		List<String> sgtzh_list = new ArrayList<>();

		List<String> jinghao_list1 = new ArrayList<>();
		List<String> ceshishijian_list1 = new ArrayList<>();


		ArrayList<Object> total_list = new ArrayList<Object>();

		// 获取数据
		String jh_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\jh.txt";
		BufferedReader baa1 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(jh_file)), "UTF-8"));
		String line_save1;
		while ((line_save1 = baa1.readLine()) != null) {
			jh_list.add(line_save1);
		}
//		System.out.println(jh_list);

		String csrq_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\csrq.txt";
		BufferedReader baa2 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(csrq_file)), "UTF-8"));
		String line_save2;
		while ((line_save2 = baa2.readLine()) != null) {
			csrq_list.add(line_save2);
		}
//		System.out.println(csrq_list);

		String sccdygfz_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\sccdygfz.txt";
		BufferedReader baa3 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(sccdygfz_file)), "UTF-8"));
		String line_save3;
		while ((line_save3 = baa3.readLine()) != null) {
			sccdygfz_list.add(line_save3);
		}
//		System.out.println(sccdygfz_list);

		String scczhgfz_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\scczhgfz.txt";
		BufferedReader baa4 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(scczhgfz_file)), "UTF-8"));
		String line_save4;
		while ((line_save4 = baa4.readLine()) != null) {
			scczhgfz_list.add(line_save4);
		}
//		System.out.println(scczhgfz_list);

		String xccdygfz_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\xccdygfz.txt";
		BufferedReader baa48 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(xccdygfz_file)), "UTF-8"));
		String line_save48;
		while ((line_save48 = baa48.readLine()) != null) {
			xccdygfz_list.add(line_save48);
		}
//		System.out.println(xccdygfz_list);

		String xcczhgfz_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\xcczhgfz.txt";
		BufferedReader baa5 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(xcczhgfz_file)), "UTF-8"));
		String line_save5;
		while ((line_save5 = baa5.readLine()) != null) {
			xcczhgfz_list.add(line_save5);
		}
//		System.out.println(xcczhgfz_list);

		String sccxl1_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\sccxl1.txt";
		BufferedReader baa6 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(sccxl1_file)), "UTF-8"));
		String line_save6;
		while ((line_save6 = baa6.readLine()) != null) {
			sccxl1_list.add(line_save6);
		}
//		System.out.println(sccxl1_list);

		String sccxl2_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\sccxl2.txt";
		BufferedReader baa7 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(sccxl2_file)), "UTF-8"));
		String line_save7;
		while ((line_save7 = baa7.readLine()) != null) {
			sccxl2_list.add(line_save7);
		}
//		System.out.println(sccxl2_list);

		String xccxl1_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\xccxl1.txt";
		BufferedReader baa8 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(xccxl1_file)), "UTF-8"));
		String line_save8;
		while ((line_save8 = baa8.readLine()) != null) {
			xccxl1_list.add(line_save8);
		}
//		System.out.println(xccxl1_list);

		String xccxl2_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\xccxl2.txt";
		BufferedReader baa9 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(xccxl2_file)), "UTF-8"));
		String line_save9;
		while ((line_save9 = baa9.readLine()) != null) {
			xccxl2_list.add(line_save9);
		}
//		System.out.println(xccxl2_list);

		String yxcc_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\yxcc.txt";
		BufferedReader baa10 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(yxcc_file)), "UTF-8"));
		String line_save10;
		while ((line_save10 = baa10.readLine()) != null) {
			yxcc_list.add(line_save10);
		}
//		System.out.println(yxcc_list);

		String cmcd_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\cmcd.txt";
		BufferedReader baa11 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(cmcd_file)), "UTF-8"));
		String line_save11;
		while ((line_save11 = baa11.readLine()) != null) {
			cmcd_list.add(line_save11);
		}
//		System.out.println(cmcd_list);

		String bs_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\bs.txt";
		BufferedReader baa12 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(bs_file)), "UTF-8"));
		String line_save12;
		while ((line_save12 = baa12.readLine()) != null) {
			bs_list.add(line_save12);
		}
//		System.out.println(bs_list);

		String hsl_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\hsl.txt";
		BufferedReader baa13 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(hsl_file)), "UTF-8"));
		String line_save13;
		while ((line_save13 = baa13.readLine()) != null) {
			hsl_list.add(line_save13);
		}
//		System.out.println(hsl_list);

		String ydfgbzh_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\ydfgbzh.txt";
		BufferedReader baa14 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(ydfgbzh_file)), "UTF-8"));
		String line_save14;
		while ((line_save14 = baa14.readLine()) != null) {
			ydfgbzh_list.add(line_save14);
		}
//		System.out.println(ydfgbzh_list);

		String xccpjzh_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\xccpjzh.txt";
		BufferedReader baa15 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(xccpjzh_file)), "UTF-8"));
		String line_save15;
		while ((line_save15 = baa15.readLine()) != null) {
			xccpjzh_list.add(line_save15);
		}
//		System.out.println(xccpjzh_list);

		String sccpjzh_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\sccpjzh.txt";
		BufferedReader baa16 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(sccpjzh_file)), "UTF-8"));
		String line_save16;
		while ((line_save16 = baa16.readLine()) != null) {
			sccpjzh_list.add(line_save16);
		}
//		System.out.println(sccpjzh_list);

		String zdzh_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\zdzh.txt";
		BufferedReader baa17 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(zdzh_file)), "UTF-8"));
		String line_save17;
		while ((line_save17 = baa17.readLine()) != null) {
			zdzh_list.add(line_save17);
		}
//		System.out.println(zdzh_list);

		String zxzh_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\zxzh.txt";
		BufferedReader baa18 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(zxzh_file)), "UTF-8"));
		String line_save18;
		while ((line_save18 = baa18.readLine()) != null) {
			zxzh_list.add(line_save18);
		}
//		System.out.println(zxzh_list);

		String llszh_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\llszh.txt";
		BufferedReader baa19 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(llszh_file)), "UTF-8"));
		String line_save19;
		while ((line_save19 = baa19.readLine()) != null) {
			llszh_list.add(line_save19);
		}
//		System.out.println(llszh_list);

		String llxzh_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\llxzh.txt";
		BufferedReader baa20 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(llxzh_file)), "UTF-8"));
		String line_save20;
		while ((line_save20 = baa20.readLine()) != null) {
			llxzh_list.add(line_save20);
		}
//		System.out.println(llxzh_list);

		String zsnj_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\zsnj.txt";
		BufferedReader baa21 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(zsnj_file)), "UTF-8"));
		String line_save21;
		while ((line_save21 = baa21.readLine()) != null) {
			zsnj_list.add(line_save21);
		}
//		System.out.println(zsnj_list);

		String gzz_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\gzz.txt";
		BufferedReader baa22 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(gzz_file)), "UTF-8"));
		String line_save22;
		while ((line_save22 = baa22.readLine()) != null) {
			gzz_list.add(line_save22);
		}
//		System.out.println(gzz_list);

		String yzz_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\yzz.txt";
		BufferedReader baa23 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(yzz_file)), "UTF-8"));
		String line_save23;
		while ((line_save23 = baa23.readLine()) != null) {
			yzz_list.add(line_save23);
		}
//		System.out.println(yzz_list);

		String sccc_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\sccc.txt";
		BufferedReader baa24 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(sccc_file)), "UTF-8"));
		String line_save24;
		while ((line_save24 = baa24.readLine()) != null) {
			sccc_list.add(line_save24);
		}
//		System.out.println(sccc_list);

		String sccc2_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\sccc2.txt";
		BufferedReader baa25 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(sccc2_file)), "UTF-8"));
		String line_save25;
		while ((line_save25 = baa25.readLine()) != null) {
			sccc2_list.add(line_save25);
		}
//		System.out.println(sccc2_list);

		String bmzh_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\yxcc.txt";
		BufferedReader baa26 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(bmzh_file)), "UTF-8"));
		String line_save26;
		while ((line_save26 = baa26.readLine()) != null) {
			bmzh_list.add(line_save26);
		}
//		System.out.println(bmzh_list);

		String sxdl_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\sxdl.txt";
		BufferedReader baa27 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(sxdl_file)), "UTF-8"));
		String line_save27;
		while ((line_save27 = baa27.readLine()) != null) {
			sxdl_list.add(line_save27);
		}
//		System.out.println(sxdl_list);

		String xxdl_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\xxdl.txt";
		BufferedReader baa28 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(xxdl_file)), "UTF-8"));
		String line_save28;
		while ((line_save28 = baa28.readLine()) != null) {
			xxdl_list.add(line_save28);
		}
//		System.out.println(xxdl_list);

		String ty_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\ty.txt";
		BufferedReader baa29 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(ty_file)), "UTF-8"));
		String line_save29;
		while ((line_save29 = baa29.readLine()) != null) {
			ty_list.add(line_save29);
		}
//		System.out.println(ty_list);

		String yy_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\yy.txt";
		BufferedReader baa30 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(yy_file)), "UTF-8"));
		String line_save30;
		while ((line_save30 = baa30.readLine()) != null) {
			yy_list.add(line_save30);
		}
//		System.out.println(yy_list);

		String bx_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\bx.txt";
		BufferedReader baa31 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(bx_file)), "UTF-8"));
		String line_save31;
		while ((line_save31 = baa31.readLine()) != null) {
			bx_list.add(line_save31);
		}
//		System.out.println(bx_list);
//
		String bj_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\bj.txt";
		BufferedReader baa32 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(bj_file)), "UTF-8"));
		String line_save32;
		while ((line_save32 = baa32.readLine()) != null) {
			bj_list.add(line_save32);
		}
//		System.out.println(bj_list);

		String jspl_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\jspl.txt";
		BufferedReader baa33 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(jspl_file)), "UTF-8"));
		String line_save33;
		while ((line_save33 = baa33.readLine()) != null) {
			jspl_list.add(line_save33);
		}
//		System.out.println(jspl_list);

		String rcyl_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\rcyl.txt";
		BufferedReader baa34 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(rcyl_file)), "UTF-8"));
		String line_save34;
		while ((line_save34 = baa34.readLine()) != null) {
			rcyl_list.add(line_save34);
		}
//		System.out.println(rcyl_list);

		String llpl_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\llpl.txt";
		BufferedReader baa35 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(llpl_file)), "UTF-8"));
		String line_save35;
		while ((line_save35 = baa35.readLine()) != null) {
			llpl_list.add(line_save35);
		}
//		System.out.println(llpl_list);

		String sgtmj_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\sgtmj.txt";
		BufferedReader baa36 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(sgtmj_file)), "UTF-8"));
		String line_save36;
		while ((line_save36 = baa36.readLine()) != null) {
			sgtmj_list.add(line_save36);
		}
//		System.out.println(sgtmj_list);

		String sgtzdmj_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\sgtzdmj.txt";
		BufferedReader baa37 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(sgtzdmj_file)), "UTF-8"));
		String line_save37;
		while ((line_save37 = baa37.readLine()) != null) {
			sgtzdmj_list.add(line_save37);
		}
//		System.out.println(sgtzdmj_list);

		String cmd_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\cmd.txt";
		BufferedReader baa38 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(cmd_file)), "UTF-8"));
		String line_save38;
		while ((line_save38 = baa38.readLine()) != null) {
			cmd_list.add(line_save38);
		}
//		System.out.println(cmd_list);

		String dym_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\dym.txt";
		BufferedReader baa39 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(dym_file)), "UTF-8"));
		String line_save39;
		while ((line_save39 = baa39.readLine()) != null) {
			dym_list.add(line_save39);
		}
//		System.out.println(dym_list);

		String jsdym_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\jsdym.txt";
		BufferedReader baa40 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(jsdym_file)), "UTF-8"));
		String line_save40;
		while ((line_save40 = baa40.readLine()) != null) {
			jsdym_list.add(line_save40);
		}
//		System.out.println(jsdym_list);

		String xdydgl_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\xdydgl.txt";
		BufferedReader baa41 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(xdydgl_file)), "UTF-8"));
		String line_save41;
		while ((line_save41 = baa41.readLine()) != null) {
			xdydgl_list.add(line_save41);
		}
//		System.out.println(xdydgl_list);

		String sgtlx_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\sgtlx.txt";
		BufferedReader baa51 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(sgtlx_file)), "UTF-8"));
		String line_save51;
		while ((line_save51 = baa51.readLine()) != null) {
			sgtlx_list.add(line_save51);
		}
//		System.out.println(sgtlx_list);

		String gzlx_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\gzlx.txt";
		BufferedReader baa42 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(gzlx_file)), "UTF-8"));
		String line_save42;
		while ((line_save42 = baa42.readLine()) != null) {
			gzlx_list.add(line_save42);
		}
//		System.out.println(gzlx_list);

		String fxjg_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\fxjg.txt";
		BufferedReader baa43 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fxjg_file)), "UTF-8"));
		String line_save43;
		while ((line_save43 = baa43.readLine()) != null) {
			fxjg_list.add(line_save43);
		}
//		System.out.println(fxjg_list);

		String slgl_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\slgl.txt";
		BufferedReader baa44 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(slgl_file)), "UTF-8"));
		String line_save44;
		while ((line_save44 = baa44.readLine()) != null) {
			slgl_list.add(line_save44);
		}
//		System.out.println(slgl_list);

		String djgl_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\djgl.txt";
		BufferedReader baa45 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(djgl_file)), "UTF-8"));
		String line_save45;
		while ((line_save45 = baa45.readLine()) != null) {
			djgl_list.add(line_save45);
		}
//		System.out.println(djgl_list);

		String xtxl_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\xtxl.txt";
		BufferedReader baa46 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(xtxl_file)), "UTF-8"));
		String line_save46;
		while ((line_save46 = baa46.readLine()) != null) {
			xtxl_list.add(line_save46);
		}
//		System.out.println(xtxl_list);

		String sgtds_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\sgtds.txt";
		BufferedReader baa47 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(sgtds_file)), "UTF-8"));
		String line_save47;
		while ((line_save47 = baa47.readLine()) != null) {
			sgtds_list.add(line_save47);
		}
//		System.out.println(sgtds_list);

		String sgtcc_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\sgtcc.txt";
		BufferedReader baa50 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(sgtcc_file)), "UTF-8"));
		String line_save50;
		while ((line_save50 = baa50.readLine()) != null) {
			sgtcc_list.add(line_save50);
		}
//		System.out.println(sgtcc_list);

		String sgtzh_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\sgtzh.txt";
		BufferedReader baa49 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(sgtzh_file)), "UTF-8"));
		String line_save49;
		while ((line_save49 = baa49.readLine()) != null) {
			sgtzh_list.add(line_save49);
		}
//		System.out.println(sgtzh_list);

		//井号筛选
		for (int i = 0; i < jh_list.size(); i = i + 1) {
			if( ! jinghao_list1.contains(jh_list.get(i))){
				jinghao_list1.add(jh_list.get(i));
			}
		}
//		System.out.println("jinghao_list1"+jinghao_list1);

		// 测试时间筛选
		for (int i = 0; i < csrq_list.size(); i = i + 1) {
			if( ! ceshishijian_list1.contains(csrq_list.get(i))){
				ceshishijian_list1.add(csrq_list.get(i));
			}
		}
//		System.out.println("ceshishijian_list1"+ceshishijian_list1);


		total_list.add(jh_list);
		total_list.add(csrq_list);
		total_list.add(sccdygfz_list);
		total_list.add(scczhgfz_list);
		total_list.add(xccdygfz_list);
		total_list.add(xcczhgfz_list);
		total_list.add(sccxl1_list);
		total_list.add(sccxl2_list);
		total_list.add(xccxl1_list);
		total_list.add(xccxl2_list);
		total_list.add(yxcc_list);
		total_list.add(cmcd_list);
		total_list.add(bs_list);
		total_list.add(hsl_list);
		total_list.add(ydfgbzh_list);
		total_list.add(xccpjzh_list);
		total_list.add(sccpjzh_list);
		total_list.add(zdzh_list);
		total_list.add(zxzh_list);
		total_list.add(llszh_list);
		total_list.add(llxzh_list);
		total_list.add(zsnj_list);
		total_list.add(gzz_list);
		total_list.add(yzz_list);
		total_list.add(sccc_list);
		total_list.add(sccc2_list);
		total_list.add(bmzh_list);
		total_list.add(sxdl_list);
		total_list.add(xxdl_list);
		total_list.add(ty_list);
		total_list.add(yy_list);
		total_list.add(bx_list);
		total_list.add(bj_list);
		total_list.add(jspl_list);
		total_list.add(rcyl_list);
		total_list.add(llpl_list);
		total_list.add(sgtmj_list);
		total_list.add(sgtzdmj_list);
		total_list.add(cmd_list);
		total_list.add(dym_list);
		total_list.add(jsdym_list);
		total_list.add(xdydgl_list);
		total_list.add(sgtlx_list);
		total_list.add(gzlx_list);
		total_list.add(fxjg_list);
		total_list.add(slgl_list);
		total_list.add(djgl_list);
		total_list.add(xtxl_list);
		total_list.add(sgtds_list);
		total_list.add(sgtcc_list);
		total_list.add(sgtzh_list);
		total_list.add(jinghao_list1);
		total_list.add(ceshishijian_list1);


		Map<String, Object> result = new HashMap ();
		result.put("total_list", total_list);
		System.out.println(total_list);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseData.ok(result);
	}

	// 获取数据处理过程
	@GetMapping("/rusult_data_chuli")
	public ResponseData rusult_data_chuli () throws IOException {
		List<Object> chulidata_guocheng = new ArrayList<Object>();
		List<Object> chulidata_length = new ArrayList<Object>();
		List<Object> result_chuli11 = new ArrayList<Object>();
		try {
			String rusult_select_file1 = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\chulidata_length.txt";
			BufferedReader baa1 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(rusult_select_file1)), "UTF-8"));
			String line_save1;
			while ((line_save1 = baa1.readLine()) != null) {
				chulidata_length.add(line_save1);
			}

			String rusult_select_file = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\chulidata_guocheng.txt";
			BufferedReader baa = new BufferedReader(new InputStreamReader(new FileInputStream(new File(rusult_select_file)), "UTF-8"));
			String line_save;
			while ((line_save = baa.readLine()) != null) {
				chulidata_guocheng.add(line_save);
			}
//			System.out.println(rusult_xunlian);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		};
		result_chuli11.add(chulidata_length);
		result_chuli11.add(chulidata_guocheng);
		Map<String, Object> result = new HashMap();
		result.put("result_chuli11", result_chuli11);
		return ResponseData.ok(result);
	}

	//重新定义数据处理过程
	@GetMapping("/renamechuli_file")
	public ResponseData renamechuli_file() {
		Map<String, Object> result = null;
		List<String> model_select_forecast_label = new ArrayList<>();
		try {
			System.out.println("ok");
			File writename = new File(PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\chulidata_guocheng.txt");
			writename.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			out.write(0+ "\r\n"); // \r\n为换行
			out.flush(); // 把缓存区内容压入文件
			out.close();

			System.out.println("ok");
			File writename1 = new File(PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\chulidata_length.txt");
			writename1.createNewFile();
			BufferedWriter out1 = new BufferedWriter(new FileWriter(writename1));
			out1.write(0+ "\r\n"); // \r\n为换行
			out1.flush(); // 把缓存区内容压入文件
			out1.close();
			System.out.println("重新定义数据处理过程成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// // 调用python输出识别井和时间数据
	@RequestMapping("/get_shibie_data")
	public ResponseData get_shibie_data()  throws JsonParseException, JsonMappingException, IOException   {

		//调用python
		List<String> shibie_label1 = new ArrayList<String>();
		try {
			System.out.println("start");
			//环境和main
			String[] args5=new String[]{"E:\\PYthon\\python.exe", "E:\\桌面\\vue\\well_shibie_moduel\\jing_cun.py"};
			Process pr=Runtime.getRuntime().exec(args5);

			BufferedReader in = new BufferedReader(new InputStreamReader(
					pr.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
//				training_label1.add(line);
//				System.out.println(line);
			}
//			System.out.println(training_label1);
			in.close();
			pr.waitFor();

			System.out.println("end");
			shibie_label1.add("识别数据输出完成！");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		};
		List<String> shibie_label11 = new ArrayList<String>();
		shibie_label11 = shibie_label1;
		Map<String, Object> result = new HashMap();
		result.put("shibie_label11", shibie_label11);
		return ResponseData.ok(result);
	}





	// 调用识别模型
	@GetMapping("/getshibiemodelList")
	public ResponseData getshibiemodelListUsers( ) throws IOException {
		List<String> shibie_model_list11 = new ArrayList<>();


		String Model_save_total_file = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\model_save_history.txt";
		BufferedReader baa = new BufferedReader(new InputStreamReader(new FileInputStream(new File(Model_save_total_file)), "UTF-8"));
		String line_save;
		while ((line_save = baa.readLine()) != null) {
			shibie_model_list11.add(line_save);
		}

		System.out.println(shibie_model_list11);
		Map<String, Object> result = new HashMap ();
		result.put("shibie_model_list11", shibie_model_list11);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseData.ok(result);
	}

	// 保存选择的识别模型
	@GetMapping("/get_yuce_model")
	public ResponseData get_yuce_model1(String canshu_3) {


		try {
//			System.out.println("start");
			System.out.println(canshu_3);
			File writename1 = new File(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\shibie_model.txt");
			writename1.createNewFile();
			BufferedWriter out1 = new BufferedWriter(new FileWriter(writename1));
			out1.write(canshu_3+"\r\n"); // \r\n为换行
			out1.flush(); // 把缓存区内容压入文件
			out1.close();

			System.out.println("数据时间保存成功！");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseData.fail("识别数据保存失败！");
	}

	//读取示功图识别井号
	@GetMapping("/getshibiejingList")
	public ResponseData getshibiejingListUsers( ) throws IOException {
		List<String> shibie_jing_load_result_list = new ArrayList<>();
		// 获取模型训练与优化结果
//		Scanner scanners5 = new Scanner(new FileInputStream("E:\\桌面\\vue\\Model_save_total.txt"),"UTF-8") ;
//		scanners5.next();scanners5.next();
//		String itemname = scanners5.next();
		//从数据库获取数据
		String Model_save_total_file = "E:\\桌面\\vue\\well_shibie_moduel\\jinghao.txt";
		BufferedReader baa = new BufferedReader(new InputStreamReader(new FileInputStream(new File(Model_save_total_file)), "UTF-8"));
		String line_save;
		while ((line_save = baa.readLine()) != null) {
			shibie_jing_load_result_list.add(line_save);
//			System.out.println(line_save);
		}
//		while(scanner5.hasNext()){
//			model_load_result_list1.add(String.format((scanner5.next())) );
//		}
//		System.out.println(xiaohe_jing_load_result_list);

		Map<String, Object> result = new HashMap ();
		result.put("shibie_jing_load_result_list", shibie_jing_load_result_list);
		System.out.println(shibie_jing_load_result_list);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseData.ok(result);
	}

	//读取示功图识别测试时间
	@GetMapping("/getshibieshijianList")
	public ResponseData getshibieshijianListUsers(String jinghao ) throws IOException {
		List<String> shibie_shijian_load_result_list = new ArrayList<>();
		//从数据库获取数据
		String shibie_shijian_file = "E:\\桌面\\vue\\well_shibie_moduel\\"+jinghao+"ceshishijian.txt";
		BufferedReader baa = new BufferedReader(new InputStreamReader(new FileInputStream(new File(shibie_shijian_file)), "UTF-8"));
		String line_save;
		while ((line_save = baa.readLine()) != null) {
			shibie_shijian_load_result_list.add(line_save);
//			System.out.println(line_save);
		}
//		while(scanner5.hasNext()){
//			model_load_result_list1.add(String.format((scanner5.next())) );
//		}
//		System.out.println(xiaohe_jing_load_result_list);

		Map<String, Object> result = new HashMap ();
		result.put("shibie_shijian_load_result_list", shibie_shijian_load_result_list);
		System.out.println(shibie_shijian_load_result_list);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseData.ok(result);
	}

	//保存识别选择的数据
	@GetMapping("/baocun_xuanze_data_shibie")
	public ResponseData baocun_xuanze_data_shibiesave(String jinghao,String shijian) {
		try {
//			System.out.println("start");
			System.out.println(jinghao);
			File writename1 = new File("E:\\桌面\\vue\\well_shibie_moduel\\jing_hao.txt");
			writename1.createNewFile();
			BufferedWriter out1 = new BufferedWriter(new FileWriter(writename1));
			out1.write(jinghao+"\r\n"); // \r\n为换行
			out1.flush(); // 把缓存区内容压入文件
			out1.close();
			System.out.println("井号保存成功！");

			System.out.println(shijian);
			File writename2 = new File("E:\\桌面\\vue\\well_shibie_moduel\\ceshi_riqi.txt");
			writename2.createNewFile();
			BufferedWriter out2 = new BufferedWriter(new FileWriter(writename2));
			out2.write(shijian+"\r\n"); // \r\n为换行
			out2.flush(); // 把缓存区内容压入文件
			out2.close();
			System.out.println("测试时间保存成功！");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseData.fail("识别数据保存失败！");
	}

	// 示功图识别
	@RequestMapping("/shigongtu_shibie")
	public ResponseData shigongtu_shibie()  throws JsonParseException, JsonMappingException, IOException   {

		//调用python
		List<String> shibie_label11 = new ArrayList<String>();
		List<String> line1 = new ArrayList<String>();
		try {
			System.out.println("start");
			//环境和main
			String[] args1=new String[]{"E:\\PYthon\\python.exe", "E:\\桌面\\vue\\well_shibie_moduel\\well_shibie.py"};// python程序名
			Process pr=Runtime.getRuntime().exec(args1);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					pr.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
//				training_label1.add(line);
				System.out.println(line);
			}
//			System.out.println(training_label1);
			in.close();
			pr.waitFor();
			System.out.println("end");
			shibie_label11.add("示功图识别完成！");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		};
		Map<String, Object> result = new HashMap();
		result.put("shibie_label11", shibie_label11);
		return ResponseData.ok(result);
	}

	// 获取示功图识别结果
	@GetMapping("/list1_shibie")
	public ResponseData queryUsers_shibie(String jinghao, String shijian) throws IOException {
		List<String> shibie_jinghao_list = new ArrayList<>();
		List<String> shibie_jinghao_list1 = new ArrayList<>();
		List<String> shibie_testday_list = new ArrayList<>();
		List<String> shibie_result_list = new ArrayList<>();
		List<String> shibie_result_list2 = new ArrayList<>();
		ArrayList<Object> shibie_total_list = new ArrayList<Object>();

		// 获取识别结果数据1
		String new_shijian = shijian.replace("/", "_");
		String shibie_result_file = "E:\\桌面\\vue\\well_shibie_moduel\\"+jinghao+"_"+new_shijian+"_Result_shibie.txt";
		BufferedReader baa1 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(shibie_result_file)), "UTF-8"));
		String line_save1;
		while ((line_save1 = baa1.readLine()) != null) {
			shibie_result_list.add(line_save1);
		}
		System.out.println(shibie_result_list);

		// 获取识别结果数据2
//		String new_shijian = shijian.replace("/", "_");
		String shibie_result_file2 = "E:\\桌面\\vue\\well_shibie_moduel\\shibie_data_"+jinghao+"_"+new_shijian+".txt";
		BufferedReader baa2 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(shibie_result_file2)), "UTF-8"));
		String line_save2;
		while ((line_save2 = baa2.readLine()) != null) {
			shibie_result_list2.add(line_save2);
		}
		System.out.println(shibie_result_list2);

//		// 获取井号数据
//		String jinghao_shibie_file = "E:\\桌面\\vue\\well_shibie_moduel\\jing_hao.txt";
//		BufferedReader baa2 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(jinghao_shibie_file)), "UTF-8"));
//		String line_save2;
//		while ((line_save2 = baa2.readLine()) != null) {
//			shibie_jinghao_list.add(line_save2);
//		}
//		System.out.println(shibie_jinghao_list);
//
//		//井号筛选
//		for (int i = 0; i < shibie_jinghao_list.size(); i = i + 1) {
//			if( ! shibie_jinghao_list1.contains(shibie_jinghao_list.get(i))){
//				shibie_jinghao_list1.add(shibie_jinghao_list.get(i));
//			}
//		}
//		System.out.println("shibie_jinghao_list1"+shibie_jinghao_list1);
//
//		// 获取测试日期数据
//		String testday_shibie_file = "E:\\桌面\\vue\\well_shibie_moduel\\ceshi_riqi.txt";
//		BufferedReader baa3 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(testday_shibie_file)), "UTF-8"));
//		String line_save3;
//		while ((line_save3 = baa3.readLine()) != null) {
//			shibie_testday_list.add(line_save3);
//		}
//		System.out.println(shibie_testday_list);

		shibie_total_list.add(shibie_result_list);
		shibie_total_list.add(shibie_result_list2);
//		shibie_total_list.add(shibie_jinghao_list);
//		shibie_total_list.add(shibie_testday_list);
//		shibie_total_list.add(shibie_jinghao_list1);

		Map<String, Object> result = new HashMap ();
		result.put("shibie_total_list", shibie_total_list);
		System.out.println(shibie_total_list);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseData.ok(result);
	}

	// 获取示功图识别结果
	@GetMapping("/getxiaohe_resultList")
	public ResponseData queryUsers_getxiaohe_resultList(String jinghao, String shijian) throws IOException {
		List<String> xiaohe_result_list = new ArrayList<>();
		ArrayList<Object> xiaohe_total_list = new ArrayList<Object>();

		// 获取识别结果数据
		String new_shijian = shijian.replace("/", "_");
		String xiaohe_result_file = "E:\\桌面\\vue\\well_distinguish\\"+jinghao+"_"+new_shijian+"_Result_xiaohe.txt";
		BufferedReader baa1 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(xiaohe_result_file)), "UTF-8"));
		String line_save1;
		while ((line_save1 = baa1.readLine()) != null) {
			xiaohe_result_list.add(line_save1);
		}
		System.out.println(xiaohe_result_list);

//		// 获取识别结果数据2
////		String new_shijian = shijian.replace("/", "_");
//		String shibie_result_file2 = "E:\\桌面\\vue\\well_shibie_moduel\\shibie_data_"+jinghao+"_"+new_shijian+".txt";
//		BufferedReader baa2 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(shibie_result_file2)), "UTF-8"));
//		String line_save2;
//		while ((line_save2 = baa2.readLine()) != null) {
//			shibie_result_list2.add(line_save2);
//		}
//		System.out.println(shibie_result_list2);

//		// 获取井号数据
//		String jinghao_shibie_file = "E:\\桌面\\vue\\well_shibie_moduel\\jing_hao.txt";
//		BufferedReader baa2 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(jinghao_shibie_file)), "UTF-8"));
//		String line_save2;
//		while ((line_save2 = baa2.readLine()) != null) {
//			shibie_jinghao_list.add(line_save2);
//		}
//		System.out.println(shibie_jinghao_list);
//
//		//井号筛选
//		for (int i = 0; i < shibie_jinghao_list.size(); i = i + 1) {
//			if( ! shibie_jinghao_list1.contains(shibie_jinghao_list.get(i))){
//				shibie_jinghao_list1.add(shibie_jinghao_list.get(i));
//			}
//		}
//		System.out.println("shibie_jinghao_list1"+shibie_jinghao_list1);
//
//		// 获取测试日期数据
//		String testday_shibie_file = "E:\\桌面\\vue\\well_shibie_moduel\\ceshi_riqi.txt";
//		BufferedReader baa3 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(testday_shibie_file)), "UTF-8"));
//		String line_save3;
//		while ((line_save3 = baa3.readLine()) != null) {
//			shibie_testday_list.add(line_save3);
//		}
//		System.out.println(shibie_testday_list);

		xiaohe_total_list.add(xiaohe_result_list);
//		shibie_total_list.add(shibie_result_list2);
//		shibie_total_list.add(shibie_jinghao_list);
//		shibie_total_list.add(shibie_testday_list);
//		shibie_total_list.add(shibie_jinghao_list1);

		Map<String, Object> result = new HashMap ();
		result.put("xiaohe_total_list", xiaohe_total_list);
		System.out.println(xiaohe_total_list);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseData.ok(result);
	}

	// 获取识别的示功图数据
	@GetMapping("/cumputes15")
	public ResponseData cumputes15(String jinghao, String shijian) throws IOException {
//		System.out.println(canshu15);
		List<Object> shigongtu_chongcheng_shibie = new ArrayList<Object>();
		List<Object> shigongtu_zhaihe_shibie = new ArrayList<Object>();
		ArrayList<Object> shigongtu_shibie_list = new ArrayList<Object>();
		try {
			// 获取识别示功图冲程数据shigongtu_chongcheng_0SB8SAfl03_2014_01_06
			String new_shijian = shijian.replace("/", "_");
			String shibie_shigongtu_chongcheng_file = "E:\\桌面\\vue\\well_shibie_moduel\\shigongtu_chongcheng_"+jinghao+"_"+new_shijian+".txt";
			BufferedReader baa1 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(shibie_shigongtu_chongcheng_file)), "UTF-8"));
			String line_save1;
			while ((line_save1 = baa1.readLine()) != null) {
				shigongtu_chongcheng_shibie.add(line_save1);
			}
			System.out.println(shigongtu_chongcheng_shibie);

			// 获取识别示功图载荷数据
			String shibie_shigongtu_zhaihe_file = "E:\\桌面\\vue\\well_shibie_moduel\\shigongtu_zhaihe_"+jinghao+"_"+new_shijian+".txt";
			BufferedReader baa2 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(shibie_shigongtu_zhaihe_file)), "UTF-8"));
			String line_save2;
			while ((line_save2 = baa2.readLine()) != null) {
				shigongtu_zhaihe_shibie.add(line_save2);
			}
			System.out.println(shigongtu_zhaihe_shibie);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		};
		int b = shigongtu_chongcheng_shibie.size();
		for (int i = 0; i < b; i = i + 1) {
			List<Object> shigongtu_shibie1 = new ArrayList<Object>();
			shigongtu_shibie1.add(shigongtu_chongcheng_shibie.get(i));
			shigongtu_shibie1.add(shigongtu_zhaihe_shibie.get(i));
			shigongtu_shibie_list.add(shigongtu_shibie1);

		}

		System.out.println(shigongtu_shibie_list);
		Map<String, Object> result = new HashMap();
		result.put("shigongtu_shibie_list", shigongtu_shibie_list);
		return ResponseData.ok(result);

	}

	// // 调用python输出校核井和时间数据
	@RequestMapping("/get_xiaohe_data")
	public ResponseData get_xiaohe_data()  throws JsonParseException, JsonMappingException, IOException   {

		//调用python
		List<String> xiaohe_label1 = new ArrayList<String>();
		try {
			System.out.println("start");
			//环境和main
			String[] args1=new String[]{"E:\\PYthon\\python.exe", "E:\\桌面\\vue\\well_distinguish\\jing_cun.py"};
			Process pr=Runtime.getRuntime().exec(args1);

			BufferedReader in = new BufferedReader(new InputStreamReader(
					pr.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
//				training_label1.add(line);
//				System.out.println(line);
			}
//			System.out.println(training_label1);
			in.close();
			pr.waitFor();

			System.out.println("end");
			xiaohe_label1.add("校核数据输出完成！");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		};
		List<String> xiaohe_label11 = new ArrayList<String>();
		xiaohe_label11 = xiaohe_label1;
//		xiaohe_label.remove("");
//		System.out.println(opt_label);
		Map<String, Object> result = new HashMap();
		result.put("xiaohe_label11", xiaohe_label11);
		return ResponseData.ok(result);
//		int[] chart=new int[] {10, 60, 40, 70, 5, 20, 36, 10, 10, 55};
//		Map<String, Object> result = new HashMap ();
//		result.put("chart",chart);
//		return ResponseData.ok(result);
	}

	//读取示功图校核井号
	@GetMapping("/getxiaohejingList")
	public ResponseData getxiaohejingListUsers( ) throws IOException {
		List<String> xiaohe_jing_load_result_list = new ArrayList<>();
		// 获取模型训练与优化结果
//		Scanner scanners5 = new Scanner(new FileInputStream("E:\\桌面\\vue\\Model_save_total.txt"),"UTF-8") ;
//		scanners5.next();scanners5.next();
//		String itemname = scanners5.next();
		//从数据库获取数据
		String Model_save_total_file = "E:\\桌面\\vue\\well_distinguish\\jinghao.txt";
		BufferedReader baa = new BufferedReader(new InputStreamReader(new FileInputStream(new File(Model_save_total_file)), "UTF-8"));
		String line_save;
		while ((line_save = baa.readLine()) != null) {
			xiaohe_jing_load_result_list.add(line_save);
//			System.out.println(line_save);
		}
//		while(scanner5.hasNext()){
//			model_load_result_list1.add(String.format((scanner5.next())) );
//		}
//		System.out.println(xiaohe_jing_load_result_list);

		Map<String, Object> result = new HashMap ();
		result.put("xiaohe_jing_load_result_list", xiaohe_jing_load_result_list);
		System.out.println(xiaohe_jing_load_result_list);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseData.ok(result);
	}

	//读取示功图校核测试时间
	@GetMapping("/getxiaoheshijianList")
	public ResponseData getxiaoheshijianListUsers(String jinghao ) throws IOException {
		List<String> xiaohe_shijian_load_result_list = new ArrayList<>();
		//从数据库获取数据
		String xiaohe_shijian_file = "E:\\桌面\\vue\\well_distinguish\\"+jinghao+"ceshishijian.txt";
		BufferedReader baa = new BufferedReader(new InputStreamReader(new FileInputStream(new File(xiaohe_shijian_file)), "UTF-8"));
		String line_save;
		while ((line_save = baa.readLine()) != null) {
			xiaohe_shijian_load_result_list.add(line_save);
//			System.out.println(line_save);
		}
//		while(scanner5.hasNext()){
//			model_load_result_list1.add(String.format((scanner5.next())) );
//		}
//		System.out.println(xiaohe_jing_load_result_list);

		Map<String, Object> result = new HashMap ();
		result.put("xiaohe_shijian_load_result_list", xiaohe_shijian_load_result_list);
		System.out.println(xiaohe_shijian_load_result_list);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseData.ok(result);
	}

	//保存校核选择的数据
	@GetMapping("/baocun_xuanze_data_xiaohe")
	public ResponseData baocun_xuanze_data_xiaohesave(String jinghao,String shijian) {
		try {
//			System.out.println("start");
			System.out.println(jinghao);
			File writename1 = new File("E:\\桌面\\vue\\well_distinguish\\jing_hao.txt");
			writename1.createNewFile();
			BufferedWriter out1 = new BufferedWriter(new FileWriter(writename1));
			out1.write(jinghao+"\r\n"); // \r\n为换行
			out1.flush(); // 把缓存区内容压入文件
			out1.close();
			System.out.println("井号保存成功！");

			System.out.println(shijian);
			File writename2 = new File("E:\\桌面\\vue\\well_distinguish\\ceshi_riqi.txt");
			writename2.createNewFile();
			BufferedWriter out2 = new BufferedWriter(new FileWriter(writename2));
			out2.write(shijian+"\r\n"); // \r\n为换行
			out2.flush(); // 把缓存区内容压入文件
			out2.close();
			System.out.println("测试时间保存成功！");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseData.fail("校核数据保存失败！");
	}

	// // 调用python校核
	@RequestMapping("/xiao_python")
	public ResponseData xiao_python()  throws JsonParseException, JsonMappingException, IOException   {

		//调用python
		List<String> xiaohe_label2 = new ArrayList<String>();
		try {
//			System.out.println("start");
//			//环境和main
//			String[] args4=new String[]{"D:\\Anaconda3\\python.exe", "E:\\桌面\\vue\\well_distinguish\\well_distinguish.py"};
//			Process pr=Runtime.getRuntime().exec(args4);
//			BufferedReader in = new BufferedReader(new InputStreamReader(
//					pr.getInputStream(), "utf-8"));
//			String line;
//			while ((line = in.readLine()) != null) {
////				training_label1.add(line);
//				System.out.println(line);
//			}
////			System.out.println(training_label1);
//			in.close();
//			pr.waitFor();

			System.out.println("start");
			//环境和main
			String[] args3=new String[]{"E:\\PYthon\\python.exe", "E:\\\\桌面\\\\vue\\\\well_distinguish\\\\well_distinguish.py"};
			Process pr=Runtime.getRuntime().exec(args3);

			BufferedReader in = new BufferedReader(new InputStreamReader(
					pr.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
//				training_label1.add(line);
				System.out.println(line);
			}
//			System.out.println(training_label1);
			in.close();
			pr.waitFor();

			System.out.println("end");
//			System.out.println("校核完成！");
			xiaohe_label2.add("校核完成！");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		};
		List<String> xiaohe_label222 = new ArrayList<String>();
		xiaohe_label222 = xiaohe_label2;
//		xiaohe_label.remove("");
//		System.out.println(opt_label);
		Map<String, Object> result = new HashMap();
		result.put("xiaohe_label222", xiaohe_label222);
		return ResponseData.ok(result);
//		int[] chart=new int[] {10, 60, 40, 70, 5, 20, 36, 10, 10, 55};
//		Map<String, Object> result = new HashMap ();
//		result.put("chart",chart);
//		return ResponseData.ok(result);
	}

	//读取结果数据
	@RequestMapping("outcome")
	public ArrayList Opt()  throws JsonParseException, JsonMappingException, IOException   {
		//这个是柱状图的data
		ArrayList<Object> data = new ArrayList<Object>();
		ArrayList<Double> times = new ArrayList<Double>();
		ArrayList<Double> npv = new ArrayList<Double>();
		ArrayList<Double> ysz = new ArrayList<Double>();
		//读项目名，前台获取不到。
		Scanner scanners = new Scanner(new FileInputStream("E:\\桌面\\vue\\training_result.txt"),"GBK") ;
		scanners.next();scanners.next();
		String itemname = scanners.next();
		System.out.println("打开NPV结果文件.........."  );
		//从数据库获取数据
		String npvfile = "E:\\桌面\\vue\\training_result.txt";
		Scanner scanner = new Scanner(new FileInputStream(npvfile),"GBK") ;
		int a = 0;
		double b,c,d,e;
		while(scanner.hasNext()){
			// String[] as = null;
			//as[a++] = scanner.next();一个一个加
			times.add(Double.parseDouble(scanner.next()) );
			npv.add(Double.parseDouble(scanner.next()) );
			ysz.add(Double.parseDouble(scanner.next()) );
		}
		//直接加对象，集合里套集合
		data.add(times);
		data.add(npv);
		data.add(ysz);
		System.out.println(data.toString());
		return data;
	}

	//保存模型选择
  @RequestMapping(value = "/file_save", method = RequestMethod.POST)

 public ResponseData save(String model_way) {


		try {
			System.out.println("ok");
			System.out.println(model_way);
			File writename = new File(PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\Modle_Choice.txt");
			writename.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			out.write(model_way + "\r\n"); // \r\n为换行
			out.flush(); // 把缓存区内容压入文件
			out.close();
			System.out.println("模型保存成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseData.fail("模型保存失败！");
	}

	//保存特征选择
	  @RequestMapping(value = "/file_F_save", method = RequestMethod.POST)
	public ResponseData Fsave(String fvalue) {


		try {
			System.out.println("ok");
			System.out.println(fvalue);
			File writename = new File(PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\Fvalue_Choice.txt");
			writename.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			out.write(fvalue+ "\r\n"); // \r\n为换行
			out.flush(); // 把缓存区内容压入文件
			out.close();
			System.out.println("特征选择保存成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//保存优化模型选择
	@GetMapping("/model_way_opt_save")
	public ResponseData model_opt_save(String model_way_opt) {
		try {
			System.out.println("ok");
			System.out.println(model_way_opt);
			File writename = new File("E:\\桌面\\vue\\Model_way_opt_choice.txt");
			writename.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			out.write(model_way_opt + "\r\n"); // \r\n为换行
			out.flush(); // 把缓存区内容压入文件
			out.close();
			System.out.println("优化模型保存成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseData.fail("优化模型保存失败！");
	}
	//保存优化模型参数选择
	@GetMapping("/paraneters_select_opt_save")
	public ResponseData paraneters_opt_save(String SVM_C, String LR_penalty, String KNN_n_neighbors,
											String RF_n_estimators, String RF_n_samples_leaf, String LGB_num_leaves,
											String LGB_learning_rate, String LGB_n_estimators, String XGB_max_depth,
											String XGB_learning_rate, String XGB_n_estimators, String DT_max_depth,
											String BNB_alpha, String GDBT_learning_rate, String GDBT_n_estimators,
											String ADB_learning_rate, String ADB_n_estimators, String GNB_priors,
											String LDA_solver, String LDA_priors, String QDA_priors) {
		try {
			System.out.println("ok");
			System.out.println(SVM_C);
			File writename_SVM = new File("E:\\桌面\\vue\\SVM_opt\\paraneters_SVM_opt.txt");
			writename_SVM.createNewFile();
			BufferedWriter out_SVM = new BufferedWriter(new FileWriter(writename_SVM));
			out_SVM.write(SVM_C + "\r\n"); // \r\n为换行
			out_SVM.flush(); // 把缓存区内容压入文件
			out_SVM.close();

			System.out.println(LR_penalty);
			File writename_LR = new File("E:\\桌面\\vue\\LR_opt\\paraneters_LR_opt.txt");
			writename_LR.createNewFile();
			BufferedWriter out_LR = new BufferedWriter(new FileWriter(writename_LR));
			out_LR.write(LR_penalty + "\r\n"); // \r\n为换行
			out_LR.flush(); // 把缓存区内容压入文件
			out_LR.close();

			System.out.println(KNN_n_neighbors);
			File writename_KNN = new File("E:\\桌面\\vue\\KNN_opt\\paraneters_KNN_opt.txt");
			writename_KNN.createNewFile();
			BufferedWriter out_KNN = new BufferedWriter(new FileWriter(writename_KNN));
			out_KNN.write(KNN_n_neighbors + "\r\n"); // \r\n为换行
			out_KNN.flush(); // 把缓存区内容压入文件
			out_KNN.close();

			System.out.println(RF_n_estimators);
			System.out.println(RF_n_samples_leaf);
			File writename_RF = new File("E:\\桌面\\vue\\RF_opt\\paraneters_RF_opt.txt");
			writename_RF.createNewFile();
			BufferedWriter out_RF = new BufferedWriter(new FileWriter(writename_RF));
			out_RF.write(RF_n_estimators + "\r\n");
			out_RF.write(RF_n_samples_leaf + "\r\n"); // \r\n为换行
			out_RF.flush(); // 把缓存区内容压入文件
			out_RF.close();

			System.out.println(LGB_num_leaves);
			System.out.println(LGB_learning_rate);
			System.out.println(LGB_n_estimators);
			File writename_LGB = new File("E:\\桌面\\vue\\LGB_opt\\paraneters_LGB_opt.txt");
			writename_LGB.createNewFile();
			BufferedWriter out_LGB = new BufferedWriter(new FileWriter(writename_LGB));
			out_LGB.write(LGB_num_leaves + "\r\n");
			out_LGB.write(LGB_learning_rate + "\r\n");
			out_LGB.write(LGB_n_estimators + "\r\n");// \r\n为换行
			out_LGB.flush(); // 把缓存区内容压入文件
			out_LGB.close();

			System.out.println(XGB_max_depth);
			System.out.println(XGB_learning_rate);
			System.out.println(XGB_n_estimators);
			File writename_XGB = new File("E:\\桌面\\vue\\XGB_opt\\paraneters_XGB_opt.txt");
			writename_XGB.createNewFile();
			BufferedWriter out_XGB = new BufferedWriter(new FileWriter(writename_XGB));
			out_XGB.write(XGB_max_depth + "\r\n");
			out_XGB.write(XGB_learning_rate + "\r\n");
			out_XGB.write(XGB_n_estimators + "\r\n");// \r\n为换行
			out_XGB.flush(); // 把缓存区内容压入文件
			out_XGB.close();

			System.out.println(DT_max_depth);
			File writename_DT = new File("E:\\桌面\\vue\\DT_opt\\paraneters_DT_opt.txt");
			writename_DT.createNewFile();
			BufferedWriter out_DT = new BufferedWriter(new FileWriter(writename_DT));
			out_DT.write(DT_max_depth + "\r\n"); // \r\n为换行
			out_DT.flush(); // 把缓存区内容压入文件
			out_DT.close();

			System.out.println(BNB_alpha);
			File writename_BNB = new File("E:\\桌面\\vue\\BNB_opt\\paraneters_BNB_opt.txt");
			writename_BNB.createNewFile();
			BufferedWriter out_BNB = new BufferedWriter(new FileWriter(writename_BNB));
			out_BNB.write(BNB_alpha + "\r\n"); // \r\n为换行
			out_BNB.flush(); // 把缓存区内容压入文件
			out_BNB.close();

			System.out.println(GDBT_learning_rate);
			System.out.println(GDBT_n_estimators);
			File writename_GDBT = new File("E:\\桌面\\vue\\GDBT_opt\\paraneters_GDBT_opt.txt");
			writename_GDBT.createNewFile();
			BufferedWriter out_GDBT = new BufferedWriter(new FileWriter(writename_GDBT));
			out_GDBT.write(GDBT_learning_rate + "\r\n");
			out_GDBT.write(GDBT_n_estimators + "\r\n");// \r\n为换行
			out_GDBT.flush(); // 把缓存区内容压入文件
			out_GDBT.close();

			System.out.println(ADB_learning_rate);
			System.out.println(ADB_n_estimators);
			File writename_ADB = new File("E:\\桌面\\vue\\ADB_opt\\paraneters_ADB_opt.txt");
			writename_ADB.createNewFile();
			BufferedWriter out_ADB = new BufferedWriter(new FileWriter(writename_ADB));
			out_ADB.write(ADB_learning_rate + "\r\n");
			out_ADB.write(ADB_n_estimators + "\r\n");// \r\n为换行
			out_ADB.flush(); // 把缓存区内容压入文件
			out_ADB.close();

			System.out.println(GNB_priors);
			File writename_GNB = new File("E:\\桌面\\vue\\GNB_opt\\paraneters_GNB_opt.txt");
			writename_GNB.createNewFile();
			BufferedWriter out_GNB = new BufferedWriter(new FileWriter(writename_GNB));
			out_GNB.write(GNB_priors + "\r\n"); // \r\n为换行
			out_GNB.flush(); // 把缓存区内容压入文件
			out_GNB.close();

			System.out.println(LDA_solver);
			System.out.println(LDA_priors);
			File writename_LDA = new File("E:\\桌面\\vue\\LDA_opt\\paraneters_LDA_opt.txt");
			writename_LDA.createNewFile();
			BufferedWriter out_LDA = new BufferedWriter(new FileWriter(writename_LDA));
			out_LDA.write(LDA_solver + "\r\n");
			out_LDA.write(LDA_priors + "\r\n");// \r\n为换行
			out_LDA.flush(); // 把缓存区内容压入文件
			out_LDA.close();

			System.out.println(QDA_priors);
			File writename_QDA = new File("E:\\桌面\\vue\\QDA_opt\\paraneters_QDA_opt.txt");
			writename_QDA.createNewFile();
			BufferedWriter out_QDA = new BufferedWriter(new FileWriter(writename_QDA));
			out_QDA.write(QDA_priors + "\r\n"); // \r\n为换行
			out_QDA.flush(); // 把缓存区内容压入文件
			out_QDA.close();

			System.out.println("模型优化参数保存成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseData.fail("优化模型保存失败！");
	}

	// 调用python优化
	@RequestMapping("/usepython_model_opt")
	public ResponseData Opt_model(String forcast_filename)  throws JsonParseException, JsonMappingException, IOException   {


		//调用python
		List<String> opt_label1 = new ArrayList<String>();
		try {
			System.out.println("start");
			//环境和main
			Process pr=Runtime.getRuntime().exec(args12);
//			String errStr = consumeInputStream(pr.getErrorStream());
//			String inStr = consumeInputStream(pr.getInputStream());
//			// 标准错误流（必须写在 waitFor 之前）
//			String errStra = consumeInputStream(pr.getErrorStream());
//			int retCode = pr.waitFor();
//			if(retCode == 0){
//				System.out.println("程序正常执行结束");
//			}
			BufferedReader in = new BufferedReader(new InputStreamReader(
					pr.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
//				training_label1.add(line);
				System.out.println(line);
			}
//			System.out.println(training_label1);
			in.close();
			pr.waitFor();

			System.out.println("end");
			opt_label1.add("模型优化完成！");
			opt_label1.add("模型保存完成！");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		};
		List<String> opt_label11 = new ArrayList<String>();
		opt_label11 = opt_label1;
		opt_label11.remove("");
		System.out.println(opt_label11);
		Map<String, Object> result = new HashMap();
		result.put("opt_label11", opt_label11);
		return ResponseData.ok(result);
//		int[] chart=new int[] {10, 60, 40, 70, 5, 20, 36, 10, 10, 55};
//		Map<String, Object> result = new HashMap ();
//		result.put("chart",chart);
//		return ResponseData.ok(result);
	}

	// 获取模型训练与优化结果
	@GetMapping("/getmodelList")
	public ResponseData getmodelListUsers( ) throws IOException {
		List<UserVo> model_load_result_list = new ArrayList<UserVo>();
		List<String> model_load_result_list1 = new ArrayList<>();
		// 获取模型训练与优化结果
//		Scanner scanners5 = new Scanner(new FileInputStream("E:\\桌面\\vue\\Model_save_total.txt"),"UTF-8") ;
//		scanners5.next();scanners5.next();
//		String itemname = scanners5.next();m
		//从数据库获取数据
		String Model_save_total_file = "E:\\桌面\\vue\\model_save_total.txt";
		BufferedReader baa = new BufferedReader(new InputStreamReader(new FileInputStream(new File(Model_save_total_file)), "UTF-8"));
		String line_save;
		while ((line_save = baa.readLine()) != null) {
			model_load_result_list1.add(line_save);
			System.out.println(line_save);
		}
//		while(scanner5.hasNext()){
//			model_load_result_list1.add(String.format((scanner5.next())) );
//		}
		System.out.println(model_load_result_list1);
		int a = model_load_result_list1.size();
		System.out.println(a);

		for (int i = 0; i < a; i = i + 1) {
			model_load_result_list.add(new UserVo(i, model_load_result_list1.get(i)));
		}
		Map<String, Object> result = new HashMap ();
		result.put("model_load_result_list1", model_load_result_list1);
		System.out.println(model_load_result_list1);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseData.ok(result);
	}

	// 获取准确率数据
	@GetMapping("/cumputes1")
	public ResponseData jisuan1 (String canshu1) throws IOException {


		List<String> label1 = new ArrayList<String>();
		List<Object> acc_noopt = new ArrayList<Object>();
		List<Object> acc_opt = new ArrayList<Object>();
		List<Object> acc_total_noopt = new ArrayList<Object>();
		List<Object> acc_total_opt = new ArrayList<Object>();
		List<Object> acc_total = new ArrayList<Object>();
		List<Object> acc_total1 = new ArrayList<Object>();
		try {
//			System.out.println("start");
			// 获取标签
			Scanner scanners10 = new Scanner(new FileInputStream(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\label.txt"),"UTF-8") ;
			scanners10.next();scanners10.next();
			String itemname10 = scanners10.next();
			//从数据库获取数据
			String label1_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\label.txt";
			Scanner scanner10 = new Scanner(new FileInputStream(label1_file),"UTF-8") ;
			while(scanner10.hasNext()){
				label1.add(String.format(scanner10.next()));
			}
			System.out.println(label1);
			// 获取优化前准确率
			Scanner scanners1 = new Scanner(new FileInputStream(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\acc_"+canshu1+"_no_opt.txt"),"UTF-8") ;
			scanners1.next();scanners1.next();
			String itemname1 = scanners1.next();
			//从数据库获取数据
			String acc_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\acc_"+canshu1+"_no_opt.txt";
			Scanner scanner1 = new Scanner(new FileInputStream(acc_file),"UTF-8") ;
			while(scanner1.hasNext()){
				acc_noopt.add(Double.parseDouble(scanner1.next()) );
			}
			System.out.println(acc_noopt);
			// 获取优化后准确率
//			Scanner scanners11 = new Scanner(new FileInputStream(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\acc_"+canshu1+"_opt.txt"),"UTF-8") ;
//			scanners11.next();scanners1.next();
//			String itemname11 = scanners11.next();
			//从数据库获取数据
			String acc11_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\acc_"+canshu1+"_opt.txt";
			Scanner scanner11 = new Scanner(new FileInputStream(acc11_file),"UTF-8") ;
			while(scanner11.hasNext()){
				acc_opt.add(Double.parseDouble(scanner11.next()) );
			}
			System.out.println(acc_opt);

			// 获取总的准确率
//			Scanner scanners4 = new Scanner(new FileInputStream(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\acc_total_"+canshu1+"_no_opt.txt"),"UTF-8") ;
//			scanners4.next();
//			String itemname4 = scanners4.next();
			//从数据库获取数据
			String acc_total_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\acc_total_"+canshu1+"_no_opt.txt";
			Scanner scanner4 = new Scanner(new FileInputStream(acc_total_file),"UTF-8") ;
			while(scanner4.hasNext()){
				acc_total_noopt.add(Double.parseDouble(scanner4.next()) );
			}
			System.out.println(acc_total_noopt);
			Scanner scanners41 = new Scanner(new FileInputStream(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\acc_total_"+canshu1+"_opt.txt"),"UTF-8") ;
			scanners41.next();
//			String itemname4 = scanners4.next();
			//从数据库获取数据
			String acc_total_file1 = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\acc_total_"+canshu1+"_opt.txt";
			Scanner scanner41 = new Scanner(new FileInputStream(acc_total_file1),"UTF-8") ;
			while(scanner41.hasNext()){
				acc_total_opt.add(Double.parseDouble(scanner41.next()) );
			}
			System.out.println(acc_total_opt);

			int a = label1.size();
			System.out.println(a);
			List<Object> acctotal1 = new ArrayList<Object>();
			acctotal1.add("product");
			acctotal1.add("优化前");
			acctotal1.add("优化后");
			acc_total.add(acctotal1);
			for (int i = 0; i < a; i = i + 1) {
				List<Object> acctotal = new ArrayList<Object>();
				acctotal.add(label1.get(i));
				acctotal.add(acc_noopt.get(i));
				acctotal.add(acc_opt.get(i));
				acc_total.add(acctotal);
			}
			acc_total1.add(acc_total);
			acc_total1.add(acc_total_noopt);
			acc_total1.add(acc_total_opt);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		};
		System.out.println(acc_total);
		Map<String, Object> result = new HashMap();
		result.put("acc_total1", acc_total1);
		return ResponseData.ok(result);
	}

	// 获取召回率
	@GetMapping("/cumputes3")
	public ResponseData jisuan3 (String canshu3) throws IOException {


		List<String> label1 = new ArrayList<String>();
		List<Object> recall_noopt = new ArrayList<Object>();
		List<Object> recall_opt = new ArrayList<Object>();
		List<Object> recall_total_noopt = new ArrayList<Object>();
		List<Object> recall_total_opt = new ArrayList<Object>();
		List<Object> recall_total = new ArrayList<Object>();
		List<Object> recall_total1 = new ArrayList<Object>();
		try {
//			System.out.println("start");
			// 获取标签
			Scanner scanners10 = new Scanner(new FileInputStream(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\label.txt"),"UTF-8") ;
			scanners10.next();scanners10.next();
			String itemname10 = scanners10.next();
			//从数据库获取数据
			String label1_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\label.txt";
			Scanner scanner10 = new Scanner(new FileInputStream(label1_file),"UTF-8") ;
			while(scanner10.hasNext()){
				label1.add(String.format(scanner10.next()));
			}
			System.out.println(label1);
			// 获取优化前准确率
			Scanner scanners1 = new Scanner(new FileInputStream(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\recall_"+canshu3+"_no_opt.txt"),"UTF-8") ;
			scanners1.next();scanners1.next();
			String itemname1 = scanners1.next();
			//从数据库获取数据
			String acc_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\recall_"+canshu3+"_no_opt.txt";
			Scanner scanner1 = new Scanner(new FileInputStream(acc_file),"UTF-8") ;
			while(scanner1.hasNext()){
				recall_noopt.add(Double.parseDouble(scanner1.next()) );
			}
			System.out.println(recall_noopt);
			// 获取优化后准确率
			Scanner scanners11 = new Scanner(new FileInputStream(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\recall_"+canshu3+"_opt.txt"),"UTF-8") ;
			scanners11.next();scanners11.next();
			String itemname11 = scanners11.next();
			//从数据库获取数据
			String acc11_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\recall_"+canshu3+"_opt.txt";
			Scanner scanner11 = new Scanner(new FileInputStream(acc11_file),"UTF-8") ;
			while(scanner11.hasNext()){
				recall_opt.add(Double.parseDouble(scanner11.next()) );
			}
			System.out.println(recall_opt);

			// 获取总的准确率
			Scanner scanners4 = new Scanner(new FileInputStream(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\recall_total_"+canshu3+"_no_opt.txt"),"UTF-8") ;
			scanners4.next();
//			String itemname4 = scanners4.next();
			//从数据库获取数据
			String acc_total_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\recall_total_"+canshu3+"_no_opt.txt";
			Scanner scanner4 = new Scanner(new FileInputStream(acc_total_file),"UTF-8") ;
			while(scanner4.hasNext()){
				recall_total_noopt.add(Double.parseDouble(scanner4.next()) );
			}
			System.out.println(recall_total_noopt);
			Scanner scanners41 = new Scanner(new FileInputStream(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\recall_total_"+canshu3+"_opt.txt"),"UTF-8") ;
			scanners41.next();
//			String itemname4 = scanners4.next();
			//从数据库获取数据
			String acc_total_file1 = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\recall_total_"+canshu3+"_opt.txt";
			Scanner scanner41 = new Scanner(new FileInputStream(acc_total_file1),"UTF-8") ;
			while(scanner41.hasNext()){
				recall_total_opt.add(Double.parseDouble(scanner41.next()) );
			}
			System.out.println(recall_total_opt);

			int a = label1.size();
			System.out.println(a);
			List<Object> acctotal1 = new ArrayList<Object>();
			acctotal1.add("product");
			acctotal1.add("优化前");
			acctotal1.add("优化后");
			recall_total.add(acctotal1);
			for (int i = 0; i < a; i = i + 1) {
				List<Object> acctotal = new ArrayList<Object>();
				acctotal.add(label1.get(i));
				acctotal.add(recall_noopt.get(i));
				acctotal.add(recall_opt.get(i));
				recall_total.add(acctotal);
			}
			recall_total1.add(recall_total);
			recall_total1.add(recall_total_noopt);
			recall_total1.add(recall_total_opt);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		};

		Map<String, Object> result = new HashMap();
		result.put("recall_total1", recall_total1);
		return ResponseData.ok(result);
	}

	// 获取loss_train数据
	@GetMapping("/cumputes2")
	public ResponseData jisuan2 (String canshu2) throws IOException {


		List<Object> loss_train1 = new ArrayList<Object>();
		List<Object> loss_train11 = new ArrayList<Object>();
		List<Object> loss_train = new ArrayList<Object>();
		List<Object> loss_diedaicishu = new ArrayList<Object>();
		try {
			// 获取迭代次数
			Scanner scanners9 = new Scanner(new FileInputStream(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\train_size_"+canshu2+"_no_opt.txt"),"UTF-8") ;
			scanners9.next();scanners9.next();
			String itemname9 = scanners9.next();
			//从数据库获取数据
			String loss_diedaicishu_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\train_size_"+canshu2+"_no_opt.txt";
			Scanner scanner9 = new Scanner(new FileInputStream(loss_diedaicishu_file),"UTF-8") ;
			while(scanner9.hasNext()){
				loss_diedaicishu.add(Double.parseDouble(scanner9.next()) );
			}
			System.out.println(loss_diedaicishu);
			// 获取优化前的loss_train
			Scanner scanners = new Scanner(new FileInputStream(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\train_loss_"+canshu2+"_no_opt.txt"),"UTF-8") ;
			scanners.next();scanners.next();
			String itemname = scanners.next();
			//从数据库获取数据
			String loss_train_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\train_loss_"+canshu2+"_no_opt.txt";
			Scanner scanner = new Scanner(new FileInputStream(loss_train_file),"UTF-8") ;
			while(scanner.hasNext()){
				loss_train1.add(Double.parseDouble(scanner.next()) );
			}
			System.out.println(loss_train1);

			// 获取优化后的loss_train
			Scanner scanners1 = new Scanner(new FileInputStream(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\train_loss_"+canshu2+"_opt.txt"),"UTF-8") ;
			scanners1.next();scanners1.next();
			String itemname1 = scanners1.next();
			//从数据库获取数据
			String loss_train_file1 = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\train_loss_"+canshu2+"_opt.txt";
			Scanner scanner1 = new Scanner(new FileInputStream(loss_train_file1),"UTF-8") ;
			while(scanner1.hasNext()){
				loss_train11.add(Double.parseDouble(scanner1.next()) );
			}
			System.out.println(loss_train11);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		};
		loss_train.add(loss_diedaicishu);
		loss_train.add(loss_train1);
		loss_train.add(loss_train11);
		System.out.println(loss_train);
		Map<String, Object> result = new HashMap();
		result.put("loss_train", loss_train);
		return ResponseData.ok(result);
//		double[] line=new double[] {0.2, 0.11, 0.09, 0.08, 0.07, 0.06, 0.055, 0.05, 0.048, 0.047};
//		Map<String, Object> result = new HashMap ();
//		result.put("line",line);
//		return ResponseData.ok(result);
	}

	// 获取loss_test数据
	@GetMapping("/cumputes4")
	public ResponseData jisuan4 (String canshu4) throws IOException {


		List<Object> loss_test1 = new ArrayList<Object>();
		List<Object> loss_test11 = new ArrayList<Object>();
		List<Object> loss_test = new ArrayList<Object>();
		List<Object> loss_diedaicishu = new ArrayList<Object>();
		try {
			// 获取迭代次数
			Scanner scanners9 = new Scanner(new FileInputStream(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\train_size_"+canshu4+"_no_opt.txt"),"UTF-8") ;
			scanners9.next();scanners9.next();
			String itemname9 = scanners9.next();
			//从数据库获取数据
			String loss_diedaicishu_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\train_size_"+canshu4+"_no_opt.txt";
			Scanner scanner9 = new Scanner(new FileInputStream(loss_diedaicishu_file),"UTF-8") ;
			while(scanner9.hasNext()){
				loss_diedaicishu.add(Double.parseDouble(scanner9.next()) );
			}
			System.out.println(loss_diedaicishu);
			// 获取优化前的loss_test
			Scanner scanners6 = new Scanner(new FileInputStream(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\validation_loss_"+canshu4+"_no_opt.txt"),"UTF-8") ;
			scanners6.next();scanners6.next();
			String itemname = scanners6.next();
			//从数据库获取数据
			String loss_test_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\validation_loss_"+canshu4+"_no_opt.txt";
			Scanner scanner6 = new Scanner(new FileInputStream(loss_test_file),"UTF-8") ;
			while(scanner6.hasNext()){
				loss_test1.add(Double.parseDouble(scanner6.next()) );
			}
			System.out.println(loss_test1);
			// 获取优化后的loss_test
			Scanner scanners61 = new Scanner(new FileInputStream(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\validation_loss_"+canshu4+"_opt.txt"),"UTF-8") ;
			scanners61.next();scanners61.next();
			String itemname1 = scanners61.next();
			//从数据库获取数据
			String loss_test_file1 = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\validation_loss_"+canshu4+"_opt.txt";
			Scanner scanner61 = new Scanner(new FileInputStream(loss_test_file1),"UTF-8") ;
			while(scanner61.hasNext()){
				loss_test11.add(Double.parseDouble(scanner61.next()) );
			}
			System.out.println(loss_test11);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		};
		loss_test.add(loss_diedaicishu);
		loss_test.add(loss_test1);
		loss_test.add(loss_test11);
		System.out.println(loss_test);
		Map<String, Object> result = new HashMap();
		result.put("loss_test", loss_test);
		return ResponseData.ok(result);
	}

	// 调用优化参数结果
	@GetMapping("/cumputes5")
	public ResponseData jisuan5 () throws IOException {


		List<String> canshu_label1 = new ArrayList<String>();
		List<Object> shuju_list = new ArrayList<Object>();
		List<Object> canshu_total1 = new ArrayList<Object>();
		try {
			//从数据库获取数据
			String label1_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\params_.txt";
			Scanner scanner10 = new Scanner(new FileInputStream(label1_file),"UTF-8") ;
			while(scanner10.hasNext()){
				canshu_label1.add(String.format(scanner10.next()));
			}
			System.out.println(canshu_label1);
			// 获取优化前准确率
			//从数据库获取数据
			String acc_file = PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\Best_params_.txt";
			Scanner scanner1 = new Scanner(new FileInputStream(acc_file),"UTF-8") ;
			while(scanner1.hasNext()){
				shuju_list.add(Double.parseDouble(scanner1.next()) );
			}
			System.out.println(shuju_list);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		};
		canshu_total1.add(canshu_label1);
		canshu_total1.add(shuju_list);
		System.out.println(canshu_total1);
		Map<String, Object> result = new HashMap();
		result.put("canshu_total1", canshu_total1);
		return ResponseData.ok(result);
	}



	// 保存训练起止时间
	@GetMapping("/get_train_date")
	public ResponseData get_train_date1(String trainstartdate, String trainenddate) {


		try {
//			System.out.println("start");
			System.out.println(trainstartdate);
			File writename1 = new File(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\train_start_date.txt");
			writename1.createNewFile();
			BufferedWriter out1 = new BufferedWriter(new FileWriter(writename1));
			out1.write(trainstartdate+"\r\n"); // \r\n为换行
			out1.flush(); // 把缓存区内容压入文件
			out1.close();

			System.out.println(trainenddate);
			File writename2 = new File(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\train_end_date.txt");
			writename2.createNewFile();
			BufferedWriter out2 = new BufferedWriter(new FileWriter(writename2));
			out2.write(trainenddate + "\r\n"); // \r\n为换行
			out2.flush(); // 把缓存区内容压入文件
			out2.close();
			System.out.println("数据时间保存成功！");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseData.fail("识别数据保存失败！");
	}

	// 保存预测起止时间
	@GetMapping("/get_yuce_date")
	public ResponseData get_yuce_date1(String shibiestartdate, String shibieenddate) {


		try {
//			System.out.println("start");
			System.out.println(shibiestartdate);
			File writename1 = new File(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\shibie_start_date.txt");
			writename1.createNewFile();
			BufferedWriter out1 = new BufferedWriter(new FileWriter(writename1));
			out1.write(shibiestartdate+"\r\n"); // \r\n为换行
			out1.flush(); // 把缓存区内容压入文件
			out1.close();

			System.out.println(shibieenddate);
			File writename2 = new File(PATH+"\\TeZzhengshibie_ShiGongTuzhengdaun\\shibie_end_date.txt");
			writename2.createNewFile();
			BufferedWriter out2 = new BufferedWriter(new FileWriter(writename2));
			out2.write(shibieenddate + "\r\n"); // \r\n为换行
			out2.flush(); // 把缓存区内容压入文件
			out2.close();
			System.out.println("数据时间保存成功！");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseData.fail("识别数据保存失败！");
	}

	// 模型训练
	@RequestMapping("/training")
	public ResponseData Opt2(String forcast_filename)  throws JsonParseException, JsonMappingException, IOException   {

		//调用python
		List<String> training_label1 = new ArrayList<String>();
		List<String> line1 = new ArrayList<String>();


		try {
			System.out.println("start");
			//环境和main
			Process pr=Runtime.getRuntime().exec(args13);

			BufferedReader in = new BufferedReader(new InputStreamReader(
					pr.getInputStream(), "utf-8"));
			String line;
			while ((line = in.readLine()) != null) {
//				training_label1.add(line);
				System.out.println(line);
			}
//			System.out.println(training_label1);
			in.close();
			pr.waitFor();
			System.out.println("end");
			training_label1.add("模型训练完成！");
			training_label1.add("模型保存完成！");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		};
		List<String> training_label = new ArrayList<String>();
		training_label = training_label1;
		training_label.remove("");
		System.out.println(training_label);
		Map<String, Object> result = new HashMap();
		result.put("training_label", training_label);
		return ResponseData.ok(result);
	}


	public static String consumeInputStream(InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String s ;
		StringBuilder sb = new StringBuilder();
		while((s=br.readLine())!=null){
			System.out.println(s);
			sb.append(s);
		}
		return sb.toString();
	}




	// 调用模型训练总准确率和总召回率数据
	@GetMapping("/get_total")
	public ResponseData get_total1 () throws IOException {
		List<Object> model_label = new ArrayList<Object>();
		List<String> model_acc = new ArrayList<String>();
		List<Object> model_recall = new ArrayList<Object>();
		List<Object> total_list = new ArrayList<Object>();
		List<Object> total1 = new ArrayList<Object>();


		try {
//			System.out.println("start");
			// 获取标签
//			Scanner scanners10 = new Scanner(new FileInputStream(PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\model_select.txt"),"UTF-8") ;
//			scanners10.next();scanners10.next();
//			String itemname10 = scanners10.next();
			//从数据库获取数据
			String label1_file = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\model_select.txt";
			Scanner scanner10 = new Scanner(new FileInputStream(label1_file),"GBK") ;
			while(scanner10.hasNext()){
				model_label.add(String.format(scanner10.next()));
			}
			System.out.println(model_label);
			// 获取准确率
//			Scanner scanners1 = new Scanner(new FileInputStream(PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\model_acc.txt"),"UTF-8") ;
//			scanners1.next();scanners1.next();
//			String itemname1 = scanners1.next();
			//从数据库获取数据
			String acc_file = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\model_acc.txt";
			Scanner scanner1 = new Scanner(new FileInputStream(acc_file),"GBK") ;
			while(scanner1.hasNext()){
				model_acc.add(String.format(scanner1.next()));
			}
			System.out.println(model_acc);
			// 获取总的准确率
//			Scanner scanners4 = new Scanner(new FileInputStream(PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\model_recall.txt"),"UTF-8") ;
//			scanners4.next();
//			String itemname4 = scanners4.next();
			//从数据库获取数据
			String acc_total_file = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\model_recall.txt";
			Scanner scanner4 = new Scanner(new FileInputStream(acc_total_file),"GBK") ;
			while(scanner4.hasNext()){
				model_recall.add(String.format(scanner4.next()));
			}
			System.out.println(model_recall);

			int a = model_label.size();
			System.out.println(a);
			List<Object> acctotal1 = new ArrayList<Object>();
			acctotal1.add("模型");
			acctotal1.add("总准确率");
			acctotal1.add("总召回率");
			total1.add(acctotal1);
			for (int i = 0; i < a; i = i + 1) {
				List<Object> model = new ArrayList<Object>();
				model.add(model_label.get(i));
				model.add(model_acc.get(i));
				model.add(model_recall.get(i));
				System.out.println(model);
				total1.add(model);
			}
			total_list.add(total1);
			total_list.add(model_label);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		};
		System.out.println(total_list);
		Map<String, Object> result = new HashMap();
		result.put("total_list", total_list);
		return ResponseData.ok(result);
	}

	// 获取训练过程
	@GetMapping("/rusult_select")
	public ResponseData rusult_select () throws IOException {
		List<Object> rusult_xunlian = new ArrayList<Object>();


		try {
			String rusult_select_file = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\result_xunlian.txt";
			BufferedReader baa = new BufferedReader(new InputStreamReader(new FileInputStream(new File(rusult_select_file)), "UTF-8"));
			String line_save;
			while ((line_save = baa.readLine()) != null) {
				rusult_xunlian.add(line_save);
			}
//			System.out.println(rusult_xunlian);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		};
		Map<String, Object> result = new HashMap();
		result.put("rusult_xunlian", rusult_xunlian);
		return ResponseData.ok(result);
	}

	//重新定义训练过程
	@GetMapping("/renametraining_file")
	public ResponseData renametraining_file() {
		Map<String, Object> result = null;
		List<String> model_select_forecast_label = new ArrayList<>();


		try {
			System.out.println("ok");
			File writename = new File(PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\result_xunlian.txt");
			writename.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			out.write(""+ "\r\n"); // \r\n为换行
			out.flush(); // 把缓存区内容压入文件
			out.close();
			System.out.println("重新定义训练过程成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 获取优化过程
	@GetMapping("/rusult_opt_test")
	public ResponseData rusult_opt_test () throws IOException {
		List<Object> result_youhua = new ArrayList<Object>();
		try {
			String rusult_select_file = "E:\\桌面\\vue\\result_youhua.txt";
			BufferedReader baa = new BufferedReader(new InputStreamReader(new FileInputStream(new File(rusult_select_file)), "UTF-8"));
			String line_save;
			while ((line_save = baa.readLine()) != null) {
				result_youhua.add(line_save);
			}
//			System.out.println(rusult_xunlian);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		};
		Map<String, Object> result = new HashMap();
		result.put("result_youhua", result_youhua);
		return ResponseData.ok(result);
	}

	//重新定义优化过程
	@GetMapping("/renameopt_file")
	public ResponseData renameopt_file() {
		Map<String, Object> result = null;
		List<String> model_select_forecast_label = new ArrayList<>();
		try {
			System.out.println("ok");
			File writename = new File("E:\\桌面\\vue\\result_youhua.txt");
			writename.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			out.write(""+ "\r\n"); // \r\n为换行
			out.flush(); // 把缓存区内容压入文件
			out.close();
			System.out.println("重新定义优化过程成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 获取预测过程
	@GetMapping("/forecast_guocheng_file")
	public ResponseData forecast_guocheng_file () throws IOException {
		List<Object> result_yuce = new ArrayList<Object>();


		try {
			String rusult_select_file = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\result_yuce.txt";
			BufferedReader baa = new BufferedReader(new InputStreamReader(new FileInputStream(new File(rusult_select_file)), "UTF-8"));
			String line_save;
			while ((line_save = baa.readLine()) != null) {
				result_yuce.add(line_save);
				System.out.println(result_yuce);
			}
//			System.out.println(rusult_xunlian);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		};
		Map<String, Object> result = new HashMap();
		result.put("result_yuce", result_yuce);
		return ResponseData.ok(result);
	}

	//重新定义优化过程
	@GetMapping("/renameforecast_file")
	public ResponseData renameforecast_file() {
		try {
			System.out.println("ok");
			File writename = new File("E:\\桌面\\vue\\result_yuce.txt");
			writename.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			out.write(""+ "\r\n"); // \r\n为换行
			out.flush(); // 把缓存区内容压入文件
			out.close();
			System.out.println("重新定义预测过程成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	//保存模型选择
	@GetMapping("/model_select_forecast")
	public ResponseData model_select_forecast_save(String canshu11) {
		Map<String, Object> result = null;
		List<String> model_select_forecast_label = new ArrayList<>();
		try {
			System.out.println("ok");
			System.out.println(canshu11);
			File writename = new File("E:\\桌面\\vue\\Modle_select_forecast.txt");
			writename.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			out.write(canshu11 + "\r\n"); // \r\n为换行
			out.flush(); // 把缓存区内容压入文件
			out.close();
			System.out.println("预测模型选择成功！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 模型预测
	@RequestMapping("/forecast")
	public ResponseData Opt3()  throws JsonParseException, JsonMappingException, IOException   {



		//调用python
		List<String> forecast_label1 = new ArrayList<String>();
		try {
			System.out.println("start");
			//环境和main
			Process pr=Runtime.getRuntime().exec(args14);

			String errStr = consumeInputStream(pr.getErrorStream());
			String inStr = consumeInputStream(pr.getInputStream());
			// 标准错误流（必须写在 waitFor 之前）
			String errStra = consumeInputStream(pr.getErrorStream());
			int retCode = pr.waitFor();
			if(retCode == 0){
				System.out.println("程序正常执行结束");
			}
			System.out.println("end");
			forecast_label1.add("模型预测完成！");
//			forecast_label1.add("模型保存完成！");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		};
		List<String> forecast_label = new ArrayList<String>();
		forecast_label = forecast_label1;
		forecast_label.remove("");
		System.out.println(forecast_label);
		Map<String, Object> result = new HashMap();
		result.put("forecast_label", forecast_label);
		return ResponseData.ok(result);
	}

	// 获取预测结果
	@GetMapping("/list1")
	public ResponseData queryUsers() throws IOException {
		List<String> shibie_jh = new ArrayList<>();
		List<String> shibie_jh_s = new ArrayList<>();
		List<String> shibie_csrq = new ArrayList<>();
		List<String> shibie_csrq_s = new ArrayList<>();
		List<String> shibie_rusult = new ArrayList<>();
		List<String> shibie_bj = new ArrayList<>();
		List<String> shibie_jsdym = new ArrayList<>();
		List<String> shibie_jspl = new ArrayList<>();
		List<String> shibie_bs = new ArrayList<>();
		List<String> shibie_bx = new ArrayList<>();
		List<String> shibie_cmd = new ArrayList<>();
		List<String> shibie_cmcd = new ArrayList<>();
		List<String> shibie_hsl = new ArrayList<>();
		List<String> shibie_dyhd = new ArrayList<>();
		List<List<String>> shibie_jjg = new ArrayList<>();
		List<List<String>> shibie_yyb = new ArrayList<>();
		List<List<String>> shibie_aqq = new ArrayList<>();
		ArrayList<Object> total_list = new ArrayList<Object>();



		// 获取井号数据
		String forecast_jinghao_file = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\shibie_jh.txt";
		BufferedReader baa2 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(forecast_jinghao_file)), "UTF-8"));
		String line_save2;
		while ((line_save2 = baa2.readLine()) != null) {
			shibie_jh.add(line_save2);
		}
		System.out.println(shibie_jh);

		// 获取测试日期数据
		String forecast_testday_file = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\shibie_csrq.txt";
		BufferedReader baa3 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(forecast_testday_file)), "UTF-8"));
		String line_save3;
		while ((line_save3 = baa3.readLine()) != null) {
			shibie_csrq.add(line_save3);
		}
		System.out.println(shibie_csrq);

		String forecast_result_file = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\shibie_result_.txt";
		BufferedReader baa1 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(forecast_result_file)), "UTF-8"));
		String line_save1;
		while ((line_save1 = baa1.readLine()) != null) {
			shibie_rusult.add(line_save1);
		}
		System.out.println(shibie_rusult);

		// 加载动液面数据
		String dongyemian_result_file = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\shibie_jsdym.txt";
		BufferedReader baa4 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(dongyemian_result_file)), "UTF-8"));
		String line_save4;
		while ((line_save4 = baa4.readLine()) != null) {
			shibie_jsdym.add(line_save4);
		}
		System.out.println(shibie_jsdym);

		// 加载产液量数据
		String chanyeliang_result_file = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\shibie_jspl.txt";
		BufferedReader baa5 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(chanyeliang_result_file)), "UTF-8"));
		String line_save5;
		while ((line_save5 = baa5.readLine()) != null) {
			shibie_jspl.add(line_save5);
		}
		System.out.println(shibie_jspl);

		String forecast_result_file1 = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\shibie_bj.txt";
		BufferedReader baa6 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(forecast_result_file1)), "UTF-8"));
		String line_save6;
		while ((line_save6 = baa6.readLine()) != null) {
			shibie_bj.add(line_save6);
		}
		System.out.println(shibie_bj);

		String forecast_result_file2 = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\shibie_bs.txt";
		BufferedReader baa7 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(forecast_result_file2)), "UTF-8"));
		String line_save7;
		while ((line_save7 = baa7.readLine()) != null) {
			shibie_bs.add(line_save7);
		}
		System.out.println(shibie_bs);

		String forecast_result_file3 = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\shibie_bx.txt";
		BufferedReader baa8 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(forecast_result_file3)), "UTF-8"));
		String line_save8;
		while ((line_save8 = baa8.readLine()) != null) {
			shibie_bx.add(line_save8);
		}
		System.out.println(shibie_bx);

		String forecast_result_file4 = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\shibie_cmd.txt";
		BufferedReader baa9 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(forecast_result_file4)), "UTF-8"));
		String line_save9;
		while ((line_save9 = baa9.readLine()) != null) {
			shibie_cmd.add(line_save9);
		}
		System.out.println(shibie_cmd);

		String forecast_result_file5 = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\shibie_cmcd.txt";
		BufferedReader baa10 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(forecast_result_file5)), "UTF-8"));
		String line_save10;
		while ((line_save10 = baa10.readLine()) != null) {
			shibie_cmcd.add(line_save10);
		}
		System.out.println(shibie_cmcd);

		String forecast_result_file6 = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\shibie_hsl.txt";
		BufferedReader baa11 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(forecast_result_file6)), "UTF-8"));
		String line_save11;
		while ((line_save11 = baa11.readLine()) != null) {
			shibie_hsl.add(line_save11);
		}
		System.out.println(shibie_hsl);

		String forecast_result_file7 = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\shibie_dyhd.txt";
		BufferedReader baa12 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(forecast_result_file7)), "UTF-8"));
		String line_save12;
		while ((line_save12 = baa12.readLine()) != null) {
			shibie_dyhd.add(line_save12);
		}
		System.out.println(shibie_dyhd);

		for (int i = 0; i < shibie_jh.size(); i = i + 1) {
			String aa,bb,cc,dd;
			List<String> acas = new ArrayList<>();
			List<String> acas1 = new ArrayList<>();
			List<String> acas2 = new ArrayList<>();
			aa = shibie_jh.get(i);
			cc = shibie_csrq.get(i);
			bb = cc.replace(' ', '-');
			dd = bb.replace(':', '-');
			String forecast_result_file8 = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\shibie_jjg+"+aa+'+'+dd+"+.txt";
			BufferedReader baa13 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(forecast_result_file8)), "UTF-8"));
			String line_save13;
			while ((line_save13 = baa13.readLine()) != null) {
				acas.add(line_save13);
			}
			shibie_jjg.add(acas);

			String forecast_result_file9 = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\shibie_yyb+"+aa+'+'+dd+"+.txt";
			BufferedReader baa14 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(forecast_result_file9)), "UTF-8"));
			String line_save14;
			while ((line_save14 = baa14.readLine()) != null) {
				acas1.add(line_save14);
			}
			shibie_yyb.add(acas1);

			String forecast_result_file10 = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\shibie_aqq+"+aa+'+'+dd+"+.txt";
			BufferedReader baa15 = new BufferedReader(new InputStreamReader(new FileInputStream(new File(forecast_result_file10)), "UTF-8"));
			String line_save15;
			while ((line_save15 = baa15.readLine()) != null) {
				acas2.add(line_save15);
			}
			shibie_aqq.add(acas2);
		}

		//井号筛选
		for (int i = 0; i < shibie_jh.size(); i = i + 1) {
			if( ! shibie_jh_s.contains(shibie_jh.get(i))){
				shibie_jh_s.add(shibie_jh.get(i));
			}
		}
		System.out.println(shibie_jh_s);

		//测试时间筛选
		for (int i = 0; i < shibie_csrq.size(); i = i + 1) {
			if( ! shibie_csrq_s.contains(shibie_csrq.get(i))){
				shibie_csrq_s.add(shibie_csrq.get(i));
			}
		}
		System.out.println(shibie_csrq_s);

		total_list.add(shibie_jh);
		total_list.add(shibie_csrq);
		total_list.add(shibie_rusult);
		total_list.add(shibie_jsdym);
		total_list.add(shibie_jspl);
		total_list.add(shibie_bj);
		total_list.add(shibie_bs);
		total_list.add(shibie_bx);
		total_list.add(shibie_cmd);
		total_list.add(shibie_cmcd);
		total_list.add(shibie_hsl);
		total_list.add(shibie_dyhd);
		total_list.add(shibie_jh_s);
		total_list.add(shibie_csrq_s);
		total_list.add(shibie_jjg);
		total_list.add(shibie_yyb);
		total_list.add(shibie_aqq);


		Map<String, Object> result = new HashMap ();
		result.put("total_list", total_list);
		System.out.println(total_list);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResponseData.ok(result);
	}

	// 获取示功图数据
	@GetMapping("/cumputes7")
	public ResponseData jisuan7 (String canshu7, String canshu13) throws IOException {
		System.out.println(canshu7);
		List<Object> shigongtu_chongcheng = new ArrayList<Object>();
		List<Object> shigongtu_zhaihe = new ArrayList<Object>();
		ArrayList<Object> shigongtu = new ArrayList<Object>();


		try {
			System.out.println(canshu7);
			String aa;
			String bb;
			bb = canshu13.replace(' ', '-');
			aa = bb.replace(':', '-');
			System.out.println(aa);
			// 获取示功图冲程数据
			Scanner scanners7 = new Scanner(new FileInputStream(PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\"+canshu7+'+'+aa+"+cc.txt"),"utf-8") ;
			scanners7.next();scanners7.next();
			String itemname7 = scanners7.next();
			//从数据库获取数据
			String shigongtu_chongcheng_file = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\"+canshu7+'+'+aa+"+cc.txt";
			Scanner scanner7 = new Scanner(new FileInputStream(shigongtu_chongcheng_file),"utf-8") ;
			while(scanner7.hasNext()){
				shigongtu_chongcheng.add(Double.parseDouble(scanner7.next()) );
			}
			System.out.println(shigongtu_chongcheng);

			System.out.println(canshu13);
			// 获取示功图悬点载荷数据
			Scanner scanners8 = new Scanner(new FileInputStream(PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\"+canshu7+'+'+aa+"+zh.txt"),"utf-8") ;
			scanners8.next();scanners8.next();
			String itemname8 = scanners8.next();
			//从数据库获取数据
			String shigongtu_zhaihe_file = PATH + "\\TeZzhengshibie_ShiGongTuzhengdaun\\"+canshu7+'+'+aa+"+zh.txt";
			Scanner scanner8 = new Scanner(new FileInputStream(shigongtu_zhaihe_file),"utf-8") ;
			while(scanner8.hasNext()){
				shigongtu_zhaihe.add(Double.parseDouble(scanner8.next()) );
			}
			System.out.println(shigongtu_zhaihe);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		};
		int b = shigongtu_chongcheng.size();
		for (int i = 0; i < b; i = i + 1) {
			List<Object> shigongtu1 = new ArrayList<Object>();
			shigongtu1.add(shigongtu_chongcheng.get(i));
			shigongtu1.add(shigongtu_zhaihe.get(i));
			shigongtu.add(shigongtu1);
		}

		System.out.println(shigongtu);
		Map<String, Object> result = new HashMap();
		result.put("shigongtu", shigongtu);
		return ResponseData.ok(result);

	}



}

