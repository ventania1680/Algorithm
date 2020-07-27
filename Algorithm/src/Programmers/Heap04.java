// https://programmers.co.kr/learn/courses/30/lessons/42628
// 20.7.27. ventania1680
// �켱���� ť�� ��������, �������� ���ķ� �� �� ���
package Programmers;

import java.util.*;

public class Heap04 {
	public static int[] solution (String[] operations) {
		int[] answer = {0, 0}; // idx0�� �ִ�, idx1�� �ּڰ�. ť�� ����ִ� ��� ���� 0�� ��ȯ
		PriorityQueue<Integer> inc = new PriorityQueue<>(); // �ڹ� �켱���� ť Ŭ������ �⺻ �������� ����
		PriorityQueue<Integer> dec = new PriorityQueue<>(Collections.reverseOrder()); // �������� ���ķ� ����
		StringTokenizer st;
		for (int i = 0; i < operations.length; i++) { // 0���� �����Ͽ� operations �迭�� ��� ���Ҹ� ����
			st = new StringTokenizer(operations[i]);
			if (st.nextToken().equals("I")) { // ť�� ���ο� ���� ����
				int n = Integer.parseInt(st.nextToken());
				inc.add(n);
				dec.add(n);
			}
			else {
				if (inc.isEmpty()) continue; // ť�� ������� �� ������û�� ���� ����
				else if (st.nextToken().equals("1")) { // �ִ��� �����ϴ� ���
					if (inc.contains(dec.peek()))
						inc.remove(dec.poll());
					else
						dec.poll();
				}
				else { // �ּڰ��� �����ϴ� ���
					if (dec.contains(inc.peek()))
						dec.remove(inc.poll());
					else
						inc.poll();
				}
			}
		}
		if (!inc.isEmpty()) { // ť�� ������� ���� ��쿡 �ִ񰪰� �ּڰ��� answer �迭�� ���� �Ҵ�
				answer[0] = dec.peek();
				answer[1] = inc.peek();
		}
		return answer;
	}
}
