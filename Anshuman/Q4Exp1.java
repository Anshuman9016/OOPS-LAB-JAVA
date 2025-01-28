public class Q4Exp1 {
	   
	    public double area(double length, double width) {
	        return (length * width);
	    }

	
	    public int Area(int side) {
	        return side * side;
	    }

	   
	    public double Area(double radius) {
	        return 22/7 * radius * radius;
	    }

	   
	    public double Area(double base, double height) {
	        return 0.5 * base * height;
	    }

	    public static void main(String[] args) {
	        Q4Exp1 shape = new Q4Exp1 ();

	        
	        System.out.println("Area of Rectangle: " + shape.Area(5, 3));

	
	        System.out.println("Area of Square: " + shape.Area(4));


	        System.out.println("Area of Circle: " + shape.Area(7));

	   
	        System.out.println("Area of Triangle: " + shape.Area(6, 8));
	    }
	}