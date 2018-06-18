package component

import com.nominanuda.krui.react.native.*
import img.Img
import img.boxed_cross_32
import react.RBuilder
import react.RComponent
import react.RState
import react.router.native.Link
import common.copy
import hBox
import kotlinext.js.js
import react.native.*


interface MenuLinkProps : StylableProps {
    var to : String
    var title : String
    var icon : Img
}

var _DrawerLayoutAndroidRef : dynamic = null

class MenuLink(props: MenuLinkProps) : RComponent<MenuLinkProps, RState>(props) {
    override fun RBuilder.render() {
        View {
            attrs {
                style = props.style
            }
            View {
                Image {
                    attrs {
                        source = props.icon
                    }
                }
            }
            View {
                attrs {
                    style = mkStyle {
                        paddingLeft = 16
                    }
                }
                Link {
                    attrs {
                        to = props.to
                        onPress = {_DrawerLayoutAndroidRef?.closeDrawer()}
                    }
                    Text {
                        attrs {
                            style = mkStyle {
                                fontSize = 24
//                                fontFamily = "sans-serif"

                            }
                        }
                        +props.title
                    }
                }
            }
        }
    }
}

//fun cacheStyle(builder : Style.() -> Unit) : Style {
//    return StyleSheet.create(js {
//        dummy = js(builder)
//    }).dummy as Style
//}
//
//internal val compStyle = cacheStyle {
//
//}

internal val ownStyle : Style = hBox() { flex = 1 }
fun RBuilder.menuLink(
        _title : String,
        _to : String = "#",
        _style : Style = js {},
        _icon : Img = boxed_cross_32
) = child(MenuLink::class) {
    attrs {
        style = ownStyle.copy(_style)
        to  = _to
        title = _title
        icon = _icon
    }
}
