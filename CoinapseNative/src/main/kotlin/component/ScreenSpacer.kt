package component

import com.nominanuda.krui.react.native.mkStyle
import com.nominanuda.krui.react.native.row
import component.ScreenSpacer.Companion.compStyle
import img.Img
import img.boxed_cross_32
import react.RBuilder
import react.RComponent
import react.RState
import react.native.StylableProps
import react.native.Style
import react.native.Text
import react.native.View
import styles


interface ScreenSpacerProps : StylableProps {
    var title : String
}


class ScreenSpacer(props: ScreenSpacerProps) : RComponent<ScreenSpacerProps, RState>(props) {
    companion object {
        val compStyle = mkStyle {
            flex = 1
            flexDirection = row
            backgroundColor = "#AAAAAA"

            flexShrink = 1
            flexGrow = 0
            flexBasis = 20
        }
    }

    override fun RBuilder.render() {
        View {
            attrs {
                style = props.style
            }
            Text {
                attrs {
                    style = mkStyle {
                        color = "#555555"
                    }
                }
                + props.title
            }
        }
    }
}

fun RBuilder.screenSpacer(_title : String = "", _style : Style? = compStyle) = child(ScreenSpacer::class) {
    attrs {
        style = _style
        title = _title
    }
}
