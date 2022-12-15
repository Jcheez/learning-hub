package leetcode.java;

import java.util.HashMap;

class Node {
    public boolean endOfWord;
    public HashMap<Character, Node> storage;

    public Node() {
        this.endOfWord = false;
        this.storage = new HashMap<>();
    }
}

class Trie {

    HashMap<Character, Node> storage;

    public Trie() {
        this.storage = new HashMap<>();
    }
    
    public void insert(String word) {
        Node temp = null;
        char[] wordArr = word.toCharArray();

        for (int i=0; i<wordArr.length ; i++) {
            if (temp == null && !this.storage.containsKey(wordArr[i])) {
                this.storage.put(wordArr[i], new Node());
                temp = this.storage.get(wordArr[i]);
            } else if (temp == null && this.storage.containsKey(wordArr[i])) {
                temp = this.storage.get(wordArr[i]);
            } else if (temp != null && !temp.storage.containsKey(wordArr[i])) {
                temp.storage.put(wordArr[i], new Node());
                temp = temp.storage.get(wordArr[i]);
            } else {
                temp = temp.storage.get(wordArr[i]);
            }
        }
        temp.endOfWord = true;
    }
    
    public boolean search(String word) {
        Node temp = null;
        for (char c : word.toCharArray()) {
            if (temp == null && !this.storage.containsKey(c)) {
                return false;
            } else if (temp == null && this.storage.containsKey(c)) {
                temp = this.storage.get(c);
            } else if (temp != null && !temp.storage.containsKey(c)) {
                return false;
            } else {
                temp = temp.storage.get(c);
            }
        }
        return temp.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = null;
        for (char c : prefix.toCharArray()) {
            if (temp == null && !this.storage.containsKey(c)) {
                return false;
            } else if (temp == null && this.storage.containsKey(c)) {
                temp = this.storage.get(c);
            }else if (temp != null && !temp.storage.containsKey(c)) {
                return false;
            } else {
                temp = temp.storage.get(c);
            }
        }
        return temp.storage.size() >= 0;
    }
}