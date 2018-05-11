import common.Reducer
import kotlinext.js.jsObject
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.native.DrawerLayoutAndroid
import react.native.View
import react.redux.Provider
import react.router.native.NativeRouter
import react.router.native.Route
import redux.applyMiddleware
import redux.combineReducers
import redux.compose
import redux.createStore
import screen.*


interface AppState {
    var home : HomeState
}

interface AppReducers {
    var home : Reducer<HomeState>
}

var _store : Any = "MIKIIII"

class App(props: RProps) : RComponent<RProps, RState>(props) {
    init {
        //    val _history = createBrowserHistory()

        val initialState = kotlinext.js.js {}
        val enhancers : Array<Any> = arrayOf()

        val _thunk = redux.thunk.default
        val middleware = arrayOf(
                _thunk
//            ,routerMiddleware(_history)
        )

        val composedEnhancers = compose(
                applyMiddleware(*middleware),
                *enhancers
        )

//        val _routerReducer = routerReducer
/*
    val _counterReducer = module.counterReducer
    val _todoReducer = module.todoReducer
*/

/*
        val fakeReducer : Reducer<Any> = fun(state : Any?, action : dynamic): Any {
            if (state == null) return js {}
            return state
        }
*/
        val rootReducer = combineReducers(jsObject <AppReducers>{
            home = homeReducer
            /*
                        routing = _routerReducer
                    counter = _counterReducer
                    todo = _todoReducer
            */
        } as Any)//TODO remove as Any

        _store = createStore(
                rootReducer,
                initialState,
                composedEnhancers
        )

    }
    override fun RBuilder.render(): dynamic {
        return Provider() {
            attrs {
                store = _store
            }
            NativeRouter {
                DrawerLayoutAndroid {
                    attrs {
                        drawerWidth = 300
                        renderNavigationView = navigationView
                    }
                    View {
                        Route {
                            attrs {
                                path = "/"
                                exact = true
                                component = {home()}//screen.Home::class.js
                            }
                        }
                        Route {
                            attrs {
                                path = "/about"
                                component = About::class.js
                            }
                        }
                    }
                }
            }
        }
    }
}

fun RBuilder.app() = child(App::class) {

}
