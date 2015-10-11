Question: https://leetcode.com/problems/word-ladder/
```
public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(wordList == null || wordList.size() == 0){
            return 0;
        }
        if(beginWord.equals(endWord)) return 2;
        Set<String> hash = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        hash.add(beginWord);
        int length = 1;
        while(!queue.isEmpty()){
            length++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String word = queue.poll();
                for(String nextString: getNextString(word, wordList)){
                    if(hash.contains(nextString)){
                        continue;
                    }
                    if(nextString.equals(endWord)){
                        return length;
                    }
                    hash.add(nextString);
                    queue.offer(nextString);
                }
            }
        }
        return 0;
    }
    
    private String replace(String word, int index, char c){
        char[] words = word.toCharArray();
        words[index] = c;
        return new String(words);
    }
    private ArrayList<String> getNextString(String word, Set<String> wordList){
        ArrayList<String> result =new ArrayList<String>();
        for(int i = 0; i < word.length(); i++){
            for(char c= 'a';c <'z';c++){
                if(c == word.charAt(i)){
                    continue;
                }
                String nextWord = replace(word,i,c);
                if(wordList.contains(nextWord)){
                    result.add(nextWord);
                }
            }
        }
        return result;
    }
}
```
