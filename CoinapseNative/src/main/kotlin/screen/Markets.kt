package screen

import AppState
import Screens
import com.nominanuda.krui.react.native.heightPercentageToDP
import com.nominanuda.krui.react.native.mkStyle
import com.nominanuda.krui.react.native.row
import com.nominanuda.krui.react.native.widthPercentageToDP
import com.nominanuda.krui.redux.Dispatch
import com.nominanuda.krui.redux.DispatchToPropsMapper
import com.nominanuda.krui.redux.Reducer
import com.nominanuda.krui.redux.ToPropsMapper
import common.assign
import common.invoke
import component.crossBox
import component.screenSpacer
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

interface ReactReduxComponentXxx {
//    fun makeRenderer() : RBuilder.() -> Unit
}

object fac : ReactReduxComponentXxx {

}

class Markets(props: MarketsProps) : RComponent<MarketsProps, RState>(props) {

    override fun RBuilder.render() {
        View {
            attrs {
                style = mkStyle {
                    backgroundColor = "yellow"
                    flex = 1
                    //flexDirection = column
                }
            }
            View {
                attrs {
                    style = mkStyle {
                        borderColor = "red"
                        borderWidth = 1
//                        height = 30
                        flex = 1
                        flexDirection = row
                        flexShrink = 1
                        flexGrow = 0
                        flexBasis = 30
                    }
                }
                Text { +props.name }
            }
            screenSpacer(_title = "FEATURED MARKETS")
            View {
                attrs {
                    style = mkStyle {
                        borderColor = "red"
                        borderWidth = 1
                        //height = 40
                        flexBasis = 300
                        flex = 1
                        flexDirection = row
                        flexShrink = 1
                        flexGrow = 1
                    }
                }
                crossBox(widthPercentageToDP(100.0).toInt(), 200)
//                Image {
//                    attrs {
//                        source = boxed_cross_32
//                        style = mkStyle {
//                            height = 200
//                            width = 300
//                        }
//                    }
//                }
            }
            screenSpacer(_title = "INDICES")
            View {
                attrs {
                    style = mkStyle {
                        borderColor = "red"
                        borderWidth = 1
                        flexBasis = 30
                        //height = 30
                        flexShrink = 1
                        flexGrow = 0
                    }
                }
                Text { +"Hello  !!!!" }
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

fun Screens.markets() : ReactElement {
    val mapStateToProps : ToPropsMapper<AppState> =  { state : AppState ->
        state.markets
    }

    val mapDispatchToProps : DispatchToPropsMapper<MarketsProps> = {dispatch : Dispatch ->
        bindActionCreators(jsObject<MarketsProps>{
        }, dispatch)
    }
    console.info("INTO RBuilder.markets")
    console.info("widthPercentageToDP"+ widthPercentageToDP(100.0))
    console.info("heightPercentageToDP"+ heightPercentageToDP(100.0))

    var singletonEl : ReactElement? = null
    singletonEl = (connect(mapStateToProps, mapDispatchToProps)(
            { p : MarketsProps -> Markets(p)}
    ))()
    return singletonEl!!
    //return (connect(mapStateToProps, mapDispatchToProps)(Markets::class.js))()
}

