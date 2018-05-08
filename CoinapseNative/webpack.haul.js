'use strict';

const path = require('path');
const webpack = require('webpack');
/*
 * type Options = {
 *   platform: 'ios' | 'android', // Current platform
 *     dev: boolean, // Whether to build for development
 *       minify: boolean, // Whether to minify the bundle
 *         bundle: boolean, // Whether building the bundle for packaging
 *           root: string, // Absolute path to the project root
 *           }
 *           */
module.exports = ({ platform }, defaults) => ({
    //mode: 'development',
    //context: defaults.context,
    output: {...defaults.output},
	  entry: `./build/js/app.js`,
      module: {
		      ...defaults.module,
//              rules: [...defaults.module.rules],
              rules:
                  defaults.module.rules.map(function(r) {
                    if(r.exclude !== undefined) {
                        var re = r.exclude;
                        r.exclude = [];
                        r.exclude.push(re);
                        r.exclude.push(/kotlin\.js/);
                    }
                    return r;
                }).concat([{
                      test: /\.js$/,
                      use: ["source-map-loader"],
                      enforce: "pre"
                  }])
        },
        plugins : [
            ...defaults.plugins,
/*
            new webpack.LoaderOptionsPlugin({
                debug: true
            })
*/
        ],
	  resolve: {
		      ...defaults.resolve,
//		      plugins: [...defaults.resolve.plugins],//, new CustomPlugin()
		      modules: [
//                '.',
//                'build/js',
                path.resolve('src'),
//                  path.resolve('src','main','kotlin'),
//                  'src/main/kotlin',
                'node_modules'],
		    },
    target: 'webworker',
    //devtool: '#source-map'
});
