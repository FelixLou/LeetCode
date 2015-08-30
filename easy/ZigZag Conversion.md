Question: https://leetcode.com/problems/zigzag-conversion/
```
My solutin:
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0){
            return "";
        }
        if (s.length() <= numRows || numRows == 1) return s; ///Corner case!!!
        int length = s.length();
        String result = "";
        for (int j = 0; j < length; j = j + 2 * numRows - 2){
            result = result + s.charAt(j);
        }
        for (int i = 2; i < numRows; i++){
            for (int j = i - 1; j < length; ){
                result = result + s.charAt(j);
                j = j + 2 * numRows - 2 * i;
                if (j >= length) break;
                result = result + s.charAt(j);
                j = j + 2 * (i - 1);
            }
        }
        for (int j = numRows - 1; j < length; j = j + 2 * numRows - 2){
            result = result + s.charAt(j);
        }
        return result;
    }
//////////////////////////////////////////////////
Renjia's solution:
public String convert(String s, int nRows) {
    char[] c = s.toCharArray();
    int len = c.length;
    StringBuffer[] sb = new StringBuffer[nRows];
    for (int i = 0; i < sb.length; i++) sb[i] = new StringBuffer();

    int i = 0;
    while (i < len) {
        for (int idx = 0; idx < nRows && i < len; idx++) // vertically down
            sb[idx].append(c[i++]);
        for (int idx = nRows-2; idx >= 1 && i < len; idx--) // obliquely up
            sb[idx].append(c[i++]);
    }
    for (int idx = 1; idx < sb.length; idx++)
        sb[0].append(sb[idx]);
    return sb[0].toString();
}
```
