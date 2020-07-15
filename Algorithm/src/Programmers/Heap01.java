// https://programmers.co.kr/learn/courses/30/lessons/42626
// 20.7.15. ventania1680
package Programmers;

import java.util.PriorityQueue;

public class Heap01 {
	public static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < scoville.length; i++) {
			pq.add(scoville[i]);
		}
		int answer = 0;
		while(pq.peek() < K) {
			if (pq.size() < 2) return -1;
			int mixed = pq.poll();
			mixed += pq.poll()*2;
			pq.add(mixed);
			answer++;
		}
		return answer;
	}
}
