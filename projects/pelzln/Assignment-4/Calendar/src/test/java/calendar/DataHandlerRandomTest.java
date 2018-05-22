package calendar;

import java.util.*;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for DataHandler class.
 */

public class DataHandlerRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;


	private Appt getRandomAppt(Random random){
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
        Appt appt = new Appt(startHour,
                startMinute ,
                startDay ,
                startMonth ,
                startYear ,
                title,
                description,
                emailAddress);

        return appt;
    }

    /**
     * Return a randomly selected method to be tests !.
     */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"getApptRange","deleteAppt"};// The list of the of methods to be tested in the Appt class

        int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

        return methodArray[n] ; // return the method name
    }
    /**


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

				Appt appt1=getRandomAppt(random);
				if(!appt1.getValid())continue;
                Appt appt2=getRandomAppt(random);
                if(!appt2.getValid())continue;
                Appt appt3=getRandomAppt(random);
                if(!appt3.getValid())continue;
                Appt appt4=getRandomAppt(random);
                if(!appt4.getValid())continue;

                DataHandler handler = new DataHandler();

                for (int i = 0; i < NUM_TESTS; i++) {
                    String methodName = DataHandlerRandomTest.RandomSelectMethod(random);
                    if (methodName.equals("getApptRange")) {

                        GregorianCalendar day1 = new GregorianCalendar(appt1.getStartYear(), appt1.getStartMonth(), appt1.getStartDay());
                        GregorianCalendar day2 = new GregorianCalendar(appt2.getStartYear(), appt2.getStartMonth(), appt2.getStartDay());
                        GregorianCalendar day3 = new GregorianCalendar(appt3.getStartYear(), appt3.getStartMonth(), appt3.getStartDay());
                        GregorianCalendar day4 = new GregorianCalendar(appt4.getStartYear(), appt4.getStartMonth(), appt4.getStartDay());

                        CalDay cday1 = new CalDay(day1);
                        CalDay cday2 = new CalDay(day2);
                        CalDay cday3 = new CalDay(day3);
                        CalDay cday4 = new CalDay(day4);

                        cday1.addAppt(appt1);
                        cday2.addAppt(appt2);
                        cday3.addAppt(appt3);
                        cday4.addAppt(appt4);

                        int firstDay = ValuesGenerator.getRandomIntBetween(random, 0, 14);
                        int lastDay = ValuesGenerator.getRandomIntBetween(random, 15, 27);
                        int firstMonth = ValuesGenerator.getRandomIntBetween(random, 0, 5);
                        int lastMonth = ValuesGenerator.getRandomIntBetween(random, 6, 11);
                        int firstYear = ValuesGenerator.getRandomIntBetween(random, 2017, 2018);
                        int lastYear = ValuesGenerator.getRandomIntBetween(random, 2018, 2018);
                        GregorianCalendar fday = new GregorianCalendar(firstYear, firstMonth, firstDay);
                        GregorianCalendar lday = new GregorianCalendar(lastYear, lastMonth, lastDay);

                        handler.getApptRange(fday, lday);

                    } else if (methodName.equals("deleteAppt")) {
                        handler.saveAppt(appt1);
                        handler.saveAppt(appt2);
                        handler.saveAppt(appt3);
                        handler.saveAppt(appt4);
                        boolean check = handler.deleteAppt(appt1);
                    }

                }

				elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				if((iteration%10000)==0 && iteration!=0 )
					System.out.println("elapsed time: "+ elapsed + " of "+TestTimeout);

			}
		}catch(NullPointerException e){

		}

		System.out.println("Done testing...");

	}
	
}
