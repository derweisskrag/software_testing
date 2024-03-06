package org.example;

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

    public Triangle(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
