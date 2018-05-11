package component

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.native.Image
import react.native.StylableProps
import react.native.Text
import react.native.View
import react.router.native.Link
import styles
import kotlinext.js.*

interface MenuLinkProps : StylableProps {
    var to : String
    var title : String
}


class MenuLink(props: MenuLinkProps) : RComponent<MenuLinkProps, RState>(props) {
    override fun RBuilder.render() {
        View {
            attrs {
                style = js {
                    backgroundColor = "red"
                    flex = 1
                    flexDirection = "row"
                }
            }
            View {
                Image {
                    attrs {
                        source = require("../../src/main/kotlin/img/boxed_cross_32.png")
                    }
                }
            }
            View {
                Link {
                    attrs {
                        to = props.to
                    }

                    Text {
                        +props.title
                    }
                }
            }
        }
    }
}

fun RBuilder.menuLink(_title : String, _to : String = "#", _style : Any? = styles.menu) = child(MenuLink::class) {
    attrs {
        style = _style
        to  = _to
        title = _title
    }
}
