package leetcode.java;

import java.util.HashMap;

class Node {
    public boolean endOfWord;
    public HashMap<Character, Node> storage;

    public Node() {
        this.endOfWord = false;
        this.storage = new HashMap<>();
    }

    public Node(HashMap<Character, Node> storage) {
        this.endOfWord = false;
        this.storage = storage;
    }
}


class WordDictionary {

    HashMap<Character, Node> storage;

    public WordDictionary() {
        this.storage = new HashMap<>();
    }
    
    public void addWord(String word) {
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
        Node store = new Node(this.storage);
        return this.dfs(store, word.toCharArray(), 0);
    }

    public boolean dfs(Node storage, char[] cArr, int currentPos) {
        Node temp = storage;

        for (int i=currentPos; i<cArr.length; i++) {
            if (cArr[i] == '.') {
                for (Node next : temp.storage.values()) {
                    if (this.dfs(next, cArr, i+1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!temp.storage.containsKey(cArr[i])) {
                    return false;
                }
                temp = temp.storage.get(cArr[i]);
            }
        }
        return temp.endOfWord;
    }
}
