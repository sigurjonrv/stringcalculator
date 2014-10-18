package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		if(text.contains("-")){
			
			 throw new RuntimeException("Negatives not allowed: "); 
		}
		if(text.startsWith("//"))
		{
			text = text.replaceFirst("//", "");
			text = text.replaceFirst("\n", "");
			text = text.replaceAll(text.substring(0, 1), ",");
			text = text.substring(1);
		}
		
		if(text.contains("\n")){
				text = text.replaceAll("\n", ",");
		}
		if(text.contains(";")){
				text = text.replaceAll(";", ",");
		}
		if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
        	if(toInt(number) <= 1000){
        		total += toInt(number);
        	}
		    
		}
		return total;
    }
}