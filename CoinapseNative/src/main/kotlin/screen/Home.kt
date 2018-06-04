package screen

import AppState
import common.*
import kotlinext.js.*
import react.*
import react.native.Image
import react.native.Text
import react.native.View
import react.redux.connect
import redux.bindActionCreators
import styles

interface HomeProps : RProps
{
    var name : String
}

interface HomeState : HomeProps {
}

class Home(props: HomeProps) : RComponent<HomeProps, RState>(props) {
    override fun RBuilder.render(): dynamic {
        return View {
            attrs {
                style = styles.common//TODO manage style top down from home ??
            }

            View {
                Image {
                    attrs {
                        source = kotlinext.js.require("../../src/main/kotlin/img/boxed_cross_32.png")
                    }
                }
            }
            View {
                Text {
                    + "Hello  !!!!"
                    + props.name
                }
            }
        }
    }
}

val homeReducer : Reducer<HomeState> = fun(state : HomeState?, action : dynamic): HomeState {
    if (state == null) return jsObject<HomeState> { name = "my lord3" }//js {}
    return state.copyToDyn {
        name = "buzzurro"
    }
}


fun RBuilder.home(): ReactElement {
    val mapStateToProps : ToPropsMapper<AppState> =  { state : AppState ->
        state.home
    }

    val mapDispatchToProps : DispatchToPropsMapper<HomeProps> = {dispatch : Dispatch ->
        bindActionCreators(jsObject<HomeProps>{
        }, dispatch)
    }

    return (connect(mapStateToProps, mapDispatchToProps)(Home::class.js))()
}

