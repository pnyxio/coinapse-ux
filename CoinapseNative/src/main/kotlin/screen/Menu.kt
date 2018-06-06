package screen

import com.nominanuda.krui.react.native.column
import com.nominanuda.krui.react.native.mkStyle
import component.MenuLink
import component.menuLink
import kotlinext.js.js
import react.*
import react.native.Text
import react.native.View
import react.router.native.Link

class MenuProps : RProps

val navigationView : () -> ReactElement? = {
    buildElement {
        View {
            attrs {
                style = mkStyle {
                    flex = 1
                    flexDirection = column
                }
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
