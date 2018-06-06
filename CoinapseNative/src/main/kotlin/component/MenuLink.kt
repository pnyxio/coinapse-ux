package component

import com.nominanuda.krui.react.native.mkStyle
import com.nominanuda.krui.react.native.row
import img.Img
import img.boxed_cross_32
import react.RBuilder
import react.RComponent
import react.RState
import react.router.native.Link
import styles
import kotlinext.js.*
import react.buildElement
import react.native.*
import kotlin.js.Console


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
                style = mkStyle {
                    flex = 1
                    flexDirection = row
                    //alignItems = "center"
                    borderColor = "black"
                    borderWidth = 1
                }
            }
            View {
                Image {
                    attrs {
                        source = props.icon//boxed_cross_32//require(props.icon)
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
//                        component = {buildElement {
//                            TouchableHighlight {
//                                attrs {
//                                    onPress = {_DrawerLayoutAndroidRef?.closeDrawer()}
//                                }
//                                Text {
//                                    attrs {
//                                        style = mkStyle {
//                                            fontSize = 24
//                                            fontFamily = "sans-serif"
//
//                                        }
//                                    }
//                                    +props.title
//                                }
//                            }
//                        }}
                    }
                    Text {
                        attrs {
                            style = mkStyle {
                                fontSize = 24
                                fontFamily = "sans-serif"

                            }
                        }
                        +props.title
                    }
                }
            }
        }
    }
}

fun RBuilder.menuLink(_title : String, _to : String = "#", _style : Style? = styles.menu, _icon : Img = boxed_cross_32) = child(MenuLink::class) {
    attrs {
        style = _style
        to  = _to
        title = _title
        icon = _icon
    }
}
