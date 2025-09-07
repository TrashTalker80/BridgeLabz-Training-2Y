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

# Level 1 Practice Programs

1. Write a program to input the Principal, Rate, and Time values and calculate Simple Interest.

**Hint \=\>** 

1. Simple Interest \= Principal \* Rate \* Time / 100  
2. Take user input for principal, rate, time  
3. Write a method to calculate the simple interest given principle, rate and time as parameters  
4. Output “The Simple Interest is \_\_\_ for Principal \_\_\_, Rate of Interest \_\_\_ and Time \_\_\_”

2. Create a program to find the maximum number of handshakes among students.

**Hint \=\>** 

1. Get integer input for the numberOfStudents variable.  
2. Use the combination \= (n \* (n \- 1)) / 2 formula to calculate the maximum number of possible handshakes.  
3. Write a method to use the combination formulae to calculate the number of handshakes  
4. Display the number of possible handshakes.

3. An athlete runs in a triangular park with sides provided as input by the user in meters. If the athlete wants to complete a 5 km run, then how many rounds must the athlete complete

**Hint \=\>** 

1. Take user input for 3 sides of a triangle   
2. The perimeter of a triangle is the addition of all sides and rounds is distance/perimeter  
3. Write a Method to compute the number of rounds user needs to do to complete 5km run

4. Write a program to check whether a number is positive, negative, or zero.

**Hint \=\>** Get integer input from the user. Write a Method to return \-1 for negative number, 1 for positive number and 0 if number is zero

5. Write a program SpringSeason that takes two int values month and day from the command line and prints “Its a Spring Season” otherwise prints “Not a Spring Season”. 

**Hint \=\>** Spring Season is from March 20 to June 20\. Write a Method to check for Spring season and return a boolean true or false 

6. Write a program to find the sum of n natural numbers using loop

**Hint \=\>** Get integer input from the user. Write a Method to find the sum of n natural numbers using loop 

7. Write a program to find the smallest and the largest of the 3 numbers.

**Hint \=\>** 

1. Take user input for 3 numbers  
2. Write a single method to find the smallest and largest of the three numbers

   ***public static int\[\] findSmallestAndLargest(int number1, int number2, int number3)***

8. Write a program to take 2 numbers and print their quotient and reminder

**Hint \=\>** 

1. Take user input as integer  
2. Use division operator (/) for quotient and moduli operator (%) for reminder  
3. Write Method to find the reminder and the quotient of a number 

   ***public static int\[\] findRemainderAndQuotient(int number, int divisor)*** 

9. Create a program to divide N number of chocolates among M children. Print the number of chocolates each child will get and also the remaining chocolates

**Hint \=\>** 

1. Get an integer value from user for the numberOfchocolates and numberOfChildren.  
2. Write the method to find the number of chocolates each child gets and number of remaining chocolates

   ***public static int\[\] findRemainderAndQuotient(int number, int divisor)*** 

10. Write a program calculate the wind chill temperature given the temperature and wind speed

**Hint \=\>** 

1. Write a method to calculate the wind chill temperature using the formula 

   windChill \= 35.74 \+ 0.6215 \*temp \+ (0.4275\*temp \- 35.75) \* windSpeed0.16 

   ***public double calculateWindChill(double temperature, double windSpeed)***

11. Write a program to calculate various trigonometric functions using Math class given an angle in degrees

**Hint \=\>** 

1. Method to calculate various trigonometric functions, Firstly convert to radians and then use Math function to find sine, cosine and tangent.

   ***public double\[\] calculateTrigonometricFunctions(double angle)***

   