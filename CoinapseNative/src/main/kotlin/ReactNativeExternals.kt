@file:JsModule("react-native")
package react.native

import react.RClass
import react.RComponent
import react.RProps

external object AppRegistry {
    fun <T : RComponent<*, *>> registerComponent(name: String, createComponent: () -> JsClass<T>)
}

external interface PlatformSelectConfig<T> {
    var ios: T
    var android: T
}

external object StyleSheet {
    fun create(style: dynamic): dynamic
}

external object Platform {
/**
 * Has the value 'ios' or 'android'
 */

  val OS: String
/**
 * On iOS, the [VERSION] is a result of -[UIDevice systemVersion], which is a [String] with the
 * current version of the operating system. An example of the system version is "10.3".
 *
 * On Android, the [VERSION] is an [Int] representing the api level. An example is that
 */

  @JsName("Version")
  val VERSION: dynamic

  fun <T> select(select: PlatformSelectConfig<T>): T
}
external interface ViewProps : RProps {

}

external val View : RClass<ViewProps>
/*
open external class View : Component<ViewProps, RState> {
    override fun render(): dynamic = definedExternally
}
*/

external interface TextProps : RProps {

}

external val Text : RClass<TextProps>

/*
open external class Text : Component<TextProps, RState> {
    override fun render(): dynamic = definedExternally
}
*/

//external object Text
external object Button


external interface DrawerLayoutAndroidProps : RProps {
    var drawerWidth : Int
    //var drawerPosition={DrawerLayoutAndroid.positions.Left}
    var renderNavigationView : Any//={() => navigationView}
}

external val DrawerLayoutAndroid : RClass<DrawerLayoutAndroidProps>

