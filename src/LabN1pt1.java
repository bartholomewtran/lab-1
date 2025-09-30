/*
Bartholomew Tran
F25 CIS D035A 11Y, 62Z Java Programming
Assignment -1
Due Date: October 3, 2025
Date Submitted: September 30, 2025
 */

//Lab -1 Part 1

/*

1. DESIGN

Approach for this is as follows: allow user input of inventory for the following:

    - TVs
    - VCRs
    - Remote Controllers
    - CD Players
    - Tape Recorders

System built-in database has the following data:

    - Unit price per item (in an array)
    - Sales tax rate

Program finds the subtotal cost of all items, then calculates total cost by considering sales tax. Applications of
different Java concepts can be observed throughout the program.
Program returns a formatted receipt of their total cost including sales tax.

 */
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Arrays; //for part 1


public class LabN1pt1 {
    public static void main(String[] args) {

        System.out.print("\n\nPart 1: Receipts\n\n");

/*
2. VARIABLES

The following section of code defines the variables and array names.

Included in the comments, I wrote 2 ways of defining variables: long way (individualized list)
and short way (arrays). My personal preference is arrays.

 */
        /* WE CAN LIST PRICES AND QUANTITIES INDIVIDUALLY AS SO...
        // Define inventory prices
        float TV = 400.00F;
        float VCR = 220.00F;
        float RemoteController = 35.20F;
        float CDPlayer = 300.00F;
        float TapeRecorder = 150.00F;

        // Define quantity sold
        int TVsold = 3;
        int VCRsold = 5;
        int RCsold = 1;
        int CDPsold = 2;
        int TRsold = 4;

        BUT IT WILL BE TOO MUCH TO DO 2-3 DIFFERENT DATASETS. SO, I USED ARRAYS INSTEAD TO STREAMLINE
        PROCESS MEANWHILE ACCOMMODATING FOR DIFFERENT DATA
        */

        // Define constant values (price, inventory items, sales tax)
        // Define sales tax
        float salesTax = 0.0825F;

        double[] PriceArr = new double[]{400.00, 220.00, 35.20, 300.00, 150.00};
        String[] InvArr = new String[]{"TV", "VCR", "Remote Controller", "CD Player", "Tape Recorder"};

        int[] inputArr = new int[5]; // There are 5 item types to count, so it's made it into a fillable array.
        Scanner inputR = new Scanner(System.in); //inputR will represent placement
        Scanner inputD = new Scanner(System.in); // inputD will represent the menu choice

/*

3. INPUT

The following is where user input is applied. Scanner (as defined above) is used to allow users to input the
quantity of items. User is properly instructed to input single integers as quantities in a specific order as
intended by the program.

Process is streamlined to simple data entry.

 */



        while (true) {
            System.out.printf("To create a receipt, press R. To quit program, press Q:\n");
            String choice = inputD.next().toUpperCase();

            if (choice.equals("R")) {
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

/*
4. PROCESSING

The following block includes the processing of calculations and formatting of the output in the terminal.

Formatting, processing, and printing are integrated together in the order that the user will see from top to down.
Each part of the processing is labeled by individual comments for easier understanding. For-loop is used to make
the repetitive operations efficient. Printing of rows per inventory is included in the processing for-loop.

 */
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

/*
5. PRINT

The following block prints out the subtotal, sales tax, and total, which are the main pieces of data that the user
would want to know.

 */
                // Print receipt values
                System.out.printf("\n\t%50s\t%15.2f\n", "Subtotal: $", grandSubtotal);
                System.out.printf("\t%50s\t%15.2f\n", "Sales Tax (" + (salesTax * 100) + "%):", salesTaxAmount);
                System.out.printf("\t%50s\t%15.2f\n", "TOTAL: $", grandTotal);

                // The following are for formatting
                System.out.printf("-------------------------------------------------------------------------------\n");
                System.out.printf("\n\n\n");

            }
            else if (choice.equals("Q")) {
                System.out.println("Program quitting. Done.");
                break;
            }

        }

/*

OUTPUT

The following is the output from the terminal showing the printed receipt.

With data output: Set 1 -> 2 1 4 1 2

-------------------------------------------------------------------------------
	QTY	Description                   	     Unit Price	   Total Price

	 2	TV                            	         400.00	         800.00
	 1	VCR                           	         220.00	         220.00
	 4	Remote Controller             	          35.20	         140.80
	 1	CD Player                     	         300.00	         300.00
	 2	Tape Recorder                 	         150.00	         300.00

	                                       Subtotal: $	        1760.80
	                                Sales Tax (8.25%):	         145.27
	                                          TOTAL: $	        1906.07
-------------------------------------------------------------------------------

With data output: Set 2 -> 3 0 2 0 21

-------------------------------------------------------------------------------
	QTY	Description                   	     Unit Price	   Total Price

	 2	TV                            	         400.00	         800.00
	 0	VCR                           	         220.00	           0.00
	 3	Remote Controller             	          35.20	         105.60
	 0	CD Player                     	         300.00	           0.00
	21	Tape Recorder                 	         150.00	        3150.00

	                                       Subtotal: $	        4055.60
	                                Sales Tax (8.25%):	         334.59
	                                          TOTAL: $	        4390.19
-------------------------------------------------------------------------------

 */

    }
}
