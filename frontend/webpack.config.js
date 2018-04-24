var config = require('./build/WebPackHelper.js')
var path = require('path')


module.exports = {
    mode: "development",
    entry: './js/app.js',//config.moduleName,
    output: {
        path: path.resolve('./bundle'),
        publicPath: '/build/',
        filename: 'bundle.js'
    },
    resolve: {
        modules: [path.resolve('js'), path.resolve('..', 'src'), path.resolve('.'), path.resolve('node_modules')],
        extensions: ['.js', '.css']
    },
    module: {
        rules: [
            /*
                                { test: /\.js$/, loader: "babel-loader",
                                exclude: [/kotlin/],
                                options: {
        //				              presets: ["es2015"],
                                    plugins: ["react-native-web"]
                                    }
                                },
                                { test: /\.css$/, use: [ 'style-loader', 'css-loader' ] }
                    */
        ]
    },
    devtool: '#source-map',
    //contentPath: "bundle.js"
};


