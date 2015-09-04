Question: https://leetcode.com/problems/rectangle-area/
```
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int a = (C- A) * (D -B);
        int b = (G -E) * (H -F);
        int overlap = 0;
        if (Math.min(C,G) > Math.max(E,A) && Math.min(D,H) > Math.max(B,F)){
            overlap = (Math.min(C,G) - Math.max(E,A)) * (Math.min(D,H) - Math.max(B,F));
        }
        return a + b - overlap;
    }
/////////////////////////////
Renjia's solution:
int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int left = max(A,E), right = max(min(C,G), left);
    int bottom = max(B,F), top = max(min(D,H), bottom);
    return (C-A)*(D-B) - (right-left)*(top-bottom) + (G-E)*(H-F);
}
```
