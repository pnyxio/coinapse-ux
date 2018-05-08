@file:JsModule("react-router-native")
package react.router.native

import react.RClass
import react.RProps

external interface NativeRouterProps : RProps {

}
external val NativeRouter : RClass<NativeRouterProps>

external interface RouteProps : RProps {
    var exact : Boolean
    var path : String
    var component : JsClass<dynamic>
}
external val Route : RClass<RouteProps>

external interface LinkProps : RProps {
    var to :String
}
external val Link : RClass<LinkProps>


