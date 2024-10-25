    public boolean combinationBracket(String s) {
        Deque<Character> bracket = new Deque<>();
        Map<Integer, Character> myMap = new HashMap<>();
        myMap.put('(', ')');
        myMap.put('[', ']');
        myMap.put('{', '}');

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

    private boolean searchBracket(Character symbol, Map<Character, Character> myMap, Deque<Character> bracket) {
        for (Map.Entry<Character, Character> entry : myMap.entrySet()) {
            if (symbol == entry.getKey()) {
                bracket.addTail(symbol);
                return true;
            }
            if (symbol == entry.getValue() && bracket.size() == 0) {
                return false;
            }
            if (symbol == entry.getValue()) {
                Character check = bracket.removeTail();
                if (check != entry.getKey()) {
                    return false;
                }
            }
        }
        return true;
    }
