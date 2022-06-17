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
    int[] regsValue;
    String[] regsValueBinary;
    public Register(MainUI GUI){
        this.GUI = GUI;
        regsValue = new int[100];
        regsValueBinary = new String[100];
    }
    public void store(int i, int val){
        System.out.println(i+" "+val);
        try{
            regsValue[i] = val;
            regsValueBinary[i] = Integer.toBinaryString(val);
            while(regsValueBinary[i].length() < 32){
                regsValueBinary[i] = "0"+regsValueBinary[i];
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Array index out of bounds");
        }
        
        //update table
        GUI.updateRegisterWindow(regsValue, regsValueBinary);
    }
    public int load(int i){
        return regsValue[i];
    }
}
