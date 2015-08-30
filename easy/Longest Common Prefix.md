Question: https://leetcode.com/problems/longest-common-prefix/
```
My solution:
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        if (strs == null || strs.length == 0){
            return result;
        }
        result = strs[0];
        for (int i = 1; i < strs.length; i++){
            result = commonPrefix(strs[i], result);
        }
        return result;
    }
    
    private String commonPrefix(String A, String B){
        int length = Math.min(A.length(), B.length());
        String res = "";
        for (int i = 0; i < length; i++){
            if (A.charAt(i) == B.charAt(i)){
                res += A.charAt(i);
            }
            else {
                break;
            }
        }
        return res;
    }
/////////////////////////////////////////////////////////////
Renjia's solution:
public String longestCommonPrefix(String[] strs) {
    if(strs == null || strs.length == 0)    return "";
    String pre = strs[0];
    int i = 1;
    while(i < strs.length){
        while(strs[i].indexOf(pre) != 0)     ////////////////get 新技能！
            pre = pre.substring(0,pre.length()-1);
        i++;
    }
    return pre;
}
```
