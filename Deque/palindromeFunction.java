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
            Character s1 = palindrome.removeFront();
            Character s2 = palindrome.removeTail();
            if (!(s1.equals(s2))) {
                return false;
            }
        }

        return true;
    }
}
