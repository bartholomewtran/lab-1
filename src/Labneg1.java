//Lab -1 Part 1

import java.util.Arrays;

public class Labneg1 {
    public static void main(String[] args) {

        System.out.print("Part 1\n\n\n");

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

        // Contain all  3 inventory quantity data provided into arrays
        int[] dataarraytest = {3, 5, 1, 2, 4};
        int[] dataarray1 = {2, 1, 4, 1, 2};
        int[] dataarray2 = {3, 0, 2, 0, 21};

        // Call all arrays into a variable to run in a method
        int[][] allarrays = {dataarraytest, dataarray1, dataarray2};

        // Method: run for the number of arrays in allarrays
        for (int[] QtyArr : allarrays) { //For each array

            double grandSubtotal = 0.00;
            // Print header
            System.out.printf("\t%2s\t%-30s\t%15s\t%15s\n", "QTY", "Description", "Unit Price", "Total Price");

            // For each array in allarrays
            for (int i = 0; i < QtyArr.length; i++) {

                // Calculate the total cost for each current item (i)
                float itemTotalCost = (float) (QtyArr[i] * PriceArr[i]);

                // Add the item's total cost to the grand subtotal
                grandSubtotal += itemTotalCost;

                // Print the row using INDIVIDUAL array elements
                System.out.printf("\t%2d\t%-30s\t%15.2f\t%15.2f\n", QtyArr[i], InvArr[i], PriceArr[i], itemTotalCost);

            }

            // Calculate and print final totals
            float salesTaxAmount = (float) (grandSubtotal * salesTax);
            float grandTotal = (float) (grandSubtotal + salesTaxAmount);

            // Print receipt values
            System.out.printf("\t%50s\t%15.2f\n", "Subtotal:", grandSubtotal);
            System.out.printf("\t%50s\t%15.2f\n", "Sales Tax (" + (salesTax * 100) + "%):", salesTaxAmount);
            System.out.printf("\t%50s\t%15.2f\n", "TOTAL:", grandTotal);
            System.out.print("---------------------------------------------------------------------\n");;
        }

        //Part 2: Find Fahrenheit of Centigrade && Centigrade of Fahrenheit

        System.out.print("Part 2\n\n\n");


    }
}

