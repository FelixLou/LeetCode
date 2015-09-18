Question: https://leetcode.com/problems/isomorphic-strings/
```
    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[128];
        int[] m2 = new int[128];
        for(int i=0; i<s.length(); i++) {
            if(m1[s.charAt(i)]!=m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i + 1; //聪明！
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }
```