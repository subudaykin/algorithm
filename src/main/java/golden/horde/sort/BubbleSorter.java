package golden.horde.sort;

public class BubbleSorter extends BaseSorter implements ISorter {

	@Override
	public void sort(int[] arr) {
		if (!shouldArrayBeSorted(arr))
			return;
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		}
	}

	@Override
	public String description() {
		return "Bubble sorting";
	}

}
