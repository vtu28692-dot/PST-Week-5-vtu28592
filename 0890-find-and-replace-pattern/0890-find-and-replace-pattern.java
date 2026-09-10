import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        
        return result;
    }

    private boolean matches(String word, String pattern) {
        int[] pToW = new int[256];
        int[] wToP = new int[256];

        for (int i = 0; i < pattern.length(); i++) {
            char pChar = pattern.charAt(i);
            char wChar = word.charAt(i);

            // If a mapping exists, verify it matches current characters
            if (pToW[pChar] != 0 && pToW[pChar] != wChar) return false;
            if (wToP[wChar] != 0 && wToP[wChar] != pChar) return false;

            // Establish 1-to-1 mapping
            pToW[pChar] = wChar;
            wToP[wChar] = pChar;
        }

        return true;
    }
}