package com.sydx.aqsc.ctrl;

/**
 * @author zyd
 * @create 2022-05-04-9:34
 */

import com.sydx.aqsc.entity.znjs.OptResult;
import com.sydx.aqsc.entity.znjs.WellVo;
import com.sydx.aqsc.util.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

@RestController
@RequestMapping("/user_zyd")
public class  ShowResultController{
    String PATH="D:\\ideaproject\\课题组项目备用\\";
    @GetMapping("/opt")
    public ResponseData queryOpt(Integer wellNumber,Integer timeSteps) throws FileNotFoundException {

        System.out.println("optget成功");
        System.out.println(wellNumber+" "+timeSteps);
        List<WellVo> users = new ArrayList<WellVo>();
        Map<String, Object> result = new HashMap<>();
//        Scanner scanners = new Scanner(new FileInputStream(PATH+"well1.txt"),"GBK") ;
        try {
            Scanner sc = new Scanner(new FileInputStream(PATH+"well1.txt"),"GBK") ;
            for (int i=1;i<=wellNumber;i++){
                for (int j=1;j<=timeSteps;j++){
                    users.add(new WellVo(i,"井"+i,sc.nextLine(),"timestep"+j));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        result.put("list", users);
        result.put("total", 19);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return ResponseData.ok(result);
    }
    @GetMapping("/opt_all")
    public ResponseData queryOpt_ALL() throws FileNotFoundException {

        String PATH="D:\\ideaproject\\课题组项目备用\\";
        String PATH1="D:\\eclexmple\\PROD_compare\\PROD_compare\\";

        List<OptResult> users = new ArrayList<>();
        Map<String, Object> result = new HashMap<>();
        try {
            Scanner scanners = new Scanner(new FileInputStream(PATH1+"PROD.RSM"),"GBK") ;
            for (int i = 0; i <2; i++) {
                scanners.nextLine();
            }
            String order=scanners.nextLine();
            String[] orders=order.trim().split("\\t");
            ArrayList<String> orderList = new ArrayList<>();
            for (String s:orders) {
                orderList.add(s.trim());
            }
            scanners.nextLine();
            scanners.nextLine();
            scanners.nextLine();
            while (scanners.hasNextLine()){
                String[] res=scanners.nextLine().trim().split("\\t");
                for (int i=0;i<res.length;i++) {
                    res[i]=res[i].trim();
                }
                Integer TIME = Math.round(Float.valueOf(res[0])) ;
                Integer YEARS = Math.round(Float.valueOf(res[1])) ;
                int indexFOPT=0;
                int indexFWIT=0;
                int indexFWPT=0;
                int indexFWIR=0;
                int indexFOPR=0;
                int indexFWPR=0;
                int indexFWCT=0;
                int indexFPR=0;
                for (int i=0;i<orderList.size();i++){

                    if (orderList.get(i).equals("FOPT") ){  indexFOPT=i; }
                    if (orderList.get(i).equals("FWIT") ){  indexFWIT=i; }
                    if (orderList.get(i).equals("FWPT") ){  indexFWPT=i; }
                    if (orderList.get(i).equals("FWIR") ){  indexFWIR=i; }
                    if (orderList.get(i).equals("FOPR") ){  indexFOPR=i; }
                    if (orderList.get(i).equals("FWPR") ){  indexFWPR=i; }
                    if (orderList.get(i).equals("FWCT") ){  indexFWCT=i; }
                    if (orderList.get(i).equals("FPR") ){   indexFPR= i ; }
                }
                Float FOPT = Float.valueOf(res[indexFOPT]);
                Float FWIT = Float.valueOf(res[indexFWIT]);
                Float FWPT = Float.valueOf(res[indexFWPT]);
                Float FWIR = Float.valueOf(res[indexFWIR]);
                Float FOPR = Float.valueOf(res[indexFOPR]);
                Float FWPR = Float.valueOf(res[indexFWPR]);
                Float FWCT = Float.valueOf(res[indexFWCT]);
                Float FPR =  Float.valueOf(res[indexFPR]);
                OptResult optResult = new OptResult(TIME,YEARS,FOPT,FWIT,FWPT,FWIR,FOPR,FWPR,FWCT,FPR);
                users.add(optResult);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<Integer> TIME = new ArrayList<>();
        ArrayList<Integer> YEARS = new ArrayList<>();
        ArrayList<Float>   FOPT = new ArrayList<>();
        ArrayList<Float>   FWIT = new ArrayList<>();
        ArrayList<Float>   FWPT = new ArrayList<>();
        ArrayList<Float>   FWIR = new ArrayList<>();
        ArrayList<Float>   FOPR = new ArrayList<>();
        ArrayList<Float>   FWPR = new ArrayList<>();
        ArrayList<Float>   FWCT = new ArrayList<>();
        ArrayList<Float>   FPR  = new ArrayList<>();
        for (OptResult opt:users) {
            TIME.add(opt.getTIME());
            YEARS.add(opt.getYEARS());
            FOPT.add(opt.getFOPT());
            FWIT.add(opt.getFWIT());
            FWPT.add(opt.getFWPT());
            FWIR.add(opt.getFWIR());
            FOPR.add(opt.getFOPR());
            FWPR.add(opt.getFWPR());
            FWCT.add(opt.getFWCT());
            FPR .add(opt.getFPR());
        }
        result.put("TIME", TIME);
        result.put("YEARS",YEARS);
        result.put("FOPT", FOPT);
        result.put("FWIT", FWIT);
        result.put("FWPT", FWPT);
        result.put("FWIR", FWIR);
        result.put("FOPR", FOPR);
        result.put("FWPR", FWPR);
        result.put("FWCT", FWCT);
        result.put("FPR", FPR );
        result.put("total", 19);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("进入all方法");
        return ResponseData.ok(result);
    }


}
