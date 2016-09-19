package com.hanbit.web.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PreLambdaList {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
		PreLambdaList p = new PreLambdaList();
		System.out.println("전체 합 "+p.sumElems(numbers, n->true));
		System.out.println("짝수 합 "+p.sumElems(numbers, n->n%2==0));
		System.out.println("홀수 합 "+p.sumElems(numbers, n->n%2==1));
		
	}
public int sumElems(List<Integer>list,Predicate<Integer>p){
	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
	int sum = 0;
	for (int num : numbers) {
		if (p.test(num)) {
			sum+=num;
		}
		
	}
		return sum;
}
	
////=======옛날방식=========

//	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
//
//	public void printElem() {
//		for (int num : numbers) {
//			System.out.println(num);
//		}
//	}
//	public int sumAll(){
//		int sum = 0;
//		for (int num : numbers) {
//			sum += num;
//		}
//		return sum;
//		
//	}
//
//	public int sumEven(){
//		int sum = 0;
//		for (int num : numbers) {
//			if (num%2==0) {
//				sum +=num;
//			}
//		}
//		return sum;
//		
//	}
//	public int sumOdd(){
//		int sum = 0;
//		for (int num : numbers) {
//			if (num%2!=0) {
//				sum += num;
//			}
//		}
//		return sum;
//	}

	
}