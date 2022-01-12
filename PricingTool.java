
/* Name; John Gitahi
    SMU; 48116033
	Lab 3 Fall-2019
*/	




import java.text.DecimalFormat; //program uses DecimalFormat
import java.util.Scanner; //program uses Scanner

public class PricingTool {

   static DecimalFormat formater = new DecimalFormat("#,###.00");//to display values in proper format
   static Scanner sc =new Scanner(System.in);
   static double totalCost=0.0;
   static double totalClientCost=0.0;
   static String staffingProposal="";
   static double consultantHourlyRate=35.00;
   static double SeniorConsultantHourlyRate=55.00;
   static double managerHourlyRate=65.00;
   static double seniorManagerHourlyRate=75.00;
   static double principalHourlyRate=100.00;
  
   static double consultantHourlyBillRate=135.00;
   static double seniorConsultantHourlyBillRate=155.00;
   static double managerHourlyBillRate=165.00;
   static double seniorManagerHourlyBillRate=175.00;
   static double principalHourlyBillRate=200;
  
   public static void main(String[] args) {
      
         
      
       System.out.println("Welcome to Princing Tool"); //welcome line
      
       while(true)
       {
           int option=displayMenu();
           switch(option)
           {
               case 1://hourly rates
                   displayHourlyRates();
               break;
              
               case 2://display hourly bill
                   displayHourlyBillRates();
               break;
              
               case 3://enter staff project
                   staffProject();
               break;
              
               case 4://display staff project
                   displayprojectStaffingProposal();
               break;
               case 5:
                   System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                   System.out.println("Your total cost fo employee salary per week is: $"+formater.format(totalCost));
                   System.out.println("The total cost to client per week is: $"+formater.format(totalClientCost));
                   System.out.println("Your profit per week is: $"+formater.format(calculateProfit()));
                   System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
               break;
               case 9:
                   System.out.println("You have successfully submitted your project proposal.Good-Bye!");
                   System.exit(0);
               break;
               default:
                   System.out.println("Incorrect menu option, please try again.");  
           }//end of switch case
       }//end of while loop
   }//end main method

   //Function to display Menu
   public static int displayMenu()
   {
       int option=0;
      
       //displaying menu
       System.out.println("Please choose from following menu options -");
       System.out.println("1)Display levels and hourly rates of consultants");
       System.out.println("2)Display levels and hourly bill rates of consultants");
       System.out.println("3)Staff project");
       System.out.println("4)Display project staffing proposal");
       System.out.println("5)Calculate profit");
       System.out.println("9)Submit project staffing proposal and exit");
      
       System.out.print("Option:");
       option=sc.nextInt();//input for option
      
       return option;
   }//end of display menu
  
   //Function to display employee hourly rates
   public static void displayHourlyRates()
   {
       System.out.println("Levels and Hourly Rates");
       System.out.println("-----------------------");
       System.out.println("Employee Level \t\tHourly Rate");
       System.out.println("--------------------------------------");
       System.out.println("--------------------------------------");
       System.out.println("Consultant \t\t$"+formater.format(consultantHourlyRate));
       System.out.println("Senior Consultant \t$"+formater.format(SeniorConsultantHourlyRate));
       System.out.println("Manager \t\t$"+formater.format(managerHourlyRate));
       System.out.println("Senior Manager \t\t$"+formater.format(seniorManagerHourlyRate));
       System.out.println("Principal \t\t$"+formater.format(principalHourlyRate));
   }//end of method displayHourlyRates()
  
   //Function to display hourly bill rates to clients
   public static void displayHourlyBillRates()
   {
       System.out.println("Levels and Hourly Bill Rates");
       System.out.println("-----------------------");
       System.out.println("Employee Level \t\tHourly Bill Rate");
       System.out.println("--------------------------------------");
       System.out.println("--------------------------------------");
       System.out.println("Consultant \t\t$"+formater.format(consultantHourlyBillRate));
       System.out.println("Senior Consultant \t$"+formater.format(seniorConsultantHourlyBillRate));
       System.out.println("Manager \t\t$"+formater.format(managerHourlyBillRate));
       System.out.println("Senior Manager \t\t$"+formater.format(seniorManagerHourlyBillRate));
       System.out.println("Principal \t\t$"+formater.format(principalHourlyBillRate));
   }//end of method displayHourlyBillRates
  
  
   public static void staffProject()
   {
       int num =0;
       double hours=0.0;
       int level=0;
       do
       {
           System.out.println("Enter 1 for Consultant");
           System.out.println("Enter 2 for Senior Consultant");
           System.out.println("Enter 3 for Manager");
           System.out.println("Enter 4 for Senior Manager");
           System.out.println("Enter 5 for Principal");
           System.out.println("Enter any other number when done.");
          
           System.out.print("Level:");
           level=sc.nextInt();//input for level
          
           switch(level)
           {
               case 1://to add consultant(s)
                   System.out.print("How many Consultans would you like to staff?");
                   num=sc.nextInt();
                   hours=getHoursPerWeek();
                   staffingProposal += num +" Consultant (s) at "+ hours+" hours per week\n";
                   updateTotalCost(num, hours, consultantHourlyRate);
                   updateTotalClientCost(num, hours, consultantHourlyBillRate);
                   break;
                  
               case 2://to add senior consultant(s)
                   System.out.print("How many Senior Consultans would you like to staff?");
                   num=sc.nextInt();
                   hours=getHoursPerWeek();
                   staffingProposal += num +" Senior Consultant(s) at "+ hours+" hours per week\n";
                   updateTotalCost(num, hours, SeniorConsultantHourlyRate);
                   updateTotalClientCost(num, hours, seniorConsultantHourlyBillRate);
                   break;
                  
               case 3://to add manager(s)
                   System.out.print("How many Managers would you like to staff?");
                   num=sc.nextInt();
                   hours=getHoursPerWeek();
                   staffingProposal += num +" Manager(s) at "+ hours+" hours per week\n";
                   updateTotalCost(num, hours, managerHourlyRate);
                   updateTotalClientCost(num, hours, managerHourlyBillRate);
                   break;
               case 4://To add senior manager(s)
                   System.out.print("How many Senior Managers would you like to staff?");
                   num=sc.nextInt();
                   hours=getHoursPerWeek();
                   staffingProposal += num +" Senior Manager(s) at "+ hours+" hours per week\n";
                   updateTotalCost(num, hours, seniorManagerHourlyRate);
                   updateTotalClientCost(num, hours, seniorManagerHourlyBillRate);
                  
                   break;
               case 5://To add principal(s)
                   System.out.print("How many Principals would you like to staff?");
                   num=sc.nextInt();
                   hours=getHoursPerWeek();
                   staffingProposal += num +" Principals (s) at "+ hours+" hours per week\n";
                   updateTotalCost(num, hours, principalHourlyRate);
                   updateTotalClientCost(num, hours, principalHourlyBillRate);
                   break;
           }
       }while((level>=1)&&(level<=5));
      
   }//end of method staffProject
  
   public static double getHoursPerWeek()
   {
       System.out.println("How many hours per week?");
       return sc.nextDouble();
      
   }//end of method getHoursPerWeek
  
   public static void updateTotalCost(int num ,double hours, double rate)
   {
       totalCost+=rate*num*hours;
       System.out.println("The current employee cost with hourly rate of $"+rate+" is $"+formater.format(totalCost));
      
   }//end of method updateTotalCost
  
   public static void updateTotalClientCost(int num ,double hours, double rate)
   {
       totalClientCost+=rate*num*hours;
       System.out.println("The current cost to the client with hourly bill rate of $"+rate+" is $"+formater.format(totalClientCost));
   }//end of method updateTotalClientCost
  
   public static void displayprojectStaffingProposal()
   {
       //This function displays staffing proposals
       System.out.println(staffingProposal);
      
   }//end of method displayprojectStaffingProposal
  
   public static double calculateProfit()
   {
       //as per output requirement of the program profit=totalClientCost-totalCost
       //and return output to main method switch case 5
       return totalClientCost-totalCost;
      
   }//end of method calculateProfit
  
}//end PrincingTool class