/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.singlecyclesimulator.utilities;

import java.util.Scanner;

/**
 *
 * @author Anurag
 */
public class Utilities {
    static public enum registerNames {
		$zero, $at, $v0, $v1, $a0, $a1, $a2, $13, $t0, $t1, $t2,
		$t3, $t4, $t5, $t6, $t7, $s0, $s1, $s2, $s3, $s4, $s5, $s6,
		$s7, $t8, $t9, $k0, $k1, $gp, $sp, $fp, $ra}
    
    public static String InstructionToBinaryConverter(String instruction){
        instruction = instruction.replace(",", "");
        instruction = instruction.replace("(", " ");
        instruction = instruction.replace(")", "");
        instruction = instruction.replace(";", "");
        String op = "";
        String rs = "";
        String rt = "";
        String rd = "";
        String shamt = "";
        String funct = "";
        String imm = "";
        String iType = "";
        
        try (Scanner sc = new Scanner(instruction)) {
            switch(sc.next()){
                case "add":
                    iType = "R";
                    op = "000000";
                    rd = RegisterToAddress(sc.next());
                    rs = RegisterToAddress(sc.next());
                    rt = RegisterToAddress(sc.next());
                    shamt = "00000";
                    funct = "100000";
                    break;
                case("addi"):
                    iType = "I";
                    op = "001000";
                    rt = RegisterToAddress(sc.next());
                    rs = RegisterToAddress(sc.next());
                    imm = Integer.toBinaryString(sc.nextInt());
                    while(imm.length()<16){
                        imm = "0"+ imm;
                    }
                    break;
                    
                case("and"):
                    iType = "R";
                    op = "000000";
                    rd = RegisterToAddress(sc.next());
                    rs = RegisterToAddress(sc.next());
                    rt = RegisterToAddress(sc.next());
                    shamt = "00000";
                    funct = "100100";
                    break;
                    
                case("andi"):
                    iType = "I";
                    op = "001100";
                    rt = RegisterToAddress(sc.next());
                    rs = RegisterToAddress(sc.next());
                    imm = Integer.toBinaryString(sc.nextInt());
                    while(imm.length()<16){
                        imm = "0"+ imm;
                    }
                    break;
                    
                case("or"):
                    iType = "R";
                    op = "000000";
                    rd = RegisterToAddress(sc.next());
                    rs = RegisterToAddress(sc.next());
                    rt = RegisterToAddress(sc.next());
                    shamt = "00000";
                    funct = "100101";
                    break;
                    
                case("ori"):
                    iType = "I";
                    op = "001101";
                    rd = RegisterToAddress(sc.next());
                    rs = RegisterToAddress(sc.next());
                    imm = Integer.toBinaryString(sc.nextInt());
                    while(imm.length()<16){
                        imm = "0"+ imm;
                    }
                    break;
                    
                case("sub"):
                    iType = "R";
                    op = "000000";
                    rd = RegisterToAddress(sc.next());
                    rs = RegisterToAddress(sc.next());
                    rt = RegisterToAddress(sc.next());
                    shamt = "00000";
                    funct = "100010";
                    break;
                    
                case("lw"):
                    iType = "lw";
                    op = "010011";
                    rt = RegisterToAddress(sc.next());
                    imm = Integer.toBinaryString(sc.nextInt());
                    rs = RegisterToAddress(sc.next());
                    
                    while(imm.length()<16){
                        imm = "0"+ imm;
                    }
                    break;
                    
                case("sw"):
                    iType = "sw";
                    op = "101011";
                    rs = RegisterToAddress(sc.next());
                    imm = Integer.toBinaryString(sc.nextInt());
                    rt = RegisterToAddress(sc.next());
                    
                    while(imm.length()<16){
                        imm = "0"+ imm;
                    }
                    break;
                    
                case("j"):
                    iType = "J";
                    op = "000010";
                    imm = Integer.toBinaryString(sc.nextInt());
                    while(imm.length()<26){
                        imm = "0"+ imm;
                    }
                    break;
                    
                case("beq"):
                    iType = "I";
                    op = "000100";
                    rt = RegisterToAddress(sc.next());
                    rs = RegisterToAddress(sc.next());
                    imm = Integer.toBinaryString(sc.nextInt());
                    while(imm.length()<16){
                        imm = "0"+ imm;
                    }
                    break;
                    
//                case("mul"):
//                    iType = "R";
//                    op = "011100";
//                    funct = "000010";
//                    rd = RegisterToAddress(sc.next());
//                    rs = RegisterToAddress(sc.next());
//                    rt = RegisterToAddress(sc.next());
//                    break;
            }
        }catch(Exception e){
            System.out.println("Check Syntax");
        }
        switch (iType) {
            case "R":
                return op+" "+rs+" "+rt+" "+rd+" "+shamt+" "+funct;
            case "I":
                return op+" "+rs+" "+rt+" "+imm;
            case "J":
                return op+" "+imm;
            case "lw":
                return op+" "+rs+" "+rt+" "+imm;
            case "sw":
                return op+" "+rs+" "+rt+" "+imm;
            default:
                return op+" "+rs+" "+rt+" "+rd+" "+shamt+" "+funct;
        }
        
    }
    public static String RegisterToAddress(String Register){
        switch(Register){
        case( "$zero"):
			Register = "00000";
			break;
		case("$at"):
			Register = "00001";
			break;
		case("$v0"):
			Register = "00010";
			break;
		case("$v1"):
			Register = "00011";
			break;
		case("$a0"):
			Register = "00100";
			break;
		case("$a1"):
			Register = "00101";
			break;
		case("$a2"):
			Register = "00110";
			break;
		case("$a3"):
			Register = "00111";
			break;
		case("$t0"):
			Register = "01000";
			break;
		case("$t1"):
			Register = "01001";
			break;
		case("$t2"):
			Register = "01010";
			break;
		case("$t3"):
			Register = "01011";
			break;
		case("$t4"):
			Register = "01100";
			break;
		case("$t5"):
			Register = "01101";
			break;
		case("$t6"):
			Register = "01110";
			break;
		case("$t7"):
			Register = "01111";
			break;
		case("$s0"):
			Register = "10000";
			break;		
		case("$s1"):
			Register = "10001";
			break;
		case("$s2"):
			Register = "10010";
			break;
		case("$s3"):
			Register = "10011";
			break;
		case("$s4"):
			Register = "10100";
			break;
		case("$s5"):
			Register = "10101";
			break;
		case("$s6"):
			Register = "10110";
			break;
		case("$s7"):
			Register = "10111";
			break;
		case("$t8"):
			Register = "11000";
			break;
		case("$t9"):
			Register = "11001";
			break;
		case("$k0"):
			Register = "11010";
			break;
		case("$k1"):
			Register = "11011";
			break;
		case("$gp"):
			Register = "11100";
			break;
		case("$sp"):
			Register = "11101";
			break;
		case("$fp"):
			Register = "11110";
			break;
		case("$ra"):
			Register = "11111";
			break;
		}
    return Register;
    }
    
    public static String AddressToRegister(String Register){
        switch(Register){
        case("00000"):
			Register = "$zero";
			break;
		case("00001"):
			Register = "$at" ;
			break;
		case( "00010"):
			Register = "$v0";
			break;
		case("00011"):
			Register = "$v1";
			break;
		case("00100"):
			Register = "$a0";
			break;
		case("00101"):
			Register = "$a1";
			break;
		case("00110"):
			Register = "$a2";
			break;
		case("00111"):
			Register = "$a3";
			break;
		case("01000"):
			Register = "$t0";
			break;
		case("01001"):
			Register = "$t1";
			break;
		case("01010"):
			Register = "$t2";
			break;
		case("01011"):
			Register = "$t3";
			break;
		case("01100"):
			Register = "$t4";
			break;
		case("01101"):
			Register = "$t5";
			break;
		case("01110"):
			Register = "$t6";
			break;
		case("01111"):
			Register = "$t7";
			break;
		case("10000"):
			Register = "$s0";
			break;		
		case("10001"):
			Register = "$s1";
			break;
		case("10010"):
			Register = "$s2";
			break;
		case("10011"):
			Register = "$s3";
			break;
		case("10100"):
			Register = "$s4";
			break;
		case("10101"):
			Register = "$s5";
			break;
		case("10110"):
			Register = "$s6";
			break;
		case("10111"):
			Register = "$s7";
			break;
		case("11000"):
			Register = "$t8";
			break;
		case("11001"):
			Register = "$t9";
			break;
		case("11010"):
			Register = "$k0";
			break;
		case("11011"):
			Register = "$k1";
			break;
		case("11100"):
			Register = "$gp";
			break;
		case("11101"):
			Register = "$sp";
			break;
		case("11110"):
			Register = "$fp";
			break;
		case("11111"):
			Register = "$ra";
			break;
		}
    return Register;
    }
    
    public static int registerToInt(String reg){
        switch(reg) {
			case "$zero":
				return 0;
			case "$at":
				return 1;
			case "$v0":
				return 2;
			case "$v1":
				return 3;
			case "$a0":
				return 4;
			case "$a1":
				return 5;
			case "$a2":
				return 6;
			case "$a3":
				return 7;	
			case "$t0":
				return 8;
			case "$t1":
				return 9;
			case "$t2":
				return 10;
			case "$t3":
				return 11;	
			case "$t4":
				return 12;
			case "$t5":
				return 13;
			case "$t6":
				return 14;
			case "$t7":
				return 15;	
			case "$s0":
				return 16;
			case "$s1":
				return 17;
			case "$s2":
				return 18;
			case "$s3":
				return 19;	
			case "$s4":
				return 20;
			case "$s5":
				return 21;
			case "$s6":
				return 22;
			case "$s7":
				return 23;	
			case "$t8":
				return 24;
			case "$t9":
				return 25;
			case "$k0":
				return 26;
			case "$k1":
				return 27;
			case "$gp":
				return 28;
			case "$sp":
				return 29;
			case "$fp":
				return 30;
			case "$ra":
				return 31;	
		}
		return -1;
    }
    
}
