package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 字典树的java实现
 */
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.wordEnd = false;
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = new Character(word.charAt(i));
            if (!node.childdren.containsKey(c)) {
                node.childdren.put(c, new TrieNode());
            }
            node = node.childdren.get(c);
        }
        node.wordEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        boolean found = true;
        for (int i = 0; i < word.length(); i++) {
            Character c = new Character(word.charAt(i));
            if (!node.childdren.containsKey(c)) {
                return false;
            }
            node = node.childdren.get(c);
        }
        return found && node.wordEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        boolean found = true;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = new Character(prefix.charAt(i));
            if (!node.childdren.containsKey(c)) {
                return false;
            }
            node = node.childdren.get(c);
        }
        return found;
    }

    public static void main(String[] args){
        Trie trie = new Trie();

        trie.insert("apple");
        boolean s1 = trie.search("apple");   // returns true
        System.out.println("s1="+s1);
        boolean s2 = trie.search("app");     // returns false
        System.out.println("s2="+s2);
        boolean s3 = trie.startsWith("app"); // returns true
        System.out.println("s3="+s3);
        trie.insert("app");
        boolean s4 = trie.search("app");     // returns true
        System.out.println("s4="+s4);
    }

}

class TrieNode {
    Map<Character, TrieNode> childdren;
    boolean wordEnd;

    public TrieNode() {
        childdren = new HashMap<Character, TrieNode>();
        wordEnd = false;
    }
}