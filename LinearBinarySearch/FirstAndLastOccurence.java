package StringBuilder_StringBuffer_FileReader_LinearAndBinarySearch;

public class FirstAndLastOccurence {
	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,4,4,4,5,6,7};
		System.err.println("First occurence of 4 is at index: " + firstOccurence(arr, 4));
		System.err.println("Last occurence of 4 is at index: " + lastOccurence(arr, 4));
	}

	private static int lastOccurence(int[] arr, int target) {
		int low = 0, high = arr.length-1;
		while(low <= high) {
			int mid = low + (high-low)/2;
			
			if(arr[mid] > target) high = mid-1;
			else low = mid+1;
		}
		
		return high;
	}

	private static int firstOccurence(int[] arr, int target) {
		int low = 0, high = arr.length-1;
		while(low <= high) {
			int mid = low + (high-low)/2;
			
			if(arr[mid] < target) low = mid+1;
			else high = mid-1;
		}
		
		return low;
	}
}
