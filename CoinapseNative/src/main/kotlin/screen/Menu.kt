package screen

import com.nominanuda.krui.react.native.*
import component.menuLink
import react.*
import react.router.native.Link
import STYLES

interface MenuProps : RProps
//fun RBuilder.view(handler: RHandler<ViewProps>) : ReactElement = child(ViewComponent::class, handler)

val navigationView : () -> ReactElement? = {
    buildElement {
        View {
            attrs {
                style = STYLES.menu
            }
/*
            Text {
                +"hdjhhjdsjfdjjkjhdsfj"
            }
*/
            menuLink("Home", "/")
            //trade
            //menuLink("Watchlist")
            menuLink("Portfolio")
            //menuLink("News Feed")
            //discover
            menuLink("Trade Markets", "/markets")
            //menuLink("?Search Markets")
            //menuLink("Get Signals")
            //menuLink("Managed Trading")
            //more
            menuLink("Help")
            menuLink("Transfer Funds")
            menuLink("Settings")
            menuLink("About", "/about")//TODO routing table ?? also exact....
            menuLink("Logout")
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
