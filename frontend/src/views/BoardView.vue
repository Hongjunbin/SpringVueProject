<template>
  <div>
    <div class="container">
      <table class="table table-hover">
        <thead class="table-light">
          <tr >
            <th style="width: 15%;">글 번호</th>
            <th style="width: 55%;">글 제목</th>
            <th style="width: 15%;">작성자</th>
            <th style="width: 15%;">작성일</th>
          </tr>
        </thead>
        <tbody>
          <tr @click="boardClick(board)" v-for="board in boardData" :key="board">
            <th scope="row">{{ board.boardNo }}</th>
            <td>{{ board.boardTitle }}</td>
            <!-- <router-link :to="`/boardDetail?bNo=${board.boardNo}`">{{ board.boardTitle }}</router-link> -->
            <td>{{ board.userName}}</td>
            <td>{{ board.enrollDate }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
  import axios from 'axios';
  export default{
    components : {

    },
    mounted() {
      this.load();
    },
    data(){
      return {
        boardData : [],
      }
    },
    methods : {
      load(){
        axios.get('/board').then(res=>{
          this.boardData = res.data;
        });
      },
      boardClick(board){
        this.$router.push({
          name: 'BoardDetail',
          query: {boardNo : board.boardNo}
        })
      }
    },
  }
</script>