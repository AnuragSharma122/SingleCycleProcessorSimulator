/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.singlecyclesimulator.src;
import com.singlecyclesimulator.viewComponent.MainUI;
import java.util.ArrayList;
import java.util.Scanner;
import com.singlecyclesimulator.utilities.Utilities;
/**
 *
 * @author Anurag
 */
public class ControlPanel implements Runnable {
    
    InstructionMemory imw;
    DataMemory dmw;
    Register reg;
    ALU alu;
    MainUI GUI = new MainUI(this);
    int PC;
    String currentInstruction;
    String opcode ="";
    String regS = "";
    String regT = "";
    String regD = "";
    String shamt = "";
    String func = "";
    String imm = "";
    int result;
    int targetRegIndex = 0;
    public boolean runFlag = false;
    boolean willWrite = false;
    boolean stepFlag = false;
    public int instructionTotal;
    
    public ControlPanel(){
        GUI.setVisible(true);
        imw = new InstructionMemory(GUI);
        dmw = new DataMemory(GUI);
        reg = new Register(GUI);
        alu = new ALU();
        PC = 0;
    }
    public void loadcode(ArrayList<String> inputData){
        int i=0;
        for(String s:inputData){
            if(s.equals("")){
                imw.store(i, "0");
                i++;
                continue;
            }
            imw.store(i, s);
            i++;
            instructionTotal++;
        }
    }
    @Override
    public void run() {
        while(true){
            while(!runFlag && !stepFlag){
                synchronized(this) {
                    try {
			System.out.println("Waiting...");
			this.wait();
		    } catch (InterruptedException e) {
                        System.out.println("InterruptedException");
                    }
                }
            }
//            reg.store(4, 42);
//              System.out.println(reg.load(10));
            fetch();
            decode();
            execute();
            memory();
            writeback();
            if (stepFlag) {
		stepFlag = false;
            } else { delay();}
//            else { delay();}
        }
        
    }
    //method for fetch stage
    public void fetch(){
        System.out.println("Step 1. Fetch");
        currentInstruction = imw.load(PC);
        System.out.println("currentInstruction = "+currentInstruction);
        GUI.highlightPC(PC);
    }
    public void decode(){
        System.out.println("Step 2. Decode");
        Scanner sc;
        sc = new Scanner(currentInstruction);
        opcode = sc.next();
        switch(opcode){
            case "000000":
                regS = sc.next();
                regT = sc.next();
                regD = sc.next();
                shamt = sc.next();
                func = sc.next();
                break;
            case "000010":
                imm = sc.next();
                break;
            default:
                regS = sc.next();
                regT = sc.next();
                imm = sc.next();
        }
    }
    public void execute(){
        System.out.println("Step 3. Execute");
        int val1;
        int val2;
        if(opcode.equals("000000")){
            regS = Utilities.AddressToRegister(regS);
            regT = Utilities.AddressToRegister(regT);
            regD = Utilities.AddressToRegister(regD);
            
            switch(func){
                case "100000":
                    //Add
                    val1 = reg.load(Utilities.registerToInt(regS)+1);
                    val2 = reg.load(Utilities.registerToInt(regT)+1);
                    targetRegIndex = Utilities.registerToInt(regD);
                    result = alu.add(val1,val2);
//                    System.out.println(val1 +" "+ val2+" "+val3);
//                    reg.store(val3,val1+val2);
                    break;
                case "100100":
                    //And
                    val1 = reg.load(Utilities.registerToInt(regS)+1);
                    val2 = reg.load(Utilities.registerToInt(regT)+1);
                    targetRegIndex = Utilities.registerToInt(regD);
                    result = ALU.and(val1,val2);
                    break;
                case "100101":
                    //Or
                    val1 = reg.load(Utilities.registerToInt(regS)+1);
                    val2 = reg.load(Utilities.registerToInt(regT)+1);
                    targetRegIndex = Utilities.registerToInt(regD);
                    result = ALU.or(val1,val2);
                    break;
                case "100010":
                    //sub
                    val1 = reg.load(Utilities.registerToInt(regS)+1);
                    val2 = reg.load(Utilities.registerToInt(regT)+1);
                    targetRegIndex = Utilities.registerToInt(regD);
                    result = ALU.sub(val1,val2);
                    break;
            }
        }else{
            switch(opcode){
                case "001000":
                    //addi
                    regS = Utilities.AddressToRegister(regS);
                    regT = Utilities.AddressToRegister(regT);
                    val1 = reg.load(Utilities.registerToInt(regS)+1);
                    val2 = Integer.parseInt(imm,2);
                    targetRegIndex = Utilities.registerToInt(regT);
                    result = alu.add(val1, val2);
                    break;
                    
                case "001100":
                    //andi
                    regS = Utilities.AddressToRegister(regS);
                    regT = Utilities.AddressToRegister(regT);
                    val1 = reg.load(Utilities.registerToInt(regS)+1);
                    val2 = Integer.parseInt(imm,2);
                    targetRegIndex = Utilities.registerToInt(regT);
                    result = ALU.and(val1, val2);
                    break;
                case "001101":
                    //ori
                    regS = Utilities.AddressToRegister(regS);
                    regT = Utilities.AddressToRegister(regT);
                    val1 = reg.load(Utilities.registerToInt(regS)+1);
                    val2 = Integer.parseInt(imm,2);
                    targetRegIndex = Utilities.registerToInt(regT);
                    result = ALU.or(val1, val2);
                    break;
            }
        }
    }
    public void memory(){
        if(opcode.equals("100011")){
            
        }else if(opcode.equals("101011")){
            
        }
    }
    public void writeback(){
        reg.store(targetRegIndex, result);
        PC++;
        if (PC == instructionTotal) {
            runFlag = false;
	}
    }
    void delay() {
	try {
            Thread.sleep((long) (1000 * 5));
        } catch (InterruptedException e) {
        }
    }
    public synchronized void operation(String option) {
	if(option.equals("Start Execution")){
            System.out.println("Starting Exectuion");
            runFlag = true;
        }else if (option.equals("Resume")) {
	    runFlag = true;
            System.out.println("Resuming Exectuion");	
	} else if (option.equals("Pause")) {
            runFlag = false;
            System.out.println("Pausing Exectuion");	
	} else if (option.equals("Step")) {
            stepFlag = true;
            System.out.println("Stepping through Exectuion");	
	}
	
	synchronized(this) {
            this.notifyAll();
	}
    }
    
//    public float getDelay() {		
//	return cp.getDelay();
//    }
}
