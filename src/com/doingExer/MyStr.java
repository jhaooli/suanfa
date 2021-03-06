package com.doingExer;

import java.util.LinkedHashMap;
import java.util.Map;

public class MyStr {

	
	/**
	 * 编写一个函数，其作用是将输入的字符串反转过来。

	示例 1:

	输入: "hello"
	输出: "olleh"
	示例 2:

	输入: "A man, a plan, a canal: Panama"
	输出: "amanaP :lanac a ,nalp a ,nam A"
	 * @param s
	 * @return
	 */
	 public String reverseString(String s) {
	        char[] chs = s.toCharArray();
	        char[] tmp = new char[s.length()];
	        String reverseStr = null;
	        for(int i=0,j=chs.length-1;i<chs.length;i++) {
	        	tmp[i] = chs[j];
	        	j--;
	        }
	        reverseStr = String.valueOf(tmp);
	        return reverseStr;
	    }
	 
	 
	 /**
	 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

	案例:

	s = "leetcode"
	返回 0.

	s = "loveleetcode",
	返回 2.
	  * @param s
	  * @return
	  * 	通过率9/104
	  */
	 public int firstUniqChar(String s) {
	        //一层循环做慢指针遍历
		 	//内层循环做快指针做对比
		 char[] ch = s.toCharArray();
		 for(int i=0;i<ch.length;i++) {
			 for(int j=0;j<ch.length;j++) {
				 if(ch[j]==ch[i]) {
					 break;
				 }
				 return i;
			 }
		 }//out of end 
		 
		 return -1;
	    }
	 
	 /**
	  * 	上一题的答案
	  * @param s
	  * @return
	  */
	 public int firstUniqChar2(String s) {
         Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
         char[] arr = s.toCharArray();
         for(int i =0;i<arr.length;i++){
             if(!map.containsKey(arr[i])){
                 map.put(arr[i],i);
             }else{
                 map.put(arr[i],-1);
             }
         }
         for(Map.Entry<Character,Integer> entry :map.entrySet()){
             if(entry.getValue()!=-1){
                 return entry.getValue();
             }
         }
         return -1;
     }

	 
	 /**
	  * 	请你来实现一个 atoi 函数，使其能将字符串转换成整数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。

当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。

该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。

注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。

在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：

假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，qing返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

示例 1:

输入: "42"
输出: 42
示例 2:

输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
示例 3:

输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
示例 4:

输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。
示例 5:

输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。 
     因此返回 INT_MIN (−231) 。
	  * @param str
	  * @return
	  */
	 public int myAtoi(String str) {
		 return (str!=null && !str.equals(""))?Integer.parseInt(str.trim()):-1;
	    }
	 
	 
	 /**
	  * 实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
	  * @param haystack
	  * @param needle
	  * @return
	  */
	 public int strStr(String haystack, String needle) {
	        
		 if(needle.trim()=="") return -1;
//		 if(needle.equals("")||haystack.equals(needle)){
//	            return 0;
//	        }
	        int index=-1;
	        if(haystack.contains(needle)){
	            String[] str=haystack.split(needle);
	            if(str.length>=1){
	                index=str[0].length();
	            }else {
	                index=0;
	            }
	        }else{
	                index=-1;
	            }
	        return index;
	
		 
	    }
}
