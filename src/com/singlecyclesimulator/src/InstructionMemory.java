/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.singlecyclesimulator.src;
import com.singlecyclesimulator.utilities.Utilities;
import com.singlecyclesimulator.viewComponent.MainUI;
/**
 *
 * @author Anurag
 */

public class InstructionMemory {
    MainUI mainui;
    
    String[] instructions;
    String[] binaryInstructions;
    
    public InstructionMemory(MainUI mainui){
        this.mainui = mainui;
        instructions = new String[100];
        binaryInstructions = new String[100];
    }
    void store(int k, String data){
      instructions[k] = data;
      binaryInstructions[k] = Utilities.InstructionToBinaryConverter(data);
        try {
            mainui.updateInstructionMemoryWindow(instructions, binaryInstructions);
        }
	catch(NullPointerException e) {
	    System.out.println("NullPointerException thrown!");
	}
    }
    public String load(int i){
        return binaryInstructions[i];
    }
}

