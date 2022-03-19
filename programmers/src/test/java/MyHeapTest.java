import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MyHeapTest {
    @Test
    void sol1() {
        int k = 5;
        int[] ints = {1, 2, 3};
        System.out.println(this.solution(ints, k));
    }

    /**
     * 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듭니다.
     * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
     *
     * @param scoville 현재의 스코빌 지수
     * @param K        도달할 스코빌 지수
     * @return 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수
     */
    public int solution(int[] scoville, int K) {
        if (scoville.length < 2 || scoville.length > 1000000) {
            return -1;
        }
        if (0 > K || K > 1000000000) {
            return -1;
        }

        Queue<Integer> q = new PriorityQueue<>(Comparator.naturalOrder());
        // K 이하의 음식만 대상으로 하면 될까??
        for (int j : scoville) {
            if (j >= 0 && j <= 1000000)
                q.offer(j);
        }

        int count = 0;
        while (q.size() != 0) {
            Integer first = q.poll();
            if (first >= K) {
                break;
            }
            Integer second = q.poll();
            if (second != null) {
                int newScoville = first + (second * 2);
                count++;
                q.offer(newScoville);
            } else {
                count = -1;
                break;
            }
        }

        return count;
    }
}
