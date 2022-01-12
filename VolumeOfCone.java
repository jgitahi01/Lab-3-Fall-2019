
/* Name; John Gitahi
    SMU; 48116033
	Lab 2 Fall-2019
*/	




import java.util.Scanner;// program uses Scanner

public class VolumeOfCone 
{

    public static double volume(double radius, double height) 
	{
        return (1.0/3)*Math.PI*radius*radius*height;//return a double
    }//end volume

    public static void main(String[] args) // main method
	{
        Scanner in = new Scanner(System.in);//create scanner to obtain input from command
        System.out.print("Enter the radius of the cone: ");//prompts user to enter radius of Cone
        double radius = in.nextDouble();//read input from user
        System.out.print("Enter the height of the cone: ");
        double height = in.nextDouble();//read input from user
        System.out.printf("The volume of the cone with radius %.4f and height %.4f is: %.4f\n", radius, height, volume(radius, height));
    }//end main
}//end class
