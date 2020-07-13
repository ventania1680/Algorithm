// https://programmers.co.kr/learn/courses/30/lessons/42584
// 20.7.13. ventania1680
package Programmers;

import java.util.PriorityQueue;

class item implements Comparable<item> {
	int price;
	int sec;
	public item(int price, int sec) {
		this.price = price;
		this.sec = sec;
	}
	@Override
	public int compareTo(item o) {
		if (this.price < o.price)
			return 1;
		return -1;
	}
	
}

public class SQ05 {
	public static int[] solution(int[] prices) {
		int size = prices.length;
		int[] answer = new int[size];
		PriorityQueue<item> q = new PriorityQueue<item>();
		for (int i = 0; i < size; i++) {
			answer[i] = size - i - 1;
			q.add(new item(prices[i], i));
			while(!q.isEmpty()) {
				item tmp = q.peek();
				if (prices[i] < tmp.price) {
					answer[tmp.sec] = i - tmp.sec;
					q.poll();
				}
				else
					break;
			}
		}
		return answer;
	}
}
