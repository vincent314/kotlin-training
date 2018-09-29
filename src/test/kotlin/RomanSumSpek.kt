import org.amshove.kluent.shouldEqual
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it


object RomanSumSpek : Spek({
    describe("RomanSum") {
        it("should unpack simple numerals") {
            unpack("I") shouldEqual "I" // 1
            unpack("IV") shouldEqual "IIII" // 4
            unpack("IX") shouldEqual "VIIII" // 9
            unpack("XL") shouldEqual "XXXX" // 40
            unpack("XC") shouldEqual "LXXXX" // 90
            unpack("CD") shouldEqual "CCCC" // 400
            unpack("CM") shouldEqual "DCCCC" // 900
        }
        it("should unpack complexe numerals") {
            unpack("MMMCDLIV") shouldEqual "MMMCCCCLIIII" // 3.454
            unpack("MCLV") shouldEqual "MCLV" // 1.155
        }
        it("should merge 2 decompacted roman values") {
            merge("I", "X") shouldEqual "XI" // 1 + 10 = 11
            merge("XI", "VI") shouldEqual "XVII"  // 11 + 6 = 17
            merge("XVII", "CL") shouldEqual "CLXVII" // 17 + 550 = 567
            merge("XVIIII", "XXIIII") shouldEqual "XXXVIIIIIIII" // 19 + 24 = 43
            merge("MMCCCLIIII", "MCXXIIII") shouldEqual "MMMCCCCLXXIIIIIIII" // 2354 + 1124 = 3478
        }
        it("should group decompacted roman numeral") {
            group("IIIII") shouldEqual "V" // 5
            group("VV") shouldEqual "X" // 10
            group("XXXXX") shouldEqual "L" // 50
            group("LL") shouldEqual "C" // 100
            group("CCCCC") shouldEqual "D" // 500
            group("DD") shouldEqual "M" // 1000
            group("VVV") shouldEqual "XV" // 15
            group("XXXXXXX") shouldEqual "LXX" // 70
            group("LLI") shouldEqual "CI" // 101
            group("DDDLL") shouldEqual "MDC" // 1600
            group("MMMMMMXXXXXX") shouldEqual "MMMMMMLX" // 6060
            group("XXXVIIIIIIII") shouldEqual "XXXXIII" // 43
        }
        it("should simplify decompacted roman numeral") {
            simplify("IIII") shouldEqual "IV" // 4
            simplify("VIIII") shouldEqual "IX" // 9
            simplify("XXXX") shouldEqual "XL" // 40
            simplify("LXXXX") shouldEqual "XC" // 90
            simplify("CCCC") shouldEqual "CD" // 400
            simplify("DCCCC") shouldEqual "CM" // 900

            simplify("CCCCXXIIII") shouldEqual "CDXXIV" // 424
            simplify("XXXXIII") shouldEqual "XLIII" // 43
        }

        it("should add 2 roman numerals") {
            sum("I", "I") shouldEqual "II" // 1 + 1 = 2
            sum("I", "C") shouldEqual "CI" // 1 + 100 = 101
            sum("V", "XI") shouldEqual "XVI" // 5 + 11 = 16
            sum("XXXIX", "I") shouldEqual "XL" // 39 + 1 = 40
            sum("XCIX","I") shouldEqual "C" // 99 + 1 = 100
            sum("XIX", "XXIV") shouldEqual "XLIII" // 19 + 24 = 43
            sum("DCXCIV", "MMCCCLIV") shouldEqual "MMMXLVIII" // 694 + 2354 = 3048
        }

    }

})