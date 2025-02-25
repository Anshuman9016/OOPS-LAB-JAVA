package q;

import p.A;

public class B {
    public static void main(String[] args) {
        A a = new A();

        // Accessing public method
        a.publicMethod();

        // Accessing protected method (will cause an error)
        // a.protectedMethod();

        // Accessing default method (will cause an error)
        // a.defaultMethod();

        // Accessing private method (not accessible)
        // a.privateMethod();

        // Accessing private method through a public method within the same class
        a.accessPrivateMethod();
    }
}
