(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-1e3b888b"],{"3deb":function(t,n,a){"use strict";a.r(n);var o=function(){var t=this,n=t.$createElement,a=t._self._c||n;return a("div",[a("marquee",{attrs:{id:"affiche",align:"left",behavior:"scroll",direction:"left",hspace:"50",vspace:"20",loop:"-1",scrollamount:"10",scrolldelay:"0",onMouseOut:"this.start()",onMouseOver:"this.stop()"}},[a("span",{staticStyle:{"margin-top":"20px","margin-left":"25px","font-size":"40px"}},[t._v("正在生产的计划："+t._s(this.nowPlanNo))]),a("span",{staticStyle:{"margin-top":"20px","margin-left":"25px","font-size":"40px"}},[t._v("合格数："+t._s(this.nowPlanActualNum))]),a("span",{staticStyle:{"margin-top":"20px","margin-left":"25px","font-size":"40px"}},[t._v("补焊合格数："+t._s(this.nowPlanFailNum))]),a("span",{staticStyle:{"margin-top":"20px","margin-left":"25px","font-size":"40px"}},[t._v("不合格数："+t._s(this.nowPlanWeldingFinishNum))])]),a("el-form",{staticClass:"demo-form-inline",staticStyle:{"margin-top":"20px","margin-left":"25px"},attrs:{inline:!0,model:t.selectForm}},[a("el-form-item",{attrs:{label:"选择未完成计划"}},[a("el-select",{attrs:{placeholder:"选择未完成计划"},model:{value:t.selectForm.planNo,callback:function(n){t.$set(t.selectForm,"planNo",n)},expression:"selectForm.planNo"}},t._l(t.unFinishPlanNoForm,(function(t,n){return a("el-option",{attrs:{label:t.planNo,value:t.planNo}})})),1)],1),a("el-form-item",[a("el-button",{attrs:{type:"primary",icon:"el-icon-refresh"},on:{click:function(n){return t.startPlan("selectForm")}}},[t._v("切换计划 ")])],1)],1),a("div",{staticStyle:{"min-height":"700px","line-height":"700px"}},[a("el-button",{staticClass:"button",attrs:{type:"success",circle:""},on:{click:function(n){return t.pass(1)}}},[t._v("合格")]),a("el-button",{staticClass:"button",attrs:{type:"danger",circle:""},on:{click:function(n){return t.pass(2)}}},[t._v("不合格")]),a("el-button",{staticClass:"button",attrs:{type:"warning",circle:""},on:{click:function(n){return t.pass(3)}}},[t._v("补焊合格")])],1)],1)},e=[],l={created:function(){this.getProductPlan()},destroyed:function(){clearInterval(this.timer)},mounted:function(){this.getUnFinishPlanNo()},data:function(){return{nowPlanNo:"",nowPlanActualNum:"",nowPlanFailNum:"",nowPlanWeldingFinishNum:"",unFinishPlanNoForm:[{planNo:""}],selectForm:{planNo:""},beforeForm:{planNo:""}}},methods:{pass:function(t){console.log(t);var n=this;this.$axios.post("http://localhost:8181/mesPrimaryProducePlan/pass",{before:this.beforeForm.planNo,enum:t}).then((function(t){console.log(t.data),"合格"==t.data?n.reload():"完成"==t.data&&n.$confirm("计划已完成，点击确认刷新页面","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){n.reload()}))}))},getProductPlan:function(){var t=this;this.$axios.get("http://localhost:8181/mesPrimaryProducePlan/getProductPlan").then((function(n){console.log(n.data.mes),null!=n.data.mesPrimaryProducePlan&&(t.beforeForm.planNo=n.data.mesPrimaryProducePlan.planNo),"查询成功"==n.data.mes?(t.nowPlanNo=n.data.mesPrimaryProducePlan.planNo,t.nowPlanActualNum=n.data.mesPrimaryProducePlan.actualNum,t.nowPlanFailNum=n.data.mesPrimaryProducePlan.failNum,t.nowPlanWeldingFinishNum=n.data.mesPrimaryProducePlan.weldingFinishNum):(t.nowPlanNo="",t.nowPlanActualNum=0,t.nowPlanFailNum=0,t.nowPlanWeldingFinishNum=0)}))},getUnFinishPlanNo:function(){var t=this;this.$axios.get("http://localhost:8181/mesPrimaryProducePlan/getUnFinishPlan").then((function(n){console.log(n.data),t.unFinishPlanNoForm=n.data}))},startPlan:function(t){var n=this;console.log(this.selectForm.planNo),this.$axios.post("http://localhost:8181/mesPrimaryProducePlan/startPlanByNo",{now:this.selectForm.planNo,before:this.beforeForm.planNo}).then((function(t){console.log(t.data),"开始生产"==t.data?n.reload():alert(t.data)}))}},inject:["reload"]},i=l,s=(a("9b89"),a("2877")),r=Object(s["a"])(i,o,e,!1,null,"35bd346c",null);n["default"]=r.exports},"9b89":function(t,n,a){"use strict";a("e27d")},e27d:function(t,n,a){}}]);