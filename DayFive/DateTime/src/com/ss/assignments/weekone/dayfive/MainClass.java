/**
 * 
 */
package com.ss.assignments.weekone.dayfive;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Michael
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Demonstrate DateTime api
		Scanner input = new Scanner(System.in);
		Random rng = new Random();
		Integer givenYear;
		Integer givenMonth;
		Integer givenDay;
		
		// Store Birthday in day, month, year, second, and nanosecond
		LocalDateTime birthday = LocalDateTime.of(1998, 3, 11, 0, 0, 0, 0);
		System.out.println(birthday.toString());

		// Get date of previous Thursday
		LocalDate randomDate = LocalDate.of(1980 + rng.nextInt(40), rng.nextInt(12), rng.nextInt(28));
		LocalDate lastThursday = randomDate.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY));
		System.out.println(randomDate.toString() + " is on a " + randomDate.getDayOfWeek().toString());
		System.out.println(lastThursday.toString() + " is on a " + lastThursday.getDayOfWeek().toString());

		// Show difference between ZoneId and ZoneOffset
		ZonedDateTime todayZoned = ZonedDateTime.now();
		System.out.println("Zone ID: " + todayZoned.getZone().toString());
		System.out.println("Zone Offset: " + todayZoned.getOffset().toString());

		// Convert ZonedDateTime to Instant, and vice versa
		Instant todayInstant = Instant.from(todayZoned);
		System.out.println("Instant from ZDT: " + todayInstant.toString());
		todayZoned = ZonedDateTime.ofInstant(todayInstant, ZoneId.systemDefault());
		System.out.println("ZDT from Instant: " + todayZoned.toString());

		// Get length of months from given year
		System.out.print("Year to get length of months: ");
		givenYear = input.nextInt();
		randomDate = LocalDate.ofYearDay(givenYear, 1);
		LocalDate randomDateWithMonth;
		Month[] monthList = Month.values();

		for (Month m : monthList) {
			randomDateWithMonth = randomDate.withMonth(m.getValue());
			System.out.println(m.getDisplayName(TextStyle.FULL, Locale.getDefault()) + " has "
					+ randomDateWithMonth.lengthOfMonth() + " days in " + randomDateWithMonth.getYear());
		}
		
		// List Mondays in random month
		System.out.print("Year to get for month: ");
		givenYear = input.nextInt();
		System.out.print("Month to get Mondays in previously given year: ");
		givenMonth = input.nextInt();
		randomDateWithMonth = LocalDate.of(givenYear, givenMonth, 1).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
		
		do {
			System.out.println(randomDateWithMonth.toString() + " is on a Monday");
			randomDateWithMonth = randomDateWithMonth.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		} while (randomDateWithMonth.getMonth().getValue() == givenMonth);
		
		//Check if day is Friday 13th
		System.out.print("Year to check for Friday 13th: ");
		givenYear = input.nextInt();
		System.out.print("Month to check for Friday 13th: ");
		givenMonth = input.nextInt();
		System.out.print("Day to check if Friday 13th: ");
		givenDay = input.nextInt();
		randomDate = LocalDate.of(givenYear, givenMonth, givenDay);
		
		if (randomDate.getDayOfWeek() == DayOfWeek.FRIDAY && randomDate.getDayOfMonth() == 13) {
			System.out.println(randomDate.toString() + " is a Friday 13th");
		} else {
			System.out.println(randomDate.toString() + " is not a Friday 13th");
		}
	}

}
