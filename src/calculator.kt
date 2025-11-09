import java.util.Scanner

/**
 * A simple Kotlin console calculator.
 * Supports basic arithmetic: addition, subtraction, multiplication, and division.
 * Demonstrates:
 *  - User input handling
 *  - Control flow (when statements)
 *  - Functions
 *  - Exception handling
 */

fun main() {
    val scanner = Scanner(System.`in`)

    println("===== Kotlin Simple Calculator =====")

    // Main loop to keep program running until user exits
    while (true) {
        println("\nSelect an operation:")
        println("1. Addition (+)")
        println("2. Subtraction (-)")
        println("3. Multiplication (*)")
        println("4. Division (/)")
        println("5. Exit")
        print("Enter choice (1-5): ")

        val choice = scanner.nextLine()

        if (choice == "5") {
            println("Exiting calculator. Goodbye!")
            break
        }

        print("Enter first number: ")
        val num1 = scanner.nextLine().toDoubleOrNull()
        print("Enter second number: ")
        val num2 = scanner.nextLine().toDoubleOrNull()

        if (num1 == null || num2 == null) {
            println("❌ Invalid input. Please enter valid numbers.")
            continue
        }

        val result = when (choice) {
            "1" -> add(num1, num2)
            "2" -> subtract(num1, num2)
            "3" -> multiply(num1, num2)
            "4" -> divide(num1, num2)
            else -> {
                println("❌ Invalid choice. Please select between 1-5.")
                continue
            }
        }

        if (result != null) {
            println("✅ Result: $result")
        }
    }
}

// Functions for each operation
fun add(a: Double, b: Double): Double = a + b
fun subtract(a: Double, b: Double): Double = a - b
fun multiply(a: Double, b: Double): Double = a * b

fun divide(a: Double, b: Double): Double? {
    return if (b == 0.0) {
        println("❌ Error: Cannot divide by zero.")
        null
    } else {
        a / b
    }
}
