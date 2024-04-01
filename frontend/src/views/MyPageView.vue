<template>
  <div class="container">
    <span>이름 : </span>
    <span id="userNickName">{{ this.memberInfo.userName }}</span>&nbsp;
    <hr>
    <span id="boardListInfo">{{ this.memberInfo.userName }} 님의 작성한 게시글 목록 </span>
    <table class="table table-hover">
      <thead class="table-light">
        <tr>
          <th style="width: 15%;">글 번호</th>
          <th style="width: 45%;">글 제목</th>
          <th style="width: 10%;">작성자</th>
          <th style="width: 10%;">작성일</th>
          <th style="width: 10%">삭제</th>
          <th style="width: 10%">수정</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="board in this.boardInfo" :key="board">
          <th scope="row">{{ board.boardNo }}</th>
          <td id="boardTitle" @click="boardClick(board)">{{ board.boardTitle }}</td>
          <td>{{ board.userName}}</td>
          <td>{{ board.enrollDate }}</td>
          <td><button @click="boardDeleteBtn(board.boardNo)" class="btn btn-primary me-2">삭제</button></td>
          <td><router-link :to="{name: 'BoardUpdate', query: {boardNo: board.boardNo}}"><button class="btn btn-primary me-2">수정</button></router-link></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
  import axios from 'axios';
  export default {
    components : {

    },
    mounted() {
      this.load();
    },
    data(){
      return {
        boardInfo : [],
        memberInfo : {} 
      }
    },
    methods : {
      boardClick(board){
        this.$router.push({
          name: 'BoardDetail',
          query: {boardNo : board.boardNo}
        })
      },
      load(){
        const member = JSON.parse(sessionStorage.getItem('loginUser'));
      
        if(!member){
          this.$router.push({path : "/"});
        } else {
          axios.get('/myPageInfo', {
            params: member
          }).then(res=>{
            this.boardInfo = res.data.boardInfo;
            this.memberInfo = res.data.memberInfo;
          });
        }
      },
      boardDeleteBtn(boardNo){
        if(confirm("정말 삭제하시겠습니까??") == true){
          axios.post('/deleteBoard', {
          boardNo : boardNo,
          }).then(()=>{
            alert("성공적으로 삭제 되었습니다.");
            this.load();
          })
        }
      },
    }
  }
</script>
<style>
  #boardListInfo{
    font-weight: bold;
  }
  #userNickName{
    font-weight: bold;
  }
  #boardTitle{
    cursor: pointer;
  }
</style>