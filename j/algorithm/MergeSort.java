package j.algorithm;

public class MergeSort {
	
	public int[] Sort(int[] array, int low, int high) {
		if (low<high) {
			int mid = low + (high-low)/2;
			Sort(array, low, mid);
			Sort(array, mid+1, high);
			Merge(array, low, high, mid);
		}
		return array;
	}
	public int[] Merge(int[] array, int low, int high, int mid) {
		int[] a2 = new int[high-low+1];
		int lp=low, hp=mid+1, cp=0;
		
		while(lp<=mid && hp<=high) {
			if (array[lp]<=array[hp]) {
				a2[cp] = array[lp];
				lp++; cp++;
			}
			else {
				a2[cp] = array[hp];
				hp++; cp++;
			}
		}
		
		while(lp<=mid)  {a2[cp] = array[lp]; lp++; cp++;};
		while(hp<=high) {a2[cp] = array[hp]; hp++; cp++;};
		
		for (int i=low; i<=high; i++) array[i] = a2[i-low];
		
		return array;
	}
	public static void main(String[] args) {
		int[] input1 = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		MergeSort ms = new MergeSort();
		
		ms.Sort(input1, 0, input1.length-1);
		
		for (int i=0; i<input1.length; i++)
			System.out.print(input1[i]+" ");

	}

}
