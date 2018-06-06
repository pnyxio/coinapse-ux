package screen

import AppState
import com.nominanuda.krui.redux.Dispatch
import com.nominanuda.krui.redux.DispatchToPropsMapper
import com.nominanuda.krui.redux.Reducer
import com.nominanuda.krui.redux.ToPropsMapper
import common.assign
import common.invoke
import img.boxed_cross_32
import kotlinext.js.jsObject
import react.*
import react.native.Image
import react.native.Text
import react.native.View
import react.redux.connect
import redux.bindActionCreators
import styles


interface MarketsProps : RProps
{
    var name : String
}

interface MarketsState : MarketsProps {
}

class Markets(props: MarketsProps) : RComponent<MarketsProps, RState>(props) {
    override fun RBuilder.render(): dynamic {
        return View {
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
                    + "Hello  !!!!"
                    + props.name
                }
            }
        }
    }
}

val marketsReducer : Reducer<MarketsState> = fun(state : MarketsState?, action : dynamic): MarketsState {
    if (state == null) return jsObject<MarketsState> { name = "my MARKET" }//js {}
    return state.assign {
        name = "buzzurro"
    }
}


fun RBuilder.markets(): ReactElement {
    val mapStateToProps : ToPropsMapper<AppState> =  { state : AppState ->
        state.markets
    }

    val mapDispatchToProps : DispatchToPropsMapper<MarketsProps> = {dispatch : Dispatch ->
        bindActionCreators(jsObject<MarketsProps>{
        }, dispatch)
    }

    return (connect(mapStateToProps, mapDispatchToProps)(Markets::class.js))()
}

