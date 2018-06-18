import org.junit.Test
import java.math.BigDecimal
import java.math.MathContext
import java.math.MathContext.DECIMAL128
import java.math.MathContext.UNLIMITED

class moo {
    @Test
    fun main(/*args : Array<String>**/) {
        val mc : MathContext = DECIMAL128//UNLIMITED
        val tot = 100.0
        val colGutRatio = 5.0
        val x = colGutRatio * 12.0  + 11.0
        val gut = tot / x
        val col = gut * colGutRatio
        println("val gridCol = ${gut.toDouble().toString()}%")
        println("val gridGut = ${col.toDouble().toString()}%")

        var z = 0.0
        for(i in 1..12) {
            println("//Col #${i}")
            println("val col_${i}_l : Double = ${z.toDouble().toString()}")
            z = z + col
            println("val col_${i}_r : Double = ${z.toDouble().toString()}")
            z = z + gut
        }
        print("ddd")
    }

//    @Test
//    fun main(/*args : Array<String>**/) {
//        val mc : MathContext = DECIMAL128//UNLIMITED
//        val tot = BigDecimal("100", mc)
//        val colGutRatio = BigDecimal("5", mc)
//        val x = colGutRatio.multiply(BigDecimal("12"), mc).plus(BigDecimal("11"))
//        val gut = tot.divide(x, mc)
//        val col = gut.multiply(colGutRatio)
//        println("val gridCol = ${gut.toDouble().toString()}%")
//        println("val gridGut = ${col.toDouble().toString()}%")
//
//        var z = BigDecimal("0", mc)
//        for(i in 1..12) {
//            println("//Col #${i}")
//            println("val col_${i}_l : Double = ${z.toDouble().toString()}")
//            z = z.add(col)
//            println("val col_${i}_r : Double = ${z.toDouble().toString()}")
//            z = z.add(gut)
//        }
//        print("ddd")
//    }

}
