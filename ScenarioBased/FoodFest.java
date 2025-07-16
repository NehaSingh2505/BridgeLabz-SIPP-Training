public class FoodFest{
    public static void main(String[] args) {
        int[] stall1={300,490,560,700,980};//sorted array of stall 1
        int[] stall2={240,345,456,765,965};//sorted 
        int merged[]=mergeSortedArrays(stall1, stall2);//merging both arrays
        for(int num : merged) {
            System.out.print(num + " ");//printing merged array
        }
    }

    public static int[] mergeSortedArrays(int[] array1, int[] array2) {
        int length1 = array1.length, length2 = array2.length;
        int[] merged = new int[length1 + length2];
        int i = 0, j = 0, k = 0;
        while(i < length1 && j < length2) {
            if(array1[i] < array2[j]) {
                merged[k++] = array1[i++];
            } else {
                merged[k++] = array2[j++];
            }
        }
        while(i < length1) {
            merged[k++] = array1[i++];
        }
        while(j < length2) {
            merged[k++] = array2[j++];
        }
        return merged;
    }
}