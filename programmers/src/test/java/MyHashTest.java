import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MyHashTest {

	Pattern pattern = Pattern.compile("^[a-z]{1,20}$");

	HashMap<String, Integer> reverseSortByValue(HashMap<String, Integer> source) {
		// Create a list from elements of HashMap
		List<Map.Entry<String, Integer>> list = new LinkedList<>(source.entrySet());

		// Sort the list using lambda expression
//		Collections.sort(list, (i1, i2) -> i1.getValue().compareTo(i2.getValue()));
		list.sort((i1, i2) -> i2.getValue().compareTo(i1.getValue()));     // reverse

		// put data from sorted list to hashmap
		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}
		return temp;
	}

	@Test
	void sol1() throws Exception {
		// 완주하지 못한 자 찾기
		String[] a = new String[]{"mislav", "stanko", "mislav", "ana"};
		String[] b = new String[]{"stanko", "ana", "mislav"};
		String notCompletionPerson = solution1(a, b);
		System.out.println("=============");
		System.out.println(notCompletionPerson);
	}

	@Test
	void sol2() {
		// 2차원 배열에서의 서로 다른 옷의 조합의 수
//		String[][] clothes = new String[][]{{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
		String[][] clothes = new String[][]{{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};

		int i = solution2(clothes);
		System.out.println(i);
	}

	@Test
	void sol3() {
		// 장르별 많이 재생된 2곡
		// 노래는 고유 번호로 구분
		// 수록 기준은 재생횟수에 따라 장르 > 노래 > 고유번호 낮은 순으로
		// 노래 장르는 genres, 재생횟수 plays
		// 노래 고유번호의 int[] 배열이 return
		final int[] rts = solution3(
				new String[]{"classic", "pop", "classic", "classic", "pop"},
				new int[]{500, 600, 150, 800, 2500}
		);
		for (int rt : rts) {
			System.out.println(rt);
		}
	}

	// 해시 - 베스트앨범
	public int[] solution3(String[] genres, int[] plays) {
		// 장르별 곡의 재생횟수
		HashMap<String, HashMap<Integer, Integer>> bestMap = new HashMap<>();
		// 장르별 재생횟수 합
		HashMap<String, Integer> genreOrderMap = new HashMap<>();

		for (int i = 0; i < genres.length; i++) {
			// 곡수에 따라 역순 정렬하기 위해 key 만 정렬되는 tree map으로
			// key 를 재생 횟수로. 고유번호가 낮은 노래가 우선순위임
			// 재생횟수는 중복이 있을 수 있으니 key 로 사용할 수 없음
			HashMap<Integer, Integer> playCountMap = bestMap.getOrDefault(genres[i], new HashMap<>());
			playCountMap.put(i, plays[i]);
			bestMap.put(genres[i], playCountMap);
			genreOrderMap.put(genres[i], genreOrderMap.getOrDefault(genres[i], 0) + plays[i]);
		}

		// 각 장르별 재생횟수
		// value 로 정렬
		final List<Map.Entry<String, Integer>> entryList = genreOrderMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toList());

		List<Integer> list = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : entryList) {
			HashMap<Integer, Integer> songMap = bestMap.get(entry.getKey());
			final List<Integer> songCounts = songMap.entrySet().stream()
					.sorted(Collections
							.reverseOrder(Map.Entry.<Integer, Integer>comparingByValue())
							.thenComparing(Map.Entry.comparingByKey()))
					.limit(2)
					.map(Map.Entry::getKey)
					.collect(Collectors.toList());
			// 같은 횟수면 고유번호 낮은 순으로
			list.addAll(songCounts);
		}
		return list.stream().mapToInt(i -> i).toArray();
	}

	private int solution2(String[][] clothes) {
		// [의상의 이름, 의상의 종류]
		// 상의의 수를 A 하의의 수를 B라고 하면 상의와 하의의 조합하는 경우의 수는 A * B
		// 상의만 선택, 하의만 선택하는 경우가 있어서 (A+1)*(B+1) 로 판단함
		// 계산된 모든 경우의 수에 아무것도 입지 않는 경우가 있어서 최종 값에서 -1
		// 의상의 이름은 동일한 이름이 없으니 경우의 수 계산을 위해 그냥 숫자로
		HashMap<String, Integer> map = new HashMap<>();
		for (String[] clothe : clothes) {
			String type = clothe[1];
			map.put(type, map.getOrDefault(type, 0) + 1);
		}
		int comb = 1;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.print("key : " + entry.getKey());
			System.out.println(", value : " + entry.getValue());
			comb = comb * (entry.getValue() + 1);
		}
		return comb - 1;
	}

	public int fact(int n) {
		if (n <= 1)
			return n;
		else
			return fact(n - 1) * n;

	}

	public String solution1(String[] participant, String[] completion) throws Exception {
		final int length = participant.length;
		if (length < 1 || length > 100000) {
			throw new Exception();
		}
		String remainPerson = null;
//		final String binarySearch = binarySearch(participant, completion);
//		remainPerson = listSearch(participant, completion);
		remainPerson = simpleSearch(participant, completion);
		return remainPerson;
	}

	/**
	 * 해시 탐색을 위해서는 총 두개의 알고리즘이 필요하다
	 * <p>
	 * 데이터를 저장하는 알고리즘
	 * 데이터를 검색하는 알고리즘
	 *
	 * @param participant
	 * @param completion
	 * @return
	 */
	private String simpleSearch(String[] participant, String[] completion) {
		Arrays.sort(participant);
		Arrays.sort(completion);
		for (int i = 0; i < participant.length; i++) {
			if (i == participant.length - 1) {
				return participant[i];
			}
			if (!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}

		return null;
	}

	private String listSearch(String[] participant, String[] completion) {
		final List<String> cList = Arrays.asList(completion);
		cList.sort(String::compareTo);
		String remainPerson = null;
		for (String s : participant) {
			// 완주자중에 참가자가 있으면 패스
			if (!cList.contains(s)) {
				//	완주자에 참가자가 없음
				remainPerson = s;
				break;
			}
		}

		if (remainPerson == null) {
			for (String key : participant) {
				final int frequency = Collections.frequency(Arrays.asList(participant), key);
				if (frequency == 2) {
					remainPerson = key;
					break;
				}
			}
		}
		return remainPerson;
	}

	private String binarySearch(String[] participant, String[] completion) {
		Arrays.sort(participant);
		Arrays.sort(completion);
		int dupNum = Integer.MIN_VALUE;
		for (String s : participant) {
			// 0보다 작은 결과가 나온 수들은 배열에 없는 것
			// 0포함 양수는 search 의 결과로 해당 위치를 의미
			// 반드시!!!! 정렬된 값으로 실행 필요
			int search = Arrays.binarySearch(completion, s);
			System.out.println(s + ", " + search);
			if (dupNum == search) {
				// 중복된 완주자로 둘 중하나는 미완주자.
				return s;
			}
			if (search < 0) {
				// 미완주자!!
				return s;
			}
			dupNum = search;
		}
		return null;
	}
}
