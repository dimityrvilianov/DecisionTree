package com.csc.interfaces;

public interface IBinaryTree<T> extends IVisitable<T> {

	int getNodeID();

	T getData();

	IBinaryTree<T> getYesBranch();

	void setYesBranch(IBinaryTree<T> yesBranch);

	IBinaryTree<T> getNoBranch();

	void setNoBranch(IBinaryTree<T> noBranch);
}
