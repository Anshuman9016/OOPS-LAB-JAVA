package p; // Ensure this matches the directory structure

public class A {
    // Public method
    public void publicMethod() {
        System.out.println("Public method");
    }

    // Protected method
    protected void protectedMethod() {
        System.out.println("Protected method");
    }

    // Default (package-private) method
    void defaultMethod() {
        System.out.println("Default method");
    }

    // Private method
    private void privateMethod() {
        System.out.println("Private method");
    }

    // Method to access private method within the same class
    public void accessPrivateMethod() {
        privateMethod();
    }
}
