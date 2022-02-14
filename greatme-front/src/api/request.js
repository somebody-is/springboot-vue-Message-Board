import axios from "axios"
import nprogress from 'nprogress'
import "nprogress/nprogress.css";
import store from '../store';

const requests = axios.create({
  baseURL:"/api",
  timeout:30000,
});


requests.interceptors.request.use((config) => {
  // if(store.state.detail.uuid_token){
  //     //请求头添加一个字段(userTempId)
  //     config.headers.userTempId = store.state.detail.uuid_token;
  //   }
  //   //需要携带token带给服务器
  //   if(store.state.user.token){
  //     config.headers.token = store.state.user.token;
  //   }
  nprogress.start();
  return config;
});


requests.interceptors.response.use((res) => {

  nprogress.done();
  return res.data;
},(error)=>{
  //return Promise.reject(new Error('faile'));
});

export default requests;
