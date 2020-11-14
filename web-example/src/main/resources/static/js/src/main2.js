//在main.js中使用
// const Vue = require("../avue-mobile");
Vue.use(window.AVUE);
var VueRouter = require('vue-router');
var VueDemo = require('components/demo');

// alert(111)
var Foo = Vue.extend({
    template: VueDemo
})

router.start(Foo, '#app')
