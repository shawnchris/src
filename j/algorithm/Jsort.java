package j.algorithm;

public class Jsort {

	private static void swapNumbers(int i, int j, int[] array) {
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	private static void printNumbers(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println();
	}

	// Bubble sort logic
	public static void bubble_sort(int[] array) {
		int t = 0;
		int s = 0;
		for (int i = 0; i < array.length-1; i++) {
			for (int j = i+1; j < array.length; j++) {
				if (array[i] > array[j]) {
					swapNumbers(i, j, array);
					s++;
				}
				t++;
			}
			printNumbers(array);
		}
		System.out.println("Total comparison: " + t);
		System.out.println("Total swap: " + s);
	}

	// Insertion sort logic
	public static void insertion_sort(int[] array){
		int t = 0;
		int s = 0;
		for (int i = 1; i < array.length; i++) {
			for(int j = i ; j > 0 ; j--){
				if(array[j] < array[j-1]){
					swapNumbers(j, j-1, array);
					s++;
				}
				t++;
			}
			printNumbers(array);
		}
		System.out.println("Total comparison: " + t);
		System.out.println("Total swap: " + s);
	}

	// Quick sort logic
	static int tt = 0;
	static int ss = 0;
	public static void quick_sort(int low, int high, int[] array) {
		int l = low;
		int h = high;
		int pivot = array[l+(h-l)/2];

		while (l<=h) {
			while (array[l]<pivot) {l++;tt++;}
			while (array[h]>pivot) {h--;tt++;}
			if (l<h) {
				swapNumbers(l, h, array);
				System.out.print("low="+low+" high="+high+" l="+l+" h="+h+" pivot="+pivot+" -> ");
				printNumbers(array);
				ss++;
			}
			l++;
			h--;
		}

		if (low < h) quick_sort(low, h, array);
		if (high > l) quick_sort(l, high, array);
	}

	public static void quick_sort2(int low, int high, int[] array) {
		if (low < high) {
			int p = partition(low, high, array);
			quick_sort2(low, p-1, array);
			quick_sort2(p+1, high, array);
		}
	}
	public static int partition(int low, int high, int[] array) {
		int pivot = array[high];
		int index = low - 1;
		for (int i = low; i < high; i++) {
			if (array[i] <= pivot) {
				index++;
				if (index != i) swapNumbers(index, i, array);
			}
		}
		swapNumbers(index+1, high, array);
		System.out.print("low="+low+" high="+high+" pivot="+pivot+" -> ");
		printNumbers(array);
		return index+1;
	}

	// Merge sort logic
	public static void merge_sort(int low, int high, int[] array) {
		if (low < high) {
			int mid = low + (high - low) / 2;
			merge_sort(low, mid, array);
			merge_sort(mid+1, high, array);
			merge(low, mid, high, array);
			System.out.print("low="+low+" high="+high+" -> ");
			printNumbers(array);
		}
	}
	public static void merge(int low, int mid, int high, int[] a) {
		int[] b = new int[a.length];
		int l = low;
		int r = mid+1;
		int c = 0;
		while (l<=mid && r<=high) {
			if (a[l]<=a[r]) {
				b[c] = a[l];
				l++;
			}
			else {
				b[c] = a[r];
				r++;
			}
			c++;
		}
		while(l<=mid) { b[c] = a[l]; l++; c++;}
		while(r<=high) { b[c] = a[r]; r++; c++;}
		for (int i=low; i<=high; i++) a[i]=b[i-low];
	}

	// Heap sort logic
	public static int heapSize;
	public static void heap_sort(int[] A) {
		//max heap is built with heapSize initialised
		build_max_heap(A);
		printNumbers(A);
		//starting from end loop through entire array
		for(int i=A.length-1;i>=1;i--)
		{
			//since heap is already heapified and maintains max heap property
			//the first element of the array is root of max heap
			//swap it with the extreme element of the array i.e. setting the largest element to the end of array
			int temp = A[0];
			A[0]=A[i];
			A[i]=temp;
			//reduce the heap window by 1
			heapSize = heapSize-1;
			//call max heapify on the reduced heap
			printNumbers(A);
			max_heapify(A,0);
			printNumbers(A);
		}
	}
	public static void build_max_heap(int[] A)
	{
		heapSize = A.length;//heap size initialised
		for(int i=A.length/2; i>=0;i--)//since n/2, n/2+1 ... are leaves we can start from n/2 step downwards
		{
			//call MAX_HEAPIFY on each root node starting from n/2
			max_heapify(A, i);
		}
	}
	public static void max_heapify(int A[],int i)
	{
		int l=left(i);//the left element's index which is 2*i+1 (for zero based indexed array)
		int r=right(i);//right index = 2*i+2;
		int largestElementIndex = -1;//index can't be negative so initialise largest index , it will be used later
		//heapSize is the current size of the heap being worked upon
		//check if left index lies within the heap.
		//if element at left index is greater than root(A[i]) element, max heap property is violated
		//copy the index of violated element in largestElementIndex
		if(l<heapSize && A[l]>A[i]){
			largestElementIndex = l;
		}
		else //if max heap property is not violated copy the root's index in largestElementIndex
		{
			largestElementIndex=i;
		}
		//check to see the right sub tree for max heap property violation
		//here the largestElementIndex is calculated from previous step
		if(r<heapSize && A[r]>A[largestElementIndex])
		{
			largestElementIndex = r;
		}
		//if root doesn't has the largest index then swap the largest element with root element

		if(largestElementIndex!=i)
		{
			int temp = A[i];
			A[i]=A[largestElementIndex];
			A[largestElementIndex]=temp;
			//after swap, recursively call the MAX_HEAPIFY on the largest index(root element)
			max_heapify(A, largestElementIndex);
		}
	}
	public static int left(int i)
	{
		//returns left index of a zero index based array
		return 2*i+1;
	}

	public static int right(int i)
	{
		//returns right index of a zero based array
		return 2*i+2;
	}

	// Counting sort logic - assuming all numbers are >= 0
	public static void counting_sort(int[] A) {
		int length = A.length;
		int max = 0;
		for (int i=0; i<length; i++)
			if (A[i]>max) max=A[i];

		int[] B = new int[length];
		int[] C = new int[max+1];

		for (int j=0; j<length; j++)
			C[A[j]] = C[A[j]] + 1;
		// C[i] now contains the number of elements equal to i .
		System.out.print("C: ");
		printNumbers(C);

		for (int i=1; i<=max; i++)
			C[i] = C[i] + C[i-1];
		// C[i] now contains the number of elements less than or equal to i .
		System.out.print("C: ");
		printNumbers(C);

		for (int j = length-1; j>=0 ; j--) {
			B[C[A[j]]-1] = A[j];
			C[A[j]] = C[A[j]] - 1;
			System.out.print("C: ");
			printNumbers(C);
			System.out.print("B: ");
			printNumbers(B);
		}
	}

	public static void main(String[] args) {
		int[] input1 = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		int[] input2 = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		int[] input3 = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		int[] input4 = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		int[] input5 = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		int[] input6 = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
		int[] input7 = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };

		System.out.println("Bubble sort:");
		bubble_sort(input1);

		System.out.println("\nInsertion sort:");
		insertion_sort(input2);

		System.out.println("\nQuick sort:");
		quick_sort(0, input3.length-1, input3);
		System.out.println("Total comparison: " + tt);
		System.out.println("Total swap: " + ss);
		quick_sort2(0, input6.length-1, input6);

		System.out.println("\nMerge sort");
		merge_sort(0, input4.length-1, input4);

		System.out.println("\nHeap sort");
		heap_sort(input5);

		System.out.println("\nCounting sort");
		counting_sort(input7);

	}
}

/*
Insertion sort 		θ(n^2) 		θ(n^2)
Merge sort 			θ(nlgn) 	θ(nlgn)
Heapsort 			O(nlgn) 	—
Quicksort 			θ(n^2) 		θ(nlgn) (expected)
Counting sort 		θ(k+n) 		θ(k+n)
Radix sort 			θ(d(k+n))	θ(d(k+n))
Bucket sort 		θ(n^2) 		θ(n) (average-case)
 */
