<template>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.2/css/bootstrap.min.css" integrity="sha512-b2QcS5SsA8tZodcDtGRELiGv5SaKSk1vDHDaQRda0htPYWZ6046lr3kJ5bAAQdpV2mmA/4v0wQF9MyU6/pDIAg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <HeaderView />
  <RouterView />
</template>

<script>

import { RouterView } from 'vue-router';
import HeaderView from './components/HeaderView.vue';

export default {
  name: 'App',
  components: {
    HeaderView,
    RouterView
},
  data(){
    return {
    }
  },
  methods: {
  }
}
</script>

<style>
#app {
  height: 100%;
  width: 100%;
  box-sizing: border-box;
}

</style>
