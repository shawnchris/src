package com.leetcode.oj;

import java.util.*;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
public class CloneGraph {
	HashMap<Integer, UndirectedGraphNode> map = new HashMap();

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node==null) return null;

		// create new node and search its all neighbors
		UndirectedGraphNode p = new UndirectedGraphNode(node.label);
		map.put(Integer.valueOf(p.label), p);

		// loop all neighbors
		for(UndirectedGraphNode n : node.neighbors)
		{
			// hook already created and searched node
			if(map.containsKey(n.label))
				p.neighbors.add(map.get(n.label));
			else
				p.neighbors.add(cloneGraph(n));
		}
		return p;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
