// https://programmers.co.kr/learn/courses/30/lessons/42627
// 20.7.17. ventania1680
// 우선순위 큐로 해결할 수 있는 문제
package Programmers;

import java.util.*;
class job implements Comparable<job> { // 작업을 저장할 클래스 선언
	int req; // 요청 시각
	int len; // 소요 시간
	public job(int req, int len) {
		this.req = req;
		this.len = len;
	}
	@Override
	public int compareTo(job o) {
		if (this.len == o.len) { // 작업 길이가 같은 경우
			if (this.req < o.req) // 요청 시각이 빠른 순으로 정렬
				return -1;
			return 1;
		}
		if (this.len < o.len) // 작업 길이가 짧은 순으로 정렬
			return -1;
		return 1;
	}
}
public class Heap03 {
	public static int solution(int[][] jobs) {
		int answer = 0;
		Arrays.sort(jobs, Comparator.comparingInt(o1 -> o1[0])); // 요청시간의 오름차순으로 정렬
		PriorityQueue<job> pq = new PriorityQueue<>(); // 작업 대기열
		int j = 0, time = 0; // j는 jobs의 index, time은 현재 수행 중인 작업을 수행한 시간
		job cur = null; // 현재 수행 중인 작업
		for (int i = 0; i <= 1000000; i++) { // 문제 조건에 의해 최대 100만초까지 고려함
			while (j < jobs.length && jobs[j][0] <= i) { // 현재 시각 이전에 요청받은 작업을 대기열에 추가
				pq.add(new job(jobs[j][0], jobs[j++][1]));
			}
			if (pq.isEmpty() && cur == null) continue;
			if (time == 0)
				cur = pq.poll();
			else if (time == cur.len) { // 현재 작업을 완료한 경우
				answer += i - cur.req; // 소요 시간을 더해줌
				if (j == jobs.length && pq.isEmpty()) break; // 더이상 수행할 작업이 없으면 for문 탈출
				cur = pq.poll(); // 대기열에서 진행할 작업을 가져옴
				time = 0; // 수행 시간을 0으로 초기화
			}
			if (cur != null) time++;
		} // for문 끝
		return (int)Math.ceil(answer/jobs.length); // 소요 시간을 모두 더한 값을 총 작업의 수로 나누고 소수점을 버린 결과를 반환
	}
}
