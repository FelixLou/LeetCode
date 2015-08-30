Question: https://leetcode.com/problems/implement-strstr/
```
My solution:
    public int strStr(String haystack, String needle) {
        if (needle == null|| needle.length() == 0){
            return 0;
        }
        if (haystack == null || haystack.length() == 0){
            return -1;
        }

        int j = 0;
        for (int i = 0; i < haystack.length(); i++){
            int start = i;
            while (i < haystack.length() && haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if (j == needle.length()){
                    return start;
                }
            }
            j = 0;
            i = start;
        }
        return -1;
    }
//////////////////////////////////////////////////////////
Renjia's solution:
public int strStr(String haystack, String needle) {
  for (int i = 0; ; i++) {
    for (int j = 0; ; j++) {
      if (j == needle.length()) return i;
      if (i + j == haystack.length()) return -1;
      if (needle.charAt(j) != haystack.charAt(i + j)) break;
    }
  }
}
```
