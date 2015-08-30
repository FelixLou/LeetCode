Question: https://leetcode.com/problems/add-binary/
```
    public String addBinary(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0){
            return "";
        }
        String result = new String();
        int length = Math.max(a.length(), b.length()) - 1;
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(length-- >= 0){
            int aa = i >= 0 ? Character.getNumericValue(a.charAt(i)) : 0;
            int bb = j >= 0 ? Character.getNumericValue(b.charAt(j)): 0;
            result = (aa + bb + carry)%2 + result;
            carry = (aa + bb+ carry)/2;
            i--;
            j--;
        }
        if (carry == 1){
            result = 1 + result;
        }
        return result;
    }
/////////////////////
Renjia's solution:
public String addBinary(String a, String b) {
    BigInteger aint = new BigInteger(a,2);
    BigInteger bint = new BigInteger(b,2);
    return aint.add(bint).toString(2);
}
```
