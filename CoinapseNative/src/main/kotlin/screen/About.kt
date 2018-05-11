package screen

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.native.Text
import react.native.View

class About(props: RProps) : RComponent<RProps, RState>(props) {

    override fun RBuilder.render(): dynamic {
        return View {
            Text {
                +"ABOUT !!!!!!!!!!!!!!!!!"
            }
        }
    }
}
