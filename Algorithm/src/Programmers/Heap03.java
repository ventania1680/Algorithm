// https://programmers.co.kr/learn/courses/30/lessons/42627
// 20.7.17. ventania1680
// �켱���� ť�� �ذ��� �� �ִ� ����
package Programmers;

import java.util.*;
class job implements Comparable<job> { // �۾��� ������ Ŭ���� ����
	int req; // ��û �ð�
	int len; // �ҿ� �ð�
	public job(int req, int len) {
		this.req = req;
		this.len = len;
	}
	@Override
	public int compareTo(job o) {
		if (this.len == o.len) { // �۾� ���̰� ���� ���
			if (this.req < o.req) // ��û �ð��� ���� ������ ����
				return -1;
			return 1;
		}
		if (this.len < o.len) // �۾� ���̰� ª�� ������ ����
			return -1;
		return 1;
	}
}
public class Heap03 {
	public static int solution(int[][] jobs) {
		int answer = 0;
		Arrays.sort(jobs, Comparator.comparingInt(o1 -> o1[0])); // ��û�ð��� ������������ ����
		PriorityQueue<job> pq = new PriorityQueue<>(); // �۾� ��⿭
		int j = 0, time = 0; // j�� jobs�� index, time�� ���� ���� ���� �۾��� ������ �ð�
		job cur = null; // ���� ���� ���� �۾�
		for (int i = 0; i <= 1000000; i++) { // ���� ���ǿ� ���� �ִ� 100���ʱ��� �����
			while (j < jobs.length && jobs[j][0] <= i) { // ���� �ð� ������ ��û���� �۾��� ��⿭�� �߰�
				pq.add(new job(jobs[j][0], jobs[j++][1]));
			}
			if (pq.isEmpty() && cur == null) continue;
			if (time == 0)
				cur = pq.poll();
			else if (time == cur.len) { // ���� �۾��� �Ϸ��� ���
				answer += i - cur.req; // �ҿ� �ð��� ������
				if (j == jobs.length && pq.isEmpty()) break; // ���̻� ������ �۾��� ������ for�� Ż��
				cur = pq.poll(); // ��⿭���� ������ �۾��� ������
				time = 0; // ���� �ð��� 0���� �ʱ�ȭ
			}
			if (cur != null) time++;
		} // for�� ��
		return (int)Math.ceil(answer/jobs.length); // �ҿ� �ð��� ��� ���� ���� �� �۾��� ���� ������ �Ҽ����� ���� ����� ��ȯ
	}
}
