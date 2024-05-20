import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
		String inputFileName = "Input.txt";

		try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
			String line;
            int count = 0;
            String longestWord = "";
            Map<String,Integer> frequency = new HashMap<>();
			while ((line = reader.readLine()) != null) { // чтение файла
				// System.out.println(line + "\n");
                String[] parts = line.split("\\s+");
                for( String word : parts) {

                    if (word.length() > longestWord.length()) { // самое длинное слово
                        longestWord = word;
                    }

                    if (frequency.containsKey(word)){  // частота слов
                        frequency.put(word, frequency.get(word) +1);
                    } else {  
                        int coun = 1;
                        frequency.put(word, coun);
                    }

                    count ++; // количество слов
                
                }
                
                line = reader.readLine();
            }         
            System.out.println("Количество слов: " + count);
            System.out.println("Самое длинное слово: " + longestWord);
            System.out.println("Сколько раз каждое слово встречается в файле: " );
            System.out.println(frequency);
		}
		
        catch (IOException e) {
			e.printStackTrace();
		}
	}

}   