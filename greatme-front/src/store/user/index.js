import {reqLogin} from "../../api";
const state = {
  token: localStorage.getItem("TOKEN"),
  userInfo:{},
}

const mutations = {
  setUserInfo(state,user){
    state.userInfo=user
  },
  USERLOGIN(state, token) {
    state.token = token;
  },
  // CLEAR(state) {
  //   //帮仓库中先关用户信息清空
  //   state.token = '';
  //   state.userInfo = {};
  //   //本地存储数据清空
  //   localStorage.removeItem("TOKEN");
  // }
  CLEAR(state) {
    //帮仓库中先关用户信息清空
    state.token = '';
    state.userInfo = {};
    //本地存储数据清空
    localStorage.removeItem("USER");
  }
};

const actions = {
  // async userLogin({
  //   commit
  // }, username,password) {
  //   let result = await reqLogin(username,password);
  //   //服务器下发token，用户唯一标识符(uuid)
  //   //将来经常通过带token找服务器要用户信息进行展示
  //   if (result.code == 200) {
  //     //用户已经登录成功且获取到token
  //     commit("USERLOGIN", result.token);
  //     //持久化存储token+
  //     localStorage.setItem("TOKEN", result.token);
  //     return "ok";
  //   } else {
  //     return Promise.reject(new Error("faile"));
  //   }
  // },
  async userLogin({
    commit
  }, user) {
    let data = await reqLogin(user.u,user.p);
    console.log(JSON.stringify(user))
    if (data.result == 1) {
      localStorage.setItem("USER", JSON.stringify(data.user));
    }
    return data;
  },
  //获取用户信息
  async getUserInfo({
    commit
  }) {
    //let result = await reqUserInfo();
    if (result.code == 200) {
      //提交用户信息
      commit("GETUSERINFO", result.data);
      return 'ok';
    } else {
      return Promise.reject(new Error('faile'));
    }
  },

  setUserInfo({commit},user){
    commit('setUserInfo',user)
  },
  // //退出登录
  // async userLogout({
  //   commit
  // }) {
  //   //只是向服务器发起一次请求，通知服务器清除token
  //   //let result = await reqLogout();
  //   //action里面不能操作state，提交mutation修改state
  //   if (result.code == 200) {
  //     commit("CLEAR");
  //     return 'ok';
  //   } else {
  //     return Promise.reject(new Error('faile'));
  //   }
  // },
  //退出登录
  async userLogout({
    commit
  }) {
      commit("CLEAR");
  },
};

const getters = {};

export default {
  state,
  mutations,
  actions,
  getters
}
