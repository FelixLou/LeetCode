Question: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
```
没做出来...第一种应该想到的
        public static List<String> letterCombinations(String digits) {
            String digitletter[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
            List<String> result = new ArrayList<String>();

            if (digits.length()==0) return result;

            result.add("");
            for (int i=0; i<digits.length(); i++) 
                result = combine(digitletter[digits.charAt(i)-'0'],result);

            return result;
        }

        public static List<String> combine(String digit, List<String> l) {
            List<String> result = new ArrayList<String>();

            for (int i=0; i<digit.length(); i++) 
                for (String x : l) 
                    result.add(x+digit.charAt(i));

            return result;
        }
      ////////////////////////////////////
      BFS。。。好厉害
      public List<String> letterCombinations(String digits) {
    LinkedList<String> ans = new LinkedList<String>();
    if (digits == null || digits.length() == 0){
        return ans;
    }
    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    ans.add("");
    for(int i =0; i<digits.length();i++){
        int x = Character.getNumericValue(digits.charAt(i));
        while(ans.peek().length()==i){
            String t = ans.remove();
            for(char s : mapping[x].toCharArray())
                ans.add(t+s);
        }
    }
    return ans;
}
```
