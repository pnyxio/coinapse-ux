import react.*
import react.native.Text
import react.native.View
import react.router.native.Link

class MenuProps : RProps

val navigationView : () -> ReactElement? = {
    buildElement {
        View {
            Text {
                +"hdjhhjdsjfdjjkjhdsfj"
            }
            Link {
                attrs {
                    to = "/"
                }
                Text {
                    +"HOME"
                }
            }
            Link {
                attrs {
                    to = "/about"
                }
                Text {
                    +"ABOUT"
                }
            }
        }
    }
}

fun RBuilder.menu() = child(Menu::class) {

}

class Menu(props: RProps) : RComponent<RProps, RState>(props) {

    override fun RBuilder.render(): Unit {
        Link {
            attrs {
                to = "/"
            }
            Text {
                +"HOME"
            }
        }
        Link {
            attrs {
                to = "/about"
            }
            Text {
                +"ABOUT"
            }
        }
    }
}
