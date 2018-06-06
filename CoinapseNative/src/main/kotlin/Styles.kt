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
        flexDirection = row//"react.native.getRow"
    }
    menu = mkStyle {
        //backgroundColor = "powderblue"
        flex = 1
    }
    menuItem = mkStyle {
        flex = 1
        //flexDirection = "react.native.getRow"
    }
})
