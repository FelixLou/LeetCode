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
	public static List<List<String>> groupAnagrams(String[] strs) {

		List<List<String>> result = new ArrayList<List<String>>();
		HashMap<String, List<String>> hash = new HashMap<String, List<String>>();

		if (strs.length == 0)
			return null;

		for (String s : strs) {

			char[] ch = s.toCharArray();
			Arrays.sort(ch);
			String s1 = String.valueOf(ch);

			if (hash.containsKey(s1)) {

				hash.get(s1).add(s);
			}

			else {

				List<String> le = new ArrayList<String>();
				le.add(s);
				hash.put(s1, le);
			}
		}

		for (Map.Entry<String, List<String>> entry : hash.entrySet()) {

			Collections.sort(entry.getValue());
			result.add(entry.getValue());
		}
		return result;
	}
```
