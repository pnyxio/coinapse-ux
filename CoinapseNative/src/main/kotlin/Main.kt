import kotlinext.js.js
import kotlinext.js.jsObject
import react.*
import react.native.*
import react.redux.Provider
import react.router.native.Link
import react.router.native.NativeRouter
import react.router.native.Route
import redux.applyMiddleware
import redux.combineReducers
import redux.compose
import redux.createStore








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
