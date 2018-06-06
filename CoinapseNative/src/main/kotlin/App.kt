import component._DrawerLayoutAndroidRef
import kotlinext.js.jsObject
import react.native.DrawerLayoutAndroid
import react.redux.Provider
import react.router.native.NativeRouter
import react.router.native.Route
import redux.applyMiddleware
import redux.combineReducers
import redux.compose
import redux.createStore
import redux.thunk.default
import screen.*
import com.nominanuda.krui.redux.*
import kotlinext.js.js
import react.*

interface AppState {
    var home : HomeState
    var markets : MarketsState
}

interface AppReducers {
    var home : Reducer<HomeState>
    var markets : Reducer<MarketsState>
}




class App(props: RProps) : RComponent<RProps, RState>(props) {
    val reduxStore : Any
    init {
        val initialState = js {}
        val enhancers : Array<Any> = arrayOf()
        val _thunk = default
        val middleware = arrayOf(_thunk/*,routerMiddleware*/)

        val composedEnhancers = compose(
                applyMiddleware(*middleware),
                *enhancers
        )
        val rootReducer = combineReducers(jsObject<AppReducers>{
            home = homeReducer
            markets = marketsReducer
        })

        reduxStore = createStore(
                rootReducer,
                initialState,
                composedEnhancers
        )

    }
    override fun RBuilder.render() {
        Provider() {
            attrs {
                store = reduxStore
            }
            NativeRouter {
                DrawerLayoutAndroid {
                    ref {
                        _DrawerLayoutAndroidRef = it
                    }
                    attrs {
                        drawerWidth = 300
                        renderNavigationView = navigationView
                    }
                    Route {
                        attrs {
                            path = "/"
                            exact=true
                            component = {home()}//screen.Home::class.js
                        }
                    }
                    Route {
                        attrs {
                            path = "/markets"
                            component = {markets()}
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

fun RBuilder.app() = child(App::class) {}
