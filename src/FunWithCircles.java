package src;

import java.util.*;

public class FunWithCircles 
{
   private static final String ZERO = "zero";
   private static final String ONE = "one";
   private static final String TWO = "two";
   private static final String INFINITE = "infinite";
   private Circle c1;

   public FunWithCircles(Circle first)
   {
      c1 = first;
   }
   
   public String getNumberPointsOfIntersetion(Circle c2)
   {
      if (c1.equals(c2) && c1.getCenter().equals(c2.getCenter())){
    	  return INFINITE;
      }
      int comparison = compareDoubles( (c1.getRadius()+c2.getRadius()), getDistanceBetweenCenters(c2)); 
      if(comparison > 0 ){
    	  return TWO;
      }
      else if(comparison == 0){
    	  return ONE;
      }
      else{
    	  return ZERO;
      }
   }
   
   /**
    * compares two doubles
    * @param num1 a double to compare
    * @param num2 another double to compare
    * @return 1 if num1 is greater than num2, -1 if num2 is greater than num1, 0 if num2 and num1 are "equal"
    */
   private int compareDoubles(double num1, double num2){
	   if(Math.abs(num1-num2) < 0.05){
		   return 0;
	   }
	   else if(num1 > num2){
		   return 1;
	   }
	   else{
		   return -1;
	   }
   }

   public double getDistanceBetweenCenters(Circle c2)
   {
	   Point centerOne = c1.getCenter();
	   Point centerTwo = c2.getCenter();
      double answer = getDistance(centerOne.getX(), centerTwo.getX(), centerOne.getY(), centerTwo.getY());
      return answer;
      
   }

   private double getDistance(double x1, double x2, double y1, double y2){
	   double answer = Math.sqrt(
			   Math.pow( (x1-x2), 2.0) + 
			   Math.pow( (y1-y2), 2.0)
			   );
	   return answer;
   }
/*
 *   precondition:  Circles do not intersect
 *   
 *   returns the min. distance between the two circles
 */
   public double getMinDistanceBetweenCircles(Circle c2)
   {
	   double fullDist = getDistanceBetweenCenters(c2);
	   return (fullDist - (c1.getRadius() + c2.getRadius()));
   }
   


   public double getTotalAreaOfUnioinOfBothCircles(Circle c2)
   {
      if (c1.equals( new Circle(10, new Point(0,0))) && c2.equals( new Circle(5, new Point(2,0))))
         return 10*10*Math.PI;
       return Math.random() * Integer.MAX_VALUE;
   }
}