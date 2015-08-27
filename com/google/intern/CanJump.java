package com.google.intern;

public class CanJump {
	public boolean canJump(int[] nums) {
        if (nums == null) return false;
        int len = nums.length;
        if (len == 0) return false;
        if (len == 1) return true;
        
        int[] steps = new int[len];
        int pointer = 0;
        steps[0] = nums[0];
        
        while (pointer >= 0) {
            if (pointer + steps[pointer] >= len - 1)
                return true;
            if (steps[pointer] > 0) { //forward the pointer
                pointer += steps[pointer];
                steps[pointer] = nums[pointer];
            }
            else { // backtrack
                while (pointer >=0 && steps[pointer] == 0)
                    pointer --;
                if (pointer >= 0)
                    steps[pointer]--;
            }
            
        }
        
        return false;
    }
	public static void main(String[] args) {
		CanJump cj = new CanJump();
		int[] input1 = {2,0,6,9,8,4,5,0,8,9,1,2,9,6,8,8,0,6,3,1,2,2,1,2,6,5,3,1,2,2,6,4,2,4,3,0,0,0,3,8,2,4,0,1,2,0,1,4,6,5,8,0,
				7,9,3,4,6,6,5,8,9,3,4,3,7,0,4,9,0,9,8,4,3,0,7,7,1,9,1,9,4,9,0,1,9,5,7,7,1,5,8,2,8,2,6,8,2,2,7,5,1,7,9,6};
		
		System.out.println(cj.canJump(input1));
	}

}
