package golden.horde.sort;

public class ShellSorter extends BaseSorter implements ISorter {

	@Override
	public void sort(int[] arr) {
		if (!shouldArrayBeSorted(arr))
			return;	
		int h = findH(arr.length);
		while (h >= 1) {
			for(int i = 0; i < h; i++){
				for(int j = i + h; j < arr.length; j += h){
					
				}			
			}
			h = (h-1)/3;
		}
		
	}

	@Override
	public String description() {
		return "Shell sorting";
	}
	
	private int findH(int length){
		int h = 1;
		while (3 * h + 1 < length){
			h++;
		};
		return h == 1 ? 1 : --h;
	}

}
