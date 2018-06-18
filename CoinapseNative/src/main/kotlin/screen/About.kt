package screen

import com.nominanuda.krui.react.native.*
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

class About(props: RProps) : RComponent<RProps, RState>(props) {

    override fun RBuilder.render(): dynamic {
        return View {
            Text {
                +"ABOUT !!!!!!!!!!!!!!!!!"
            }
        }
    }
}
