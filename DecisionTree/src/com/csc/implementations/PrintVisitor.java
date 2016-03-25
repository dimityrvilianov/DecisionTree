package com.csc.implementations;

import com.csc.interfaces.IBinaryTree;
import com.csc.interfaces.ITreeVisitor;

public class PrintVisitor<T> implements ITreeVisitor<T> {

	@Override
	public void visit(IBinaryTree<T> binaryTree) {
		System.out.println("nodeID = " + binaryTree.getNodeID() //$NON-NLS-1$
				+ " Class = " + binaryTree.getData().getClass()); //$NON-NLS-1$
		// + ", question/answer = " + binaryTree.getData()); //$NON-NLS-1$
	}
}
