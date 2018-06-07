package common

import kotlinext.js.*
import react.*

internal val protoObject : dynamic = js("new Object()")

fun <T> T.assign(vararg src : Any) : T {
    val o = js {}
    assign(o, this)
    for (s in src) {
        kotlinext.js.assign(o, s)
    }
    return o
}

fun beget(o: Any) : dynamic {
    return Object.create(o).asDynamic()
}

fun beget(o: Any, builder: dynamic.() -> Unit) : dynamic {
    val x = Object.create(o).asDynamic()
    builder.invoke(x)
    return x
}


fun <T> T.assign(vararg src : Any, builder: T.() -> Unit) : T {
    val o = this.assign(src)
    assign(o, builder)
    return o
}




operator fun <P : RProps> RClass<P>.invoke() =
        createElement(this, js {})

class ElementMemoizer private constructor(private val rBuilder: RBuilder) {
    private var cached : ReactElement? = null

    fun cacheElement(render : /*RBuilder.*/() -> ReactElement) : ReactElement {
        if(cached == null) {
            cached = /*rBuilder.*/render()
        }
        return cached!!
    }

    companion object {
        private val memoizersByBuilder = HashMap<RElementBuilder<RProps>, ElementMemoizer>()
        fun of(rBuilder: RBuilder, x : RElementBuilder<RProps>) : ElementMemoizer {
            if(memoizersByBuilder.containsKey(x)) {
                return memoizersByBuilder[x]!!
            } else {
                val em = ElementMemoizer(rBuilder)
                memoizersByBuilder[x] = em
                return em
            }
        }
    }
}
