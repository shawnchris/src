package j.algorithm;

public class QuickSort {
	public int[] Sort(int[] array, int low, int high) {
		if (low<high) {
			int pivot_index = Partition(array, low, high);
			Sort(array, low, pivot_index-1);
			Sort(array, pivot_index+1, high);
		}
		return array;
	}
	public int Partition(int[] array, int low, int high) {
		int pivot = array[high];
		int pivot_index = low -1;
		for (int i=low; i<high; i++) {
			if (array[i]<=pivot) {
				pivot_index++;
				if (pivot_index!=i) {
					int temp = array[pivot_index];
					array[pivot_index] = array[i];
					array[i] = temp;
				}
			}
		}
		pivot_index++;
		int temp = array[pivot_index];
		array[pivot_index] = array[high];
		array[high] = temp;
		
		return pivot_index;
	}
	
	public static void main(String[] args) {
		int[] input1 = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		QuickSort qs = new QuickSort();
		
		qs.Sort(input1, 0, input1.length-1);
		
		for (int i=0; i<input1.length; i++)
			System.out.print(input1[i]+" ");

	}

}
