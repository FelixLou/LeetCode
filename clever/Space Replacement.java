Question: http://www.lintcode.com/en/problem/space-replacement/

//input reversely, or it will overlap the origin char; don't put duplicate i--

public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // Write your code here
        if(string == null || length == 0){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < length; i++){
            if (string[i] == ' '){
                count++;
            }
        }
        int j = length - 1;
        for (int i = length + 2*count -1; i >= 0;){
            if (string[j] == ' '){  
               string[i--] = '0';
               string[i--] = '2';
               string[i--] = '%';
               j--;
            }
            else {
                string[i--] = string[j--];
            }
            
        }
        return length + 2 * count;
    }
}
