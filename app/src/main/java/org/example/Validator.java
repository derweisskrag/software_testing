package org.example;

/*
 * Implements the validation for the Triangle
 */

public class Validator {
    private Triangle tr;
    
    public String validateTriangle(){
        if(!this.tr.isTriangle()){
            System.out.println("The given object is not a triangle");
            return "NotTriangle";
        }


        // if the object is the triangle
        if(this.tr.isEquilateral()){
            System.out.println("The triangle is an equilateral");
            return "Equilateral";
        } else if(this.tr.isIsosceles()){
            System.out.println("The triangle is an isolesces");
            return "Isolesces";
        } else if(this.tr.isScalene()){
            System.out.println("The triangle is a scalene");
            return "Scalene";
        }

        return "Unknown";
    }

    public Validator(Object triangle){
        if(!(triangle instanceof Triangle)){
            throw new IllegalArgumentException("Must be of Triangle type!");
        }

        this.tr = (Triangle) triangle;
    }
}
