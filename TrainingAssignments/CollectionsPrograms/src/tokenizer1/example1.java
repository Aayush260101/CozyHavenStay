package tokenizer1;

import java.util.StringTokenizer;

public class example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="Aayush@Aman@Man@Rocket@Idiom";
		StringTokenizer token=new StringTokenizer(str,"@");
		int count = 0;
        while (token.hasMoreTokens()) {
            String word = token.nextToken();
            char firstChar = word.charAt(0); 

            
            if (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u' || firstChar == 'A' || firstChar == 'E' || firstChar == 'I' || firstChar == 'O' || firstChar == 'U') {
                count++;
                System.out.println(word);
            }
        }

        System.out.println(count);

	}

}
