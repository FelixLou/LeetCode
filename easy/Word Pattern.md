Question: https://leetcode.com/problems/word-pattern/
```
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(pattern.length() != words.length) return false;
        Map index = new HashMap();
        for (int i=0; i<words.length; ++i){
            if (!Objects.equals(index.put(pattern.charAt(i), i),
                            index.put(words[i], i))){
                return false;
            }
        }
        return true;
    }
```
