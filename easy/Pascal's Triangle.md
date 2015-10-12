Question: https://leetcode.com/problems/pascals-triangle/
```
My solution:
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows == 0) return result;
        List<Integer> preLevel = new ArrayList<Integer>();
        preLevel.add(1);
        result.add(preLevel);
        
        for(int i = 1; i < numRows; i++){
            List<Integer> level = new ArrayList<Integer>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i){
                    level.add(1);
                }
                else{
                    level.add(preLevel.get(j) + preLevel.get(j - 1));
                }
            }
            result.add(new ArrayList<Integer>(level));
            preLevel = level;
        }
        return result;
    }
}
////////////
//Renjia's method:
public List<List<Integer>> generate(int numRows)
{
    List<List<Integer>> allrows = new ArrayList<List<Integer>>();
    ArrayList<Integer> row = new ArrayList<Integer>();
    for(int i=0;i<numRows;i++)
    {
        row.add(0, 1);
        for(int j=1;j<row.size()-1;j++)
            row.set(j, row.get(j)+row.get(j+1));
        allrows.add(new ArrayList<Integer>(row));
    }
    return allrows;

}
```
