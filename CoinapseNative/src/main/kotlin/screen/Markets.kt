package screen

import AppState
import LAYOUT
import Screens
import com.nominanuda.krui.react.native.*
import com.nominanuda.krui.redux.Dispatch
import com.nominanuda.krui.redux.DispatchToPropsMapper
import com.nominanuda.krui.redux.Reducer
import com.nominanuda.krui.redux.ToPropsMapper
import common.copy
import common.invoke
import component.*
import kotlinext.js.jsObject
import react.*
import react.native.Section
import react.redux.connect
import redux.bindActionCreators


interface MarketsProps : RProps
{
    var name : String
}

interface MarketsState : MarketsProps {
}

class Markets(props: MarketsProps) : RComponent<MarketsProps, RState>(props) {
val babau = arrayOf(
        jsObject<MarketProps> {
            key = "2"
            title = "GOOGL"
            ask = "1860.09"
            bid = "1861.00"
            diff = "-29.31 (-5.06%)"
            diffPositive = true
        },
        jsObject<MarketProps> {
            key = "1"
            title = "AAPL5"
            ask = "160.09"
            bid = "161.99"
            diff = "-9.63 (-0.19%)"
            diffPositive = false
        },
        jsObject<MarketProps> {
            key = "11"
            title = "AAPL5"
            ask = "160.09"
            bid = "161.99"
            diff = "-9.63 (-0.19%)"
            diffPositive = false
        },
        jsObject<MarketProps> {
            key = "12"
            title = "AAPL5"
            ask = "160.09"
            bid = "161.99"
            diff = "-9.63 (-0.19%)"
            diffPositive = false
        },
        jsObject<MarketProps> {
            key = "13"
            title = "AAPL5"
            ask = "160.09"
            bid = "161.99"
            diff = "-9.63 (-0.19%)"
            diffPositive = false
        },
        jsObject<MarketProps> {
            key = "14"
            title = "AAPL5"
            ask = "160.09"
            bid = "161.99"
            diff = "-9.63 (-0.19%)"
            diffPositive = false
        }
)
    override fun RBuilder.render() {
        View {
            attrs {
                style = mkStyle {
                    flex = 1
                }
            }
            View {
                attrs {
                    style = mkStyle {
                        borderColor = "red"
                        borderWidth = 1
                        flex = 1
                        flexDirection = row
                        flexShrink = 1
                        flexGrow = 0
                        flexBasis = "10%"
                    }
                }
                Text {
                    +props.name
                    +" - 1"}
            }
            ScrollView {
                screenSpacer(_title = "FEATURED MARKETS")
                FlatList {
                    attrs {
                        style = mkStyle {
                            height = LAYOUT.columnDp * 4
                        }
                        data = babau
                        renderItem = {
                            marketSlide(it.item, LAYOUT.columnDp * 4)
                        }
                        horizontal = true
                    }
                }
                SectionList {
                    attrs {
                        sections = arrayOf(jsObject<Section> {
                            title = "INDICES"
                            data = babau
                        }, jsObject<Section> {
                            title = "ETH TOKENS"
                            data = babau
                        })
                        renderItem = {
                            marketRow((it.item.unsafeCast<MarketProps>()).apply {
                                style = mkStyle {
                                    //backgroundColor = "orange"
                                }
                            })
                        }
                        renderSectionHeader = { screenSpacer(it.section.title) }
                        renderSectionFooter = { screenSpacer("LINK TO ALL") }
                    }
                }
            }
        }
    }
}


val marketsReducer : Reducer<MarketsState> = fun(state : MarketsState?, action : dynamic): MarketsState {
    print(action)//TODO removeme
    if (state == null) return jsObject<MarketsState> { name = "my MARKET" }//js {}
    return state.copy {
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

    return (connect(mapStateToProps, mapDispatchToProps)(
            { p : MarketsProps -> Markets(p)}
    ))()
    //return (connect(mapStateToProps, mapDispatchToProps)(Markets::class.js))()
}

