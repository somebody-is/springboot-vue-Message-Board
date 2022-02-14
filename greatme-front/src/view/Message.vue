<template>
  <main class="container" style="margin-top: 20px;">
    <div class="p-4 p-md-5 mb-4 text-white rounded bg-dark">
      <div>
        <h1 class="display-4 fst-italic">留言板</h1>
        <p class="lead my-3">勇敢把心里的话说出来,不要隐藏自己的真心</p>
        <p class="lead mb-0"><router-link to="/addmessage" href="#" class="text-white fw-bold">写留言...</router-link></p>
      </div>
    </div>
    <div class="search-message">
      <form class="d-flex" @submit.prevent="onSubmit">
        <button class="btn btn-dark" type="submit" style="width: 100px;height: 50px;" @click="searchMessage">查询</button>
        <input style="font-size: 20px;" class="form-control me-2" type="search" placeholder="找一下你的留言"
          v-model="searchKey" aria-label="找一下你的留言">
      </form>
    </div>
    <div class="row mb-2">
      <div v-show="!this.messages.length" class="col-md-6">
        <div
          class="message-content row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
          <div class="col p-4 d-flex flex-column position-static">
            <!-- <strong class="d-inline-block mb-2 text-primary">刘宗放</strong> -->
            <div class="mb-1 text-muted" style="text-align: left;">给你的留言（づ￣3￣）づ╭❤～</div>

          </div>
          <!--          <div class="col-auto d-none d-lg-block">
            <svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>

          </div> -->
        </div>
        </div>
      <div v-for="(item,index) in this.messages" class="col-md-6" >
        <div style="background-color:rgba(255, 255, 255, 0.8);font-weight: 600;font-family: 'Times New Roman', Times, serif;"
          class="message-content row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative">
          <div class="col p-4 d-flex flex-column position-static" >
            <!-- <strong class="d-inline-block mb-2 text-primary">刘宗放</strong> -->
            <h3 class="mb-3">致：{{item.messageKey}}</h3>
            <div class="mb-1 text-muted">{{item.messageDate}}</div>
            <div class="mb-1 " style="text-align: left;">留言者：{{item.masterName?item.masterName:'匿名用户'}}</div>
            <div v-show="!item.isLocked">
              <p class="card-text mb-auto">
                <hr>
                {{item.messageContent}}
              </p>
            </div>
            <div v-show="item.isLocked">
              <hr>
              主人给留言上锁了....<el-button type="primary" @click="handleOpen(item.id)"><span
                  style="font-size: 20px;">输入密码</span></el-button>
            </div>
          </div>
          <!--          <div class="col-auto d-none d-lg-block">
            <svg class="bd-placeholder-img" width="200" height="250" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"/><text x="50%" y="50%" fill="#eceeef" dy=".3em">Thumbnail</text></svg>

          </div> -->
        </div>
      </div>
    </div>
    </div>
    <el-dialog title="密码是..." :visible.sync="lockVisible" width="400px" :before-close="handleClose">
      <el-input required style="font-size: 20px;" v-model="messagePassword"></el-input>
      <span slot="footer" class="dialog-footer">
        <el-button @click="handleClose">取 消</el-button>
        <el-button type="primary" @click="unLockMessage">确 定</el-button>
      </span>
    </el-dialog>

    <!-- <div class="row g-5">
      我好像有点喜欢你我知道这样说可能很唐实，但我真的很感谢你的出观.感谢你的出现，让我的生活有了光，在遇见你那段时间里我非常的开心，也非常的高兴.虽然身边也有人出现但是我还是一心喜欢你我很喜欢你的光照耀我的感觉你出现的这段时间里，我总是忍不住幻想幻想我们地做各种可爱的事情.幻想我们可以有个小小的家庭.感谢你能够在我最团难的时候出现，帮助我获得了新的生活.你没有像别人一样看不起我，你很乐意和我交朋友，和我聊天.可以说你的出现给我的生活带来了很大的希望和改变:我开始学着去让自了变得更好.想要向你靠近，在我心里你就如月亮一般.我愿意追逐着你，即使我们最后走不到一起，但是我信那样的结局也会是完美的

      <div class="col-md-8">
        <h3 class="pb-4 mb-4 fst-italic border-bottom">
          From the Firehose
        </h3>

        <article class="blog-post">
          <h2 class="blog-post-title">Sample blog post</h2>
          <p class="blog-post-meta">January 1, 2021 by <a href="#">Mark</a></p>

          <p>This blog post shows a few different types of content that’s supported and styled with Bootstrap. Basic
            typography, lists, tables, images, code, and more are all supported as expected.</p>
          <hr>
          <p>This is some additional paragraph placeholder content. It has been written to fill the available space and
            show how a longer snippet of text affects the surrounding content. We'll repeat it often to keep the
            demonstration flowing, so be on the lookout for this exact same string of text.</p>

        </article>


        <nav class="blog-pagination" aria-label="Pagination">
          <a class="btn btn-outline-primary" href="#">Older</a>
          <a class="btn btn-outline-secondary disabled">Newer</a>
        </nav>

      </div>

      <div class="col-md-4">
        <div class="position-sticky" style="top: 2rem;">
          <div class="p-4 mb-3 bg-light rounded">
            <h4 class="fst-italic">About</h4>
            <p class="mb-0">Customize this section to tell your visitors a little bit about your publication, writers,
              content, or something else entirely. Totally up to you.</p>
          </div>

          <div class="p-4">
            <h4 class="fst-italic">Archives</h4>
            <ol class="list-unstyled mb-0">
              <li><a href="#">March 2021</a></li>
              <li><a href="#">February 2021</a></li>
              <li><a href="#">January 2021</a></li>
              <li><a href="#">December 2020</a></li>
              <li><a href="#">November 2020</a></li>
              <li><a href="#">October 2020</a></li>
              <li><a href="#">September 2020</a></li>
              <li><a href="#">August 2020</a></li>
              <li><a href="#">July 2020</a></li>
              <li><a href="#">June 2020</a></li>
              <li><a href="#">May 2020</a></li>
              <li><a href="#">April 2020</a></li>
            </ol>
          </div>

          <div class="p-4">
            <h4 class="fst-italic">Elsewhere</h4>
            <ol class="list-unstyled">
              <li><a href="#">GitHub</a></li>
              <li><a href="#">Twitter</a></li>
              <li><a href="#">Facebook</a></li>
            </ol>
          </div>
        </div>
      </div>
    </div> -->

  </main>
</template>

<script>
  import {
    reqPublicMessage,reqGetContent,reqQueryMessage
  } from '../api/index'
  export default {
    name: 'Message',
    data() {
      return {
        messages: [],
        messageId:'',
        lockVisible: false,
        messagePassword: '',
        searchKey:''
      }
    },
    created: function() {
      reqPublicMessage().then((data) => {
        this.messages = data
      })
    },
    methods: {
      onSubmit(){return false},
      handleOpen(index){
        this.messageId=index
        this.lockVisible=true
      },
      handleClose(done) {
        this.messagePassword = ''
        this.lockVisible = false
      },
      unLockMessage() {
        if (!this.messagePassword) {
          this.$message.error('密码还没写呢');
        }
        reqGetContent(this.messageId,this.messagePassword).then((data)=>{
          if(data.result==-1){
            this.$message.error('密码错了');
            return
          }
          for(var i in this.messages){
            if(this.messages[i].id==this.messageId){
              this.messages[i].isLocked=0
              this.messages[i].messageContent=data.content
            }
          }
          this.$message({
            message: '解锁成功！',
            type: 'success'
          });
          this.lockVisible=false
        });
      },
      searchMessage(){
        if(!this.searchKey){
          reqPublicMessage().then((data) => {
            this.messages = data
          })
        }
        reqQueryMessage(this.searchKey).then((data)=>{
          this.messages=data.messages
        })
      }
    }
  }
</script>

<style>
  .message-content {
    background: whitesmoke;
    font-family: var(--bs-body-font-family);
    font-size: calc(1.275rem + .3vw);
    font-weight: 300;
  }

  .search-message {
    margin-bottom: 20px;
    max-width: 500px;
  }
</style>
