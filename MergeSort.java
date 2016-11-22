package Lab6;

public class MergeSort {

	private int[] array;
	private int[] Merge;
	private int length;
	
	public static void main(String a[]){

	int[] inputArray = {23,42,55,67,75,34,5,100,7,69};
	MergeSort ms= new MergeSort();
	ms.sort(inputArray);
	
	for(int i:inputArray)
	{
		System.out.print(i);
		System.out.print(" ");
	}
}

	private void sort(int[] inputArray) {
		this.array = inputArray;
		this.length = inputArray.length;
		this.Merge = new int[length];
		mergeSort(0, length - 1);
		
	}

	private void mergeSort(int low, int high) 
	{
		if (low < high){
			int middle = low + (high - low)/2; // Get the index of the element which is in the middle
			mergeSort(low, middle); // Sort the left side of the array
			mergeSort(middle + 1, high); // Sort the right side of the array
			merge(low, middle, high);
		}	
	}

	private void merge(int low, int middle, int high) {
		
		for (int i = low; i <= high; i++){
			Merge[i] = array[i];
		}
			
		int i = low;
		int j = middle + 1;
		int k = low;
		
		while (i <= middle && j<= high)
		{
			if (Merge[i] <= Merge[j]){
				array[k] = Merge[i];
				i++;
			}
			else {
				array[k] = Merge[j];
				j++;
			}
			k++;
		}
		
		while (i <= middle) 
		{
			array[k] = Merge[i];
			k++;
			i++;
		}
		
	}
	
}