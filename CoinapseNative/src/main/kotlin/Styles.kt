import com.nominanuda.krui.react.native.column
import com.nominanuda.krui.react.native.mkStyle
import com.nominanuda.krui.react.native.row
import kotlinext.js.js
import kotlinext.js.jsObject
import react.native.*


interface StyleNames {
    var common : Style
    var menu : Style
    var menuItem : Style
}
val styles : StyleNames = StyleSheet.create(jsObject<StyleNames> {
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
    menuItem = mkStyle {
        flex = 1
        flexDirection = row
        //alignItems = "center"
        borderColor = "red"
        borderWidth = 1
    }
})

val MENU_WIDTH = 300