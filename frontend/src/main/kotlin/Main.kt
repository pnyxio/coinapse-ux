import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.h1
import react.dom.render
import kotlin.browser.document


class App(props: RProps) : RComponent<RProps, RState>(props) {

  override fun RBuilder.render(): dynamic {
    return h1 {
        +"Hello Fucking World"
    }
  }
}
fun RBuilder.app() = child(App::class) {

}

fun main(args: Array<String>) {
    val root = document.getElementById("root")
    render(root) {
      app()
    }
}




