package leetcode;

import java.util.*;

public class WordLadder127 {

    public static void main(String[] args){
        List<String> wordList = new ArrayList<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        int nums = ladderLength("hit","cog",wordList);
        System.out.println("nums="+nums);
    }

    public  static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.size() == 0 ||
                beginWord == null || beginWord.length() == 0
                || endWord == null || endWord.length() == 0)
            return 0;

        Set<String> wordSet = new HashSet(wordList);
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        int level = 0;
        while(queue.size() > 0){
            int tempSize = queue.size();
            for(int i=0;i<tempSize;i++){
                String tempWord = queue.poll();
                if(tempWord.equals(endWord))
                    return level+1;

                for(int j=0;j<tempWord.length();j++){
                    char[] tempArray = tempWord.toCharArray();
                    for(int ch= (int)'a';ch <= (int)'z';ch++)
                    {
                        tempArray[j] = (char)ch;
                        String newWord = new String(tempArray);
                        if(wordSet.contains(newWord)
                                && !newWord.equals(tempWord)){
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }

                    }
                }
            }
            level ++;
        }
        return 0;
    }
}
