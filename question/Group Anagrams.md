Question: https://leetcode.com/problems/anagrams/
```
My solution:
//O(N^3) time limit exceeded!
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0){
            return result;
        }
        boolean[] visited = new boolean[strs.length];
        Arrays.sort(strs);
        for (int i = 0; i < strs.length - 1; i++){
            if (visited[i]) continue;
            List<String> list = new ArrayList<String>();
            list.add(strs[i]);
            for (int j = i+ 1; j < strs.length; j++){
                if (!visited[j] && isAnagram(strs[i], strs[j])){
                    list.add(strs[j]);
                    visited[j] = true;
                }
            }
        }
        return result;
    }
    
    private boolean isAnagram(String a, String b){
        if (a.length() != b.length()){
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i< a.length(); i++){
            if (map.containsKey(a.charAt(i))){
                map.put(a.charAt(i), map.get(a.charAt(i)) + 1);
            }
            else{
                map.put(a.charAt(i), 1);
            }
        }
        for (int i = 0; i< b.length(); i++){
            if (map.containsKey(b.charAt(i))){
                map.put(b.charAt(i), map.get(b.charAt(i)) - 1);
                if (map.get(b.charAt(i)) == 0){
                    map.remove(b.charAt(i));
                }
            }
            else{
                return false;
            }
        } 
        return true;  
    }
    //////////////////////////////////////////////////////////////
    Renjia's solution:
      public List<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
        HashMap<String,Integer> anacheck = new HashMap<String,Integer>();
        String temp = "";
        int index = 0;
        for (String s : strs) {
                temp = sortstring(s);
                if (!anacheck.containsKey(temp)) {
                    anacheck.put(temp,index);
                }else {
                    int i = anacheck.get(temp);
                    if (i != -1) {
                        result.add(strs[i]);
                        anacheck.put(temp, -1);
                    }
                    result.add(s);
                }
            index++;
        }
        return result;
    }

     public String sortstring(String s) {
            char[] c= s.toCharArray();
            Arrays.sort(c);
            return new String(c);
     }
     /////////////////////////////////////
      public static List<String> anagrams(String[] strs) {

        HashMap<String, List<String>> hashMap= new HashMap<String, List<String>>();
        List<String> anagramStrings = new ArrayList<String>();

        for (String str: strs) {
            char[] charArray = new char[str.length()];
            charArray = str.replaceAll("\\s+", "").toCharArray();
            Arrays.sort(charArray);

            String mapKey = String.copyValueOf(charArray);

            if (hashMap.containsKey(mapKey)) {
                hashMap.get(mapKey).add(str);
            } else {
                List<String> stringList = new ArrayList<String>();
                stringList.add(str);
                hashMap.put(mapKey, stringList);
            }
        }

        for(Map.Entry<String, List<String>> entry: hashMap.entrySet()) {
            List<String> value = entry.getValue();

            if (value.size() > 1) {
                anagramStrings.addAll(value);
            }   
        }
        return anagramStrings;
    }
```
