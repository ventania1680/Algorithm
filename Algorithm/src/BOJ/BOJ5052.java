// https://www.acmicpc.net/problem/5052
// 20.9.21. ventania1680

package BOJ;

import java.io.*;
import java.util.*;

class trieNode {
    Map<Character, trieNode> childNodes = new HashMap<>();
    boolean isLastChar;

    void setIsLastChar(boolean isLastChar) {
        this.isLastChar = isLastChar;
    }
}

class trie {
    trieNode rootNode;
    trie() {
        rootNode = new trieNode();
    }
    void insert(String str) {
        trieNode thisNode = this.rootNode;
        for (int i = 0; i < str.length(); i++) {
            thisNode = thisNode.childNodes.computeIfAbsent(str.charAt(i), c->new trieNode());
        }
        thisNode.setIsLastChar(true);
    }
    boolean contains(String str) {
        trieNode thisNode = this.rootNode;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            trieNode node = thisNode.childNodes.get(c);

            if (node == null)
                return false;

            thisNode = node;
        }
        return true;
    }
}

public class BOJ5052 {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] strArr = new String[n];
            for (int i = 0; i < n; i++)
                strArr[i] = br.readLine();
            Arrays.sort(strArr, Comparator.reverseOrder());
            trie root = new trie();
            for (int i = 0; i < n; i++) {
                if (root.contains(strArr[i])) {
                    sb.append("NO\n");
                    break;
                }
                if (i == n-1) {
                    sb.append("YES\n");
                    break;
                }
                root.insert(strArr[i]);
            }
        }
        System.out.println(sb.toString());
    }
}
