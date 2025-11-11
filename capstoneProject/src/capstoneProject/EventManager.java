package capstoneProject;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import java.util.List;
import java.util.function.Predicate;

public class EventManager {

	public static void main(String[] args) {
		
		List<Guest> guests = populateGuests();
		
		//guest from spain who love music and dance
		 Predicate<Guest> smd = g ->
         g.getCountry() == Country.Spain &&
         (g.getHobby() == Hobby.Music || g.getHobby() == Hobby.Dance);
         
         System.out.println("\nGuests from Spain who love MUSIC or DANCE:");
         guests.stream().filter(smd).forEach(System.out::println);


         //Guests from Spain who love to DRINK and are above 18
         Predicate<Guest> pSpainDrinkAdult = g ->
                 g.getCountry() == Country.Spain &&
                 g.getHobby() == Hobby.Drink &&
                 getAge(g.getDob()) > 18;

         System.out.println("\nGuests from Spain who love DRINK and are above 18:");
         guests.stream().filter(pSpainDrinkAdult).forEach(System.out::println);

         // Guests from France who love SPORTS
         Predicate<Guest> pFranceSports = g ->
                 g.getCountry() == Country.France && g.getHobby() == Hobby.Sports;

         System.out.println("\nGuests from France who love SPORTS:");
         guests.stream().filter(pFranceSports).forEach(System.out::println);

         // Number of guests whose age is above 70
         long countAbove70 = guests.stream()
                 .filter(g -> getAge(g.getDob()) > 70)
                 .count();

         System.out.println("\nNumber of guests above age 70: " + countAbove70);

         // Guests who speak CHINESE and love to READ 
         Predicate<Guest> pChineseReaders = g ->
                 g.getLanguage() == Language.Chinese && g.getHobby() == Hobby.Read;

         System.out.println("\nGuests who speak CHINESE and love to READ:");
         guests.stream().filter(pChineseReaders).forEach(System.out::println);
     }

     // Helper method to calculate age
     private static int getAge(LocalDate dob) {
         return Period.between(dob, LocalDate.now()).getYears();
     }
         
	
	
	static List<Guest> populateGuests(){
		
		List<Guest> list = new ArrayList<Guest>();
		
		list.add(new Guest("Alice", LocalDate.of(1990, 5, 10), Country.USA, Language.English, Hobby.Travel));
		list.add(new Guest("Bob", LocalDate.of(1985, 8, 21), Country.Spain, Language.Spanish, Hobby.Dance));
		list.add(new Guest("Carlos", LocalDate.of(1978, 2, 12), Country.Spain, Language.Spanish, Hobby.Music));
		list.add(new Guest("Diego", LocalDate.of(1950, 1, 1), Country.Spain, Language.Spanish, Hobby.Drink));
		list.add(new Guest("Eve", LocalDate.of(1992, 3, 14), Country.France, Language.French, Hobby.Sports));
		list.add(new Guest("Frank", LocalDate.of(1945, 7, 30), Country.Germany, Language.German, Hobby.Read));
		list.add(new Guest("Grace", LocalDate.of(1995, 9, 30), Country.China, Language.Chinese, Hobby.Read));
		list.add(new Guest("Huan", LocalDate.of(1988, 4, 19), Country.China, Language.Chinese, Hobby.Music));
		list.add(new Guest("Liu", LocalDate.of(1940, 6, 15), Country.China, Language.Chinese, Hobby.Drink));

		return list;
	}
	
}
