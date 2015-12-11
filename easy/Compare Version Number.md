Question: https://leetcode.com/problems/compare-version-numbers/
```
My Solution:
    public int compareVersion(String version1, String version2) {
        if (version1 == null || version2 == null){
            return 0;
        }
        int size1 = version1.length();
        int size2 = version2.length();
        int i = 0;
        int j = 0;
        while(i < size1 || j < size2){
            int v1 = 0;
            int v2 = 0;
            if (i < size1){
                int start1 = i;
                while(i < size1 && version1.charAt(i) != '.'){
                    i++;
                }
                v1 = Integer.parseInt(version1.substring(start1, i));
            }
            else{
                v1 = 0;
            }
            
            if(j < size2){
                int start2 = j;
                while(j < size2 && version2.charAt(j) != '.'){
                    j++;
                }
                v2 = Integer.parseInt(version2.substring(start2, j));
            }
            else{
                v2 = 0;
            }
            
            if (v1 > v2){
                return 1;
            }
            else if (v1 < v2){
                return -1;
            }
            i++;
            j++;
        }
        return 0;
    }
////////////////////////////////////////////////
2nd code:
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int maxLen = Math.max(v1.length,v2.length);
        int i = 0;
        while(i < maxLen){
            int vv1 = i < v1.length? Integer.parseInt(v1[i]):0;
            int vv2 = i < v2.length? Integer.parseInt(v2[i]):0;
            if(vv1 > vv2){
                return 1;
            }
            else if(vv1 <vv2){
                return -1;
            }
            else{
                i++;   
            }
            
        }
        return 0;
    }
    //////////////
Renjia's solution:
public int compareVersion(String version1, String version2) {
    String[] levels1 = version1.split("\\.");       //get 新技能 正则表达式
    String[] levels2 = version2.split("\\.");

    int length = Math.max(levels1.length, levels2.length);
    for (int i=0; i<length; i++) {
        Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0; 
        Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
        int compare = v1.compareTo(v2);             //get 新技能
        if (compare != 0) {
            return compare;
        }
    }

    return 0;
}
