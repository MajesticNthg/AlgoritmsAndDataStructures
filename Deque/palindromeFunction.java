public class palindromeFunction {
    public static boolean isPalindrome(String string) {
        if (string.length() < 2) {
            return true;
        }

        Deque<Character> palindrome = new Deque<>();

        for (int x = 0; x < string.length(); x++) {
            palindrome.addFront(string.charAt(x));
        }

        for (int x = 0; x < string.length() / 2; x++) {
            if (!(palindrome.removeFront().equals(palindrome.removeTail()))) {
                return false;
            }
        }

        return true;
    }
}
