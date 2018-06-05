package calendar;

import java.util.Calendar;
import java.util.Random;

import org.junit.Test;



import static org.junit.Assert.*;



/**
 * Random Test Generator  for Appt class.
 */

public class ApptRandomTest {

	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=100;

	/**
	 * Return a randomly selected method to be tests !.
	 */
    public static String RandomSelectMethod(Random random){
        String[] methodArray = new String[] {"setTitle","setRecurrence","setRecurDays","setValid","isOn","setEmailAddress"};// The list of the of methods to be tested in the Appt class

    	int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)
    	            
        return methodArray[n] ; // return the method name 
        }
	/**
	 * Return a randomly selected appointments to recur Weekly,Monthly, or Yearly !.
	 */
    public static int RandomSelectRecur(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_BY_WEEKLY,Appt.RECUR_BY_MONTHLY,Appt.RECUR_BY_YEARLY};// The list of the of setting appointments to recur Weekly,Monthly, or Yearly

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return the value of the  appointments to recur 
        }	
	/**
	 * Return a randomly selected appointments to recur forever or Never recur  !.
	 */
    public static int RandomSelectRecurForEverNever(Random random){
        int[] RecurArray = new int[] {Appt.RECUR_NUMBER_FOREVER,Appt.RECUR_NUMBER_NEVER};// The list of the of setting appointments to recur RECUR_NUMBER_FOREVER, or RECUR_NUMBER_NEVER

    	int n = random.nextInt(RecurArray.length);// get a random number between 0 (inclusive) and  RecurArray.length (exclusive)
        return RecurArray[n] ; // return appointments to recur forever or Never recur 
        }	
   /**
     * Generate Random Tests that tests Appt Class.
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
				 int startMinute=ValuesGenerator.getRandomIntBetween(random, 1, 11);
				 int startDay=ValuesGenerator.getRandomIntBetween(random, 1, 11);
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

		         if(!appt.getValid())continue;
		         for (int i = 0; i < NUM_TESTS; i++) {
					String methodName = ApptRandomTest.RandomSelectMethod(random);
					   if (methodName.equals("setTitle")){
						   String newTitle=(String) ValuesGenerator.getString(random);
						   appt.setTitle(newTitle);
						   assertEquals(newTitle,appt.getTitle());
                       }
                       else if(methodName.equals("setEmailAddress")){
					       assertEquals(emailAddress,appt.getEmailAddress());
                       }
					   else if (methodName.equals("setRecurrence")){
						   int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
						   int[] recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
						   int recur=ApptRandomTest.RandomSelectRecur(random);
						   int recurIncrement = ValuesGenerator.RandInt(random);
						   int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
						   appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
					   }
                       else if (methodName.equals("setRecurDays")){
                           int sizeArray=ValuesGenerator.getRandomIntBetween(random, 0, 8);
                           int[] recurDays=null;
                           if ((sizeArray & 1)==0){
                               recurDays=ValuesGenerator.generateRandomArray(random, sizeArray);
                           }
                           int recur=ApptRandomTest.RandomSelectRecur(random);
                           int recurIncrement = ValuesGenerator.RandInt(random);
                           int recurNumber=ApptRandomTest.RandomSelectRecurForEverNever(random);
                           appt.setRecurrence(recurDays, recur, recurIncrement, recurNumber);
                       }
                       else if (methodName.equals("isOn")){
                           int day=ValuesGenerator.getRandomIntBetween(random, 1, 11);
                           int month=ValuesGenerator.getRandomIntBetween(random, 1, 11);
                           int year=ValuesGenerator.getRandomIntBetween(random, 2017, 2018);
                           if(day==startDay && month==startMonth && year==startYear) {
                               assertTrue(appt.isOn(day,month,year));
                           }else{
                               assertFalse(appt.isOn(day,month,year));
                           }
                       }
                       else if (methodName.equals("setValid")){
					       boolean good = true;
                           int startHour2=ValuesGenerator.getRandomIntBetween(random, -5, 30);
                           if(startHour2<0 || startHour2>23){good=false;}
                           int startMinute2=ValuesGenerator.getRandomIntBetween(random, -10, 100);
                           if(startMinute2<0 || startMinute2>59){good=false;}
                           int startMonth2=ValuesGenerator.getRandomIntBetween(random, -5, 20);
                           if(startMonth2<1 || startMonth2>12){good=false;}
                           int startYear2=ValuesGenerator.getRandomIntBetween(random, -1, 2);
                           if(startYear2<=0){good=false;}
                           int startDay2=ValuesGenerator.getRandomIntBetween(random, -5, 40);
                           if(startDay2<1 || startDay2>CalendarUtil.NumDaysInMonth(startYear2,startMonth2-1)){good=false;}
                           String title2="Birthday Party";
                           String description2="This is my birthday party.";
                           String emailAddress2="xyz@gmail.com";

                           //Construct a new Appointment object with the initial data
                           //Construct a new Appointment object with the initial data
                           Appt appt2 = new Appt(startHour2,
                                   startMinute2 ,
                                   startDay2 ,
                                   startMonth2 ,
                                   startYear2 ,
                                   title2,
                                   description2,
                                   emailAddress2);
                           appt2.setValid();
					       assert(appt2.getValid()==good);
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
