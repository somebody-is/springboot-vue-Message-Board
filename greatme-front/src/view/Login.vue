<template>
  <div id="building">
    <main class="form-signin">
      <form @submit.prevent="onSubmit">
        <router-link to="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
        <img class="mb-4" src="../assets/logo.png" alt="" width="276" height="63">
        </router-link>
        <h1 class="h3 mb-3 fw-normal"><span>登陆</span></h1>

        <div class="form-floating">
          <input type="text" class="form-control" id="floatingInput" required placeholder="name@example.com" v-model="username">
          <label for="floatingInput">账号或邮箱</label>
        </div>
        <br>
        <div class="form-floating">
          <input type="password" class="form-control" id="floatingPassword"  required placeholder="Password" v-model='password'>
          <label for="floatingPassword">密码</label>
        </div>

        <div class="checkbox mb-3">
          <label style="float: right;">
            <router-link to="/register"><span style="">立即注册</span></router-link>
          </label>
        </div><br>
        <button class="w-100 btn btn-lg btn-primary"  @click="login"><span>登陆</span></button>
        <p class="mt-5 mb-3 text-muted"><span>&copy; 2017–2021</span></p>
      </form>
    </main>
  </div>
</template>

<script>
  import {reqLogin} from '../api/index'
  export default{
    name:'Login',
    data(){
      return {
        username:'',
        password:''
      }
    },
    methods:{
      onSubmit(){return false},
      login(){
        var u=this.username
        var p=this.password
        if(!u||!p){
          //this.$message.error('请输入账号和密码');
          return
        }
        this.$store.dispatch("userLogin",{u,p}).then((data) =>{
          if(data.result==1){
            this.$message({
              message: '登陆成功！',
              type: 'success'
            });
            this.$router.push("/message")
          }else{
            this.$message.error('账号或密码错误');
          }
        });
      }
    }
  }
</script>

<style scoped="scoped">

  .form-signin {
    width: 100%;
    max-width: 330px;
    padding: 15px;
    margin: auto;
    font-family: "Arial","Microsoft YaHei","黑体","宋体",sans-serif;
  }

  span{
    color:white
  }


  .form-signin .checkbox {
    font-weight: 400;
  }

  .form-signin .form-floating:focus-within {
    z-index: 2;
  }

  .form-signin input[type="email"] {
    margin-bottom: -1px;
    border-bottom-right-radius: 0;
    border-bottom-left-radius: 0;
  }

  .form-signin input[type="password"] {
    margin-bottom: 10px;
    border-top-left-radius: 0;
    border-top-right-radius: 0;
  }

  .btn{
    box-shadow: 0px 0px 5px #ffaaff;
  }

</style>
