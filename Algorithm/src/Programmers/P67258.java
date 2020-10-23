// https://programmers.co.kr/learn/courses/30/lessons/67258
// 20.10.23. venatnia1680
package Programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class P67258 {
    public static int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet<>();
        for (String gem : gems) {
            gemSet.add(gem);
        }
        Map<String, Integer> hm = new HashMap<>();

        int lim = 0;
        int len = Integer.MAX_VALUE;
        int[] answer = {0, 0};
        for (int low = 0; low < gems.length; low++) {
            boolean containAll = false;
            int high = lim;
            for (; high < gems.length && high > low; high++) {
                hm.computeIfPresent(gems[high], (k, v) -> ++v);
                hm.computeIfAbsent(gems[high], v -> 1);
                if (hm.size() == gemSet.size()) {
                    if (high - low < len) {
                        len = high - low;
                        answer[0] = low;
                        answer[1] = high;
                    }
                    containAll = true;
                    lim = high;
                    break;
                }
            }
            if (!containAll)
                break;
            if (hm.get(gems[low]) == 1)
                hm.remove(gems[low]);
            hm.computeIfPresent(gems[low], (k, v)->--v);
            hm.computeIfPresent(gems[high], (k, v)->--v);
        }
        answer[0]++; answer[1]++;
        return answer;
    }
}
