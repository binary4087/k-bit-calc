package com.kbitcalc

import java.math.BigInteger

object BitCalc {
    fun parse(input: String): BigInteger {
        return when {
            input.startsWith("0x", ignoreCase = true) -> BigInteger(input.substring(2), 16)
            input.startsWith("0b", ignoreCase = true) -> BigInteger(input.substring(2), 2)
            else -> BigInteger(input)
        }
    }

    fun format(value: BigInteger): String {
        return "Dec: ${value} | Hex: 0x${value.toString(16).uppercase()} | Bin: 0b${value.toString(2)}"
    }

    fun and(a: BigInteger, b: BigInteger) = a.and(b)
    fun or(a: BigInteger, b: BigInteger) = a.or(b)
    fun xor(a: BigInteger, b: BigInteger) = a.xor(b)
    fun nand(a: BigInteger, b: BigInteger) = a.and(b).not()
    fun nor(a: BigInteger, b: BigInteger) = a.or(b).not()
    fun not(a: BigInteger) = a.not()
    fun lsh(a: BigInteger, b: BigInteger) = a.shiftLeft(b.toInt())
    fun rsh(a: BigInteger, b: BigInteger) = a.shiftRight(b.toInt())
}