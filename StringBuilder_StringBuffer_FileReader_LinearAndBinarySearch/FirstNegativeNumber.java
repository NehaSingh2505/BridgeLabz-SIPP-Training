package StringBuilder_StringBuffer_FileReader_LinearAndBinarySearch;

public class FirstNegativeNumber {
	
	public static int findFirstNegative(int[] arr) {
		for(int num: arr) {
			if(num < 0) return num;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = {4,2,5,7,2,-1,4,7,-2,4,6};
		System.out.print("First negative number is: ");
		System.out.println(findFirstNegative(arr));
	}

}
