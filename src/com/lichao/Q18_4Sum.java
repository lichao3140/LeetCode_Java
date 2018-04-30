package com.lichao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author ChaoLi
 * @date 2018��4��30��-����2:25:21
 * @email 396229938@QQ.com
 */
public class Q18_4Sum {

	public static void main(String[] args) {
		//����Integer���飬Ĭ��ֵΪ4��
		Integer[] readNums = new Integer[4]; 
		//ʹ��Scanner��system in�� 
		Scanner scanner = new Scanner(System.in); 
		for(int i=0;i<4;i++){ 
			//��ȡ���ַ�������ĵ�i��Ԫ�� 
			readNums[i]=scanner.nextInt(); 
			//ͨ��������Կ������鱻һ��һ����ֵ�ˣ�ʵ��ʹ���в���Ҫ��ӡ
			System.out.println(Arrays.asList(readNums));
		}
	}
	
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 4) {
			return res;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) { // ȥ��
				for (int j = 0; j < nums.length - 2; j++) {
					if (j == i + 1 || nums[j] != nums[j - 1]) { // ȥ��
						int begin = j + 1;
						int end = nums.length - 1;
						int newTarget = target - nums[i] - nums[j];
						while(begin < end) {
							if (nums[begin] + nums[end] == newTarget) {
								res.add(Arrays.asList(nums[i], nums[j], nums[begin], nums[end]));
								while (begin < end && nums[begin] == nums[begin + 1]) begin++;
								while (begin < end && nums[end] == nums[end - 1]);
							} else if (nums[begin] + nums[end] > newTarget) {
								end--;
							} else {
								begin++;
							}
						}
					}
				}
			}
		}
		return res;
	}

}
