/**
 * Lab 3 Ingeniera de Sofware
 * Operaciones sobre numeros complejos
 * 
 * @author Zurita Paco Elvis Jherson
 * @author Condori Cuevas Jhon Carlos
 * @author Quispe Torrez Ever
 * @author Escobar Ruiz Marco Antonio
 * @version 1.0
 **/

class function {
    public static void main(String[] args) {
        System.out.println("Numeros Complejos!");
        Complex x = new Complex(2, 3);
        Complex y = new Complex(-4, 5);
        Complex z = x.addition(y);
        Complex s = x.subtraction(y);
        Complex m = x.multiplication(y);
        Complex d = x.division(y);
        Complex c = x.conjugate();
        double mod = x.modulus();
        double ph = x.phase();
        Complex pow = x.power(2);
        Complex sqrt = x.squareRoot();
        Complex log = x.logarithm();

        System.out.println("Adition");
        System.out.println(z.toStg());
        System.out.println("Subtraction");
        System.out.println(s.toStg());
        System.out.println("Multiplication");
        System.out.println(m.toStg());
        System.out.println("Division");
        System.out.println(d.toStg());
        System.out.println("Conjugate");
        System.out.println(c.toStg());
        System.out.println("Modulus");
        System.out.println(mod);
        System.out.println("Phase");
        System.out.println(ph);
        System.out.println("Power");
        System.out.println(pow.toStg());
        System.out.println("Square Root");
        System.out.println(sqrt.toStg());
        System.out.println("Logarithm");
        System.out.println(log.toStg());
    }
}

class Complex {
    double real;
    double img;

    Complex(double r, double i) {
        this.real = r;
        this.img = i;
    }

    Complex addition(Complex y) {
        Complex z = new Complex(0, 0);
        z.real = this.real + y.real;
        z.img = this.img + y.img;
        return z;
    }

    Complex subtraction(Complex y) {
        Complex z = new Complex(0, 0);
        z.real = this.real - y.real;
        z.img = this.img - y.img;
        return z;
    }

    Complex multiplication(Complex y) {
        Complex z = new Complex(0, 0);
        z.real = this.real * y.real - this.img * y.img;
        z.img = this.real * y.img + this.img * y.real;
        return z;
    }

    /*@author Quispe Torrez Ever*/

    Complex division(Complex y) {
        Complex z = new Complex(0, 0);
        double denominator = y.real * y.real + y.img * y.img;
        z.real = (this.real * y.real + this.img * y.img) / denominator;
        z.img = (this.img * y.real - this.real * y.img) / denominator;
        return z;
    }

    /*@author Escobar Ruiz Marco Antonio*/

    Complex conjugate() {
        Complex z = new Complex(this.real, -this.img);
        return z;
    }

    /*@author Condori Cuevas Jhon Carlos*/

    double modulus() {
        return Math.sqrt(this.real * this.real + this.img * this.img);
    }
   
    /*@author Zurita Paco Elvis Jherson*/

    double phase() {
        return Math.atan2(this.img, this.real);
    }

    /*@author Quispe Torrez Ever*/

    Complex power(double n) {
        double r = this.modulus();
        double theta = this.phase();
        double newReal = Math.pow(r, n) * Math.cos(n * theta);
        double newImg = Math.pow(r, n) * Math.sin(n * theta);
        Complex z = new Complex((int) newReal, (int) newImg);
        return z;
    }

    /*@author Escobar Ruiz Marco Antonio*/

    Complex squareRoot() {
        double r = this.modulus();
        double theta = this.phase();
        double newReal = Math.sqrt(r) * Math.cos(theta / 2);
        double newImg = Math.sqrt(r) * Math.sin(theta / 2);
        Complex z = new Complex((int) newReal, (int) newImg);
        return z;
    }

    /*@author Condori Cuevas Jhon Carlos*/

    Complex logarithm() {
        double r = this.modulus();
        double theta = this.phase();
        double newReal = Math.log(r);
        double newImg = theta;
        Complex z = new Complex((int) newReal, (int) newImg);
        return z;
    }

    /*@author Zurita Paco Elvis Jherson*/

    String toStg() {
        return (String.valueOf(this.real) + "+" + String.valueOf(this.img) + "i");
    }
}
