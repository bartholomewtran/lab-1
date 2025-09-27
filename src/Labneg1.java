//Lab -1 Part 1

import java.sql.SQLOutput;
import java.util.Arrays; //for part 1

//imports for part 2
import java.io.*;
import java.util.Formatter;
import java.util.Scanner;


public class Labneg1 {
    public static void main(String[] args) {

        System.out.print("\n\nPart 1: Receipts\n\n");

        /* WE CAN LIST PRICES AND QUANTITIES INDIVIDUALLY AS SO...
        // Define inventory prices
        var TV = 400.00;
        var VCR = 220.00;
        var RemoteController = 35.20;
        var CDPlayer = 300.00;
        var TapeRecorder = 150.00;

        // Define quantity sold
        int TVsold = 3;
        int VCRsold = 5;
        int RCsold = 1;
        int CDPsold = 2;
        int TRsold = 4;

        BUT IT WILL BE TOO MUCH TO DO 2-3 DIFFERENT DATASETS. SO, I USED ARRAYS INSTEAD TO STREAMLINE
        PROCESS MEANWHILE ACCOMODATING FOR DIFFERENT DATA
        */

        // Define constant values (price, inventory items, sales tax)
        // Define sales tax
        var salesTax = 0.0825;

        double[] PriceArr = new double[]{400.00, 220.00, 35.20, 300.00, 150.00};
        String[] InvArr = new String[]{"TV", "VCR", "Remote Controller", "CD Player", "Tape Recorder"};

        int[] inputArr = new int[5]; // There are 5 item types to count, so it's made it into a fillable array.
        Scanner inputR = new Scanner(System.in); //inputR will represent placement

        System.out.printf("How many TVs were sold? ");
        inputArr[0] = inputR.nextInt();
        System.out.printf("How many VCRs were sold? ");
        inputArr[1] = inputR.nextInt();
        System.out.printf("How many Remote Controllers were sold? ");
        inputArr[2] = inputR.nextInt();
        System.out.printf("How many CD Players were sold? ");
        inputArr[3] = inputR.nextInt();
        System.out.printf("How many Tape Recorders were sold? ");
        inputArr[4] = inputR.nextInt();

        System.out.printf("\n\n"); // Formatting
        System.out.printf("-------------------------------------------------------------------------------\n"); // Formatting
        double grandSubtotal = 0.00;
        // Print header
        System.out.printf("\t%2s\t%-30s\t%15s\t%15s\n", "QTY", "Description", "Unit Price", "Total Price\n");

        // For each item in inventory
        for (int j = 0; j < inputArr.length; j++) {

            // Calculate the total cost for each current item (i)
            float itemTotalCost = (float) (inputArr[j] * PriceArr[j]);

            // Add the item's total cost to the grand subtotal
            grandSubtotal += itemTotalCost;

            // Print the row using INDIVIDUAL array elements
            System.out.printf("\t%2d\t%-30s\t%15.2f\t%15.2f\n", inputArr[j], InvArr[j], PriceArr[j], itemTotalCost);

        }

        // Calculate and print final totals
        float salesTaxAmount = (float) (grandSubtotal * salesTax);
        float grandTotal = (float) (grandSubtotal + salesTaxAmount);

        // Print receipt values
        System.out.printf("\n\t%50s\t%15.2f\n", "Subtotal:", grandSubtotal);
        System.out.printf("\t%50s\t%15.2f\n", "Sales Tax (" + (salesTax * 100) + "%):", salesTaxAmount);
        System.out.printf("\t%50s\t%15.2f\n", "TOTAL:", grandTotal);

        // The following are for formatting
        System.out.printf("-------------------------------------------------------------------------------\n");
        System.out.printf("\n\n\n");



        // Part 2: Find Fahrenheit of Centigrade && vice versa






        System.out.println("Part 2: F to C / C to F Conversion.\n");
        double number; //possibly redundant.

        // Menu has to stay running until given permission to quit. Utilizing while(true) to sustain with a break
        // after forced quit.
        // Program is 2-step: Unit selection then number conversion. All encased in if-elif loop.
        Scanner inputM = new Scanner(System.in); //inputM will be universal variable

        while (true) {
            System.out.println("Type C to find Degrees in Centigrade. Type F to find Degrees in Fahrenheit. Type Q " +
                    "to quit program.");
            String choice = inputM.next().toUpperCase(); // Read ONCE and store

            if (choice.equals("F")) {
                System.out.println("Enter temperature in Centigrade: ");
                // Scanner inputc = new Scanner(System.in); <-- originally in but is redundant. switched from inputc,
                // inputf to universal unputM
                float deg = inputM.nextFloat();
                // Conversion calculation
                deg = (float) (deg * (180.00 / 100.0));
                deg = deg + 32;

                System.out.println("Your temperature in Fahrenheit: " + deg);
            }

            else if (choice.equals("C")) {
                System.out.println("Enter temperature in Fahrenheit: ");
                // Scanner inputc = new Scanner(System.in); <-- originally in but is redundant. switched from inputc,
                // inputf to universal unputM
                float deg = inputM.nextFloat();
                // Conversion calculation
                deg = (float) (deg - 32.0);
                deg = deg * (100f / 180f);

                System.out.println("Your temperature in Centigrade: " + deg);
            }
            // For manual quit.
            else if (choice.equals("Q")) {
                System.out.println("Program quitting. Done.");
                break;
            }
        }
    }
}
