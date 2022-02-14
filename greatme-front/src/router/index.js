import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '../view/Login'
import Message from '../view/Message'
import Register from '../view/Register'
import NotFound from '../view/NotFound/NotFound'
import AddMessage from '../view/AddMesage'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Default',
      component: Message,
      meta:{show:true}
    },{
      path: '*',
      name:'NotFound',
      component: NotFound,
      meta:{show:false}
    },{
      path: '/login',
      name: 'Login',
      component: Login,
      meta:{show:false}
    },{
      path: '/message',
      name: 'Message',
      component: Message,
      meta:{show:true}
    },{
      path: '/register',
      name: 'Register',
      component: Register,
      meta:{show:false}
    },{
      path: '/addmessage',
      name: 'AddMessage',
      component: AddMessage,
      meta:{show:true}
    }
  ]
})
