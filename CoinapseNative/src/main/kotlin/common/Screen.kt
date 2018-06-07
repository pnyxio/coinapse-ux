package common

import react.RComponent
import react.RProps
import react.RState
import screen.HomeProps

class ComponentPath() {

}

abstract class ReactReduxComponent<P : RProps,S : RState>(
        props: P,
        val path : ComponentPath
) : RComponent<P, S>(props) {
    init {
        //register route
    }

    fun xxx() {

    }
}

abstract class Screen<P : RProps,S : RState>(
        props: P,
        val routePrefix : String
) : RComponent<P, S>(props) {
    init {
        //register route
    }
}