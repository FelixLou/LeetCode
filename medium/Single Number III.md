Question: https://leetcode.com/problems/single-number-iii/

Answer； https://leetcode.com/discuss/52351/accepted-java-space-easy-solution-with-detail-explanations
```
	    public List<Integer> singleNumberIII(int[] A) {
	        // write your code here
	    	List<Integer> result = new ArrayList<Integer>();
	        if (A == null || A.length == 0){
	            return result;
	        }
	        int xor = 0;
	        for (int i = 0; i < A.length; i++){
	            xor ^= A[i];
	        }
	        //find a the last bit that is 1
	        int lastOne =  xor - (xor & (xor - 1));
	        
	        int number1 = 0;
	        int number2 = 0;
	        for (int i = 0; i < A.length; i++){
	            if ((A[i] & lastOne) != 0){
	                number1 ^= A[i];
	            }
	            else {
	                number2 ^= A[i];
	            }
	        }
	        result.add(number1);
	        result.add(number2);
	        return result;
	    }
```
