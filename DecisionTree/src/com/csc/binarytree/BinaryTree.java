package com.csc.binarytree;

import com.csc.interfaces.IBinaryTree;
import com.csc.interfaces.ITreeVisitor;

public class BinaryTree<T> implements IBinaryTree<T> {

	public BinaryTree(final int newNodeID, final T newData) {
		this.nodeID = newNodeID;
		this.data = newData;
		this.yesBranch = null;
		this.noBranch = null;
	}

	@Override
	public int getNodeID() {
		return this.nodeID;
	}

	@Override
	public T getData() {
		return this.data;
	}

	@Override
	public IBinaryTree<T> getYesBranch() {
		return this.yesBranch;
	}

	@Override
	public void setYesBranch(final IBinaryTree<T> yesBranch) {
		this.yesBranch = yesBranch;
	}

	@Override
	public IBinaryTree<T> getNoBranch() {
		return this.noBranch;
	}

	@Override
	public void setNoBranch(final IBinaryTree<T> noBranch) {
		this.noBranch = noBranch;
	}

	@Override
	public void accept(final ITreeVisitor<T> visitor) {
		visitor.visit(this);
	}
	
	private final int nodeID;
	private final T data;
	private IBinaryTree<T> yesBranch;
	private IBinaryTree<T> noBranch;
	public String temp;
}