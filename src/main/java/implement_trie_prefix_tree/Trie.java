package implement_trie_prefix_tree;

// https://leetcode.com/problems/implement-trie-prefix-tree/
class Trie {

    class Node {
        String val;
        Node[] children;

        public Node(String val) {
            this.val = val;
            this.children = new Node[26];
        }
    }

    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node(null);
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        char[] chars = word.toCharArray();
        for (char c: chars) {
            int idx = c - 'a';
            Node next = node.children[idx];
            if (next == null) {
                next = new Node(null);
                node.children[idx] = next;
            }
            node = next;
        }
        node.val = word;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        Node node = root;
        for (char c: chars) {
            int idx = c - 'a';
            Node next = node.children[idx];
            if (next == null) return false;
            node = next;
        }
        return word.equals(node.val);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] chars = prefix.toCharArray();
        Node node = root;
        for (char c: chars) {
            int idx = c - 'a';
            Node next = node.children[idx];
            if (next == null) return false;
            node = next;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
