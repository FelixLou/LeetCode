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
/////////////////////////////////
    public boolean wordPattern(String pattern, String str) {
        String[] arr= str.split(" ");
        HashMap<Character, String> map = new HashMap<Character, String>();
        if(arr.length!= pattern.length())
            return false;
        for(int i=0; i<arr.length; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(arr[i]))
                    return false;
            }else{
                if(map.containsValue(arr[i]))
                    return false;
                map.put(c, arr[i]);
            }    
        }
        return true;
    }
```
