package screen

import AppState
import com.nominanuda.krui.react.native.column
import com.nominanuda.krui.react.native.mkStyle
import com.nominanuda.krui.react.native.row
import com.nominanuda.krui.react.native.widthPercentageToDP
import common.*
import img.boxed_cross_32
import kotlinext.js.*
import react.*
import react.native.Image
import react.native.Text
import react.native.View
import react.redux.connect
import redux.bindActionCreators
import styles
import com.nominanuda.krui.redux.*
import component.crossBox
import component.screenSpacer


interface HomeProps : RProps
{
    var name : String
}

interface HomeState : HomeProps {
}

class Home(props: HomeProps) : RComponent<HomeProps, RState>(props) {
    override fun RBuilder.render() {
        View {
            View {
                attrs {
                    style = styles.common//TODO manage style top down from markets ??
                }

                View {
                    Image {
                        attrs {
                            source = boxed_cross_32
                        }
                    }
                }
                View {
                    Text {
                        +"Hello  !!!!"
                        +props.name
                    }
                }
            }
        }
    }
}

val homeReducer : Reducer<HomeState> = fun(state : HomeState?, action : dynamic): HomeState {
    if (state == null) return jsObject<HomeState> { name = "my lord3" }//js {}
    return state.assign {
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

