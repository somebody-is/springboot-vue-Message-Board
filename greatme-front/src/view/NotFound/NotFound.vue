<template>
  <div>
    <div class="central-body">
      <img class="image-404" src="./static/404.svg" width="300px">
      <router-link to="/message" class="btn-go-home" target="_blank">返回首页</router-link>
    </div>
    <div class="objects">
      <img class="object_rocket" src="./static/rocket.svg" width="40px">
      <div class="earth-moon">
        <img class="object_earth" src="./static/earth.svg" width="100px">
        <img class="object_moon" src="./static/moon.svg" width="80px">
      </div>
      <div class="box_astronaut">
        <img class="object_astronaut" src="./static/astronaut.svg" width="140px">
      </div>
    </div>
    <div class="glowing_stars">
      <div class="star"></div>
      <div class="star"></div>
      <div class="star"></div>
      <div class="star"></div>
      <div class="star"></div>

    </div>
  </div>
</template>

<script>
  export default {
    name: 'NotFound'
  }
</script>

<style>
  @import "./static/style.css";
</style>
