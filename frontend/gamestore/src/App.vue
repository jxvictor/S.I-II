<template>
  <div id="app">
    <p id="title-text">Game Store</p>
    <router-view></router-view>
  
  </div>
</template>

<script>

//import Games from './components/Games.vue'
//import Comments from './components/Comments.vue'

export default {
  name: 'App'
}
</script>

<style>
  #app{
    font-family:Arial, Helvetica, sans-serif;
  }

  #title-text{
    text-align: center;
    font-size: 28px;
  }
  html{
    background-color: cadetblue;
    
  }
  
</style>
