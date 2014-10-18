package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		if(text.contains("-")){
			
			 throw new RuntimeException("Negatives not allowed: "); 
		}

		if(text.startsWith("//["))
		{
			text = text.replaceAll("[."+ text.charAt(3) +"?]", ",");
			//text = text.replaceAll(temp, ",");
			text = text.replaceFirst("//", "");
			text = text.replaceFirst("\n", "");
			while(!isnumber(text.charAt(0)))
			{
				text = text.substring(1);
			}
			while(text.contains(",,"))
			{
				text = text.replaceAll(",,", ",");
			}
		}
		else if(text.startsWith("//"))
		{
			text = text.replaceFirst("//", "");
			text = text.replaceFirst("\n", "");
			text = text.replaceAll(text.substring(0, 1), ",");
			while(!isnumber(text.charAt(0)))
			{
				text = text.substring(1);
			}
			while(text.contains(",,"))
			{
				text = text.replaceAll(",,", ",");
			}
			
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
	private static Boolean isnumber(char number){
		if(number == '0' ||
			number == '1' ||
			number == '2' ||
			number == '3' ||
			number == '4' ||
			number == '5' ||
			number == '6' ||
			number == '7' ||
			number == '8' ||
			number == '9')
		{
			return true;
		}
		else
			return false;

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