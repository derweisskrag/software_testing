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
        return this.x == this.y && 
            this.y == this.z &&
            this.z == this.x;
    }


    public boolean isScalene(){
        return !this.isEquilateral() && !this.isIsosceles();
    }


    public boolean isIsosceles(){
        return (this.x == this.y ||
            this.y == this.z ||
            this.z == this.x) && !this.isEquilateral();
    }


    public boolean isTriangle(){
        return this.x + this.y > this.z &&
            this.y + this.z > this.x &&
            this.z + this.x > this.y;
    }


    public Triangle(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
