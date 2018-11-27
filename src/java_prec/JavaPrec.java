package java_prec;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaPrec {

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] result = twoSum(nums, target);
		for(int i:result){
			//System.out.print(i+",");
		}
		
		ListNode n1 = new ListNode(8);
		ListNode n11 = new ListNode(9);
		ListNode n12 = new ListNode(9);
		n11.next = n12;
		n1.next = n11;
		ListNode n2 = new ListNode(2);
		ListNode n21 = new ListNode(6);
		ListNode n22 = new ListNode(4);
		n21.next = n22;
		n2.next = n21;
		addTwoNumbers(n1,n2);
		
		int lengthOfLongestSubstring = lengthOfLongestSubstring("abcabcbb");
		//System.out.println(lengthOfLongestSubstring);
		
		int[] num41 = {3};
		int[] num42 = {-2,-1};
		double findMedianSortedArrays = findMedianSortedArrays(num41,num42);
		
	}
	public static int[] twoSum(int[] nums, int target) {
        
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> list1 = new ArrayList<Integer>();
        for(int i:nums){
        	list.add(i);
        }
        for(int m=0;m<list.size();m++){
        	for(int n=0;n<list.size();n++){
        		int mval = list.get(m);
        		int nval = list.get(n);
        		if(m!=n && (mval+nval)==target){
        			list1.add(m);
        		}
        	}
        }
        
        int[] result = new int[list1.size()];
        for(int n=0;n<list1.size();n++){
            result[n] = list1.get(n);
        }
        return result;
    }

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		List<Integer> val1 = new ArrayList<Integer>();
		
		val1.add(l1.val);
		while(l1.next!=null){
			val1.add(l1.next.val);
			if(l1.next.next!=null){
				l1.next = l1.next.next;
			}else{
				l1.next = null;
			}
		}
		List<Integer> val2 = new ArrayList<Integer>();
		
		val2.add(l2.val);
		while(l2.next!=null){
			val2.add(l2.next.val);
			if(l2.next.next!=null){
				l2.next = l2.next.next;
			}else{
				l2.next = null;
			}
		}
		Collections.reverse(val1);
		Collections.reverse(val2);
		
		List<Integer> max = new ArrayList<Integer>();
		List<Integer> min = new ArrayList<Integer>();
		if(val1.size()>=val2.size()){
			max = val1;
			min = val2;
		}else{
			max = val2;
			min = val1;
		}
		int t = 0;
		List<Integer> result = new ArrayList<Integer>();
		int msize = 0;
		for(int i=(max.size()-1);i>=0;i--){
			msize++;
			int mm = max.get(i);
			if(msize<=min.size()){
				int nn = min.get((min.size()-msize));
				int plus = mm+nn+t;
				if(plus>=10){
					result.add(plus%10);
					t = 1;
				}else{
					result.add(plus);
					t = 0;
				}
			}else{
				if((mm+t)>=10){
					result.add((mm+t)%10);
					t = 1;
				}else{
					result.add(mm+t);
					t = 0;
				}
			}
		}
		if(t>0){
			result.add(t);
		}
		
		Collections.reverse(result);
		ListNode resultNode = null;
		for(int i:result){
			//后一个
			ListNode te = new ListNode(i);
			if(resultNode==null){
				resultNode = te;
			}else{
				te.next = resultNode;
				resultNode = te;
			}
		}
		
        return resultNode;
    }
	public static int lengthOfLongestSubstring(String s) {
		char[] sc = s.toCharArray();
		int len = 0;
		for(int i=0;i<sc.length;i++){
			List temp = new ArrayList();
			temp.add(sc[i]);
			if(temp.size()>len){
				len = temp.size();
			}
			for(int j=(i+1);j<sc.length;j++){
				if(!temp.contains(sc[j])){
					temp.add(sc[j]);
					if(temp.size()>len){
						len = temp.size();
					}
				}else{
					break;
				}
			}
		}
		
        return len;
    }
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] numsAll = new int[nums1.length+nums2.length];
        for(int i=0;i<nums1.length;i++){
        	numsAll[i] = nums1[i];
        }
        for(int j=0;j<nums2.length;j++){
        	numsAll[nums1.length+j] = nums2[j];
        }
        for(int n=0;n<numsAll.length-1;n++){
        	for(int m=0;m<numsAll.length-1-n;m++){
        		int n1 = numsAll[m];
        		int n2 = numsAll[m+1];
        		if(n1>n2){
        			numsAll[m] = n2;
        			numsAll[m+1] = n1;
        		}
        	}
        }
        double result = 0.0;
        if(numsAll.length%2==0){
        	double d1 = numsAll[numsAll.length/2-1];
        	double d2 = numsAll[numsAll.length/2];
        	result = (d1+d2)/2;
        }else{
        	result = numsAll[numsAll.length/2];
        }
        System.out.println(result);
		return result;
    }
}

