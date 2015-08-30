Question: https://leetcode.com/problems/multiply-strings/
```
My solution:
    public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() ==0){
            return "";
        }
        int carry = 0;
        if (num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String result = "";
        for(int i = num1.length() + num2.length() - 2; i >= 0 ; i--){
            int sum = carry;
            for (int j = Math.min(num1.length() - 1, i); j >= Math.max(0, i - num2.length() + 1); j--){
                sum += Character.getNumericValue(num1.charAt(j)) * Character.getNumericValue(num2.charAt(i - j));//Not numberic!
            }
            carry = sum/10;
            sum = sum%10;
           // System.out.println(carry + " "+ sum);
            result = sum + result;
            
        }
        if (carry != 0){
            result = carry + result;
        }
        return result;
    }
///////////////////////////////
Renjia's solution:
    public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] products = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                products[i + j + 1] += d1 * d2;
            }
        }
        int carry = 0;
        for (int i = products.length - 1; i >= 0; i--) {
            int tmp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : products) sb.append(num);
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }
```
