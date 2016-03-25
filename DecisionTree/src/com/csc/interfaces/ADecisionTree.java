package com.csc.interfaces;

import java.util.function.Consumer;

import com.csc.binarytree.BinaryTree;
import com.csc.nodetypes.NodeType;

public abstract class ADecisionTree<T> implements IDecisionTree<T> {

	@Override
	public boolean addYesBranch(int existingNodeID, int newNodeID, T newData) {
		return addNode(existingNodeID, newNodeID, newData, NodeType.YES);
	}

	@Override
	public boolean addNoBranch(int existingNodeID, int newNodeID, T newData) {
		return addNode(existingNodeID, newNodeID, newData, NodeType.NO);
	}

	@Override
	public boolean isBalanced() {
		return isTreeBalanced(this.rootNode);
	}

	protected IBinaryTree<T> rootNode;
	protected ITreeVisitor<T> treeVisitor;

	private boolean addNode(int existingNodeID, int newNodeID, T newData,
			NodeType nodeType) {
		if (this.rootNode == null) {
			return false;
		}
		if (nodeType.equals(NodeType.YES)) {
			searchTreeAndAddNode(this.rootNode, existingNodeID, newNodeID,
					newData, node -> {
						if (node.getYesBranch() == null) {
							node.setYesBranch(
									new BinaryTree<>(newNodeID, newData));
						}
					});
			return true;
		}
		if (nodeType.equals(NodeType.NO)) {
			searchTreeAndAddNode(this.rootNode, existingNodeID, newNodeID,
					newData, node -> {
						if (node.getNoBranch() == null) {
							node.setNoBranch(
									new BinaryTree<>(newNodeID, newData));
						}
					});
			return true;
		}
		return false;
	}

	private boolean searchTreeAndAddNode(final IBinaryTree<T> currentNode,
			final int existingNodeID, final int newNodeID, final T newData,
			Consumer<IBinaryTree<T>> function) {

		boolean addStatus = false;
		if (currentNode.getNodeID() == existingNodeID) {
			function.accept(currentNode);
			addStatus = true;
		} else {
			if (currentNode.getYesBranch() != null) {
				if (searchTreeAndAddNode(currentNode.getYesBranch(),
						existingNodeID, newNodeID, newData, function)) {
					addStatus = true;
				} else {
					if (currentNode.getNoBranch() != null) {
						if (searchTreeAndAddNode(currentNode.getNoBranch(),
								existingNodeID, newNodeID, newData, function)) {
							addStatus = true;
						}
					}
				}
			}
		}
		return addStatus;
	}

	private boolean isTreeBalanced(IBinaryTree<T> currentNode) {
		if (currentNode.getYesBranch() == null
				&& currentNode.getNoBranch() == null) {
			return true;
		} else if (currentNode.getYesBranch() != null
				&& currentNode.getNoBranch() != null) {
			return isTreeBalanced(currentNode.getYesBranch())
					&& isTreeBalanced(currentNode.getNoBranch());
		} else {
			return false;
		}
	}

}
