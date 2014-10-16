package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text));
		}
		else
			return toInt(text);
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
		String[] splitted = null;
		String[] semisplitted;

		if(numbers.contains("//")) {
			numbers = numbers.substring(2);
			semisplitted = numbers.split("\n", 1);
			splitted = semisplitted[1].split(semisplitted[0]);
			return splitted;
		}
		else if(numbers.contains("\n") && numbers.contains(","))
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



}