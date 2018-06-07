package component

import com.nominanuda.krui.react.native.mkStyle
import com.nominanuda.krui.react.native.row
import img.boxed_cross_32
import img.cross_box
import react.RBuilder
import react.RComponent
import react.RState
import react.native.*


interface CrossBoxProps : StylableProps {
}


class CrossBox(props: CrossBoxProps) : RComponent<CrossBoxProps, RState>(props) {

    override fun RBuilder.render() {
        Image {
            attrs {
                style = props.style
                source = boxed_cross_32
                resizeMethod = "scale"
                resizeMode = "stretch"
            }
        }
    }
}

fun RBuilder.crossBox(_width : Int = 32, _height : Int? = null) = child(CrossBox::class) {
    val __height = _height ?: _width
    attrs {
        style = mkStyle {
            width = _width
            height = __height
            resizeMode = "repeat"//, cover, stretch, center, repeat"
//            flex = 1
//            flexDirection = row
//            flexShrink = 1
//            flexGrow = 0
//            flexBasis = _width
        }
    }
}
