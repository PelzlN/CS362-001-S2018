package calendar;


import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {

    private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
    private static final int NUM_TESTS=100;


    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
         long startTime = Calendar.getInstance().getTimeInMillis();
         long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		 System.out.println("Start testing...");

		 try{
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				 long randomseed =System.currentTimeMillis(); //10
				 //			System.out.println(" Seed:"+randomseed );
				 Random random = new Random(randomseed);

				 int startHour=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 59);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 30);
				 int startMonth=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startYear=ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
				 String title="Birthday Party";
				 String description="This is my birthday party.";
				 String emailAddress="xyz@gmail.com";

				 //Construct a new Appointment object with the initial data
				 //Construct a new Appointment object with the initial data
				 Appt appt1 = new Appt(startHour,
						 startMinute ,
						 startDay ,
						 startMonth ,
						 startYear ,
						 title,
						 description,
						 emailAddress);

                 if(!appt1.getValid())continue;

                 int startHour2=ValuesGenerator.getRandomIntBetween(random, 1, 11);
                 int startMinute2=ValuesGenerator.getRandomIntBetween(random, -1, 61);

                 //Construct a new Appointment object with the initial data
                 //Construct a new Appointment object with the initial data
                 Appt appt2 = new Appt(startHour2,
                         startMinute2 ,
                         startDay ,
                         startMonth ,
                         startYear ,
                         title,
                         description,
                         emailAddress);

                 if(!appt2.getValid())continue;

                 GregorianCalendar cal = new GregorianCalendar(startYear,startMonth,startDay);
                 CalDay day = new CalDay(cal);

                 day.addAppt(appt1);
                 day.addAppt(appt2);

                 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
                 if((iteration%10000)==0 && iteration!=0 )
                     System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

             }
         }catch(NullPointerException e){

         }

         System.out.println("Done testing...");

	 }


	
}
