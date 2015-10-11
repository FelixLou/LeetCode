Question: https://leetcode.com/problems/maximum-product-subarray/
```
public int maxProduct(int[] A) {
    if (A.length == 0) {
        return 0;
    }

    int maxherepre = A[0];
    int minherepre = A[0];
    int maxsofar = A[0];
    int maxhere, minhere;

    for (int i = 1; i < A.length; i++) {
        maxhere = Math.max(Math.max(maxherepre * A[i], minherepre * A[i]), A[i]);
        minhere = Math.min(Math.min(maxherepre * A[i], minherepre * A[i]), A[i]);
        maxsofar = Math.max(maxhere, maxsofar);
        maxherepre = maxhere;
        minherepre = minhere;
    }
    return maxsofar;
}
////////////////////////////////////////////
public class Solution {
    public int maxProduct( int A[]) { 
    int n = A.length;
    int[] positives = new int[n]; 
    int[] negatives = new int[n];
    int res = A[n - 1];
    positives[n - 1] = res > 0 ? res : 0;
    negatives[n - 1] = res < 0 ? res : 0;

    for ( int i = n - 2; i >= 0; i-- ) {
        if ( A[i] > 0 ) {
            positives[i] = positives[i + 1] > 0 ? A[i] * positives[i + 1] : A[i];
            negatives[i] = negatives[i + 1] < 0 ? A[i] * negatives[i + 1] : 0;
        } else if ( A[i] < 0 ) {
            positives[i] = negatives[i + 1] < 0 ? A[i] * negatives[i + 1] : 0;
            negatives[i] = positives[i + 1] > 0 ? A[i] * positives[i + 1] : A[i];
        }

        if ( positives[i] > res ) {
            res = positives[i];
        }
    }

    return res;
    }
}
```
