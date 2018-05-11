import kotlinext.js.js
import kotlinext.js.jsObject
import react.native.StyleSheet

interface StyleNames {
    var common : dynamic
    var menu : dynamic
    var menuItem : dynamic
}
val styles : StyleNames = StyleSheet.create(jsObject<StyleNames> {
    common = js {
        //backgroundColor = "powderblue"
        flex = 1
        flexDirection = "row"
    }
    menu = js {
        //backgroundColor = "powderblue"
        flex = 1
    }
    menuItem = js {
        flex = 1
        //flexDirection = "row"
    }
})
