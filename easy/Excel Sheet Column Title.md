Question: https://leetcode.com/problems/excel-sheet-column-title/
```
My solution:
    public String convertToTitle(int n) {
        if(n < 1){
            return "";
        }
        String result = "";
        while(n > 0){
            result = (char)(--n%26 + 'A') + result;
            n = n/26;
        }
        return result;
    }
//////////////////////////////////
Renjia's solution:
public String convertToTitle(int n) {
  return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
}
