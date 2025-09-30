/*
Bartholomew Tran
F25 CIS D035A 11Y, 62Z Java Programming
Assignment -1
Due Date: October 3, 2025
Date Submitted: September 30, 2025
 */

/*

1. DESIGN

Goal is to create a temperature converter from centigrade (Celsius) to Fahrenheit, and vice versa.

There are not that many variables, but this program is math-heavy. Use formula: F = 32 + C (180.0/100.0)

First major step is to define user input using scanners. This follows logic: if user inputs value for F, then output C.
If user inputs value for C, output F.

Since UX is of high importance, an in-terminal menu is created to enhance experience. The menu will allow the user
to choose which temperature unit to convert, allowing for instantaneous results. An option to quit program is also
provided to allow for easy ending of demo.

 */


import java.util.Scanner;
//imports for part 2
import java.io.*;
import java.util.Formatter;


public class LabN1pt2 {
    public static void main(String[] args) {
        // Part 2: Find Fahrenheit of Centigrade && vice versa

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
            } else if (choice.equals("C")) {
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


