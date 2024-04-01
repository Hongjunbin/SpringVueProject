<template>
  <div class="post-form">
    <h2>게시글 작성</h2>
    <form @submit.prevent="submitForm">
      <div class="form-group">
        <label for="title">제목:</label>
        <input type="text" id="title" v-model="formData.title" required>
      </div>
      <div class="form-group">
        <label for="content">내용:</label>
        <textarea id="content" rows="5" v-model="formData.content" required></textarea>
      </div>
      <button type="submit">작성</button>
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
        content: ''
      }
    };
  },
  methods: {
    submitForm() {
      axios.post('/posting', {
        boardTitle : this.formData.title, 
        boardWriting : this.formData.content}).then(res=>{
          if(res.data > 0){
            alert('게시글 작성 성공')
            this.$router.push({path : '/'});
          }
          
        })
    }
  }
};
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