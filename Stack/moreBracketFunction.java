public class moreBracketFunction {
    public static boolean moreBracket (String s) {
        if (s.length() % 2 != 0) {
            return false;
        }

        int first = 0;
        int second = 0;
        int third = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                first++;
            }
            else if (s.charAt(i) == ')') {
                first--;
            }

            else if (s.charAt(i) == '{') {
                second++;
            }
            else if (s.charAt(i) == '}') {
                second--;
            }

            else if (s.charAt(i) == '[') {
                third++;
            }
            else if (s.charAt(i) == ']') {
                third--;
            }

            if (first < 0 || second < 0 || third < 0) {
                return false;
            }
        }

        return (first == 0 && second == 0 && third == 0);
    }
}
