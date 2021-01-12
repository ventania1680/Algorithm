package BOJ1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class tree {
    private node root;

    public tree(char[][] child) {
        root = makeTree(child, 'A');
    }

    private void preorder(node cur) {
        if (cur != null) {
            System.out.print(cur.name);
            preorder(cur.leftChild);
            preorder(cur.rightChild);
        }
    }

    void preorder() {
        preorder(root);
    }

    private void inorder(node cur) {
        if (cur != null) {
            inorder(cur.leftChild);
            System.out.print(cur.name);
            inorder(cur.rightChild);
        }
    }

    void inorder() {
        inorder(root);
    }

    private void postorder(node cur) {
        if (cur != null) {
            postorder(cur.leftChild);
            postorder(cur.rightChild);
            System.out.print(cur.name);
        }
    }

    void postorder() {
        postorder(root);
    }

    private node makeTree(char[][] child, char cur) {
        node n = new node(cur);
        if (child[cur-'A'][0] != '.') {
            n.leftChild = makeTree(child, child[cur-'A'][0]);
        }
        if (child[cur-'A'][1] != '.') {
            n.rightChild = makeTree(child, child[cur-'A'][1]);
        }
        return n;
    }
}

class node {
    char name;
    node leftChild, rightChild;

    public node(char name) {
        this.name = name;
        leftChild = rightChild = null;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] child = new char[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = st.nextToken().charAt(0) - 'A';
            child[idx][0] = st.nextToken().charAt(0);
            child[idx][1] = st.nextToken().charAt(0);
        }
        tree t = new tree(child);
        t.preorder();
        System.out.println();
        t.inorder();
        System.out.println();
        t.postorder();
    }
}
