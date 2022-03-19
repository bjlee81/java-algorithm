import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class MyStackTest {

	@Test
	void sol1() {
//		int[] progresses = {20, 99, 93, 30, 55, 10};
//		int[] speeds = {5, 10, 1, 1, 30, 5};
		int[] progresses = {70};
		int[] speeds = {30};
		Arrays.stream(solution(progresses, speeds)).forEach(System.out::println);
	}

	@Test
	void sol2() {
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		System.out.println(solution(priorities, location));
	}

	/**
	 * 1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
	 * 2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
	 * 3. 그렇지 않으면 J를 인쇄합니다.
	 * <p>
	 * 예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄
	 *
	 * @param priorities
	 * @param location   내가 인쇄를 요청한 문서의 index
	 * @return 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지
	 */
	public int solution(int[] priorities, int location) {
		int answer = 0;
		Queue<Print> queue = new LinkedList<>();
		String target = "";
		for (int i = 0; i < priorities.length; i++) {
			final String docName = String.valueOf((char) (i + 65));
			queue.offer(new Print(docName, priorities[i]));
			if (location == i) {
				target = docName;
			}
		}

		while (0 < queue.size()) {
			Print print = queue.poll();
			Integer priority = print.getPriority();
			AtomicBoolean bHigher = new AtomicBoolean(false);
			queue.forEach(print1 -> {
				if (priority < print1.getPriority()) {
					bHigher.set(true);
				}
			});
			if (bHigher.get()) {
				// 높은 우선순위가 있으면 대기열의 마지막으로 변경
				queue.offer(print);
				continue;
			} else {
				// 출력
				answer++;
				System.out.println("Printing... " + print.toString());
			}

			if (target.equals(print.getDocName())) {
				System.out.println(print);
				return answer;
			}
		}
		return answer + 1;
	}

	/**
	 * 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
	 *
	 * @param progresses 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses
	 * @param speeds     각 작업의 개발 속도가 적힌 정수 배열 speeds
	 * @return 각 배포마다 몇 개의 기능이 배포되는지
	 */
	public int[] solution(int[] progresses, int[] speeds) {
		// 작업 별 완료 남은 일
		Queue<Integer> queue = new LinkedList<>();
		int maxDay = Integer.MIN_VALUE;
		int firstReleaseDay = 0;
		for (int i = 0; i < progresses.length; i++) {
			// 먼저 배포되어야 하는 우선순위가 있기에, progress 가 낮은게 있으면 기다려야함
			// 몇일이나 걸릴지 확인 - 배포는 하루에 한번이니 100 이 넘는 시점에 2
			final int releaseDay = getReleaseDay(progresses[i], speeds[i]);
			System.out.print("progress id : " + i + ", 몇일 후 : " + releaseDay);
			// i 가 우선순위기에
			if (maxDay < releaseDay) {
				maxDay = releaseDay;
			}
			if (i == 0) {
				firstReleaseDay = releaseDay;
			}
			queue.offer(releaseDay);
		}

		List<Integer> list = new ArrayList<>();
		// 최초 배포일
		for (int i = firstReleaseDay; i < maxDay + 1; i++) {
			// 매일 배포가능한지 확인
			Stack<Integer> releaseStack = new Stack<>();       // 금일 배포 가능한 스택
			while (queue.size() > 0) {
				Integer afterDay = queue.peek();
				if (i >= afterDay) {
					// 배포 가능한 경우
					releaseStack.push(afterDay);
					queue.remove();
				} else {
					break;
				}
			}
			if (releaseStack.size() > 0) {
				list.add(releaseStack.size());
			}
		}

		return list.stream().mapToInt(value -> value).toArray();
	}

	// 몇일 걸리는지 배포까지
	int getReleaseDay(int progress, int speed) {
//		final int remain = 100 - progress;
//		if (remain < speed) {
//			return 1;
//		}
		double ceil = (100.0 - (double) progress) / (double) speed;
		return (int) Math.ceil(ceil);
//		return remain / speed;
	}

	static class Print {
		private String docName;
		private Integer priority;

		public Print(String docName, Integer priority) {
			this.docName = docName;
			this.priority = priority;
		}

		public String getDocName() {
			return docName;
		}

		public void setDocName(String docName) {
			this.docName = docName;
		}

		public Integer getPriority() {
			return priority;
		}

		public void setPriority(Integer priority) {
			this.priority = priority;
		}

		@Override
		public String toString() {
			return "Print{" +
					"docName='" + docName + '\'' +
					", priority=" + priority +
					'}';
		}
	}

}
