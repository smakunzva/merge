

package sort.merge;

public class MergeSort {

	private static int [] theArray = {45,23,21,12,34,45,4};

	public static void main(String[] args) {

		//Divide the array into half starting with the left
		//Repeate until single arrays
		//Repeate dividing array for the right side

		//Merge
		//Start merging the right by comparing left siblings
		//Create a temp array equal to num of elements
		//Set i = right and j= left
		//Copy the smallest element into temp array and increment
		//Repeat until all siblings are sorted
		//Repeate process for the right side

		//int finish = theArray.length / 2;

		merge(theArray, 0, theArray.length);


		for(int num: theArray) {
			System.out.println(num);
		}


	}


	public static void arraySplit(int [] sortArray, int start, int mid, int finish) {

		if(sortArray[mid -1] <= sortArray[mid]) {
			return;
		}

		int i = start;
		int j = mid;
		int tempIndex = 0;

		int [] tempArray = new int [finish - start];

		while(i < mid && j < finish) {
			tempArray[tempIndex ++ ] = sortArray[i] <= sortArray[j] ? sortArray[i++] : sortArray[j++];
		}

		System.arraycopy(sortArray, i, sortArray, start + tempIndex, mid - i);
		System.arraycopy(tempArray, 0 , sortArray, start, tempIndex);
	}


	private static void merge(int[] myArray,int start, int finish) {

		if((finish - start) < 2) {
			return;
		}

		int mid = (finish + start) /2; //Calculate the mid position
		//System.out.println("start : " + start + " : finish : " + mid);
		merge(myArray, start , mid );

		//System.out.println("start: " + mid + " : finish : " + finish);
		merge(myArray, mid, finish);

		arraySplit(myArray, start, mid, finish);

	}
}