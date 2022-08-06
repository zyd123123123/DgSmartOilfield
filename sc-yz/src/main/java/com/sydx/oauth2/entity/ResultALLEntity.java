package com.sydx.oauth2.entity;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author zyd
 * @create 2022-07-01-21:18
 */
@Data
public class ResultALLEntity {
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
}
