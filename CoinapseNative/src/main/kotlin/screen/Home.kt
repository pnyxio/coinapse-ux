package screen

import AppState
import LAYOUT
import com.nominanuda.krui.react.native.*
import common.*
import kotlinext.js.*
import react.*
import react.redux.connect
import redux.bindActionCreators
import com.nominanuda.krui.redux.*


interface HomeProps : RProps
{
    var name : String
}

interface HomeState : HomeProps {
}
//val col = "7.042253521126761%"
//val gutter = "1.408450704225352%"

class Home(props: HomeProps) : RComponent<HomeProps, RState>(props) {
    override fun RBuilder.render() {
        View {
            attrs {
                style = mkStyle {
                    //width = "100%"
                    flex = 1
                    flexDirection = row
                }
            }
            for(i in 1..11) {
                View {
                    attrs {
                        style = mkStyle {
                            backgroundColor = "yellow"
                            width = LAYOUT.columnDp
                            height = "100%"
                        }
                    }
                }
                View {
                    attrs {
                        style = mkStyle {
                            backgroundColor = "pink"
                            width = LAYOUT.gutterDp
                            height = "100%"
                        }
                    }
                }
            }
            View {
                attrs {
                    style = mkStyle {
                        backgroundColor = "yellow"
                        width = LAYOUT.columnDp
                        height = "100%"
                    }
                }
            }
//            View {
//                attrs {
//                    style = STYLES.common//TODO manage style top down from markets ??
//                }
//                View {
//                    Image {
//                        attrs {
//                            source = boxed_cross_32
//                        }
//                    }
//                }
//                View {
//                    Text {
//                        +"Hello  !!!!"
//                        +props.name
//                    }
//                }
//            }
        }
    }
}

val homeReducer : Reducer<HomeState> = fun(state : HomeState?, action : dynamic): HomeState {
    print(action)//TODO removeme
    if (state == null) return jsObject<HomeState> { name = "my lord3" }//js {}
    return state.copy {
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

