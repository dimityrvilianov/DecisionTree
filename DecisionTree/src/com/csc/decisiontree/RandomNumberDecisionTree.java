package com.csc.decisiontree;

import java.io.IOException;

import com.csc.binarytree.BinaryTree;
import com.csc.implementations.PrintVisitor;
import com.csc.interfaces.ADecisionTree;
import com.csc.interfaces.IBinaryTree;

import temporary.example.IRandomNumber;

public class RandomNumberDecisionTree extends ADecisionTree<IRandomNumber> {

	public RandomNumberDecisionTree(final int newNodeID,
			final IRandomNumber newData) {
		this.rootNode = new BinaryTree<>(newNodeID, newData);
		this.treeVisitor = new PrintVisitor<>();
	}

	@Override
	public void queryTree() throws Exception {
		queryBinTree(this.rootNode);

	}

	private void queryBinTree(final IBinaryTree<IRandomNumber> currentNode)
			throws IOException {

		currentNode.accept(this.treeVisitor);

		if (currentNode.getData().isHigherThan50()
				&& currentNode.getYesBranch() != null) {
			queryBinTree(currentNode.getYesBranch());
		} else {
			if (currentNode.getNoBranch() != null) {
				queryBinTree(currentNode.getNoBranch());
			}
		}
	}
}