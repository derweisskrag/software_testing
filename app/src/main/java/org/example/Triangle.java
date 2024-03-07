package org.example;

/*
 * Implementation of the Triangle
 * 
 */

public class Triangle {
    // sides of the triangle
    private double x;
    private double y;
    private double z;

    //getters
    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }

    public double getZ(){
        return this.z;
    }

    // get area
    public double getArea(){
        // compute inscribed circle radius
        double s = (this.x + this.y + this.z) / 2.0;

        // return the area
        return Math.sqrt(s * (s - this.x) * (s - this.y) * (s - this.z));
    }


    public boolean isEquilateral(){
        // check if the triangle valid
        if(!this.isTriangle()){
            return false;
        }

        // evaluate if equilateral
        return this.x == this.y && 
            this.y == this.z &&
            this.z == this.x;
    }


    public boolean isScalene(){
        // check if the triangle valid
        if(!this.isTriangle()){
            return false;
        }

        // evaluate if scalene
        return !this.isEquilateral() && !this.isIsosceles();
    }


    public boolean isIsosceles(){
        // check if the triangle valid
        if(!this.isTriangle()){
            return false;
        }

        // evaluate if isolesces
        return (this.x == this.y ||
            this.y == this.z ||
            this.z == this.x) && !this.isEquilateral();
    }


    public boolean isTriangle(){
        return this.x + this.y > this.z &&
            this.y + this.z > this.x &&
            this.z + this.x > this.y;
    }


    public Triangle(Object x, Object y, Object z){
        // validate the data
        if (x == null || y == null || z == null){
            throw new IllegalArgumentException("Sides of a triangle cannot be null");
        } else if (
            !(x instanceof Double) ||
            !(y instanceof Double) ||
            !(z instanceof Double)
        ){
            throw new IllegalArgumentException("Sides of a triangle must be of type Double");
        }

        Double dx = (Double) x;
        Double dy = (Double) y;
        Double dz = (Double) z;

        if(dx <= 0 || dy <= 0 || dz <= 0){
            throw new IllegalArgumentException("Sides of a triangle must be positive");
        }
        
        this.x = (double) dx;
        this.y = (double) dy;
        this.z = (double) dz;
    }
}
