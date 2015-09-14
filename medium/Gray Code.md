Question: http://www.lintcode.com/en/problem/gray-code/
```
    public List<Integer> grayCode(int n) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (n <= 1) {
            for (int i = 0; i <= n; i++){
                result.add(i);
            }
            return result;
        }
        result = grayCode(n - 1);
        List<Integer> r1 = reverse(result);
        int x = 1 << (n-1);//
        for (int i = 0; i < r1.size(); i++) {
            r1.set(i, r1.get(i) + x);
        }
        result.addAll(r1);
        return result;
    }
    private List<Integer> reverse(List<Integer> r){
        List<Integer> rev = new ArrayList<Integer>();
        for (int i = r.size() - 1; i >= 0; i--) {
            rev.add(r.get(i));
        }
        return rev;
    }
```
