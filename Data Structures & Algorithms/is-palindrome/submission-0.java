class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("\\s+", "");
        s = s.replaceAll("\\p{Punct}", "");

        int j = s.length() - 1;
        for (int i = 0; i < (s.length() / 2); i++) {
            if (s.charAt(i) == s.charAt(j)) {
                j--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
