package lambdaproblem;

import java.util.Arrays;
import java.util.List;

public class CountryCaseChange {

	public static void main(String[] args) {
	     List<String> listCountries = Arrays.asList("France", "Germany", "Italy", "Egypt");
	     listCountries.sort((String stringArg1, String stringArg2) ->   stringArg2.compareTo(stringArg1)); 
	     for (String countryName : listCountries) {
		      System.out.println(countryName);
	     }
	  }
}
