package StringBuilder_StringBuffer_FileReader_LinearAndBinarySearch;

public class SearchWordInSentences {
	
	public static String search(String[] sentences, String target) {
		
		for(String str: sentences) {
			if(str.toLowerCase().contains(target.toLowerCase())) return str;
		}
		
		return "Not found";
	}

	public static void main(String[] args) {
		String[] sentences = {"Hello mister", "Hello miss", "Ki haal hain", "Govind paaji"};
		System.out.println("The sentence with the word Govind is: ");
		System.out.println(search(sentences, "Govind"));
	}

}
