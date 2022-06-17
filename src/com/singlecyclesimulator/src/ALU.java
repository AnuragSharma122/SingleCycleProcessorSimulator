/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.singlecyclesimulator.src;

/**
 *
 * @author Anurag
 */
public class ALU {
    public  int add(int op1, int op2){
        return op1+op2;
    }
    public static int sub(int op1, int op2){
        return op1-op2;
    }
    public static int and(int op1, int op2){
        return op1&op2;
    }
    public static int or(int op1, int op2){
        return op1|op2;
    }
    public static int xor(int op1, int op2){
        return op1^op2;
    }
    public static int nor(int op1, int op2){
        return op1+op2;
    }
    public static int mul(int op1, int op2){
        return op1*op2;
    }
    public static int div(int op1, int op2){
        return op1/op2;
    }

}
