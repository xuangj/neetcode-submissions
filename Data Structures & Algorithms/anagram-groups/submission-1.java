class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagramGroups = new ArrayList<>();

        // return list with single string 
        if (strs.length == 1) {
            List<String> anagramList = new ArrayList<>();
            anagramList.add(strs[0]);
            anagramGroups.add(anagramList);
            return anagramGroups;
        }
        
        // Map with char frequencies as key and strings associated as value
        Map<String, List<String>> charFreqMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            int[] charFreq = new int[26];

            // setting array with char frequencies of each string
            for (int j = 0; j < strs[i].length(); j++) {
                char c = strs[i].charAt(j);
                charFreq[c - 'a']++; // increment count of char in str
            }
            String charFreqStr = Arrays.stream(charFreq)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(", "));

            List<String> anagramList;
            if (!charFreqMap.containsKey(charFreqStr)) {
                // if map doesn't have that freq array -> add it and the one string associated
                anagramList = new ArrayList<>();
                anagramList.add(strs[i]);
                charFreqMap.put(charFreqStr, anagramList);
            } else {
                // if map has freq array -> append string to running list
                anagramList = charFreqMap.get(charFreqStr);
                anagramList.add(strs[i]);

                charFreqMap.put(charFreqStr, anagramList);
            }
        }

        charFreqMap.forEach((key, value) -> {
            anagramGroups.add(value);
        });

        return anagramGroups;
    }
}
