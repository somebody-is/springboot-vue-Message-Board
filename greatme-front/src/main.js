// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css';
import store from './store'
import $ from 'jquery'
import './assets/dist/css/bootstrap.min.css'
import './assets/dist/js/bootstrap.bundle.min'

Vue.config.productionTip = false
Vue.use(ElementUI)

router.beforeEach((to,from,next)=>{
  var isLogin=0
  if(localStorage.getItem('USER')!=null){
    isLogin=1
    store.dispatch('setUserInfo',JSON.parse(localStorage.getItem('USER')))
  }
  if(to.path=='/logout'){
    localStorage.removeItem("USER");
    next({path:'/login'});
  }else if(to.path=='/login'){
    if(isLogin==1){
        next({path:'/homepage'})
    }
  }
  next();
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App),
  components: { App },
  template: '<App/>'
})
