/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package org.example;
import java.util.Scanner;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        // scanning the input from the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the lengths of the sides of the triangle:");

        // process the input
        try{
            // initialize sides
            double a;
            double b;
            double c;

            // get values from user
            while(true) {
                a = scanner.nextDouble();
                b = scanner.nextDouble();
                c = scanner.nextDouble();

                // check if values are in permitted range
                if(
                    (a < 0) || (a > 200) ||
                    (b < 0) || (b > 200) ||
                    (c < 0) || (c > 200)
                ){
                    // display the wrong value message
                    System.out.println("The entered value is not in the permitted range (from 1 to 200)! Try again!");

                    // skip the iteration
                    continue;
                } 

                // display success message
                System.out.println("All values that were entered are valid!");
                break;
            }

            // create triangle
            Triangle tr = new Triangle(a, b, c);

            // create validator
            Validator vd = new Validator(tr);

            // validate the triangle and define its type
            vd.validateTriangle();

        } catch (Exception e){
            System.err.println("A side of triangle must be positive and of double type! Please, exlude strings, objects!");
        } finally {
            // closing the scanner
            scanner.close();
        }
    }
}
