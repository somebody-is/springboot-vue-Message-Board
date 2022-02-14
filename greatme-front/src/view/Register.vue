<template>
  <div style="padding-top: 60px;">
    <div class="card mb-3" style="margin-top: 60px;">
      <div class="card-header">
        WELCOME TO US
        <span style="float: right;">
          <span>已有账号</span>
          <router-link to="/login" class="card-link">登陆→</router-link>
        </span>
      </div>
      <div class="card-body">
        <div v-show='this.emailView'>
          <form @submit.prevent="onSubmit">
            <h5 class="card-title">欢迎来到GREATME</h5>
            <p class="card-text">输入你的邮箱加入GREATME的世界</p>
            <div class="input-group mb-3">
              <span class="input-group-text"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                  fill="currentColor" class="bi bi-arrow-right-square" viewBox="0 0 16 16">
                  <path fill-rule="evenodd"
                    d="M15 2a1 1 0 0 0-1-1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2zM0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm4.5 5.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z" />
                </svg></span>
              <input required type="email" class="form-control" placeholder="Email-adress" aria-label="Username"
                aria-describedby="basic-addon1" v-model="emailAddress">
            </div>
            <div class="input-group mb-3">
              <input required type="text" class="form-control" placeholder="输入验证码" aria-label="Username"
                aria-describedby="basic-addon1" v-model="inputCode">
              <span class="input-group-text" @click="updateImage" v-trigger><img style="width:100px;height: 41px;"
                  :src="this.imageSrc"></span>
            </div>
            <div class="d-grid gap-2 col-1 mx-auto">
              <button class="btn btn-outline-primary" type="submit" @click="emailReq">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                  class="bi bi-arrow-right" viewBox="0 0 16 16">
                  <path fill-rule="evenodd"
                    d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z" />
                </svg>
              </button>
            </div>
          </form>
        </div>
        <div v-show="this.codeView">
          <form @submit.prevent="onSubmit">
            <h5 class="card-title">已向您的邮箱发送验证码，请注意查收</h5>
            <p class="card-text">输入邮箱验证码</p>
            <div class="input-group mb-3">
              <span class="input-group-text"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                  fill="currentColor" class="bi bi-arrow-right-square" viewBox="0 0 16 16">
                  <path fill-rule="evenodd"
                    d="M15 2a1 1 0 0 0-1-1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2zM0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm4.5 5.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z" />
                </svg></span>
              <input type="text" class="form-control" placeholder="验证码" aria-label="Username" required
                v-model="inputCode" aria-describedby="basic-addon1">
            </div>
            <div class="mx-auto d-md-block" style="padding-left: 40%;">
              <button class="btn btn-outline-primary" @click="preStep">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                  class="bi bi-arrow-left" viewBox="0 0 16 16">
                  <path fill-rule="evenodd"
                    d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z" />
                </svg>
              </button>
              <button class="btn btn-outline-primary" type="submit" @click="codeReq">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                  class="bi bi-arrow-right" viewBox="0 0 16 16">
                  <path fill-rule="evenodd"
                    d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z" />
                </svg>
              </button>
            </div>
          </form>
        </div>
        <div v-show="this.passwordView">
          <form @submit.prevent="onSubmit">
            <h5 class="card-title">设置你的密码</h5>
            <p class="card-text">最后一步加入GREATME</p>
            <div class="input-group mb-3">
              <span class="input-group-text"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                  fill="currentColor" class="bi bi-arrow-right-square" viewBox="0 0 16 16">
                  <path fill-rule="evenodd"
                    d="M15 2a1 1 0 0 0-1-1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2zM0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm4.5 5.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z" />
                </svg></span>
              <input type="password" class="form-control" placeholder="密码(数字/字母/字符2种组合)" aria-label="Username" required
                v-model="password" aria-describedby="basic-addon1">
            </div>
            <div class="input-group mb-3">
              <span class="input-group-text"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16"
                  fill="currentColor" class="bi bi-arrow-right-square" viewBox="0 0 16 16">
                  <path fill-rule="evenodd"
                    d="M15 2a1 1 0 0 0-1-1H2a1 1 0 0 0-1 1v12a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1V2zM0 2a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V2zm4.5 5.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z" />
                </svg></span>
              <input type="password" class="form-control" placeholder="再次输入" aria-label="Username" required
                v-model="password2" aria-describedby="basic-addon1">
            </div>
            <div class="d-grid gap-2 col-1 mx-auto">
              <button class="btn btn-outline-primary" type="submit" @click="passwordReq">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                  class="bi bi-arrow-right" viewBox="0 0 16 16">
                  <path fill-rule="evenodd"
                    d="M1 8a.5.5 0 0 1 .5-.5h11.793l-3.147-3.146a.5.5 0 0 1 .708-.708l4 4a.5.5 0 0 1 0 .708l-4 4a.5.5 0 0 1-.708-.708L13.293 8.5H1.5A.5.5 0 0 1 1 8z" />
                </svg>
              </button>
            </div>
          </form>
        </div>
        <div v-show="this.resultView">
          <el-result icon="success" title="注册成功!" subTitle="返回登陆界面登陆">
            <template slot="extra">
              <router-link to="/login">
                <el-button type="primary" size="medium">返回</el-button>
              </router-link>
            </template>
          </el-result>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
  import {
    reqGetCodeImage,
    reqSendEmail,
    reqRegister
  } from '../api/index'
  export default {
    name: 'Register',
    data() {
      return {
        emailView: true,
        codeView: false,
        passwordView: false,
        resultView: false,
        emailAddress: '',
        code: '',
        inputCode: '',
        imageSrc: '',
        password: '',
        password2: ''
      }
    },
    directives: {
      trigger: {
        inserted(el, binging) {
          el.click()
        }
      }
    },
    created() {
      // 绑定事件
      window.addEventListener('keydown', this.keyDown)
    },
    methods: {
      onSubmit() {
        return false
      },
      keyDown(e) {
        // 如果是回车则执行登录方法
        if (e.keyCode === 13) {
          e.returnValue = false
        }
      },
      updateImage() {
        this.inputCode = ''
        reqGetCodeImage().then((data) => {
          if (this.emailView == true && data.code != null) {
            var c = data.code.toString()
            this.code = window.atob(c.replace(/\n/g, ""))
            this.imageSrc = data.src
          }
        })
      },
      preStep(step) {
        this.emailAddress = ''
        this.inputCode = ''
        this.codeView = false
        this.emailView = true
      },
      emailReq() {
        if (!this.emailAddress || !this.inputCode) {
          return false
        }
        if (this.inputCode.toUpperCase() != this.code) {
          this.$message.error('验证码错误');
          this.updateImage()
          return false
        }
        const loading = this.$loading({
          lock: true,
          text: '正在发送邮箱验证码......',
          spinner: 'el-icon-loading',
          background: 'rgba(0, 0, 0, 0.7)'
        });
        reqSendEmail(this.emailAddress).then((data) => {
          loading.close()
          var result = data.result
          if (result == 0) {
            this.$message.error('操作失败！请稍后重试');
          } else if (result == -1) {
            this.$message.error('该邮箱已被注册！请更换邮箱');
          } else if (result == 1) {
            this.code = window.atob(data.code)
            this.emailView = false
            this.codeView = true
          }
          this.inputCode = ''
          this.updateImage()
        })

        return false
      },
      codeReq() {
        if (!this.inputCode)
          return false;
        if (this.inputCode.toUpperCase() != this.code) {
          this.$message.error('验证码错误！');
          return false
        } else {
          this.$message({
            message: '验证成功！',
            type: 'success'
          });
          this.codeView = false;
          this.passwordView = true;
        }
      },
      warnMessage(message){
        this.$message({
          message: message,
          type: 'warning'
        });
      },
      passwordReq() {
        var t=this.password
        var rule = /^[0-9a-zA-Z_]{1,}$/
        if (t.length < 8 || t.length > 20) {
          this.warnMessage("密码长度为8-20个字符！")
          return
        }
        if (!/^[^[\u4e00-\u9fa5\s]*]*$/.test(t)) {
          this.warnMessage("不能使用空格、中文")
          return
        }
        if (/^[\w-!\.~;:@#\$%\^&\*\(\)\[\]\?+=]*$/.test(t)) {
          var num = !!t.match(/[0-9]/g),
            str = !!t.match(/[A-Za-z]/g),
            zi = !!t.match(/[-!\.~;_:@#\$%\^&\*\(\)\[\]\?+=]/g);
          var v = (num || str) && zi || num && str;
          if(!v){
            this.warnMessage("至少含有数字/字母/字符2种组合")
            return
          }
        } else {
          this.warnMessage("非法字符")
          return
        }
        //3294514005@qq.com
        if (!this.password || !this.password2)
          return false
        if (this.password != this.password2) {
          this.$message.error('两次密码不一致！');
        } else {
          reqRegister(this.emailAddress, this.password).then((data) => {
            if (data.result == 1) {
              this.$message({
                message: '注册成功！',
                type: 'success'
              });
              this.passwordView = false;
              this.resultView = true;
            } else {
              this.$message.error('操作失败！请稍后重试');
            }
          })
        }
      }
    }
  }
</script>

<style scoped="scoped">
  .card {
    margin: auto;
    width: 90%;
    max-width: 500px;
    text-align: left;
  }

  .btn {
    max-width: 50px;
  }
</style>
