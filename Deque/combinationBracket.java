public class combinationBracket {
    public boolean combinationBracket (String s) {
        Deque<Character> bracket = new Deque<>();
        for (int x = 0; x < s.length(); x++) {
            if (s.charAt(x) == '(' || s.charAt(x) == '[' || s.charAt(x) == '{') {
                bracket.addTail(s.charAt(x));
                continue;
            }
            Character symbol = bracket.removeTail();
            if (symbol == null) {
                return false;
            }
            if (s.charAt(x) == ')' && symbol != '(') {
                return false;
            }
            if (s.charAt(x) == ']' && symbol != '[') {
                return false;
            }
            if (s.charAt(x) == '}' && symbol != '{') {
                return false;
            }
        }
        return true;
    }
}
