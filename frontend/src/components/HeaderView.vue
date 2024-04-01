
<template>
  <div class="container">
    <header
      class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 mb-4 border-bottom">
      <div class="col-md-3 mb-2 mb-md-0">
        <router-link to="/" id="title" class="d-inline-flex link-body-emphasis text-decoration-none">
          Blog
        </router-link>
      </div>
      <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
        <li v-if="loginUser != ''"><router-link to="/boardPosting" class="nav-link px-2">게시글작성</router-link></li>
        <li v-if="loginUser != ''"><router-link to="/myPage" class="nav-link px-2">마이페이지</router-link></li>
      </ul>
      <div class="col-md-3 text-end">
        <div v-if="loginUser == ''">
          <button type="button" class="btn btn-primary me-2" data-bs-toggle="modal" data-bs-target="#staticBackdrop">로그인</button>
          <button type="button" class="btn btn-primary"><router-link to="/join" id="joinButton">회원가입</router-link></button>
        </div>
        <div v-else>
          <span id="nickNameTag">{{ loginUser.userName }}</span>&nbsp;&nbsp;
          <button type="button" class="btn btn-primary me-2" @click="logOutButtonClick">로그아웃</button>
        </div>
      </div>

      <!-- modal -->
      <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h1 class="modal-title fs-5" id="staticBackdropLabel">로그인</h1>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <form>
                <div class="mb-3">
                  <label for="recipient-name" class="col-form-label">아이디</label>
                  <input type="text" class="form-control" id="recipient-name" v-model.trim="userId">
                  <label for="recipient-name" class="col-form-label">비밀번호</label>
                  <input type="password" class="form-control" id="recipient-name" v-model.trim="userPwd">
                </div>
              </form>
            </div>
            <div class="modal-footer">
              <button type="button" ref="closeModal" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
              <button type="button" class="btn btn-primary" @click="loginButtonClick">로그인</button>
            </div>
          </div>
        </div>
      </div>
    <!-- /modal -->
    </header>
  </div>
</template>

<script>
import axios from 'axios';
  export default {
    components : {

    },
    created() {
      const loginUser = JSON.parse(sessionStorage.getItem('loginUser'));
      const isLoggedIn = sessionStorage.getItem('loggedIn');
      if(isLoggedIn){
        this.loginUser = loginUser;
      }
    },
    data(){
      return{
        loginUser : ''
      }
    },
    methods: {
      loginButtonClick(){
        if(this.userId === undefined){
          alert('ID를 입력하세요.')
          return
        }
        if(this.userId === ''){
          alert('ID를 입력하세요.')
          return
        }
        if(this.userPwd === undefined){
          alert('비밀번호를 입력하세요.')
          return
        }
        if(this.userPwd === ''){
          alert('비밀번호를 입력하세요.')
          return
        }
        axios.post('/login', {userId : this.userId, userPwd : this.userPwd})
        .then(res=>{
          if(res.data === ''){
            alert('로그인 실패! 없는 id 또는 없는 password');
          } else {
            alert('로그인 성공!');
            // 로그인 성공 시
            sessionStorage.setItem('loggedIn', true); // 로그인 여부를 저장
            sessionStorage.setItem('loginUser', JSON.stringify(res.data));
            this.$refs.closeModal.click();
            this.loginUser = res.data;
            this.$router.go(0);
          }
        });
      },
      logOutButtonClick(){
        sessionStorage.clear();
        alert('로그아웃을 합니다~');
        this.$router.go(0)
        // this.$router.push({path : "/"});
      }
    },
  }
</script>
<style>
  #title{
    font-size: 25px;
  }
  #joinButton{
    color: white;
    text-decoration: none;
  }
  #myPageButton{
    color: black;
    text-decoration: none;
  }
  #headerMypageButton{
    text-decoration: none;
  }
  #postingButton{
    color: white;
    text-decoration: none;
  }
  #nickNameTag{
    font-weight: bold;
  }
</style>