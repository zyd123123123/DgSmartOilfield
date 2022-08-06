package com.sydx.aqsc.test;

import com.sydx.aqsc.entity.znjs.OptResult;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author zyd
 * @create 2022-05-11-9:36
 */
public class Test2 {
    public static void main(String[] args) {
        String PATH="D:\\ideaproject\\课题组项目备用\\model";
        List<OptResult> users = new ArrayList<>();
        Map<String, Object> result = new HashMap<>();
        try {
            Scanner scanners = new Scanner(new FileInputStream(PATH+"1.RSM"),"GBK") ;
            for (int i = 0; i <2; i++) {
                scanners.nextLine();
            }
            String order=scanners.nextLine();
            String[] orders=order.trim().split("\\t");
            ArrayList<String> orderList = new ArrayList<>();
            for (String s:orderList) {
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
                    if (orderList.get(i)=="FOPT") {  indexFOPT=i; }
                    if (orderList.get(i)=="FWIT") {  indexFWIT=i; }
                    if (orderList.get(i)=="FWPT") {  indexFWPT=i; }
                    if (orderList.get(i)=="FWIR") {  indexFWIR=i; }
                    if (orderList.get(i)=="FOPR") {  indexFOPR=i; }
                    if (orderList.get(i)=="FWPR") {  indexFWPR=i; }
                    if (orderList.get(i)=="FWCT") {  indexFWCT=i; }
                    if (orderList.get(i)=="FPR") {   indexFPR= i ; }
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
        result.put("FPR ", FPR );
        result.put("total", 19);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
