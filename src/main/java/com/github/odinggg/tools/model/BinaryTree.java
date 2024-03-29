package com.github.odinggg.tools.model;

import java.util.LinkedList;

public class BinaryTree {

    /**
     * This class implements the nodes that will go on the Binary Tree. They consist of the data in
     * them, the node to the left, the node to the right, and the parent from which they came from.
     *
     * @author Unknown
     */
    class Node {
        /**
         * Data for the node
         */
        public int data;
        /**
         * The Node to the left of this one
         */
        public Node left;
        /**
         * The Node to the right of this one
         */
        public Node right;
        /**
         * The parent of this node
         */
        public Node parent;

        /**
         * Constructor of Node
         *
         * @param value Value to put in the node
         */
        public Node(int value) {
            data = value;
            left = null;
            right = null;
            parent = null;
        }
    }

    /**
     * The root of the Binary Tree
     */
    private Node root;

    /**
     * Constructor
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Method to find a Node with a certain value
     *
     * @param key Value being looked for
     * @return The node if it finds it, otherwise returns the parent
     */
    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (key < current.data) {
                if (current.left == null) return current; // The key isn't exist, returns the parent
                current = current.left;
            } else if (key > current.data) {
                if (current.right == null) return current;
                current = current.right;
            } else { // If you find the value return it
                return current;
            }
        }
        return null;
    }

    /**
     * Inserts certain value into the Binary Tree
     *
     * @param value Value to be inserted
     */
    public void put(int value) {
        Node newNode = new Node(value);
        if (root == null) root = newNode;
        else {
            // This will return the soon to be parent of the value you're inserting
            Node parent = find(value);

            // This if/else assigns the new node to be either the left or right child of the parent
            if (value < parent.data) {
                parent.left = newNode;
                parent.left.parent = parent;
            } else {
                parent.right = newNode;
                parent.right.parent = parent;
            }
        }
    }

    /**
     * Deletes a given value from the Binary Tree
     *
     * @param value Value to be deleted
     * @return If the value was deleted
     */
    public boolean remove(int value) {
        // temp is the node to be deleted
        Node temp = find(value);

        // If the value doesn't exist
        if (temp.data != value) return false;

        // No children
        if (temp.right == null && temp.left == null) {
            if (temp == root) root = null;

                // This if/else assigns the new node to be either the left or right child of the parent
            else if (temp.parent.data < temp.data) temp.parent.right = null;
            else temp.parent.left = null;
            return true;
        }

        // Two children
        else if (temp.left != null && temp.right != null) {
            Node successor = findSuccessor(temp);

            // The left tree of temp is made the left tree of the successor
            successor.left = temp.left;
            successor.left.parent = successor;

            // If the successor has a right child, the child's grandparent is it's new parent
            if (successor.parent != temp) {
                if (successor.right != null) {
                    successor.right.parent = successor.parent;
                    successor.parent.left = successor.right;
                    successor.right = temp.right;
                    successor.right.parent = successor;
                } else {
                    successor.parent.left = null;
                    successor.right = temp.right;
                    successor.right.parent = successor;
                }
            }

            if (temp == root) {
                successor.parent = null;
                root = successor;
                return true;
            }

            // If you're not deleting the root
            else {
                successor.parent = temp.parent;

                // This if/else assigns the new node to be either the left or right child of the parent
                if (temp.parent.data < temp.data) temp.parent.right = successor;
                else temp.parent.left = successor;
                return true;
            }
        }
        // One child
        else {
            // If it has a right child
            if (temp.right != null) {
                if (temp == root) {
                    root = temp.right;
                    return true;
                }

                temp.right.parent = temp.parent;

                // Assigns temp to left or right child
                if (temp.data < temp.parent.data) temp.parent.left = temp.right;
                else temp.parent.right = temp.right;
                return true;
            }
            // If it has a left child
            else {
                if (temp == root) {
                    root = temp.left;
                    return true;
                }

                temp.left.parent = temp.parent;

                // Assigns temp to left or right side
                if (temp.data < temp.parent.data) temp.parent.left = temp.left;
                else temp.parent.right = temp.left;
                return true;
            }
        }
    }

    /**
     * This method finds the Successor to the Node given. Move right once and go left down the tree as
     * far as you can
     *
     * @param n Node that you want to find the Successor of
     * @return The Successor of the node
     */
    public Node findSuccessor(Node n) {
        if (n.right == null) return n;
        Node current = n.right;
        Node parent = n.right;
        while (current != null) {
            parent = current;
            current = current.left;
        }
        return parent;
    }

    /**
     * Returns the root of the Binary Tree
     *
     * @return the root of the Binary Tree
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Prints leftChild - root - rightChild
     *
     * @param localRoot The local root of the binary tree
     */
    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.left);
            System.out.print(localRoot.data + " ");
            inOrder(localRoot.right);
        }
    }

    /**
     * Prints root - leftChild - rightChild
     *
     * @param localRoot The local root of the binary tree
     */
    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.data + " ");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }

    /**
     * Prints rightChild - leftChild - root
     *
     * @param localRoot The local root of the binary tree
     */
    public void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.print(localRoot.data + " ");
        }
    }

    /**
     * 二叉树前序遍历   根-> 左-> 右
     *
     * @param node 二叉树节点
     */
    public static void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    /**
     * 二叉树中序遍历   左-> 根-> 右
     *
     * @param node 二叉树节点
     */
    public static void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    /**
     * 二叉树后序遍历   左-> 右-> 根
     *
     * @param node 二叉树节点
     */
    public static void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    /**
     * 层序遍历
     *
     * @param root 二叉树节点
     */
    public static void levelOrder(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.pop();
            System.out.print(root.data + " ");
            if (root.left != null) queue.add(root.left);
            if (root.right != null) queue.add(root.right);
        }
    }
}
