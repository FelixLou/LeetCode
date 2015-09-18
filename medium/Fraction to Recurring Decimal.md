Question: https://leetcode.com/problems/fraction-to-recurring-decimal/
```
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";   // consider this first, or in the following there could be a problem in the sign decision
        StringBuilder sb = new StringBuilder();
        sb.append(((numerator > 0) ^ (denominator > 0)) ? "-" : ""); //remember to consider negative value!
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        sb.append(num/den);
        num = num%den;
        if(num%den != 0){
            sb.append(".");
            Map<Long, Integer> map = new HashMap<Long, Integer>();
            int count = 0;
            int presize = sb.length();
            while(num%den != 0){
                if(map.containsKey(num)){
                    sb.insert(map.get(num),"(");
                    sb.append(")");
                    break;
                }
                else{
                    map.put(num, presize + count);
                }
                num *= 10;
                sb.append(num/den);
                num = num%den;
                count++;
            }
        }
        return sb.toString();
    }
```
