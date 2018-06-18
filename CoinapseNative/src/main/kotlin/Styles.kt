import com.nominanuda.kjs.application.Layout
import com.nominanuda.kjs.application.LayoutImpl
import com.nominanuda.krui.react.native.column
import com.nominanuda.krui.react.native.mkStyle
import com.nominanuda.krui.react.native.row
import common.copy
import kotlinext.js.jsObject
import react.native.*

val LAYOUT : Layout = LayoutImpl(0.2, 0.2)

//TODO mv to framework
val MENU_WIDTH = 300

fun hBox(vararg src : Any, builder: Style.() -> Unit) : Style = mkStyle {
    //flex = 1
    flexDirection = row
}.copy(*src) { builder() }


//end TODO

interface NamedStyles {
    var common : Style
    var menu : Style
//    var menuItem : Style
}


val STYLES : NamedStyles = StyleSheet.create(jsObject<NamedStyles> {
    common = mkStyle {
        //backgroundColor = "powderblue"
        flex = 1
        flexDirection = row
    }
    menu = mkStyle {
        flex = 1
        flexDirection = column
        borderColor = "black"
        borderWidth = 1
        width = MENU_WIDTH
    }
//    menuItem = hBox().assign() {
//    }
})// as NamedStyles

