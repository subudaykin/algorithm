package golden.horde.sort;

public class MergeSorter extends BaseSorter implements ISorter {

	@Override
	public void sort(int[] arr) {
		if (!shouldArrayBeSorted(arr))
			return;	
		buffer = new int[arr.length];
		_sort(arr, 0, arr.length - 1);
		buffer = null;
	}

	@Override
	public String description() {
		return "Merge sorting";
	}
	
	private int[] buffer;
	
	private void _sort(int[] arr, int from, int to) {
		int delta = to - from;
		if (delta < 1)
			return;
		if (delta == 1){
			if (arr[from] > arr[to]) {
				swap(arr, from, to);
			}
			return;
		}
		int mediana = delta/2;
		_sort(arr, from, from + mediana);
		_sort(arr, from + mediana + 1, to);
		_merge(arr, from, from + mediana + 1, to);
	}
	
	private void _merge(int[] arr, int from, int between, int to){
		int currentIndex = 0;
		int currFirst = from;
		int currSecond = between;
		while ((currFirst < between) && (currSecond <= to)) {
			if (arr[currFirst] < arr[currSecond]) {
				buffer[currentIndex++] = arr[currFirst++];
			}
			else {
				buffer[currentIndex++] = arr[currSecond++];
			}				
		}
		while (currFirst < between) {
			buffer[currentIndex++] = arr[currFirst++];		
		}
		while (currSecond <= to) {
			buffer[currentIndex++] = arr[currSecond++];		
		}
		for(int i = 0; i < currentIndex; i++) {
			arr[from + i] = buffer[i];
		}
	}

}

