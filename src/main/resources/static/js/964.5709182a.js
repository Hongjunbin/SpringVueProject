"use strict";(self["webpackChunkfrontend"]=self["webpackChunkfrontend"]||[]).push([[964],{3964:function(t,a,e){e.r(a),e.d(a,{default:function(){return Q}});var l=e(4108),n=e(9096);const o={class:"container"},r={class:"table table-hover"},d=(0,l.QD)("thead",{class:"table-light"},[(0,l.QD)("tr",null,[(0,l.QD)("th",{style:{width:"15%"}},"글 번호"),(0,l.QD)("th",{style:{width:"55%"}},"글 제목"),(0,l.QD)("th",{style:{width:"15%"}},"작성자"),(0,l.QD)("th",{style:{width:"15%"}},"작성일")])],-1),s=["onClick"],u={scope:"row"};function i(t,a,e,i,h,c){return(0,l.Wz)(),(0,l.An)("div",null,[(0,l.QD)("div",o,[(0,l.QD)("table",r,[d,(0,l.QD)("tbody",null,[((0,l.Wz)(!0),(0,l.An)(l.ae,null,(0,l.mi)(h.boardData,(t=>((0,l.Wz)(),(0,l.An)("tr",{onClick:a=>c.boardClick(t),key:t},[(0,l.QD)("th",u,(0,n.WA)(t.boardNo),1),(0,l.QD)("td",null,(0,n.WA)(t.boardTitle),1),(0,l.QD)("td",null,(0,n.WA)(t.userName),1),(0,l.QD)("td",null,(0,n.WA)(t.enrollDate),1)],8,s)))),128))])])])])}e(3248);var h=e(2964),c={components:{},mounted(){this.load()},data(){return{boardData:[]}},methods:{load(){h.c.get("/board").then((t=>{this.boardData=t.data}))},boardClick(t){this.$router.push({name:"BoardDetail",query:{boardNo:t.boardNo}})}}},D=e(4100);const b=(0,D.c)(c,[["render",i]]);var Q=b}}]);
//# sourceMappingURL=964.5709182a.js.map