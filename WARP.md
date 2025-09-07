# WARP.md

This file provides guidance to WARP (warp.dev) when working with code in this repository.

## Repository Overview

This is a BridgeLabz training repository containing fundamental Java programming exercises. The repository consists of standalone console applications demonstrating basic programming concepts, mathematical operations, and user input handling.

## Project Structure

```
Fundamental Problems/
├── Core-Java/          # Basic Java programs with user input
│   ├── BasicCalculator.java
│   ├── CourseFeeDiscount.java
│   ├── DistanceConverter.java
│   └── ... (20+ programs)
└── Java-Fundamentals/  # Fundamental Java exercises
    ├── AddTwoNumbers.java
    ├── SimpleInterest.java
    ├── Welcome.java
    └── ... (10+ programs)
```

Each Java file is a standalone program that can be compiled and run independently. Most programs follow a pattern of:
- Using `Scanner` for user input
- Performing calculations or conversions
- Displaying results with `System.out.println()`

## Common Development Tasks

### Compiling Programs

Prerequisites: Java Development Kit (JDK) installed. Verify with:
```powershell
javac -version
```

To compile a single program:
```powershell
# From repository root
javac Core-Java\BasicCalculator.java
javac Java-Fundamentals\AddTwoNumbers.java

# Compile all programs in a directory
javac Core-Java\*.java
javac Java-Fundamentals\*.java
```

Note: `.class` files are generated in the same directory as the source files.

### Running Programs

To run a compiled program from the repository root:
```powershell
# Windows PowerShell
java -cp . Core-Java\BasicCalculator
java -cp . Java-Fundamentals\AddTwoNumbers

# Or navigate to the directory first
cd Core-Java
java BasicCalculator
```

Programs typically prompt for user input via the console, so ensure you're running them in an interactive terminal.

### Adding New Programs

When creating new exercises:
1. Place the file in the appropriate directory (`Core-Java` or `Java-Fundamentals`)
2. Follow the naming convention: `PascalCase.java` (e.g., `TemperatureConverter.java`)
3. Include the standard pattern:
   ```java
   import java.util.Scanner;
   
   public class ProgramName {
       public static void main(String[] args) {
           Scanner scanner = new Scanner(System.in);
           // Your code here
           scanner.close();
       }
   }
   ```

### Cleaning Compiled Files

To remove all compiled `.class` files:
```powershell
# PowerShell
Get-ChildItem -Path . -Filter *.class -Recurse | Remove-Item

# Or manually
Remove-Item Core-Java\*.class
Remove-Item Java-Fundamentals\*.class
```

## Code Architecture

This repository doesn't follow a typical application architecture as each file is independent. Key patterns:

1. **No package declarations**: Programs use the default package
2. **Scanner pattern**: Most programs use `Scanner` for console input
3. **Single responsibility**: Each program demonstrates one concept (calculations, conversions, etc.)
4. **Educational focus**: Code prioritizes clarity over optimization

## Development Notes

- Programs are designed for educational purposes and may not handle all edge cases
- No external dependencies beyond standard Java libraries
- No build tools (Maven/Gradle) required - simple javac compilation
- Each program can be understood in isolation without referring to other files
