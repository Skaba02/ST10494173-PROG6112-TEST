/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.runsreport;

import java.io.FileWriter;
import java.io.IOException;

public class RunsReport {

    public static void main(String[] args) {
        // Names
        String[] stadiums = {"Kingsmead", "St Georges", "Wanderers"};
        String[] batsmen = {"Jacques Kallis", "Hashim Amla", "AB De Villiers"};

        // Runs table
        int[][] runs = {
            {5000, 3800, 4200}, // Kingsmead
            {3500, 3700, 3900}, // St Georges
            {6200, 5000, 5200}  // Wanderers
        };

        // Totals
        int[] batsmanTotals = new int[batsmen.length];
        int[] stadiumTotals = new int[stadiums.length];

        // Process data
        for (int i = 0; i < stadiums.length; i++) {
            for (int j = 0; j < batsmen.length; j++) {
                batsmanTotals[j] += runs[i][j];
                stadiumTotals[i] += runs[i][j];
            }
        }

        // ---- Print a nice table ----
        System.out.println("RUNS REPORT");
        System.out.println("----------------------------------------------------------");
        System.out.printf("%-12s | %-15s | %-12s | %-12s%n",
                          "Stadium", batsmen[0], batsmen[1], batsmen[2]);
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < stadiums.length; i++) {
            System.out.printf("%-12s | %-15d | %-12d | %-12d%n",
                              stadiums[i], runs[i][0], runs[i][1], runs[i][2]);
        }
        System.out.println("----------------------------------------------------------");

        // Totals per batsman
        System.out.println("\nTOTAL RUNS BY BATSMAN:");
        for (int j = 0; j < batsmen.length; j++) {
            System.out.printf("  %-15s : %d%n", batsmen[j], batsmanTotals[j]);
        }

        // Find stadium with most runs
        int maxStadiumTotal = Integer.MIN_VALUE, maxStadiumIndex = -1;
        for (int i = 0; i < stadiumTotals.length; i++) {
            if (stadiumTotals[i] > maxStadiumTotal) {
                maxStadiumTotal = stadiumTotals[i];
                maxStadiumIndex = i;
            }
        }
        System.out.printf("%nStadium with most runs: %s (%d)%n",
                          stadiums[maxStadiumIndex], maxStadiumTotal);

        // ---- ALSO WRITE TO CSV FILE ----
        try (FileWriter writer = new FileWriter("runs_report.csv")) {
            // Header
            writer.write("Stadium," + String.join(",", batsmen) + "\n");
            // Data
            for (int i = 0; i < stadiums.length; i++) {
                writer.write(stadiums[i] + "," + runs[i][0] + "," + runs[i][1] + "," + runs[i][2] + "\n");
            }
            // Totals row
            writer.write("TOTALS," + batsmanTotals[0] + "," + batsmanTotals[1] + "," + batsmanTotals[2] + "\n");
            writer.flush();
            System.out.println("\nCSV file 'runs_report.csv' created successfully!");
        } catch (IOException e) {
            System.out.println("Error writing CSV: " + e.getMessage());
        }
    }
}
