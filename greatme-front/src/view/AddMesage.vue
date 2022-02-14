<template>
  <div style="padding-top: 30px;">
    <div class="col-xl-5" style="margin: auto;width: 98%;max-width: 600px;">
      <div class="card">
        <div class="card-header">
          <router-link to="/message" style="float: left;color: #000000;">返回</router-link>
          <h5 class="card-title">发布留言</h5>
          <h6 class="card-subtitle text-muted">留下你想说的话</h6>
        </div>
        <div class="card-body">
          <form @submit.prevent="onSubmit">
            <div class="row g-3 align-items-center">
              <div class="col-auto">
                <label for="inputPassword1" class="col-form-label">给ta留言</label>
              </div>
              <div class="col-auto">
                <input required type="text" id="inputPassword1" class="form-control" aria-describedby="passwordHelpInline" v-model="form.messageKey">
              </div>
              <div class="col-auto">
                <span id="passwordHelpInline" class="form-text">
                  所有人能通过它搜索的你的留言
                </span>
              </div>
            </div><br>
            <div class="row g-3 align-items-center">
              <div class="col-auto">
                <label for="inputPassword2" class="col-form-label">你的名字</label>
              </div>
              <div class="col-auto">
                <input required type="text" id="inputPassword2" class="form-control" aria-describedby="passwordHelpInline" v-model="form.masterName">
              </div>
              <div class="col-auto">
                <span id="passwordHelpInline" class="form-text">
                  留下你的印记吧
                </span>
              </div>
            </div>
            <hr>
            <div class="row g-3 align-items-center">
              <div class="col-auto">
                <label for="inputPassword3" class="col-form-label">留言上锁</label>
              </div>
              <div class="col-auto">
                <div class="form-check form-switch">
                  <input class="form-check-input" type="checkbox" role="switch" v-model="isLocked">
                </div>
              </div>
              <div class="col-auto">
                <span id="passwordHelpInline" class="form-text">
                  只能ta看
                </span>
              </div>
            </div>
            <br>
            <div class="row g-3 align-items-center">
              <div class="col-auto">
                <label for="inputPassword4" class="col-form-label">密码</label>
              </div>
              <div class="col-auto">
                <input :disabled='isLocked==0?true:false' type="password" id="inputPassword4" class="form-control" aria-describedby="passwordHelpInline" v-model="form.messagePassword">
              </div>
              <div class="col-auto">
                <span id="passwordHelpInline" class="form-text">
                  你们的密码
                </span>
              </div>
            </div>
            <hr>
            <div class="row g-3 align-items-center">
              <div class="col-auto">
                <label for="inputPassword5" class="col-form-label">展示</label>
              </div>
              <div class="col-auto">
                <div class="form-check form-switch">
                  <input class="form-check-input" type="checkbox" role="switch" v-model="isPublic">
                </div>
              </div>
              <div class="col-auto">
                <span id="passwordHelpInline" class="form-text">
                  要在首页展示你的留言吗
                </span>
              </div>
            </div>
            <hr>
            <label for="basic-url" class="form-label">留言</label>
              <el-input
                required
                type="textarea"
                :autosize="{ minRows: 3, maxRows: 20}"
                style="font-size: 18px;min-height: 100px;"
                placeholder="请输入内容"
                v-model="form.messageContent">
              </el-input>
            <hr>
            <button class="btn btn-primary" @click="sendMessage">发布</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import {reqSendMessage} from '../api/index'
  export default {
    name: 'AddMessage',
    data(){
      return {
        isLocked:0,
        isPublic:1,
        form:{
          messageKey:'',
          messageMaster:this.$store.state.user.userInfo.id?this.$store.state.user.userInfo.id:0,
          masterName:'匿名用户',
          isLocked:0,
          messagePassword:'',
          isPublic:1,
          messageContent:''
        },
      }
    },
    methods: {
      onSubmit() {return false},
      sendMessage(){
        if(!this.form.messageKey||!this.form.masterName||!this.form.messageContent){
          return
        }
        reqSendMessage(this.form).then((data)=>{
          if(data.result==1){
            this.$message({
              message: '发布成功！',
              type: 'success'
            });
            this.$router.push("/message");
          }
        })
      }
    },
    watch: {
      isLocked: function() {
        this.form.messagePasword=""
        this.form.isLocked=this.isLocked?1:0
      },
      isPublic: function() {
        this.form.isPublic=this.isPublic?1:0
      }
    },
  }
</script>

<style>
</style>
