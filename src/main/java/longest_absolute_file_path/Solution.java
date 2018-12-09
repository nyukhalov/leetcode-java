package longest_absolute_file_path;

import java.util.*;

// https://leetcode.com/problems/longest-absolute-file-path/
class Solution {
    class Node {
        String val;
        List<Node> children;
        public Node(String val) {
            this.val = val;
            this.children = new ArrayList<>();
        }

        boolean isFile() {
            return val != null && val.indexOf('.') != -1;
        }

        boolean isTerminal() {
            return this.children.isEmpty();
        }
    }

    public int lengthLongestPath(String input) {
        Node root = parseFilesystem(input);
        return findLongestPath(root);
    }

    private Node parseFilesystem(String input) {
        Node root = new Node(null);
        Stack<Node> stack = new Stack<>();
        Node node = root;
        Node lastNode = root;
        int prevOffset = 0;

        String[] tokens = input.split("\n");
        for (String token: tokens) {
            int offset = getOffset(token);
            String name = getName(token, offset);

            if (offset > prevOffset) {
                stack.push(node);
                node = lastNode;
            } else if (offset < prevOffset) {
                int diff = prevOffset - offset;
                while(diff-- > 0) {
                    node = stack.pop();
                }
            }

            prevOffset = offset;
            lastNode = new Node(name);
            node.children.add(lastNode);
        }

        return root;
    }

    private int getOffset(String token) {
        int offset = 0;
        for (int i=0; i<token.length(); i++) {
            if (token.charAt(i) != '\t') break;
            offset++;
        }
        return offset;
    }

    private String getName(String token, int offset) {
        if (offset == 0) return token;
        return token.substring(offset);
    }

    private int findLongestPath(Node node) {
        if (node.isTerminal()) {
            if (node.isFile()) return node.val.length();
            else return -1;
        }

        int res = 0;

        // handle root node properly
        if (node.val != null) {
            res += node.val.length();
            res += 1; // single slash '/'
        }

        int maxPath = 0;
        for (Node child: node.children) {
            int pathLen = findLongestPath(child);
            if (pathLen > maxPath) maxPath = pathLen;
        }

        if (maxPath > 0) {
            res += maxPath;
        } else {
            res = 0;
        }

        return res;
    }
}
