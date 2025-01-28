import java.util.Arrays;

public class EXP3Q4 {

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) return false;
		
		char[]sArray = s.toCharArray();
		char[]tArray = t.toCharArray();
		
		Arrays.sort(sArray);
		Arrays.sort(tArray);
		
		return Arrays.equals(sArray, tArray);
		
	}
	
	public static void main(String[] args) {
		
		String s1 = "anagram";
		String t1 = "nagaram";
		System.out.println("Are '" + s1 + "' and '" + t1 + "' anagrams? " + isAnagram(s1,t1));
		
				
		String s2 = "rat";
		String t2 = "car";
		System.out.println("Are '" + s2 + "' and '" + t2 + "' anagrams? " + isAnagram(s2,t2));
	}

}