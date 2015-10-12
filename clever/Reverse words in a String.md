Question: https://leetcode.com/problems/reverse-words-in-a-string/
```
    public String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+"); //trim() first to remove leading or trailing zeros, use "\\s+" to remove multiple spaces
        StringBuilder out = new StringBuilder();
        if (parts.length > 0) {
            for (int i = parts.length - 1; i >= 0; i--) { // reverse append to finsh in one pass
                out.append(parts[i]);
                out.append(" ");
            }
        }
        return out.toString().trim();
    }
```
