<template>
  <div class="container">
    <div>
      <div id="boardDetailHeader">
        <div id="boardDetailTitle">
          {{ boardDetailData.boardTitle }}
        </div>
        {{ boardDetailData.userName }}
        {{ boardDetailData.enrollDate }}
      </div>
      <br>
      <div id="boardWritingArea">
        {{ boardDetailData.boardWriting }}
      </div>
      <br>
      <div id="replyForm" v-if="loginUser">
        <form @submit.prevent="submitReply">
          <textarea id="createReplyArea" v-model="reply" placeholder="댓글을 입력하세요" required></textarea>
          <div id="btnContainer">
            <button type="submit" class="btn btn-primary" id="replyBtn">댓글 달기</button>
          </div>
        </form>
      </div>
      <br>
      <div id="replyHeader">댓글</div>
      <div id="replyContainer">
        <div v-for="reply in boardReplyData" :key="reply">
          <div id="replyInnerContainer">
            <div id="selectReplyArea">
              <div id="replyUserInfo">
                {{ reply.userName }} {{ reply.enrollDate }}
                <button id="replyDeleteBtn" class="btn btn-secondary" v-if="loginUser.userNo == reply.userNo" @click="replyDelete(reply.replyNo)">댓글 삭제</button>
              </div>
            </div>
            <div id="replyWriting">{{ reply.replyWriting }}</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import axios from 'axios';
  export default{
    name : 'BoardDetail',
    created() {
      const loginUser = JSON.parse(sessionStorage.getItem('loginUser'));
      const isLoggedIn = sessionStorage.getItem('loggedIn');
      if(isLoggedIn){
        this.loginUser = loginUser;
      }
    },
    data(){
      return {
        loginUser : '',
        boardDetailData : {},
        boardReplyData : [],
        reply : ''
      }
    },
    mounted(){
      this.load();
    },
    methods :{
      load(){
        axios.get('/boardDetail?boardNo=' + this.$route.query.boardNo).then(res=>{
          this.boardDetailData = res.data.board;
          this.boardReplyData = res.data.reply;
        });
      },

      submitReply(){
        axios.post('/reply', {
          replyWriting : this.reply,
          boardNo : this.boardDetailData.boardNo,
          userNo : this.loginUser.userNo,
          userName : this.loginUser.userName,
        }).then(()=>{
          alert('댓글 등록이 되었습니다.');
          this.reply = '';
          this.load();
        })
      },
      replyDelete(replyNo){
        if(confirm("정말 삭제하시겠습니까??") == true){
          axios.post('/replyDelete',{
          replyNo : replyNo,
          }).then(()=>{
            alert('댓글이 삭제 되었습니다.');
            this.load();
          })
        } else {
          return false;
        }
      }
    }
  }
</script>
<style>
  #boardDetailHeader{
    margin-left: 10%;
    margin-right: 10%;
    border: 1px solid rgb(194, 194, 194);
    border-radius: 10px;
    padding: 10px;
  }
  #boardDetailTitle{
    font-size: 24px;
    font-weight: bold;
  }
  #boardWritingArea{
    margin-left: 10%;
    margin-right: 10%;
    height: auto;
    border: 1px solid rgb(194, 194, 194);
    border-radius: 10px;
    padding: 10px;
    overflow-wrap: break-word;
  }
  #createReplyArea{
    width: 100%;
    resize: none;
    height: 100px;
  }
  #selectReplyArea{
    width: 100%;
  }
  #btnContainer{
    width: 100%;
    height: 30px;
  }
  #replyBtn{
    float: right;
  }
  #replyContainer{
    margin-left: 10%;
    margin-right: 10%;
    border: 1px solid rgb(194, 194, 194);
    border-radius: 10px;
  }
  #replyForm{
    margin-left: 15%;
    margin-right: 15%;
  }

  #replyInnerContainer{
    width: 100%;
    height: auto;
    padding: 10px;
    border-bottom: 1px solid rgb(219, 219, 219);
  }
  #replyUserInfo{
    width: 100%;
    box-sizing: border-box;
    font-weight: bold;
    font-size: 17px;
  }
  #replyWriting{
    width: 100%;
    height: 60px;
    box-sizing: border-box;
  }
  #replyHeader{
    margin-left: 10%;
    margin-right: 10%;
    font-size: 20px;
    font-weight: bold;
  }
  #replyDeleteBtn{
    float: right;
  }
</style>