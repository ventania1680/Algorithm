package Programmers;

import java.util.*;

class trieNode {
    private Map<Character, trieNode> childNodes = new HashMap<>();
    private boolean isLastChar;
    private int cnt = 0;

    public Map<Character, trieNode> getChildNodes() {
        return childNodes;
    }

    public boolean isLastChar() {
        return isLastChar;
    }

    public void setLastChar(boolean lastChar) {
        isLastChar = lastChar;
    }

    public void plusCnt() {
        this.cnt++;
    }

    public int getCnt() {
        return cnt;
    }
}

class trie {
    private trieNode rootNode;
    private trieNode rootNodeRev;

    public trie() {
        rootNode = new trieNode();
        rootNodeRev = new trieNode();
    }

    public void insert(String word) {
        trieNode thisNode = this.rootNode;
        trieNode thisNodeRev = this.rootNodeRev;
        thisNode.plusCnt();
        thisNodeRev.plusCnt();
        int len = word.length();
        for (int i = 0; i < len; i++) {
            thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c->new trieNode());
            thisNode.plusCnt();
            thisNodeRev = thisNodeRev.getChildNodes().computeIfAbsent(word.charAt(len-i-1), c->new trieNode());
            thisNodeRev.plusCnt();
        }
        thisNode.setLastChar(true);
        thisNodeRev.setLastChar(true);
    }

    public int search(String word) {
        trieNode thisNode;
        if (word.charAt(0) != '?') {
            thisNode = this.rootNode;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c == '?') break;
                trieNode node = thisNode.getChildNodes().get(c);
                if (node == null)
                    return 0;
                thisNode = node;
            }
        } else {
            thisNode = this.rootNodeRev;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (c == '?') break;
                trieNode node = thisNode.getChildNodes().get(c);
                if (node == null)
                    return 0;
                thisNode = node;
            }
        }
        return thisNode.getCnt();
    }
}

public class P60060 {
    public static int[] solution(String[] words, String[] queries) {
        trie[] root = new trie[100001];
        for (int i = 2; i <= 100000; i++)
            root[i] = new trie();
        for (String str : words) {
            root[str.length()].insert(str);
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = root[queries[i].length()].search(queries[i]);
        }
        return answer;
    }
}
