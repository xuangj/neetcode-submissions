class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);
            
            // check if map contains the letter already
            if (!mapS.containsKey(sChar)) {
                mapS.put(sChar, 1); // mark new letter's occurrance
            } else {
                Integer updatedOccurance = mapS.get(sChar) + 1;
                mapS.put(sChar, updatedOccurance); // update existing letter's occurrance in map
            }

            // same for second string
            if (!mapT.containsKey(tChar)) {
                mapT.put(tChar, 1);
            } else {
                Integer updatedOccurance = mapT.get(tChar) + 1;
                mapT.put(tChar, updatedOccurance);
            }
        }

        // loop through hashmaps and check if they have same keys and values
        for (Character c : mapS.keySet()) {
            // first map's count of character c
            Integer countS = mapS.get(c);
            
            // check if second map has same character as first map
            if (!mapT.containsKey(c)) {
                return false;
            } else {
                // check if second map's char has same # of occurrances as that of first map
                Integer countT = mapT.get(c);
                if (!countT.equals(countS)) {
                    return false;
                }
            }
        }
        return true;
    }
}
