<template>
  <div class="register-form">
    <h2>회원가입</h2>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="userName">이름/닉네임:</label>
        <input type="text" id="userName" v-model="formData.userName" required>
      </div>
      <div class="form-group">
        <label for="id">아이디:</label>
        <input type="text" id="userId" v-model="formData.userId" required>
      </div>
      <div class="form-group">
        <label for="password">비밀번호:</label>
        <input type="password" id="userPwd" v-model="formData.userPwd" required>
      </div>
      <div class="form-group">
        <label for="confirmPassword" >비밀번호 확인:</label>
        <input type="password" id="confirmPassword" v-model="formData.confirmPassword" required>
      </div>
      <button type="submit">가입</button>
    </form>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      formData: {
        userId : '',
        userPwd : '',
        userName: '',
        password: '',
        confirmPassword: ''
      }
    };
  },
  methods: {
    submitForm() {
      if(this.formData.userPwd !== this.formData.confirmPassword){
        alert('비밀번호 확인 및 비밀번호의 값이 다릅니다.');
      } else {
        axios.post('/join', {
          userName : this.formData.userName,
          userId : this.formData.userId,
          userPwd : this.formData.userPwd
        }).then(res=>{
          if(res.data == 1){
            alert('회원가입 성공! 메인화면으로 돌아갑니다!');
            this.$router.push({path : '/'});
          } else if(res.data == 2) {
            alert('아이디가 중복됩니다! 다시입력해주세요!');
            this.formData.userId = '';
            this.formData.userPwd = '';
            this.formData.userName = '';
            this.formData.password = '';
            this.formData.confirmPassword = '';
          }
        })
      }
    }
  }
};
</script>

<style>
.register-form {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
}
.form-group {
  margin-bottom: 15px;
}
label {
  display: block;
  margin-bottom: 5px;
}
input[type="text"],
input[type="email"],
input[type="password"] {
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}
button {
  padding: 10px 20px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
</style>
