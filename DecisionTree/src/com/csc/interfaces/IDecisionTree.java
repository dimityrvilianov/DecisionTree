package com.csc.interfaces;

public interface IDecisionTree<T> {

	boolean addYesBranch(int existingNodeID, int newNodeID, T newData);

	boolean addNoBranch(int existingNodeID, int newNodeID, T newData);

	boolean isBalanced();

	void queryTree() throws Exception;
}
