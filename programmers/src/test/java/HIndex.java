import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class HIndex {
    @Test
    void test() {
        int val = solution(new int[]{25, 8, 5, 3, 3});
        System.out.println(val);
    }

    /**
     * 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값
     *
     * @param citations 논문의 인용 횟수
     * @return H-Index를 나타내는 값인 h
     */
    public int solution(int[] citations) {
        // 이게 왜맞지???
        int h = 0;
        Arrays.sort(citations);
        for (int n = 0; n < citations.length; n++) {
            int finalI = n;
            long cnt = Arrays.stream(citations)
                    .filter(value -> value >= citations[finalI])
                    .count();
            System.out.println(citations[n] + "번 이상 인용된 논문 개수 : " + cnt);
            if (cnt <= citations[n]) {
                h = (int) cnt;
                break;
            }
        }

        return h;
    }
}
