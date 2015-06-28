package com.leetcode.oj;

public class WildcardMatching {
	
	public boolean isMatch(String s, String p) {
		int slen = s.length();
		int plen = p.length();
		int sp=0, pp=0, matchp=0, starp=-1;
		
		while (sp<slen) {
			if (pp<plen && (s.charAt(sp)==p.charAt(pp) || p.charAt(pp)=='?')) {
				sp++; pp++;
			}
			else if (pp<plen && p.charAt(pp)=='*') {
				starp=pp;
				matchp=sp;
				//sp++;
				pp++;
			}
			else if(starp!=-1) {
				pp = starp+1;
				matchp++;
				sp=matchp;
			}
			else
				return false;
		}
		
		while (pp<plen && p.charAt(pp)=='*')
			pp++;
		
		return (pp==plen);
	}
	
	public static void main(String[] args) {
		String[][] test ={
				{"aa","aa"},
				{"aa","a"},
				{"aaa", "aa"},
				{"aab", "c*a*b"},
				{"a", "aa"},
				{"aa", "aaa"},
		};
		
		WildcardMatching wm = new WildcardMatching();
		
		System.out.println(wm.isMatch2("ab", "*a"));
		System.out.println(wm.isMatch("ab", "*a"));
		for(int i=0; i<test.length; i++)
			System.out.println("'"+test[i][0]+"' , '"+test[i][1]+"' -> "+wm.isMatch(test[i][0], test[i][1]));

	}
	
	public boolean isMatch2(String str, String pattern) {
		int s = 0, p = 0, match = 0, starIdx = -1;            
        while (s < str.length()){
            // advancing both pointers
            if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if (p < pattern.length() && pattern.charAt(p) == '*'){
                starIdx = p;
                match = s;
                p++;
            }
           // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                p = starIdx + 1;
                match++;
                s = match;
            }
           //current pattern pointer is not star, last patter pointer was not *
          //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*')
            p++;

        return p == pattern.length();
	}

}
