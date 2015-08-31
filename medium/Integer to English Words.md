Question: https://leetcode.com/problems/integer-to-english-words/
```
    public String numberToWords(int num) {
        if (num == 0){
            return "Zero";
        }
        if (num < 1000){
            return lessThan1000(num);
        }
        String result = "";
        int[] number1 = new int[]{1000000000, 1000000, 1000};
        String[] say1 = new String[]{"Billion", "Million", "Thousand"};
        int i = 0;
        if (num >= number1[2]) i = 2;
        if (num >= number1[1]) i = 1;
        if (num >= number1[0]) i = 0;
    
        while(i < 3 && num >= number1[i]){
            int count = num/number1[i];
            num = num%number1[i];
            result = result + lessThan1000(count) + " "+say1[i] + " ";
            i++;
        }
        result = result + lessThan1000(num);
        return result.trim();
    }
    
    private String lessThan1000(int num){
        String[] say1 = new String[]{"", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        String[] say2 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String result = "";
        int count = 0;
        if (num >= 100){
            count = num/100;
            num = num%100;
            result = say2[count] + " "+ "Hundred" + " ";
        }
        count = num/10;
        if (count < 2){
            result += say2[num];
        }
        num = num%10;
        if(count >= 2){
            result += say1[count - 1] +" "+ say2[num];
        }
        return result.trim();
    }
```
