package component

import LAYOUT
import com.nominanuda.krui.react.native.*
import common.copy
import hBox
import kotlinext.js.assign
import kotlinext.js.js
import react.RBuilder
import react.RComponent
import react.RState
import react.native.StylableProps
import react.native.WithAndHeight

interface MarketProps : StylableProps {
    var key : String
    var icon: Any//TODO
    var title: String
    var ask : String
    var bid : String
    var diff: String
    var diffPositive: Boolean
}

internal val MAKET_ROW_STYLE = hBox {
//    marginLeft = LAYOUT.pageMarginDp
    height = 2 * LAYOUT.columnDp  + 2 * LAYOUT.gutterDp
}
class MarketRow(props: MarketProps) : RComponent<MarketProps, RState>(props) {
    override fun RBuilder.render() {
        View {
            attrs {
                style = props.style
            }
            View {
                attrs {
                    style = mkStyle {
                        flexDirection = row
                        marginLeft = LAYOUT.pageMarginDp
                        alignItems = "center"
                        //backgroundColor = "pink"
                        //flexBasis = LAYOUT.nColsDp(6)
                        width = LAYOUT.nColsDp(6)
                    }
                }
                crossBox(LAYOUT.columnDp * 2)
                View {
                    attrs {
                        style = mkStyle {
                            flex = 1
                            flexDirection = column
                            //backgroundColor = "magenta"
                            marginLeft = LAYOUT.gutterDp
                            height = LAYOUT.columnDp * 2
                        }
                    }
                    View {
                        attrs {
                            style = mkStyle {
                                //backgroundColor = "navy"
                                flexGrow = 1
                                justifyContent = "center"
                            }
                        }
                        Text {
                            + props.title
                        }
                    }
                    View {
                        attrs {
                            style = mkStyle {
                                //backgroundColor = "grey"
                                flexGrow = 1
                                justifyContent = "center"
                            }
                        }
                        Text {
                            attrs {
                                style = mkStyle {
                                    color = "green"
                                }
                            }
                            +props.diff
                        }
                    }
                }
            }
            View {
                attrs {
                    style = mkStyle {
                        flexDirection = row
                        //backgroundColor = "#BBBBBB"
                        marginLeft = LAYOUT.gutterDp
                        //flexBasis = LAYOUT.nColsDp(3)
                        width = LAYOUT.nColsDp(3)

                        alignItems = "center"
                    }
                }
                View {
                    attrs {
                        style = mkStyle {
                            flexDirection = column
                            justifyContent = "center"
                            //backgroundColor = "yellow"
                            alignItems = "flex-end"
                            height = LAYOUT.columnDp * 2
                            flexGrow = 1
                        }
                    }
                    Text {
                        attrs {
                            style = mkStyle {
                                //backgroundColor = "red"
                            }
                        }
                        +props.ask
                    }
                }
            }
            View {
                attrs {
                    style = mkStyle {
                        flexDirection = row
                        //backgroundColor = "#BBBBBB"
                        marginLeft = LAYOUT.gutterDp
                        //flexBasis = LAYOUT.nColsDp(3)
                        width = LAYOUT.nColsDp(3)

                        alignItems = "center"
                    }
                }
                View {
                    attrs {
                        style = mkStyle {
                            flexDirection = column
                            justifyContent = "center"
                            //backgroundColor = "yellow"
                            alignItems = "flex-end"
                            height = LAYOUT.columnDp * 2
                            flexGrow = 1
                        }
                    }
                    Text {
                        attrs {
                            style = mkStyle {
                                //backgroundColor = "green"
                            }
                        }
                        +props.bid
                    }
                }
            }
        }
    }
}

fun RBuilder.marketRow(props: MarketProps) = child(MarketRow::class) {
    attrs {
        val computedStyle = MAKET_ROW_STYLE.copy(props.style ?: js {})
        assign(this, props)
        style = computedStyle
    }
    key = props.key
}

class MarketSlide(props: MarketProps) : RComponent<MarketProps, RState>(props) {
    override fun RBuilder.render() {
        View {
            attrs {
                style = mkStyle {
                    height = "100%"
                }
            }
            crossBox(LAYOUT.columnDp * 3, LAYOUT.columnDp * 2)
        }

    }
}

fun RBuilder.marketSlide(props: MarketProps, height: Double) = child(MarketSlide::class) {
    attrs {
        assign(this, props)
    }
    key = props.key
}
