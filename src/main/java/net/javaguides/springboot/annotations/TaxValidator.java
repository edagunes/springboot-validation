package net.javaguides.springboot.annotations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class TaxValidator implements ConstraintValidator<TaxValidation, String> {
	
	@Override
	public boolean isValid(String taxno, ConstraintValidatorContext context) {
		
		Pattern pattern = Pattern.compile("[0-9]{10}$");
		
		Matcher matcher = pattern.matcher(taxno);
		
		try {
			if(!matcher.matches()) {
				return false;
			}
			else {
				int temp;
				int sum = 0;
				int lastDigit = Character.getNumericValue(taxno.charAt(9));
				
				for(int i = 0; i < 9; i++) {
					int digit = Character.getNumericValue(taxno.charAt(i));
					temp = (digit + 10 - (i + 1)) % 10;
					
					if (temp != 9) {
						temp = (int) (temp * (Math.pow(2, 10 - (i+1))) % 9);
					}
					
					sum += temp;
					
				}
				
				return lastDigit == (10 - (sum % 10)) % 10;
			}
		}
		catch (Exception e) {
			return false;
		}
	}

}
