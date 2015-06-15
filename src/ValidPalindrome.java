

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s.isEmpty()) {
			return true;
		}
		String lowerS = s.toLowerCase();
		
		int left = 0;
		int right = s.length() - 1;
		
		while (left <= right) {
			if (!Character.isLetterOrDigit(lowerS.charAt(left))) {
				left++;
				continue;
			}
			
			if (!Character.isLetterOrDigit(lowerS.charAt(right))) {
				right--;
				continue;
			}
			if (lowerS.charAt(left) != lowerS.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		ValidPalindrome p = new ValidPalindrome();
		String s = "1a2";
		System.out.println(p.isPalindrome(s.toLowerCase()));
	}
}
