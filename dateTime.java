package com.dnapass.java.training.datetime;


	import java.io.PrintStream;
	import java.time.LocalDateTime;
	import java.time.ZonedDateTime;
	import java.time.Month;
	import java.time.ZoneId;
	import java.time.temporal.ChronoUnit;
	import java.time.DateTimeException;
	import java.time.format.DateTimeFormatter;

public class FlightArrival {
	    public static void main(String[] args) {
	        DateTimeFormatter format = DateTimeFormatter
	                .ofPattern("MMM d yyyy  hh:mm a");

	        // Leaving from San Francisco on July 20, 2013, at 7:30 p.m.
	        LocalDateTime leaving = LocalDateTime.of(2013, Month.JULY, 20, 19,
	                30);
	        ZoneId leavingZone = ZoneId.of("America/Los_Angeles");
	        ZonedDateTime departure = ZonedDateTime.of(leaving, leavingZone);

	        try {
	            String out1 = departure.format(format);
	            System.out.printf("LEAVING:  %s (%s)%n", out1, leavingZone);
	        } catch (DateTimeException exc) {
	            System.out.printf("%s can't be formatted!%n", departure);
	            throw exc;
	        }

	        // Flight is 10 hours and 50 minutes, or 650 minutes
	        ZoneId arrivingZone = ZoneId.of("Asia/Tokyo");
	        ZonedDateTime arrival = departure.withZoneSameInstant(arrivingZone)
	                .plusMinutes(650);

	        try {
	            String out2 = arrival.format(format);
	            System.out.printf("ARRIVING: %s (%s)%n", out2, arrivingZone);
	        } catch (DateTimeException exc) {
	            System.out.printf("%s can't be formatted!%n", arrival);
	            throw exc;
	        }

	        if (arrivingZone.getRules().isDaylightSavings(arrival.toInstant()))
	            System.out.printf(
	                    "  (%s daylight saving time will be in effect.)%n",
	                    arrivingZone);
	        else
	            System.out.printf("  (%s standard time will be in effect.)%n",
	                    arrivingZone);
	    }
	}

//javatime
package com.dnapass.java.training.datetime;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class JavaTimePackage {

public static void main(String[] args) {
// TODO Auto-generated method stub

System.out.printf("%s%n", DayOfWeek.MONDAY.plus (3));
DayOfWeek dow = DayOfWeek.MONDAY;
Locale locale = Locale.getDefault();
System.out.println(dow.getDisplayName (TextStyle. FULL, locale));
System.out.println(dow.getDisplayName (TextStyle.NARROW, locale)); System.out.println(dow.getDisplayName (TextStyle.SHORT, locale));


System.out.printf("%d%n", Month.FEBRUARY. maxLength());

Month month = Month.AUGUST;
locale= Locale.getDefault();
System.out.println(month.getDisplayName (TextStyle. FULL, locale));
System.out.println(month.getDisplayName (TextStyle. NARROW, locale));
System.out.println(month.getDisplayName (TextStyle. SHORT, locale));



LocalDate date= LocalDate.of (2000, Month.NOVEMBER, 20);
LocalDate nextwed = date.with (TemporalAdjusters.next(DayOfWeek. WEDNESDAY));



DayOfWeek dotw= LocalDate.of(2012,Month.JULY, 9).getDayOfWeek();



// The following example uses a TemporalAdjuster to retrieve the first wednesday
// after a specific date.



date= LocalDate.of(2000, Month.NOVEMBER, 20);
TemporalAdjuster adj = TemporalAdjusters.next(DayOfWeek. WEDNESDAY);
nextwed = date.with(adj);

System.out.printf("For the date of %s, the next Wednesday is %s.%n", date, nextwed);



YearMonth date4 = YearMonth.now();
System.out.printf("%s: %d%n", date4, date4.lengthOfMonth());

YearMonth date2 = YearMonth.of(2018, Month.FEBRUARY);
System.out.printf("%s: %d%n", date2, date2.lengthOfMonth());



YearMonth date3 = YearMonth.of(2012, Month.FEBRUARY);
System.out.printf("%s: %d%n", date3, date3.lengthOfMonth());



// Is February 29 is valid for the year 2018?



MonthDay date5 = MonthDay.of (Month. FEBRUARY, 29);
boolean validLeapYear =date5.isValidYear (2010);



validLeapYear = Year.of(2012).isLeap();
LocalTime thisSec;



for (int i = 0; i <10; i++)
{
thisSec = LocalTime.now();



// implementation of display code is left to the reader System.out.printf("%d:%d: %d", thisSec.getHour(), thisSec.getMinute(), thisSec.getSecond());



}



System.out.printf("now: %s %n", LocalDateTime.now());



System.out.printf("Apr 15, 1994 @ 11:30am: %s%n", LocalDateTime.of (1994, Month.APRIL, 15, 11, 30));



System.out.printf("now (from Instant): %s%n", LocalDateTime.ofInstant (Instant.now(), ZoneId.systemDefault()));



System.out.printf("6 months from now: %s%n", LocalDateTime.now().plusMonths (6));

System.out.printf("Apr 15, 1994 @ 11:30am: %s%n", LocalDateTime.of (1994, Month.APRIL, 15, 11, 30));



System.out.printf("now (from Instant): %s%n", LocalDateTime. ofInstant (Instant.now(), ZoneId. systemDefault()));



System.out.printf("6 months from now: %s%n", LocalDateTime.now().plusMonths (6));



System.out.printf("6 months ago: %s%n", LocalDateTime.now().minusMonths (6));

Set<String> allZones = ZoneId.getAvailableZoneIds();

LocalDateTime dt = LocalDateTime.now();
// Create a List using the set of zones and sort it.
List<String> zonelist = new ArrayList<String>(allZones);
Collections.sort(zonelist);

for (String s: zonelist)
{
ZoneId zone = ZoneId.of(s);
ZonedDateTime zdt = dt.atZone (zone);
ZoneOffset offset=zdt.getOffset();
int secondsOfHour = offset.getTotalSeconds() % (60*60);
String out = String.format("55 s%n", zone, offset);

// write only time zones that do not have a whole hour offset



// to standard out.



if (secondsOfHour != 0) {
System.out.printf(out);
}
}



}



}
//timedatedemo
package com.dnapass.java.training.datetime;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Formatter;
import java.util.Locale;
public class TimeDateDemo {



public static void main(String[] args) {
// TODO Auto-generated method stub

LocalDate l_date = LocalDate.now();
System.out.println("Current date: " +l_date);

LocalTime l_time= LocalTime.now();
System.out.println("Current time:" + l_time);



YearMonth ym =YearMonth.of (2016, 9);



String firstDay = ym. atDay (1).getDayOfWeek ().name();
String lastDay = ym. atEndOfMonth().getDayOfWeek (). name();



System.out.println();



System.out.println(firstDay);
System.out.println(lastDay);



System.out.println();



LocalTime time = LocalTime.now();
System.out.println();



// in hour, minutes, seconds, nano seconds
System.out.println("Local time now: " + time);



time = LocalTime.now();



// adding four hours
LocalTime newTime = time.plusHours (4);
System.out.println();
System.out.println("Time after 4 hours :"+ newTime);
LocalDate today = LocalDate.now();



LocalDate userday = LocalDate.of(2015, Month.MAY, 15);
Period diff = Period.between(userday, today);
System.out.println("\nDifference between "+ userday +" and "+ today + diff.getYears ()
+" Year(s) and "+ diff.getMonths () +" Month()s\n");

Instant timestamp = Instant.now();
System.out.println("\nCurrent Timestamp:" + timestamp+"\n");



today = LocalDate.now();
System.out.println("\nCurrent Date: "+today);
LocalDate plusDays = today.plusDays (10);
System.out.println("10 days after today will be "+plusDays+"\n");
System.out.println("10 days before today will be "+plusDays.plusDays (-20));


today = LocalDate.now();
LocalDate lastDayOfYear= today.with(TemporalAdjusters.lastDayOfYear());
Period period = today.until(lastDayOfYear);
System.out.println();
System.out.println("Months remaining in the year: "+period.getMonths());



//Current year
Year yr = Year.now();
//given year
//Year yr = Year.of (2001);
System.out.println("\nCurrent Year:" + yr);

boolean isLeap = yr.isLeap(); // false
System.out.println("Is current year leap year?" + isLeap);
int length = yr.length(); // 365
System.out.println("Length of the year:" + length+" days\n");



// information about the month
LocalDate ldt = LocalDate.of (2016, Month.FEBRUARY, 10);
Month mn = ldt.getMonth(); // FEBRUARY
int mnIntValue = mn.getValue(); // 2
int minLength = mn.minLength(); // 28
int maxLength = mn.maxLength(); // 29
Month firstMonthOfQuarter = mn. firstMonthOfQuarter (); // JANUARY System.out.println("\nInteger value of the current month: " + mnIntValue);
System.out.println("Length of the month: " + minLength);
System.out.println("Maximum length of the month: " + maxLength);
System.out.println("First month of the Quarter: "+firstMonthOfQuarter+"\n");

time = LocalTime.of(12, 24, 32);
int hour = time.getHour();
int minute = time.getMinute();
int second= time.getSecond();
System.out.println("\nCurrent Local time: " + time);
System.out.println("Hour:" + hour);
System.out.println("Minute:" + minute);
System.out.println("Second: "+second+"\n");

// Before 7 houres and 30 minutes
LocalDateTime dateTime = LocalDateTime.now().minusHours (7).minusMinutes (30);
System.out.println("\nCurrent Date and Time: "+ LocalDateTime.now());
System.out.println("Before 7 hours and 30 minutes: " + dateTime+"\n");

String string = "May 1, 2016";
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
LocalDate date = LocalDate.parse(string, formatter);
System.out.println();
System.out.println(date);
System.out.println();



LocalDate pdate = LocalDate.of(2012, 01, 01);
LocalDate now = LocalDate.now();



diff = Period.between(pdate, now);



System.out.printf("\nDifference is %d years, %d months and %d days old\n\n",
diff.getYears(), diff.getMonths(), diff.getDays ());



dateTime= LocalDateTime.of(2016, 9, 16, 0, 0);
LocalDateTime dateTime2 = LocalDateTime.now();
int diffInNano = java.time. Duration.between(dateTime, dateTime2).getNano();
long diffInSeconds = java.time.Duration.between (dateTime, dateTime2).getSeconds();
long diffInMilli = java.time.Duration.between (dateTime, dateTime2).toMillis();
long diffInMinutes = java.time.Duration.between (dateTime, dateTime2).toMinutes();
long diffinHours = java.time.Duration.between(dateTime, dateTime2).toHours();
System.out.printf("\nDifference is %d Hours, %d Minutes, %d Milli, %d Seconds and %d Nano\n\n",
diffinHours, diffInMinutes, diffInMilli, diffInSeconds, diffInNano );




// date of birth
pdate = LocalDate.of(1989, 04, 11);



// current date
now = LocalDate.now();



// difference between current date and date of birth
diff = Period.between (pdate, now);
System.out.printf("\nI am %d years, %d months and %d days old.\n\n", diff.getYears(), diff.getMonths (), diff.getDays ());



LocalDate dt = LocalDate.now();
System.out.println("\nNext Friday: "+dt.with (TemporalAdjusters.next(DayOfWeek.FRIDAY)));
System.out.println("Previous Friday: "+dt.with(TemporalAdjusters.previous (DayOfWeek. FRIDAY))+"\n");
}



}

//utildatedemo
package com.dnapass.java.training.datetime;

import java.sql.Date;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;



public class UtilDateDemo {



public static void main(String[] args) {
// TODO Auto-generated method stub

int year =2021;
int month=0; //January
int date=1;

Calendar cal=Calendar.getInstance(); //default time zone

//get and display current date from calendar

System.out.println("year:"+ cal.get(Calendar.YEAR));
System.out.println("Month:"+ cal.get(Calendar.MONTH));
System.out.println("Day:"+ cal.get(Calendar.DATE));
System.out.println("Hour:"+ cal.get(Calendar.HOUR));
System.out.println("Minute:"+ cal.get(Calendar.MINUTE));
System.out.println();

cal.clear();
System.out.println();
cal.set(Calendar.YEAR,year);
cal.set(Calendar.MONTH,month);
cal.set(Calendar.DATE,date);
System.out.println(cal.getTime());

cal=Calendar.getInstance();
System.out.println();
System.out.println("Current date and time:"+cal.getTime());
int actualMaxYear=cal.getActualMaximum(Calendar.YEAR);
int actualMaxMonth=cal.getActualMaximum(Calendar.YEAR);
int actualMaxWeek=cal.getActualMaximum(Calendar.WEEK_OF_YEAR);
int actualMaxDate=cal.getActualMaximum(Calendar.DATE);

//max year
System.out.println("Actual Max year:"+actualMaxYear);
System.out.println("Actual Max month:"+actualMaxMonth);
System.out.println("Actual Max Week of the year:"+actualMaxWeek);
System.out.println("Actual Max date:"+actualMaxDate);
System.out.println();

System.out.println("Current date and time:"+cal.getTime());
int actualMinYear=cal.getActualMinimum(Calendar.YEAR);
int actualMinMonth=cal.getActualMinimum(Calendar.YEAR);
int actualMinWeek=cal.getActualMinimum(Calendar.WEEK_OF_YEAR);
int actualMinDate=cal.getActualMinimum(Calendar.DATE);
//min year
System.out.println("Actual Min year:"+actualMinYear);
System.out.println("Actual Min month:"+actualMinMonth);
System.out.println("Actual Min Week of the year:"+actualMinWeek);
System.out.println("Actual Min date:"+actualMinDate);
System.out.println();

Calendar calNewYork = Calendar.getInstance();
calNewYork.setTimeZone(TimeZone.getTimeZone("America/New_York"));
System.out.println();
System.out.println("Time in New York: " + calNewYork);
System.out.println("Time in New York: " + calNewYork.get(Calendar. HOUR_OF_DAY) + ":"
+ calNewYork.get(Calendar.MINUTE) + ":" + calNewYork.get (Calendar.SECOND));
System.out.println();

Calendar now = Calendar.getInstance();
System.out.println();



System.out.println("Current full date and time is :"+(now.get(Calendar.MONTH) + 1) + "-"
+ now.get (Calendar.DATE) + "-" + now.get(Calendar.YEAR) +""+now.get(Calendar.HOUR_OF_DAY) + ":"
+ now.get(Calendar.MINUTE) + ":" + now.get (Calendar. SECOND)+ "." + now.get(Calendar.MILLISECOND));
System.out.println();

// Gets a calendar using the default time zone and locale.
Calendar calendar= Calendar.getInstance();
System.out.println();
System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
System.out.println();



cal = Calendar.getInstance();
// cal.setTime (date);
System.out.println();
//cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum (Calendar.DAY_OF_MONTH));
System.out.println(cal.getTime());
System.out.println();

int days=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
System.out.println();
System.out.println("Number of days of thr current month:"+days);

// Localize in German
DateFormatSymbols symbols= new DateFormatSymbols(new Locale("de"));
// for the current Locale :
// DateFormatSymbols symbols = new DateFormatSymbols();
String[] dayNames= symbols.getWeekdays();
for (String s :dayNames) {
System.out.print(s + "\n");
System.out.println();
}



// two weeks
int noOfDays = 14;
cal = Calendar.getInstance();
java.util.Date cdate=cal.getTime();
cal.add(Calendar.DAY_OF_YEAR, noOfDays);
java.util.Date datel = cal.getTime();
System.out.println("\nCurrent Date: " + cdate + "\n");
System.out.println("Day after two weeks:" + datel + "\n");

cal=Calendar.getInstance();
cdate=cal.getTime();
//get next year
cal.add(Calendar.YEAR,1);
java.util.Date nyear=cal.getTime();
//get previous year

cal.add(Calendar.YEAR,-1);
java.util.Date pyear=cal.getTime();
System.out.println("Current Date:"+cdate);
System.out.println("Date after 1 year"+nyear);
System.out.println("Date before 1 year"+pyear);

//year to leap year or not



year = 2016;
System.out.println();



if((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
System.out.println("Year"+ year +" is a leap year");



else
System.out.println("Year "+year + " is not a leap year");



cal = new GregorianCalendar();

cal.set(Calendar.MINUTE, 0);
cal.set(Calendar.SECOND, 0);
System.out.println("\n"+cal.getTime()+"\n");
try {



String originalString = "2016-07-14 09:00:02";
java.util.Date date12 = new SimpleDateFormat("yyyy-MM-dd HH: mm:ss").parse(originalString);
String newstr = new SimpleDateFormat("MM/dd/yyyy, H:mm:ss").format(date12);
System.out.println("\n"+newstr+"\n");
}
catch(ParseException e) {
//Handle exception here
e.printStackTrace();
}



//Unix seconds
long unix_seconds= 1372339860;
//convert seconds to milliseconds
Date date12 =new Date(unix_seconds*1000L);
// format of the date
SimpleDateFormat jdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss_2"); jdf.setTimeZone (TimeZone.getTimeZone("GMT-4"));
String java_date= jdf.format(date12);
System.out.println("\n"+java_date+"\n");



}



}
