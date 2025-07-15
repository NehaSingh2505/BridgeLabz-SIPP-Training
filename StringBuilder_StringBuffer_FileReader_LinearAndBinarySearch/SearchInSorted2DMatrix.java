package StringBuilder_StringBuffer_FileReader_LinearAndBinarySearch;

public class SearchInSorted2DMatrix {
	public static void main(String[] args) {
		int[][] mat = {{1,2,3,4}, {5,6,7,8}};
		System.out.println(search(mat, 5));
	}

	private static boolean search(int[][] mat, int target) {
		int m = mat.length, n = mat[0].length;
		int low = 0, high = m*n-1;
		while(low <= high) {
			int mid = low + (high-low)/2;
			int midValue = mat[mid/n][mid%n];
			
			if(midValue == target) return true;
			else if(midValue <= target) low = mid+1;
			else high = mid-1;
		}

		return false;
	}
}
