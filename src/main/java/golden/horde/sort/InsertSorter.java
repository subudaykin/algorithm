package golden.horde.sort;

public class InsertSorter extends BaseSorter implements ISorter {

	@Override
	public void sort(int[] arr) {
		if (!shouldArrayBeSorted(arr))
			return;	
		for(int i = 1; i < arr.length; i++){
			for(int j = 0; j < i; j++){
				if (arr[i] < arr[j]){
					shiftCyclicRight(arr, j, i);
					break;
				}
			}
		}		
	}

	@Override
	public String description() {
		return "Insert sorting";
	}
	
	private void shiftCyclicRight(int[] arr, int from, int to){
		int toBefore = arr[to];
		for(int i = to; i > from; i--){
			arr[i] = arr[i - 1];
		}
		arr[from] = toBefore;
	}

}

