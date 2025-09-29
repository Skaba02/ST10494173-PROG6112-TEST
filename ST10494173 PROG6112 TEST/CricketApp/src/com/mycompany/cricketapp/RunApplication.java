/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cricketapp;

import java.util.Scanner;

public class RunApplication {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ask for input
        System.out.print("The cricketer name: ");
        String name = input.nextLine();

        System.out.print("Enter the stadium: ");
        String stadium = input.nextLine();

        System.out.print("Enter the total runs scored by " + name + " at " + stadium + ": ");
        int runs = input.nextInt();

        // Create object
        CricketRunsScored record = new CricketRunsScored(name, stadium, runs);

        // Print report
        record.printReport();
    }
}
