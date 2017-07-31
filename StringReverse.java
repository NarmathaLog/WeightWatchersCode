

public class StringReverse {
	
	//Logic for Question 1, to reverse the entire string
	public static String reverseEverything(String s)
	{
		char[] ch = s.toCharArray();
		String result = "";
		//System.out.println(ch.length);

		for (int i = ch.length - 1; i >= 0; i--) {
			//parse the string one by one in reverse order and store the values in a string 
			result = result + ch[i];
		}		
		return result;
	}

	public static void main(String[] args) 
	{		
		try {
			String reverseString = StringReverse.reverseEverything("hope you are doing well ");
			//print the reverse string
			System.out.println(reverseString);
		} catch (Exception e) {
			// we can print the customized error messages, if required.
			e.printStackTrace();
		}
	}

}
