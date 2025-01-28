public class EXP3Q2 {
	
	public static int findMissingNumber(int[] arr, int N) {
		int totalSum = N * (N+1) / 2 ;
		int arrSum = 0;
		for (int num : arr) {
			arrSum += num;
		}
		return totalSum - arrSum;
	}

	public static void main(String[] args) {
		
		int[] arr = {1,5,6,2,4};
		int N = arr.length + 1;
		int missingNumber = findMissingNumber(arr, N);
		
		System.out.println("The missing number is: " + missingNumber);
		
	}

}