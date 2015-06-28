package com.leetcode.oj;

import java.util.*;

public class FourSum {
	
	//Traditional way
	public List<List<Integer>> fourSum1(int[] num, int target) {
        List<List<Integer>> results = new LinkedList<List<Integer>>();
        if (num == null || num.length < 4)
            return results;
        Arrays.sort(num);

        for (int s = 0; s < num.length - 3; s++) {
            if (s > 0 && num[s] == num[s - 1])  continue;


            for (int e = num.length - 1; e >= s + 3; e--) {
                if (e < num.length - 1 && num[e] == num[e + 1]) continue;

                int local = target - num[s] - num[e];
                int j = s + 1;
                int k = e - 1;
                while (j < k) {

                    if (j > s + 1 && num[j] == num[j - 1]) {
                        j++;
                        continue;
                    }
                    if (k < e - 1 && num[k] == num[k + 1]) {
                        k--;
                        continue;
                    }

                    if ((num[j] + num[k]) > local)
                        k--;
                    else if ((num[j] + num[k]) < local)
                        j++;
                    else
                        results.add(new ArrayList<Integer>(Arrays.asList(
                                num[s], num[j++], num[k--], num[e])));
                }
            }
        }
        return results;
    }
	
	/*O(N^2 logN) solution
	 * The target can be the sum of two pairs of numbers. So first I calculate what numbers 
	 * I can get using a pair of numbers. Then the question is like two sum.
	 * I use TreeMap<Integer, List> to store what pairs of numbers I can use to get the number. 
	 * Then I iterate the map. When I find two lists of pairs can get the target, I cross join the pairs.
	*/
	class Pair {
        int a;
        int ai;
        int b;
        int bi;
        public Pair(int a, int ai, int b, int bi){
            this.a = a;
            this.ai = ai;
            this.b = b;
            this.bi = bi;
        }
        boolean same(Pair p){
            return p != null && p.a == a && p.b == b;
        }
    }
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(num.length < 4){
            return res;
        }
        Arrays.sort(num);
        TreeMap<Integer, List<Pair>> map = new TreeMap<>();
        for(int i = 0; i < num.length; i++){
            for(int j = i + 1; j < num.length; j++){
                Pair pair = new Pair(num[i], i, num[j], j);
                int sum = num[i] + num[j];
                List<Pair> list;
                if(map.containsKey(sum)){
                    list = map.get(sum);
                }
                else{
                    list = new ArrayList<>();
                    map.put(sum, list);
                }
                list.add(pair);
            }
        }
        Integer first = map.firstKey();
        Integer last = map.lastKey();
        while(first != null && last != null && first <= last){
            if(first + last > target){
                last = map.lowerKey(last);
            }
            else if(first + last < target){
                first = map.higherKey(first);
            }
            else if(first == last){
                List<Pair> list = map.get(first);
                for(int i = 0; i < list.size(); i++){
                    Pair a = list.get(i);
                    if(a.a == a.b){
                        for(int j = i + 1; j < list.size(); j++){
                            Pair b = list.get(j);
                            if(b.a == b.b){
                                if(a.bi < b.ai){
                                    res.add(Arrays.asList(new Integer[]{a.a, a.b, b.a, b.b}));
                                    break;
                                }
                            }
                            else{
                                break;
                            }
                        }
                        break;
                    }
                }
                last = map.lowerKey(last);
                first = map.higherKey(first);
            }
            else{
                Pair lastA = null;
                for(Pair a : map.get(first)){
                    if(a.same(lastA)){
                        continue;
                    }
                    lastA = a;
                    Pair lastB = null;
                    for(Pair b: map.get(last)){
                        if(a.bi < b.ai){
                            if(b.same(lastB)){
                                continue;
                            }
                            lastB = b;
                            res.add(Arrays.asList(new Integer[]{a.a, a.b, b.a, b.b}));
                        }
                    }
                }
                last = map.lowerKey(last);
                first = map.higherKey(first);
            }
        }
        return res;
    }
	public static void main(String[] args) {

	}

}
