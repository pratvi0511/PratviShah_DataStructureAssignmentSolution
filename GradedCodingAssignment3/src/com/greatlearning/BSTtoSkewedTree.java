package com.greatlearning;
//import java.util.*;

public class BSTtoSkewedTree {
	
	public static Node node;
    static Node prevNode = null;
    static Node headNode = null;
    
	// BST node
	static class Node {
		
		int key;
		Node left;
		Node right;
	};
			
	// creation of new node
	static Node newNode(int data) {
		
		Node temp = new Node();
		
		temp.key = data;
		temp.left = null;
		temp.right = null;
		
		return temp;
	};
			
	static Node insert(Node root, int key) {
		Node newnode = newNode(key);
		Node x = root;
		Node current_parent = null;
		while (x != null) {
			current_parent = x;
			if (key < x.key)
				x = x.left;
			else if (key > x.key)
				x = x.right;
			else {
				System.out.println("Value already exists!!!");
				return newnode;
			}
		}
				
		// If the root is null, the tree is empty.
		if (current_parent == null)
			current_parent = newnode;
		
		// assign new node node to the left child
		else if (key < current_parent.key)
			current_parent.left = newnode;
		
		// assign the new node to the right child
		else
			current_parent.right = newnode;
		
		// return pointer to new node
		return current_parent;
	}
	
	static void flattenBSTToSkewed(Node root) {
		//Base case
		if(root == null)
        {
            return;
        }
		
		flattenBSTToSkewed(root.left);
		Node rightNode = root.right;
        //Node leftNode = root.left;
        
        //Condition to check if the root Node of the skewed tree is not defined.
        if(headNode == null)
        {
            headNode = root;
            root.left = null;
            prevNode = root;
        }
        else
        {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }
		
        flattenBSTToSkewed(rightNode);
	}
	
	// Function to traverse the right skewed tree using recursion.
	static void traverseRightSkewed(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.key + " ");
        traverseRightSkewed(root.right);       
    }

	public static void main(String[] args) {
		
		Node root = newNode(50);
		root.left = newNode(30);
		root.right = newNode(60);
		root.left.left = newNode(10);
		root.right.left = newNode(55);
			
		System.out.println("The output after the conversion of the BST to the Right Skewed Tree travesal is as follows: ");
		flattenBSTToSkewed(root);
        traverseRightSkewed(headNode);
	}
}
