(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-93ca1388"],{"6ad7":function(t,e,a){"use strict";a("f194")},d09b:function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("el-button",{staticStyle:{"margin-left":"25px"},attrs:{type:"danger"},on:{click:t.deleteAll}},[t._v("批量删除")]),a("el-table",{ref:"multipleTable",staticClass:"tablessp",staticStyle:{width:"100%","margin-top":"8px","min-height":"500px"},attrs:{data:t.tableData,height:"200","highlight-current-row":"",fit:"",border:"","default-sort":{prop:"date",order:"descending"}},on:{"selection-change":t.handleSelectionChange}},[a("el-table-column",{attrs:{type:"selection",width:"60",align:"center"}}),a("el-table-column",{attrs:{align:"center",label:"序号",width:"95",type:"index",index:t.typeIndex}}),a("el-table-column",{attrs:{prop:"equipmentNo",label:"设备号",align:"center",sortable:"",width:"180"}}),a("el-table-column",{attrs:{prop:"faultReason",label:"故障原因",align:"center",sortable:"",width:"180"}}),a("el-table-column",{attrs:{prop:"faultStartTime",label:"故障时间",align:"center",sortable:"",width:"180"}}),a("el-table-column",{attrs:{label:"操作",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"mini",type:"danger"},on:{click:function(a){return t.handleDelete(e.$index,e.row)}}},[t._v("删除 ")])]}}])})],1),a("el-dialog",{attrs:{title:"提示",visible:t.delVisible,width:"300px",center:""},on:{"update:visible":function(e){t.delVisible=e}}},[a("div",{staticClass:"del-dialog-cnt"},[t._v("删除不可恢复，是否确定删除？")]),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:function(e){t.delVisible=!1}}},[t._v("取 消")]),a("el-button",{attrs:{type:"primary"},on:{click:t.deleteRow}},[t._v("确 定")])],1)]),a("el-pagination",{staticStyle:{"text-align":"center"},attrs:{background:"","current-page":t.current,"page-sizes":[5,10,20],"page-size":t.limit,layout:"total,prev,pager,next,sizes,jumper",total:t.total},on:{"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange}})],1)},i=[],n=(a("ac1f"),a("5319"),{created:function(){this.fetchPageData(1,10)},data:function(){return{delVisible:!1,msg:"",delarr:[],multipleSelection:[],total:0,current:1,limit:10,pages:"0",tableData:[{id:"",equipmentNo:"",faultStartTime:"",faultReason:""}]}},methods:{deleteRow:function(){var t=this;this.$axios.delete("http://localhost:8181/mesEquipmentFaultHistory/deleteBySelectIds/"+this.delarr).then((function(e){console.log(e.data),"删除成功"==e.data?t.$router.go(0):alert("删除失败")})),this.delarr=[],this.delVisible=!1},handleDelete:function(t,e){this.idx=t,this.msg=e,this.delarr.push(this.msg.id),this.delVisible=!0,console.log(this.delarr)},deleteAll:function(){this.delVisible=!0;for(var t=this.multipleSelection.length,e=0;e<t;e++)this.delarr.push(this.multipleSelection[e].id);console.log(this.delarr)},typeIndex:function(t){var e=this;return(e.current-1)*e.limit+t+1},fetchPageData:function(t,e){var a=this;this.$axios.get("http://localhost:8181/mesEquipmentFaultHistory/queryByList/"+t+"/"+e).then((function(t){console.log(t.data.data);for(var e=0;e<t.data.data.length;e++){var l=new Date(+new Date(t.data.data[e].faultStartTime)+288e5).toISOString().replace(/T/g," ").replace(/\.[\d]{3}Z/,"");t.data.data[e].faultStartTime=l}a.tableData=t.data.data,a.total=t.data.total,a.pages=t.data.pages}))},handleSizeChange:function(t){var e=this;e.limit=t,e.fetchPageData(e.current,e.limit)},handleCurrentChange:function(t){var e=this;e.current=t,e.fetchPageData(e.current,e.limit)},handleSelectionChange:function(t){this.multipleSelection=t}}}),r=n,o=(a("6ad7"),a("2877")),s=Object(o["a"])(r,l,i,!1,null,"c3e3c632",null);e["default"]=s.exports},f194:function(t,e,a){}}]);