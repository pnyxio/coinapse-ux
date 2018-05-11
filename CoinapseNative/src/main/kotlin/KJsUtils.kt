import kotlinext.js.*

fun <T : Any> T.jsVanillize() : T {
    Object.getPrototypeOf(this.asDynamic()).constructor = js("Object")
    return this
}

/*
inline fun jsDyn(crossinline builder: dynamic.() -> Unit) {
    val obj = kotlinext.js.js("({})")
    return obj.apply {
        builder()
    }
}
*/

