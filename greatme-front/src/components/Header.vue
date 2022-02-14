<template>
  <header class="p-3 bg-dark text-white">
    <div class="container">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <router-link to="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
          <!-- <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
            <use xlink:href="#bootstrap" />
          </svg> -->
          <img src="../assets/logo.png" style="width: 276px;height: 63;" />
        </router-link>

        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
          <li><router-link to="/message" class="nav-link px-2 text-secondary">留言板</router-link></li>
          <li><a href="#" class="nav-link px-2 text-white">Features</a></li>
          <li><a href="#" class="nav-link px-2 text-white">Pricing</a></li>
          <li><a href="#" class="nav-link px-2 text-white">FAQs</a></li>
          <li><a href="#" class="nav-link px-2 text-white">About</a></li>
        </ul>

        <div class="text-end" v-show="!this.$store.state.user.userInfo.email">
          <router-link to="/login"><button type="button" class="btn btn-outline-light me-2">登陆</button></router-link>
          <router-link to="/register"><button type="button" class="btn btn-warning">注册</button></router-link>
        </div>
        <div class="text-end" v-show="this.$store.state.user.userInfo.email">
          <el-avatar :size="40" src="https://cube.elemecdn.com/0/88/03b0d39583f48206768a7534e55bcpng.png"></el-avatar>
          <el-dropdown>
            <span class="el-dropdown-link"  style="color: white;float: right;margin-bottom: 7px;">
              {{this.$store.state.user.userInfo.email}}<i class="el-icon-arrow-down el-icon--right"></i>
            </span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item divided ><span @click="logout">退出登陆</span></el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </div>
      </div>
    </div>
  </header>
</template>

<script>
  export default{
    name:'Header',
    methods:{
      logout(){
        console.log(555)
        this.$store.dispatch("userLogout")
        this.$router.push("/login")
      }
    }
  }
</script>

<style>
  .bd-placeholder-img {
    font-size: 1.125rem;
    text-anchor: middle;
    -webkit-user-select: none;
    -moz-user-select: none;
    user-select: none;
  }

  @media (min-width: 768px) {
    .bd-placeholder-img-lg {
      font-size: 3.5rem;
    }
  }

  .form-control-dark {
    color: #fff;
    background-color: var(--bs-dark);
    border-color: var(--bs-gray);
  }

  .form-control-dark:focus {
    color: #fff;
    background-color: var(--bs-dark);
    border-color: #fff;
    box-shadow: 0 0 0 .25rem rgba(255, 255, 255, .25);
  }

  .bi {
    vertical-align: -.125em;
    fill: currentColor;
  }

  .text-small {
    font-size: 85%;
  }

  .dropdown-toggle {
    outline: 0;
  }
</style>
