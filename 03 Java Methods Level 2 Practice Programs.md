# Best Programming Practice 

1. All values as variables including Fixed, User Inputs, and Results   
2. Proper naming conventions for all variables   
3. Proper Program Name and Class Name  
4. Proper Method Name which indicates action taking inputs and providing result

**Sample Program 1:** Create a program to find the sum of all the digits of a number given by a user using an array and display the sum.

1. Use Math.random() and get a 4-digit random integer number  
2. Write a method to count digits in the number   
3. Write a method to return an array of digits from a given number.   
4. Write a method to Find the sum of the digits of the number in the array  
5. Finally, display the sum of the digits of the number

```java
// Create SumOfDigit Class to compute the sum of 4 digits random number 
class SumOfDigits {
   // Get a 4 digit random number
   public int get4DigitRandomNumber() {
      return (int) (Math.random() * 9000) + 1000;
   }

   // Find the count of digits in the number
   public int countDigits(int number) {
      int count = 0, temp = number;
      while (temp > 0) {
         count++;
         temp /= 10;
      }
      return count;
   }

   // Store the digits of the number in an array
   public int[] getDigits(int number, int count) {
      int[] digits = new int[count];
      int temp = number;
      for (int i = count - 1; i >= 0; i--) {
         digits[i] = temp % 10;
         temp /= 10;
      }
      return digits;
   }
   // Find the sum of the elements in an array
   public int sumArray(int[] array) {
      int sum = 0;
      for (int i = 0; i < array.length; i++) {
         sum += array[i];
      }
      return sum;
   }

   public static void main(String[] args) {
      // Get 4 digit random integer number
      SumOfDigits sumOfDigits = new SumOfDigits();
      int number = sumOfDigits.get4DigitRandomNumber();
      System.out.println("The Random Mumber is: " + number);

      // Get the count of digits
      int count = sumOfDigits.countDigits(number);	
      System.out.println("The count of digit is: " + count);

      // Get the array of digits from the number
      int[] digits = sumOfDigits.getDigits(number, count);

      // Find the sum of the digits of the number
      int sum = sumOfDigits.sumArray(digits);

      // Display the sum of the digits of the number
      System.out.println("\nSum of Digits: " + sum);
   }
}
```

# 

# Level 2 Practice Programs

1. Create a program to find the factors of a number taken as user input, store the factors in an array, and display the factors. Also find the sum, sum of square of factors and product of the factors and display the results

**Hint \=\>** 

1. Take the input for a number  
2. Write a ***static*** Method to find the factors of the number and save them in an array and return the array.   
3. To find factors and save to array will have two loops. The first loop to find the count and initialize the array with the count. And the second loop save the factors into the array  
4. Write a method to find the sum of the factors using factors array  
5. Write a method to find the product of the factors using factors array  
6. Write a method to find the sum of square of the factors using ***Math.pow()*** method

2. Write a program to find the sum of n natural numbers using recursive method and compare the result with the formulae n\*(n+1)/2 and show the result from both computations is correct. 

**Hint \=\>** 

1. Take the user input number and check whether it's a Natural number  
2. Write a Method to find the sum of n natural numbers using **recursion**  
3. Write a Method to find the sum of n natural numbers using the formulae n\*(n+1)/2   
4. Compare the two results and print the result

3. Write a program that takes a year as input and outputs the Year is a Leap Year or not 

**Hint \=\>** 

1. The LeapYear program only works for year \>= 1582, corresponding to a year in the Gregorian calendar.   
2. Also Leap year is divisible by 4 and not divisible by 100 or divisible by 400  
3. Write a method to check for Leap Year using the conditions a and b

4. Extend or Create a ***UnitConvertor*** utility class similar to the one shown in the notes to do the following.  Please define ***static*** methods for all the UnitConvertor class methods. E.g. 

***public static double convertKmToMiles(double km)*** **\=\>** 

1. Method To convert kilometers to miles and return the value. Use the following code  `double km2miles = 0.621371;`  
2. Method to convert miles to kilometers and return the value. Use the following code  `double miles2km = 1.60934;`  
3. Method to convert meters to feet and return the value. Use the following code to convert  `double meters2feet = 3.28084;`  
4. Method to convert feet to meters and return the value. Use the following code to convert  `double feet2meters = 0.3048;`

5. Extend or Create a ***UnitConvertor*** utility class similar to the one shown in the notes to do the following.  Please define ***static*** methods for all the UnitConvertor class methods. E.g. 

***public static double convertYardsToFeet(double yards)*** **\=\>** 

1. Method to convert yards to feet and return the value. Use following code to convert  `double yards2feet = 3;`  
2. Method to convert feet to yards and return the value. Use following code to convert  `double feet2yards = 0.333333;`  
3. Method to convert meters to inches and return the value. Use following code to convert  `double meters2inches = 39.3701;`  
4. Method to convert inches to meters and return the value. Use following code to convert  `double inches2meters = 0.0254;`  
5. Method to convert inches to centimeters and return the value. Use the following code  `double inches2cm = 2.54;`

6. Extend or Create a ***UnitConvertor*** utility class similar to the one shown in the notes to do the following.  Please define ***static*** methods for all the UnitConvertor class methods. E.g. 

***public static double convertFarhenheitToCelsius(double farhenheit)*** **\=\>** 

1. Method to convert Fahrenheit to Celsius and return the value. Use the following code  `double farhenheit2celsius = (farhenheit - 32) * 5 / 9;`  
2. Method to convert Celsius to Fahrenheit and return the value. Use the following code  `double celsius2farhenheit = (celsius * 9 / 5) + 32;`  
3. Method to convert pounds to kilograms and return the value. Use the following code  `double pounds2kilograms = 0.453592;`  
4. Method to convert kilograms to pounds and return the value. Use the following code  `double kilograms2pounds = 2.20462;`   
5. Method to convert gallons to liters and return the value. Use following code to convert   `double gallons2liters = 3.78541;`   
6. Method to convert liters to gallons and return the value. Use following code to convert  `double liters2gallons = 0.264172;` 

7. Write a program to take user input for the age of all 10 students in a class and check whether the student can vote depending on his/her age is greater or equal to 18\.

**Hint \=\>** 

1. Create a class ***public class StudentVoteChecker*** and define a method ***public boolean canStudentVote(int age)*** which takes in age as a parameter and returns true or false  
2. Inside the method firstly validate the age for a negative number, if a negative return is false cannot vote. For valid age check for age is 18 or above return true; else return false;  
3. In the main function define an array of 10 integer elements, loop through the array by take user input for the student's age, call canStudentVote() and display the result

8. Create a program to find the youngest friends among 3 Amar, Akbar and Anthony based on their ages and tallest among the friends based on their heights and display it

**Hint \=\>** 

1. Take user input for age and height for the 3 friends and store it in two arrays each to store the values for age and height of the 3 friends  
2. Write a Method to find the youngest of the 3 friends  
3. Write a Method to find the tallest of the 3 friends

9. Write a program to take user input for 5 numbers and check whether a number is positive or negative. Further for positive numbers check if the number is even or odd. Finally compare the first and last elements of the array and display if they are equal, greater, or less

**Hint \=\>** 

1. Write a Method to Check whether the number is positive or negative  
2. Write a Method to check whether the number is even or odd  
3. Write a Method to compare two numbers and return 1 if number1 \> number2 or 0 if both are equal or \-1 if number1 \< number2   
4. In the main program, Loop through the array using the length call the method ***isPositive()*** and if positive call method ***isEven()*** and print accordingly   
5. If the number is negative, print negative.   
6. Finally compare the first and last element of the array by calling the method ***compare()*** and display if they are equal, greater, or less

10. An organization took up the exercise to find the Body Mass Index (BMI) of all the persons in the team of 10 members. For this create a program to find the BMI and display the height, weight, BMI and status of each individual

**Hint \=\>** 

1. Take user input in double for the weight (in kg) of the person and height (in cm) for the person and and store it in the corresponding 2D array of 10 rows and 3 columns. The First Column storing the weight, the second column storing the height in cm and the third column is the BMI  
2. Create a Method to find the BMI of every person and populate the array. Use the formula BMI \= weight / (height \* height). Note unit is kg/m^2. For this convert cm to meter  
3. Create a Method to determine the BMI status using the logic shown in the figure below. and return the array of all the persons BMI Status.   
   ![][image1] 

11. Write a program Quadratic to find the roots of the equation ax2+ bx \+ c. Use Math functions ***Math.pow()*** and ***Math.sqrt()***

**Hint \=\>** 

1. Take a, b, and c as input values to find the roots of x.  
2. The roots are computed using the following formulae  
   delta \= b2+ 4\*a\*c

   If delta is positive the find the two roots using formulae 

   root1 of x \= (-b \+ delta)/(2\*a) 

   root1 of x \= (-b \- delta)/(2\*a)

   If delta is zero then there is only one root of x  

   root of x \= \-b/(2\*a)

   If delta is negative return empty array or nothing 

3. Write a Method to find find the roots of a quadratic equation and return the roots

12. Write a program that generates five 4 digit random values and then finds their average value, and their minimum and maximum value. Use Math.random(), Math.min(), and Math.max().

**Hint \=\>** 

1. Write a method that generates array of 4 digit random numbers given the size as a parameter as shown in the method signature 

   ***public int\[\] generate4DigitRandomArray(int size)***

2. Write a method to find average, min and max value of an array 

   ***public double\[\] findAverageMinMax(int\[\] numbers)*** 

   

[image1]: <data:image/png;base64,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>