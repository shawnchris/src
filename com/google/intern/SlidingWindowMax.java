package com.google.intern;

import java.util.*;

public class SlidingWindowMax {
	// Priority Queue Solution
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0)
            return new int[]{};
        if (len <= k) {
            Arrays.sort(nums);
            return new int[]{nums[len-1]};
        }
        
        int[] result = new int[len - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            pq.add(-nums[i]);

        result[0] = -pq.peek();
        for (int i = k; i < len; i++) {
            pq.remove(-nums[i - k]);
            pq.add(-nums[i]);
            result[i-k+1] = -pq.peek();
        }
        
        return result;
    }
    
    // Monoqueue solution
	class MonoQueue {
		class Pair {
			public int first;
			public int second;
			Pair (int f, int s) {
				this.first = f;
				this.second = s;
			}
		}
		
		Deque<Pair> m_deque = new LinkedList<Pair>();
		
		void printQueue() {
			Pair[] a = m_deque.toArray(new Pair[m_deque.size()]);
			for (int i=0; i < a.length; i++)
				System.out.print("(" + a[i].first + "," + a[i].second + ") ");
			System.out.println();
		}
		
		public void push(int val) {
			int count = 0;
            while(!m_deque.isEmpty() && m_deque.peekLast().first < val) {
                count += m_deque.peekLast().second + 1;
                m_deque.pollLast();
            }
            m_deque.addLast(new Pair(val, count));
            
            System.out.print("push("+val+"): ");
            printQueue();
            
		}
		
		public int max() {
			System.out.println("max: " + m_deque.peek().first);
			
            return m_deque.peek().first;
        }
		
		public void pop () {
			System.out.print("pop: ");
            if (m_deque.peek().second > 0) {
                m_deque.peek().second --;
                printQueue();
                return;
            }
            m_deque.poll();
            
            printQueue();
        }
	}
	public int[] maxSlidingWindow2(int[] nums, int k) {
        int len = nums.length;
        if (len == 0)
            return new int[]{};
        if (len <= k) {
            Arrays.sort(nums);
            return new int[]{nums[len-1]};
        }
        
        int[] result = new int[len - k + 1];
        MonoQueue mq = new MonoQueue();
        for (int i = 0; i < k; i++)
            mq.push(nums[i]);

        result[0] = mq.max();
        for (int i = k; i < len; i++) {
        	mq.pop();
            mq.push(nums[i]);
            result[i-k+1] = mq.max();
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		SlidingWindowMax swm = new SlidingWindowMax();
		int[] input1 = {1,3,-1,-3,5,3,6,7,8,9,10,16,10,9,12,7,6,5,4,3};
		printResult(swm.maxSlidingWindow(input1, 6));
		printResult(swm.maxSlidingWindow2(input1, 6));
	}
	
	static void printResult(int[] result) {
		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
		System.out.println();
	}

}
