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
public class ControlPanel implements Runnable {
    MainUI GUI = new MainUI(this);
    InstructionMemory imw;
    DataMemory dmw;
    Register reg;
    public ControlPanel(){
        imw = new InstructionMemory(GUI);
        dmw = new DataMemory(GUI);
        reg = new Register(GUI);
        GUI.setVisible(true);
    }

    @Override
    public void run() {
        
    }
}
