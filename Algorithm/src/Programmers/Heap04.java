// https://programmers.co.kr/learn/courses/30/lessons/42628
// 20.7.27. ventania1680
// 우선순위 큐를 오름차순, 내림차순 정렬로 두 개 사용
package Programmers;

import java.util.*;

public class Heap04 {
	public static int[] solution (String[] operations) {
		int[] answer = {0, 0}; // idx0은 최댓값, idx1은 최솟값. 큐가 비어있는 경우 각각 0을 반환
		PriorityQueue<Integer> inc = new PriorityQueue<>(); // 자바 우선순위 큐 클래스는 기본 오름차순 정렬
		PriorityQueue<Integer> dec = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 정렬로 변경
		StringTokenizer st;
		for (int i = 0; i < operations.length; i++) { // 0에서 시작하여 operations 배열의 모든 원소를 참조
			st = new StringTokenizer(operations[i]);
			if (st.nextToken().equals("I")) { // 큐에 새로운 원소 삽입
				int n = Integer.parseInt(st.nextToken());
				inc.add(n);
				dec.add(n);
			}
			else {
				if (inc.isEmpty()) continue; // 큐가 비어있을 때 삭제요청이 오면 무시
				else if (st.nextToken().equals("1")) { // 최댓값을 삭제하는 경우
					if (inc.contains(dec.peek()))
						inc.remove(dec.poll());
					else
						dec.poll();
				}
				else { // 최솟값을 삭제하는 경우
					if (dec.contains(inc.peek()))
						dec.remove(inc.poll());
					else
						inc.poll();
				}
			}
		}
		if (!inc.isEmpty()) { // 큐가 비어있지 않은 경우에 최댓값과 최솟값을 answer 배열에 각각 할당
				answer[0] = dec.peek();
				answer[1] = inc.peek();
		}
		return answer;
	}
}
