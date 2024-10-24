    public boolean combinationBracket(String s) {
        Deque<Character> bracket = new Deque<>();
        Map<Integer, Character> myMap = new HashMap<>();
        myMap.put(1, '(');
        myMap.put(2, ')');
        myMap.put(3, '[');
        myMap.put(4, ']');
        myMap.put(5, '{');
        myMap.put(6, '}');

        for (int x = 0; x < s.length(); x++) {
            if (!searchBracket(s.charAt(x), myMap, bracket)) {
                return false;
            }
        }

        if (bracket.size() != 0) {
            return false;
        }

        return true;
    }

    private boolean searchBracket(Character symbol, Map myMap, Deque<Character> bracket) {
        for (int x = 1; x <= myMap.size(); x++) {
            if (symbol == myMap.get(x) && x % 2 != 0) {
                bracket.addTail(symbol);
                return true;
            }
            if (symbol == myMap.get(x) && bracket.size() == 0) {
                return false;
            }
            if (symbol == myMap.get(x)) {
                Character check = bracket.removeTail();
                if (check != myMap.get(x - 1)) {
                    return false;
                }
            }
        }
        return true;
    }
