import { createRouter, createWebHistory } from 'vue-router'
const routes = [
    {
      path: "/", // [경로]
      name: "Board", // [이름]
      component: () => import('../views/BoardView') // [로드 파일]
    },
    {
      path: "/join",
      name: "Join",
      component: () => import('../views/JoinView')
    },
    {
      path: "/boardDetail",
      name: "BoardDetail",
      component: () => import('../views/BoardDetailView')
    },
    {
      path: "/myPage",
      name: "Mypage",
      component: () => import('../views/MyPageView')
    },
    {
      path: "/boardPosting",
      name: "BoardPosting",
      component: () => import('../views/BoardPostingView')
    },
    {
      path: "/boardUpdate",
      name: "BoardUpdate",
      component: () => import('../views/BoardUpdateView')
    }

  ];

// 라우터 생성
const router = createRouter({
    history: createWebHistory(),
    routes
});

// 라우터 추출 (main.js에서 import)
export {router}