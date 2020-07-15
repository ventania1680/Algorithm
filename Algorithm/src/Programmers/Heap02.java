// https://programmers.co.kr/learn/courses/30/lessons/42629
// 20.7.15. ventania1680
package Programmers;

import java.util.*;

class pair implements Comparable<pair> {
	int date;
	int supply;
	public pair(int date, int supply) {
		this.date = date;
		this.supply = supply;
	}
	@Override
	public int compareTo(pair o) {
		// TODO Auto-generated method stub
		if (this.supply > o.supply)
			return -1;
		else if (this.supply < o.supply)
			return 1;
		if (this.date < o.date)
			return -1;
		return 1;
	}
}

public class Heap02 {
	public static int solution (int stock, int[] dates, int[] supplies, int k) {
		List<pair> list = new ArrayList<>();
		for (int i = 0; i < dates.length; i++) {
			list.add(new pair(dates[i], supplies[i]));
		}
		Collections.sort(list);
		int answer = 0;
		int day = 0;
		while(k > stock + day) {
			for (int i = 0; i < list.size(); i++) {
				pair tmp = list.get(i);
				if (stock + day >= tmp.date) {
					stock = stock + day - tmp.date + tmp.supply;
					list.remove(i);
                    day = tmp.date;
					answer++;
					break;
				}
			}
		}
		return answer;
	}
}
