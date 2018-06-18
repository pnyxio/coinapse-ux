package com.nominanuda.kjs.application

import com.nominanuda.krui.react.native.widthPercentageToDP


interface Layout {
    fun nColsDp(n: Int): Double = n * columnDp + (n - 1) * gutterDp
    var columnDp : Double
    //var columnPerc : String
    var halfGutterDp : Double
    var gutterDp : Double
    //var gutterPerc : String
    //var pageMarginPerc : String
    var pageMarginDp : Double
}

class LayoutImpl : Layout {
    override var columnDp: Double
    private var columnPerc: String
    override var gutterDp: Double
    override var halfGutterDp: Double
    private var gutterPerc: String
    private var pageMarginPerc: String
    override var pageMarginDp: Double
    private val c : Double
    private val g : Double
    private val m : Double
    constructor(gutterColumnRatio: Double, marginColumnRatio: Double, nColumns: Int = 12) {
        c = 100.0 / ( 2 * marginColumnRatio + (nColumns - 1) * gutterColumnRatio + nColumns )
        columnPerc = "${c}%"
        columnDp = widthPercentageToDP(c)
        g = c * gutterColumnRatio
        gutterPerc = "${g}%"
        gutterDp = widthPercentageToDP(g)
        halfGutterDp = widthPercentageToDP(g/2)
        m = c * marginColumnRatio
        pageMarginPerc = "${m}%"
        pageMarginDp = widthPercentageToDP(m)
    }
}
