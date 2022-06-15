/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.singlecyclesimulator.src;

/**
 *
 * @author Anurag
 */
public class Main {
    public static void main(String[] args){
        
        ControlPanel processor = new ControlPanel();
        Thread thread = new Thread(processor);
        thread.run();
    }
}
