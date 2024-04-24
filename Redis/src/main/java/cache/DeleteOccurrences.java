package cache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeleteOccurrences {

	public static int[] deleteNth(int[] elements, int maxOccurrences) {
		if (elements == null) {
			return new int[0];
		}

		int[] result = new int[elements.length];
		int resultIndex = 0;
		int[] occurrences = new int[elements.length]; // 가정: 입력 숫자는 1000 이하의 자연수

		for (int element : elements) {
			if (occurrences[element] < maxOccurrences) {
				result[resultIndex++] = element;
				occurrences[element]++;
			}
		}

		return Arrays.copyOf(result,resultIndex);
	}

	public static void main (String[] args) {
		System.out.println(DeleteOccurrences.deleteNth(new int[]{1,1,3,3,7,2,2,2,},2));
	}

}

class cleverEx {
	public static int[] deleteNth(int[] elements, int maxOccurrences) {
		List<Integer> list = new ArrayList<>();

		for (int element : elements) {
			int count = (int) list.stream()
				.filter(i -> i == element)
				.count();
			if (count < maxOccurrences) {
				list.add(element);
			}
		}

		return list.stream()
			.mapToInt(i -> i)
			.toArray();
	}


}
