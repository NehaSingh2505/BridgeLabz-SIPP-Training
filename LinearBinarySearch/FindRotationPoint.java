package StringBuilder_StringBuffer_FileReader_LinearAndBinarySearch;

public class FindRotationPoint {
	public static void main(String[] args) {
		int[] arr = {5,6,7,8,9,1,2,3,4};
		System.out.println("The rotation point of the given array is: ");
		System.out.println(findRotationPoint(arr));
	}

	private static int findRotationPoint(int[] arr) {
		int low = 0, high = arr.length-1;
		while(low <= high) {
			int mid = low+ (high-low)/2;
			
			if(arr[mid] > arr[high]) low = mid+1;
			else high = mid-1;
		}
		
		return arr[low];
	}
}
