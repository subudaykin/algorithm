package golden.horde.sort;

public abstract class BaseSorter {
	
	protected void swap(int[] arr, int i, int j){
		if (i == j)
			return;
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	protected boolean shouldArrayBeSorted(int[] arr){
		return (arr != null) && (arr.length > 1);
	}
}
