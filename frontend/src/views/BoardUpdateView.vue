<template>
  <div class="post-form">
    <h2>게시글 수정</h2>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="title">제목:</label>
        <input type="text" id="title" v-model="formData.title" required>
      </div>
      <div class="form-group">
        <label for="content">내용:</label>
        <textarea id="content" rows="5" v-model="formData.content" required></textarea>
      </div>
      <button type="submit">수정하기</button>
    </form>
  </div>
</template>
<script>
import axios from 'axios';

export default {
  data() {
    return {
      formData: {
        title: '',
        content: '',
      }
    }
  },
  mounted(){
    this.load();
    
  },
  methods: {
    load(){
      const member = JSON.parse(sessionStorage.getItem('loginUser'));
      if(!member){
        this.$router.push({path : "/"});
      } else {
        axios.get('/boardUpdate?boardNo=' + this.$route.query.boardNo).then(res=>{
          if(!res.data){
            this.$router.push({path : '/'});
            alert('올바르지 않은 접근 방식입니다.')
          }
          this.formData.title = res.data.boardTitle;
          this.formData.content = res.data.boardWriting;
        })
      }
    },
    submitForm() {
      axios.post('/update', {
        boardNo : this.$route.query.boardNo,
        boardTitle : this.formData.title, 
        boardWriting : this.formData.content}).then(res=>{
          if(res.data > 0){
            alert('수정완료!')
            this.$router.push({path : '/'});
          }
      })
    }
  }
}
</script>

<style scoped>
.post-form {
  max-width: 800px;
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
input[type="text"]{
  width: 100%;
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}
textarea {
  width: 100%;
  height: 350px;
  resize: none;
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