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

public class InstructionMemory {
    MainUI mainui;
    
    String[] instructions = new String[100];

    String[] binaryInstructions = new String[100];
    
    public InstructionMemory(MainUI mainui){
        for (int i = 0; i < 100; i++) {
	    instructions[i] = "0";
	    binaryInstructions[i] = "0000 0000 0000 0000 0000 0000 0000 0000";
        }
        mainui.setInstructionMemoryWindow(instructions, binaryInstructions);
    }
}

