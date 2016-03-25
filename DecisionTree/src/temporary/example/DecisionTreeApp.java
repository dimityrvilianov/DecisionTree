package temporary.example;

import com.csc.decisiontree.RandomNumberDecisionTree;

class DecisionTreeApp {

	static RandomNumberDecisionTree newTree;

	public static void main(String[] args) throws Exception {
		newTree = new RandomNumberDecisionTree(0, new Random1());
		newTree.addYesBranch(0, 1, new Random2());
		newTree.addNoBranch(0, 2, new Random3());
		newTree.addYesBranch(1, 3, new Random4());
		newTree.addNoBranch(1, 4, new Random5());

		System.out.println(newTree.isBalanced());

		newTree.queryTree();
	}
}