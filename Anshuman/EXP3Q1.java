public class EXP3Q1 {
	
	public static boolean isPrime(int num) {
		if(num < 2) return false;
		for (int i = 2;i * i <= num; i++) {
			if (num %i == 0) return false;
		}
		return true ;
	}

	public static void main(String[] args) {
		int count = 0;
		
		System.out.println("Prime numbers between 1 an 1000");
		for (int i =1; i<=1000; i++) {
			if (isPrime(i)) {
				System.out.print(i + " ");
				count ++;
			}
		}
		
	System.out.println("\nTotal number of prime numbers between 1 and 1000: " + count);

	}

}