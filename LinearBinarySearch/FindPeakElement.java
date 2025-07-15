package StringBuilder_StringBuffer_FileReader_LinearAndBinarySearch;

public class FindPeakElement {
	public static void main(String[] args) {
		int[] arr = {1,2,1,3,5,6,4};
		System.out.println("The peak element in this array is: ");
		System.out.println(findPeak(arr));
	}

	private static int findPeak(int[] arr) {
		
		int low = 0, high = arr.length;
		while(low <= high) {
			int mid = low + (high-low)/2;
			
			if(arr[mid-1] < arr[mid] && arr[mid] > arr[mid+1]) return arr[mid];
			else if(arr[mid] < arr[mid+1]) low = mid+1;
			else high = mid-1;
		}
		
		return arr[low];
	}
}
