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
public class DataMemory {
    MainUI mainui;
    String[] memoryValue = new String[100];
    public DataMemory(MainUI mainui){
        for(int i=0; i<100;i++){
            memoryValue[i] = "0000 0000 0000 0000 0000 0000 0000 0000";
        }
        mainui.setMemoryWindow(memoryValue);
    }
}
