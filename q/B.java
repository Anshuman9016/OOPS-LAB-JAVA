package q;

import p.A;

public class B {
    public static void main(String[] args) {
        A a = new A();

        // Accessing public method
        a.publicMethod();

        // Accessing protected method 
       
        // Accessing default method 
       
        // Accessing private method 
       
        // Accessing private method through a public method within the same class
        a.accessPrivateMethod();
    }
}
