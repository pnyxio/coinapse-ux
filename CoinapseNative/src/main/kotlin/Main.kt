import react.*
import react.native.*
import react.router.native.Link
import react.router.native.NativeRouter
import react.router.native.Route

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

class App(props: RProps) : RComponent<RProps, RState>(props) {

  override fun RBuilder.render(): dynamic {
    return NativeRouter {
          DrawerLayoutAndroid {
              attrs {
                  drawerWidth = 300
                  renderNavigationView = navigationView
//                      Menu(MenuProps())
                  }//navigationView//Menu::class.js
              View {
                  Route {
                      attrs {
                          path = "/"
                          exact = true
                          component = Home::class.js
                      }
                  }
                  Route {
                      attrs {
                          path = "/about"
                          component = About::class.js
                      }
                  }
              }
              }
          }
  }
}

fun RBuilder.app() = child(App::class) {

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

class Home(props: RProps) : RComponent<RProps, RState>(props) {

    override fun RBuilder.render(): dynamic {
        return View {
            Text {
                    +"HOME !!!!!!!!!!!!!!!!!"
                }
            }
    }
}

class About(props: RProps) : RComponent<RProps, RState>(props) {

    override fun RBuilder.render(): dynamic {
        return View {
            Text {
                +"ABOUT !!!!!!!!!!!!!!!!!"
            }
        }
    }
}



fun main(args: Array<String>) {
  AppRegistry.registerComponent<App>("CoinapseNative") {
    App::class.js
  }
}





//class App : React.Component<Any, Any>() {
//  override fun render(): dynamic {


//      text("HelloTest1", Style(backgroundColor = "blue", fontSize = 50))
/*
      button("Button Test!") {
        println("Test Button Clicked!")
      }
      component(SubComponent())
      text(Platform.select("ios", "android"))
      text("Platform Version: ${Platform.VERSION}")
*/
/*
//class SubComponent : React.Component<Any, Any>() {
//  override fun render(): dynamic {
class SubComponent (props: RProps) : RComponent<RProps, RState>(props) {
    override fun RBuilder.render(): dynamic {
    return view {
      text("I am a sub-component!!! MInchioNAZZO")
    }
  }
}

*/
