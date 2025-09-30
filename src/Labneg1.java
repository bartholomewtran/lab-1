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
import java.util.Arrays; //for part 1

//imports for part 2
import java.io.*;
import java.util.Formatter;
import java.util.Scanner;


public class Labneg1 {
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
        PROCESS MEANWHILE ACCOMMODATING FOR DIFFERENT DATA
        */

        // Define constant values (price, inventory items, sales tax)
        // Define sales tax
        var salesTax = 0.0825;

        double[] PriceArr = new double[]{400.00, 220.00, 35.20, 300.00, 150.00};
        String[] InvArr = new String[]{"TV", "VCR", "Remote Controller", "CD Player", "Tape Recorder"};

        int[] inputArr = new int[5]; // There are 5 item types to count, so it's made it into a fillable array.
        Scanner inputR = new Scanner(System.in); //inputR will represent placement


/*

3. INPUT

The following is where user input is applied. Scanner (as defined above) is used to allow users to input the
quantity of items. User is properly instructed to input single integers as quantities in a specific order as
intended by the program.

Process is streamlined to simple data entry.

 */
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


        // Part 2: Find Fahrenheit of Centigrade && vice versa

/*

1. DESIGN

Goal is to create a temperature converter from centigrade (celsius) to fahrenheit, and vice versa.

There are not that many variables, but this program is math-heavy. Use formula: F = 32 + C (180.0/100.0)

First major step is to define user input using scanners. This follows logic: if user inputs value for F, then output C.
If user inputs value for C, output F.

Since UX is of high importance, an in-terminal menu is created to enhance experience. The menu will allow the user
to choose which temperature unit to convert, allowing for instantaneous results. An option to quit program is also
provided to allow for easy ending of demo.

 */


        System.out.println("Part 2: F to C / C to F Conversion.\n");
        double number; //possibly redundant.

/*

2. VARIABLES

Only variable here is inputM as a scanner. Scanner is used to allow for user input. Variable inputM will change
in value depending on user input.

 */
        // Menu has to stay running until given permission to quit. Utilizing while(true) to sustain with a break
        // after forced quit.
        // Program is 2-step: Unit selection then number conversion. All encased in if-elif loop.
        Scanner inputM = new Scanner(System.in); //inputM will be universal variable

/*

3. INPUT + PROCESSING + PRINT

INPUT: The input is through Scanner (inputM). Scanner is formatted where any letter becomes upper-case for easy
processing.
inputM then becomes (deg). (deg) is processed in the conversion and becomes the output.

PROCESSING: Whole processing is inside a while-loop to allow for constant input. Option to quit program is provided as
input "Q".

Menu is in a 3-step if-loop:

    - 1st if is for choosing option to convert from Centigrade to Fahrenheit (input F).
    - 2nd if is for choosing option to convert from Fahrenheit to Centigrade (input C).
    - 3rd if is for choosing to quit program (input Q).

Processing follows this logic: Take float input (deg) and input into 2-step calculation process to become an output.

PRINT: The print will be a sentence: Your temperature in <input desired unit> is ____ <insert unit symbol>.
 */
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

                System.out.println("Your temperature in Fahrenheit: " + deg + "°F");
            }

            else if (choice.equals("C")) {
                System.out.println("Enter temperature in Fahrenheit: ");
                // Scanner inputc = new Scanner(System.in); <-- originally in but is redundant. switched from inputc,
                // inputf to universal unputM
                float deg = inputM.nextFloat();
                // Conversion calculation
                deg = (float) (deg - 32.0);
                deg = deg * (100f / 180f);

                System.out.println("Your temperature in Centigrade: " + deg + "°C");
            }
            // For manual quit.
            else if (choice.equals("Q")) {
                System.out.println("Program quitting. Done.");
                break;
            }
        }

/* OUTPUT

The following is the output of the program:

With Celsius temperature 22C:

Type C to find Degrees in Centigrade. Type F to find Degrees in Fahrenheit. Type Q to quit program.
F
Enter temperature in Centigrade:
22
Your temperature in Fahrenheit: 71.6°F


With Fahrenheit temperature of -45F:

Type C to find Degrees in Centigrade. Type F to find Degrees in Fahrenheit. Type Q to quit program.
C
Enter temperature in Fahrenheit:
-45
Your temperature in Centigrade: -42.77778°C

With option to quit:

Type C to find Degrees in Centigrade. Type F to find Degrees in Fahrenheit. Type Q to quit program.
Q
Program quitting. Done.

Process finished with exit code 0

 */
    }
}
