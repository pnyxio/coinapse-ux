package component

import LAYOUT
import com.nominanuda.krui.react.native.*
import component.ScreenSpacer.Companion.compStyle
import react.RBuilder
import react.RComponent
import react.RState
import react.native.StylableProps
import react.native.Style


interface ScreenSpacerProps : StylableProps {
    var title : String
}


class ScreenSpacer(props: ScreenSpacerProps) : RComponent<ScreenSpacerProps, RState>(props) {
    companion object {
        val compStyle = mkStyle {
            flexDirection = row
            backgroundColor = "#AAAAAA"
            height = LAYOUT.columnDp
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

fun RBuilder.screenSpacer(_title : String = "", _style : Style = compStyle) = child(ScreenSpacer::class) {
    attrs {
        style = _style
        title = _title
    }
}
