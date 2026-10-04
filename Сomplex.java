import java.util.Scanner;
class Complex{
    public double real;
    public double imag;
    public Complex(double real, double imag){
        this.real = real;
        this.imag = imag;

    }
    public Complex add(Complex other){
        double r= this.real + other.real;
        double i= this.imag + other.imag;
        return new Complex(r, i);
    }
    public Complex subtract(Complex other){
        double r = this.real - other.real;
        double i = this.imag - other.imag;
        return new Complex(r, i);
    }
    public Complex multiply(Complex other){
        double r = this.real * other.real - this.imag * other.imag;
        double i = this.real * other.imag + this.imag * other.real;
        return new Complex(r, i);
    }
     public Complex divide(Complex other){
        double z=other.real * other.real + other.imag * other.imag;
        if(z==0){
            System.out.println("На ноль делить нелья");
            return new Complex(0,0);
        }
        double r = (this.real * other.real + this.imag*other.imag)/z;
        double i = (this.imag * other.real - this.real * other.imag)/z;
        return new Complex(r, i);
     }
     public String toString(){
        if (imag>=0) {
            return real + "+" + imag + "i";
        } else {
            return real + "-" + Math.abs(imag) + "i";
        }

     }



}