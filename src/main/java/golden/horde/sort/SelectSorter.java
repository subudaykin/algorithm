package golden.horde.sort;

public class SelectSorter extends BaseSorter implements ISorter {

	@Override
	public void sort(int[] arr) {
		if (!shouldArrayBeSorted(arr))
			return;
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]){
					min = j;
				}			
			}
			swap(arr, min, i);
		}	
	}

	@Override
	public String description() {
		return "Select sorting";
	}

}
