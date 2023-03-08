<template>
<div class="back">
  <router-view/>
</div>
</template>
<script>
  export default{
    data(){
      return {
       
      }
    },
    methods: {
      
        } 
        
  }
</script>
<style>
  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: auto auto;
    width: 350px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
  }

  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }

  .login_remember {
    margin: 0px 0px 35px 0px;
    text-align: left;
  }

  .back{
    height: 300vh;
      background-image: url('https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F202006%2F27%2F20200627140225_xcrnk.thumb.1000_0.jpg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1659715791&t=56adfa60bd721da1b26a9dd4550affba');
     width: 100%;
      height: 100%;
  background-size: 100% 100%;
  position: relative;
  overflow: hidden;
     /* background-repeat: no-repeat;
      background-position: center;
      background-attachment: fixed;
      background-size: cover;
      -webkit-background-size: cover;
      -moz-background-size: cover;
      -o-background-size: cover; */

    }
</style>
