(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-3dfd9b17"],{2017:function(t,s,e){"use strict";e("cafe")},7603:function(t,s,e){},9317:function(t,s,e){"use strict";e("7603")},"9ed6":function(t,s,e){"use strict";e.r(s);var a=function(){var t=this,s=t.$createElement,e=t._self._c||s;return e("div",{staticClass:"login-container"},[e("el-form",{ref:"loginForm",staticClass:"login-form",attrs:{model:t.loginForm,rules:t.loginRules,"auto-complete":"on","label-position":"left"}},[e("div",{staticClass:"title-container"},[e("h3",{staticClass:"title"},[t._v("登录")])]),e("el-form-item",{attrs:{prop:"username"}},[e("span",{staticClass:"svg-container"},[e("svg-icon",{attrs:{"icon-class":"user"}})],1),e("el-input",{ref:"username",attrs:{placeholder:"Username",name:"username",type:"text",tabindex:"1","auto-complete":"on"},model:{value:t.loginForm.username,callback:function(s){t.$set(t.loginForm,"username",s)},expression:"loginForm.username"}})],1),e("el-form-item",{attrs:{prop:"password"}},[e("span",{staticClass:"svg-container"},[e("svg-icon",{attrs:{"icon-class":"password"}})],1),e("el-input",{key:t.passwordType,ref:"password",attrs:{type:t.passwordType,placeholder:"Password",name:"password",tabindex:"2","auto-complete":"on"},nativeOn:{keyup:function(s){return!s.type.indexOf("key")&&t._k(s.keyCode,"enter",13,s.key,"Enter")?null:t.handleLogin(s)}},model:{value:t.loginForm.password,callback:function(s){t.$set(t.loginForm,"password",s)},expression:"loginForm.password"}}),e("span",{staticClass:"show-pwd",on:{click:t.showPwd}},[e("svg-icon",{attrs:{"icon-class":"password"===t.passwordType?"eye":"eye-open"}})],1)],1),e("el-button",{staticStyle:{width:"100%","margin-bottom":"30px"},attrs:{loading:t.loading,type:"primary"},nativeOn:{click:function(s){return s.preventDefault(),t.handleLogin(s)}}},[t._v("登录 ")]),e("div",{staticClass:"tips"},[e("span",[t._v("设置账号只是为了每次打开网页默认显示该线路信息，账号本身并无任何作用")])]),e("div",{staticClass:"tips"},[e("span",{staticStyle:{"margin-right":"20px"}},[t._v("1-6号站线路")]),e("span",{staticStyle:{"margin-right":"20px"}},[t._v("用户名: admin")]),e("span",[t._v(" 密码: 6位以下任意")])]),e("div",{staticClass:"tips"},[e("span",{staticStyle:{"margin-right":"20px"}},[t._v("7-10号站线路")]),e("span",{staticStyle:{"margin-right":"20px"}},[t._v("用户名: editor")]),e("span",[t._v(" 密码: 6位以下任意")])]),e("div",{staticClass:"tips"},[e("span",{staticStyle:{"margin-right":"20px"}},[t._v("11-15号站线路")]),e("span",{staticStyle:{"margin-right":"20px"}},[t._v("用户名: visitor")]),e("span",[t._v(" 密码: 6位以下任意")])])],1)],1)},n=[],r=e("61f7"),i={name:"Login",data:function(){var t=function(t,s,e){Object(r["b"])(s)?e():e(new Error("Please enter the correct user name"))},s=function(t,s,e){s.length<6?e(new Error("The password can not be less than 6 digits")):e()};return{loginForm:{username:"admin",password:"123456"},loginRules:{username:[{required:!0,trigger:"blur",validator:t}],password:[{required:!0,trigger:"blur",validator:s}]},loading:!1,passwordType:"password",redirect:void 0}},watch:{$route:{handler:function(t){this.redirect=t.query&&t.query.redirect},immediate:!0}},methods:{showPwd:function(){var t=this;"password"===this.passwordType?this.passwordType="":this.passwordType="password",this.$nextTick((function(){t.$refs.password.focus()}))},handleLogin:function(){var t=this;this.$refs.loginForm.validate((function(s){if(!s)return console.log("error submit!!"),_this.loading=!1,!1;t.loading=!0,t.$store.dispatch("user/login",t.loginForm).then((function(){"admin"==t.loginForm.username?t.$router.push({path:"/dashboard1"}):"editor"==t.loginForm.username?t.$router.push({path:"/dashboard2"}):"visitor"==t.loginForm.username&&t.$router.push({path:"/dashboard3"}),t.this.loading=!1})).catch((function(){t.loading=!1}))}))}}},o=i,l=(e("2017"),e("9317"),e("2877")),c=Object(l["a"])(o,a,n,!1,null,"668aa1f0",null);s["default"]=c.exports},cafe:function(t,s,e){}}]);