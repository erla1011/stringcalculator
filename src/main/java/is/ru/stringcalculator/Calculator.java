package is.ru.stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",") || text.contains("\n")){
			String[] numbers = splitNumbers(text);
			
			List<String> negativeNumbers = new ArrayList<String>();
			List<String> validNumbers = new ArrayList<String>();
			
			boolean hasANegativeNumber = false;
			
			for (String i : numbers) {
				int newI = toInt(i);
				if (newI < 0) {
					negativeNumbers.add(i);
					hasANegativeNumber = true;
				}
				else if (newI <= 1000) {
					validNumbers.add(i);
				}
			}
			
			if(hasANegativeNumber) {
				String negativeNumbersSeparated = "";
				for (String i : negativeNumbers) {
					negativeNumbersSeparated += ",";
					negativeNumbersSeparated += i;
				}
				throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbersSeparated.substring(1));
			}
			
			else {
				return sum(validNumbers.toArray(new String[validNumbers.size()]));
			}
		}
		else
			return toInt(text);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		String[] splitted;

		if(numbers.startsWith("//")) {
			String delimiter = numbers.substring(2,numbers.indexOf('\n'));
			if (delimiter.length() > 1) {
				delimiter = delimiter.substring(1,delimiter.indexOf(']'));
			}
		
			numbers = numbers.substring(numbers.indexOf('\n') + 1);			
			splitted = numbers.split(Pattern.quote(delimiter));
			return splitted;
		}
		else if(numbers.contains("\n") || numbers.contains(","))
		{
			splitted = numbers.split("\n|\\,");
			return splitted;
		}
		else if(numbers.contains(",")) {
			splitted = numbers.split(",");
			return splitted;
		}
		else {
			splitted = numbers.split(",");
			return splitted;
		}
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }

    public static void main(String[] args) {
    	//int sum = add("2,-4,3,-5");
    	//int sum2 = add("//:\n2:1");
    	
    }

}