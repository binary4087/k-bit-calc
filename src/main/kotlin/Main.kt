package com.kbitcalc

import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println("K-Bit Calc: Arbitrary-precision Bitwise Utility")
    println("Commands: AND, OR, XOR, NOT, EXIT")
    println("Input format: <OP> <VAL1> <VAL2> (e.g., AND 0xFF 0b1010)")

    while (true) {
        print("> ")
        if (!scanner.hasNext()) break
        val line = scanner.nextLine().trim()
        if (line.isEmpty()) continue
        
        val parts = line.split(" ")
        val op = parts[0].uppercase()
        
        if (op == "EXIT") break
        
        try {
            when (op) {
                "AND" -> executeBinaryOp(parts, BitCalc::and)
                "OR"  -> executeBinaryOp(parts, BitCalc::or)
                "XOR" -> executeBinaryOp(parts, BitCalc::xor)
                "NOT" -> executeUnaryOp(parts, BitCalc::not)
                else -> println("Unknown operation: $op")
            }
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }
}

fun executeBinaryOp(parts: List<String>, op: (java.math.BigInteger, java.math.BigInteger) -> java.math.BigInteger) {
    if (parts.size < 3) throw IllegalArgumentException("Binary operation requires two arguments")
    val a = BitCalc.parse(parts[1])
    val b = BitCalc.parse(parts[2])
    val result = op(a, b)
    println("Result: ${BitCalc.format(result)}")
}

fun executeUnaryOp(parts: List<String>, op: (java.math.BigInteger) -> java.math.BigInteger) {
    if (parts.size < 2) throw IllegalArgumentException("Unary operation requires one argument")
    val a = BitCalc.parse(parts[1])
    val result = op(a)
    println("Result: ${BitCalc.format(result)}")
}