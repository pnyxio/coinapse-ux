package common

import kotlinext.js.*
import react.*

internal val protoObject : dynamic = js("new Object()")

fun <T> T.copyToDyn(vararg src : Any) : T {
    val o = js {}
    assign(o, this)
    for (s in src) {
        assign(o, s)
    }
    return o
}

fun <T> T.copyToDyn(vararg src : Any, builder: T.() -> Unit) : T {
    val o = this.copyToDyn(src)
    assign(o, builder)
    return o
}


typealias Reducer<T> = (/*state :*/ T?, /*action :*/ dynamic) -> T
typealias ToPropsMapper<T> = (T) -> RProps
typealias Dispatch = JsFunction1<Any,Nothing>
typealias DispatchToPropsMapper<T> = (Dispatch) -> RProps


operator fun <P : RProps> RClass<P>.invoke() =
        createElement(this, js {})
