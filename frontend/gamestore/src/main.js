import Vue from 'vue'
import App from './App.vue'
import './assets/bootstrap.min.css'
import VueRouter from 'vue-router'
import { BootstrapVue } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import Home from './components/Home.vue'
import Games from './components/Games.vue'
import Sobre from './components/Sobre.vue'
import VueParticles from 'vue-particles'
import VueSplide from '@splidejs/vue-splide';



Vue.use(BootstrapVue)
Vue.use( VueSplide );
Vue.use(VueParticles)

Vue.use(VueRouter);

const router = new VueRouter({
  routes: [
    {
      path: '/',
      component: Home
    },
    {
      path: '/game/',
      component: Games
    },
    {
      path: '/sobre/',
      component: Sobre
    }
  ]
})

Vue.config.productionTip = false

new Vue({
  router, // inject the router to make whole app router-aware
  render: h => h(App),
}).$mount('#app')
