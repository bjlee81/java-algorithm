import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FullSearch {
    @Test
    void sol1() {
        var i = solution(new int[]{1, 3, 2, 4, 2});
        for (int i1 : i) {
            System.out.println(i1);
        }
    }

    public int[] solution(int[] answers) {
        int maxQuestion = 10000;
        int[] dropMath1 = new int[maxQuestion];
        int[] dropMath2 = new int[maxQuestion];
        int[] dropMath3 = new int[maxQuestion];

        int[] ans1 = new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5};
        int[] ans2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5};
        int[] ans3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int x = 0;
        int y = 0;
        int z = 0;
        for (int j = 0; j < maxQuestion; j++) {
            if (x == ans1.length) {
                x = 0;
            }
            dropMath1[j] = ans1[x++];

            if (y == ans2.length) {
                y = 0;
            }
            dropMath2[j] = ans2[y++];

            if (z == ans3.length) {
                z = 0;
            }
            dropMath3[j] = ans3[z++];
        }

        int match1 = 0;
        int match2 = 0;
        int match3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == dropMath1[i]) match1++;
            if (answers[i] == dropMath2[i]) match2++;
            if (answers[i] == dropMath3[i]) match3++;
        }
        int maxSol = Stream.of(match1, match2, match3).max(Integer::compareTo).get();
        List<Integer> answer = new ArrayList<>();
        if (maxSol == match1) {
            answer.add(1);
        }

        if (maxSol == match2) {
            answer.add(2);
        }

        if (maxSol == match3) {
            answer.add(3);
        }

        return answer.stream().mapToInt(v -> v).toArray();
    }
}
