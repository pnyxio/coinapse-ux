package screen

import AppState
import jsVanillize
import kotlinext.js.jsObject
import react.*
import react.native.Text
import react.native.View
import react.redux.connect
import redux.bindActionCreators
import styles

class HomeProps(val name : String = "name_not_set") : RProps {

}

class Home(props: HomeProps) : RComponent<HomeProps, RState>(props) {

    override fun RBuilder.render(): dynamic {
        return View {
            attrs {
                style = styles.common
            }
            Text {
                + "Hello  !!!!"
                + props.name
            }
        }
    }
}

fun RBuilder.home(): ReactElement {//Any
//TODO mapStateToProps() in Connect(screen.Home) must return a plain object. Instead received [object Object].
    //??? change proto ctor dynamically :-D

    val mapStateToProps : (AppState) -> HomeProps =  { state : AppState ->
        HomeProps(name = "my lord3").jsVanillize()
    }// as screen.HomeProps if different js mapper

/*
    val mapStateToProps : (AppState) -> dynamic =  { state : AppState ->
        jsObject<dynamic> {//TODO jsObject<dynamic> can we introduce typedef  jsObject<dynamic> jsObj jsDyn etc ??
            name = "my lord"
        }
    }// as screen.HomeProps if different js mapper
*/

    val mapDispatchToProps = {dispatch :Any ->
        bindActionCreators(jsObject<HomeProps>{
/*
            increment = CounterActionCreators.increment//dispatchable(js {type = "MIAO"})
            incrementAsync = CounterActionCreators.incrementAsync
            decrement = CounterActionCreators.decrement
            decrementAsync = CounterActionCreators.decrementAsync
            changePage  = {react.router.redux.push("/about-us")}
*/
        }, dispatch)
    }
//    val conn : JsClass<Any> = connect(mapStateToProps, mapDispatchToProps)(screen.Home::class.js)
//    val rClass = conn as RClass<screen.HomeProps>
    //return rClass({})

    return (connect(mapStateToProps, mapDispatchToProps)(Home::class.js) as RClass<HomeProps>)({})
    //return reduxConnect(screen.Home::class.js, mapStateToProps, mapDispatchToProps)
}
