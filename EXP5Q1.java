class Parent {
    private int privateNumber = 42; 

    public int getPrivateNumber() {
        return privateNumber;
    }
}

class Child extends Parent {
    public void display() {

        System.out.println("Private Number (Accessed via Method): " + getPrivateNumber());
    }
}

public class EXP5Q1 {
    public static void main(String[] args) {
        Child obj = new Child();
        obj.display();
    }
}
