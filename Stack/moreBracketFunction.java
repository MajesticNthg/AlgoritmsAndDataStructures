public class moreBracketFunction {
    public static boolean moreBracket (String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        Stack <String> firstBracket = new Stack<>();
        Stack <String> secondBracket = new Stack<>();
        Stack <String> thirdBracket = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            String flag = "";
            if (s.charAt(i) == '(') {
                firstBracket.push("(");
            }
            else if (s.charAt(i) == ')') {
                flag = firstBracket.pop();
            }

            else if (s.charAt(i) == '{') {
                secondBracket.push("{");
            }
            else if (s.charAt(i) == '}') {
                flag = secondBracket.pop();
            }

            else if (s.charAt(i) == '[') {
                thirdBracket.push("[");
            }
            else if (s.charAt(i) == ']') {
                flag = thirdBracket.pop();
            }

            if (flag == null) {
                return false;
            }
        }

        return (firstBracket.size() == 0 && secondBracket.size() == 0 && thirdBracket.size() == 0);
    }
}
