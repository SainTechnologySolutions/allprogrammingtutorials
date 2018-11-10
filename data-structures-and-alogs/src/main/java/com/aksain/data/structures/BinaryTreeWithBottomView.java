package com.aksain.data.structures;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BinaryTreeWithBottomView<T extends Comparable<T>> {
	private Node root;

	private class Node {
		T data;
		Node left;
		Node right;

		private Node(T data) {
			this.data = data;
		}
	}
	
	private class NodeWithDistance {
		Node node;
		int hDistance;
		
		private NodeWithDistance(Node node, int hDistance) {
			this.node = node;
			this.hDistance = hDistance;
		}
	}

	private Node doInsert(T data, Node node) {
		if (node == null) {
			return new Node(data);
		}
		int result = data.compareTo(node.data);
		if (result < 0) {
			node.left = doInsert(data, node.left);
		} else if (result > 0) {
			node.right = doInsert(data, node.right);
		}

		return node;
	}

	public void insert(T data) {
		root = doInsert(data, root);
	}

	private void doPrintBottomView(Node root) {
		final Map<Integer, T> distanceWiseData = new HashMap<>();
		
		final Queue<NodeWithDistance> queue = new LinkedList<>();
		queue.add(new NodeWithDistance(root, 0));
		
		while(!queue.isEmpty()) {
			int noOfElementsAtThisLevel = queue.size();
			for(int index = 0; index < noOfElementsAtThisLevel; index++) {
				final NodeWithDistance tmpWithDistance = queue.poll();
				final Node tmp = tmpWithDistance.node;
				distanceWiseData.put(tmpWithDistance.hDistance, tmp.data);
				
				if(tmp.left != null) {
					queue.add(new NodeWithDistance(tmp.left, tmpWithDistance.hDistance - 1));
				}
				if(tmp.right != null) {
					queue.add(new NodeWithDistance(tmp.right, tmpWithDistance.hDistance + 1));
				}
			}
		}
		
		System.out.println(distanceWiseData);
	}

	public void printBottomView() {
		doPrintBottomView(root);
	}

	public static void main(String[] args) {
		final BinaryTreeWithBottomView<Integer> binaryTree = new BinaryTreeWithBottomView<>();
		binaryTree.insert(50);
		binaryTree.insert(30);
		binaryTree.insert(10);
		binaryTree.insert(20);
		binaryTree.insert(40);
		binaryTree.insert(70);
		binaryTree.insert(60);
		binaryTree.insert(80);
		binaryTree.insert(90);

		binaryTree.printBottomView();
	}

}
