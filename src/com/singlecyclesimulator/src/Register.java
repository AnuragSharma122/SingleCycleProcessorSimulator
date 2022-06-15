/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.singlecyclesimulator.src;
import com.singlecyclesimulator.viewComponent.MainUI;
/**
 *
 * @author Anurag
 */
public class Register {
    MainUI GUI;
    String[] regs;
    String[] regsBinary;
    String[] regsValue = new String[100];
    String[] regsValueBinary = new String[100];
    public Register(MainUI GUI){
        this.regs = new String[]{"$zero", "$at", "$v0", "$v1", "$a0", "$a1", "$a2", "$a3", "$t0","$t1"
                                 ,"$t2" ,"$t3" ,"$t4","$t5" ,"$t6","$t7" ,"$s0" ,"$s1" ,"$s2" ,"$s3" ,"$s4"
                                 ,"$s5" ,"$s6" ,"$s7" ,"$t8" ,"$t9" ,"$k0" ,"$k1" ,"$gp" ,"$sp" ,"$fp" ,"$ra"};
        this.regsBinary = new String[]{"00000","00001","00010","00011","00100","00101","00110","00111","01000","01001","01010","01011",
                                       "01100","01101","01110","01111","10000","10001","10010","10011","10100","10101","10110","10111","11000",
                                       "11001","11010","11011","11100","11101","11110","11111",};
        for(int i=0; i<32;i++){
            regsValue[i] = "0";
            regsValueBinary[i] = "0000 0000 0000 0000 0000 0000 0000 0000";
        }
        GUI.setRegisterWindow(regsBinary,regs,regsValue,regsValueBinary);
    }
}
