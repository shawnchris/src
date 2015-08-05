package com.google.intern;

import java.util.*;

public class ContainsDuplicate3 {
	static Set<Integer> set = new HashSet<Integer>();
    
    boolean hasNearbyAD(int i, int t) {
        if (set == null) return false;
        int len = set.size();
        if (len == 0) return false;
        if (len > t) {
            for (int j = -1 * t; j <= t; j++)
                if (set.contains(i + j))
                    return true;
        }
        else {
            for (int j : set)
                if (Math.abs(i - j) <= t)
                    return true;
        }
        return false;
    }
    
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        boolean result = false;
        int len = nums.length;
        if (len <= 1) return result;
        
        set.clear();
        for (int i = 0; i < len; i++) {
            if (set.size() > k)
                set.remove(nums[i - k]);
            if (hasNearbyAD(nums[i], t)) {
                result = true;
                break;
            }
            set.add(nums[i]);
        }
        
        return result;
    }
    
	public static void main(String[] args) {
		ContainsDuplicate3 cd = new ContainsDuplicate3();
		int[] nums1 = {0,2147483647};
		System.out.println(cd.containsNearbyAlmostDuplicate(nums1, 1, 2147483647));
	}

}
