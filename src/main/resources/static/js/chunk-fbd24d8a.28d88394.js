(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-fbd24d8a"],{"097e":function(t,e,i){"use strict";i("7688")},"58d7":function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("div",[i("el-form",{staticClass:"demo-form-inline",staticStyle:{"margin-top":"20px","margin-left":"25px"},attrs:{inline:!0,model:t.stationCondition}},[i("el-form-item",{attrs:{label:"工位名称"}},[i("el-autocomplete",{staticClass:"inline-input",attrs:{"fetch-suggestions":t.querySearch1,placeholder:"请输入工位名称查询","trigger-on-focus":!1,clearable:""},on:{select:t.handleSelect},model:{value:t.stationCondition.stationName,callback:function(e){t.$set(t.stationCondition,"stationName",e)},expression:"stationCondition.stationName"}})],1),i("el-form-item",{attrs:{label:"状态"}},[i("el-select",{attrs:{placeholder:"状态"},model:{value:t.stationCondition.status,callback:function(e){t.$set(t.stationCondition,"status",e)},expression:"stationCondition.status"}},[i("el-option",{attrs:{label:"运行中",value:"1"}}),i("el-option",{attrs:{label:"等待中",value:"0"}}),i("el-option",{attrs:{label:"故障",value:"-1"}})],1)],1),i("el-form-item",[i("el-button",{attrs:{type:"primary",icon:"el-icon-search"},on:{click:t.onSubmit}},[t._v("查询")])],1),i("el-form-item",[i("el-button",{attrs:{type:"danger",icon:"el-icon-delete"},on:{click:t.deleteAll}},[t._v("批量删除")])],1),i("el-form-item",{staticStyle:{float:"right"}},[i("el-button",{attrs:{type:"primary",icon:"el-icon-circle-plus-outline"},on:{click:t.handleInsert}},[t._v("新增工位")])],1)],1),i("el-table",{ref:"multipleTable",staticClass:"tablessp",staticStyle:{width:"100%","margin-top":"8px","min-height":"700px"},attrs:{data:t.tableData,height:"200","highlight-current-row":"",fit:"",border:"","default-sort":{prop:"date",order:"descending"}},on:{"selection-change":t.handleSelectionChange}},[i("el-table-column",{attrs:{type:"selection",width:"60",align:"center"}}),i("el-table-column",{attrs:{align:"center",label:"序号",width:"95",type:"index",index:t.typeIndex}}),i("el-table-column",{attrs:{prop:"stationNo",label:"工位号",align:"center",sortable:"",width:"180"}}),i("el-table-column",{attrs:{prop:"stationName",label:"工位名称",align:"center",sortable:"",width:"180"}}),i("el-table-column",{attrs:{prop:"status",label:"状态",align:"center",sortable:"",formatter:t.stateFormat,width:"180"}}),i("el-table-column",{attrs:{label:"操作",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[i("el-button",{attrs:{size:"mini",round:"",type:"warning",icon:"el-icon-edit"},on:{click:function(i){return t.handleEdit(e.$index,e.row)}}},[t._v("编辑 ")]),i("el-button",{attrs:{size:"mini",type:"danger",icon:"el-icon-delete",round:""},on:{click:function(i){return t.handleDelete(e.$index,e.row)}}},[t._v("删除 ")])]}}])})],1),i("el-dialog",{staticClass:"edit-form",attrs:{title:"添加工位信息",visible:t.insertFormVisible,"close-on-click-modal":!1},on:{"update:visible":function(e){t.insertFormVisible=e}}},[i("el-form",{ref:"insertForm",attrs:{model:t.insertForm,"label-width":"80px"}},[i("el-form-item",{attrs:{label:"工位号",prop:"stationNo"}},[i("el-input",{attrs:{"auto-complete":"off"},model:{value:t.insertForm.stationNo,callback:function(e){t.$set(t.insertForm,"stationNo",e)},expression:"insertForm.stationNo"}})],1),i("el-form-item",{attrs:{label:"工位名称",prop:"stationName"}},[i("el-input",{attrs:{"auto-complete":"off"},model:{value:t.insertForm.stationName,callback:function(e){t.$set(t.insertForm,"stationName",e)},expression:"insertForm.stationName"}})],1)],1),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{nativeOn:{click:function(e){return t.handleCancel("insertForm")}}},[t._v("取消")]),i("el-button",{attrs:{type:"primary"},nativeOn:{click:function(e){return t.Insert("insertForm")}}},[t._v("新增")])],1)],1),i("el-dialog",{staticClass:"edit-form",attrs:{title:"编辑工位信息",visible:t.editFormVisible,"close-on-click-modal":!1},on:{"update:visible":function(e){t.editFormVisible=e}}},[i("el-form",{ref:"editForm",attrs:{model:t.editForm,"label-width":"80px"}},[i("el-form-item",{attrs:{label:"工位号",prop:"stationNo"}},[i("el-input",{attrs:{"auto-complete":"off",disabled:!0},model:{value:t.editForm.stationNo,callback:function(e){t.$set(t.editForm,"stationNo",e)},expression:"editForm.stationNo"}})],1),i("el-form-item",{attrs:{label:"工位名称",prop:"stationName"}},[i("el-input",{attrs:{"auto-complete":"off"},model:{value:t.editForm.stationName,callback:function(e){t.$set(t.editForm,"stationName",e)},expression:"editForm.stationName"}})],1),i("el-form-item",{attrs:{label:"状态",prop:"status"}},[i("el-select",{attrs:{placeholder:"选择状态"},model:{value:t.editForm.status,callback:function(e){t.$set(t.editForm,"status",e)},expression:"editForm.status"}},[i("el-option",{attrs:{label:"运行中",value:"1"}}),i("el-option",{attrs:{label:"等待中",value:"0"}}),i("el-option",{attrs:{label:"故障",value:"-1"}})],1)],1)],1),i("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{nativeOn:{click:function(e){return t.handleCancel("editForm")}}},[t._v("取消")]),i("el-button",{attrs:{type:"primary"},nativeOn:{click:function(e){return t.handleUpdate("editForm")}}},[t._v("更新")])],1)],1),i("el-dialog",{attrs:{title:"提示",visible:t.delVisible,width:"300px",center:""},on:{"update:visible":function(e){t.delVisible=e}}},[i("div",{staticClass:"del-dialog-cnt"},[t._v("删除不可恢复，是否确定删除？")]),i("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:function(e){t.delVisible=!1}}},[t._v("取 消")]),i("el-button",{attrs:{type:"primary"},on:{click:t.deleteRow}},[t._v("确 定")])],1)]),i("el-pagination",{staticStyle:{"text-align":"center"},attrs:{background:"","current-page":t.current,"page-sizes":[5,10,20],"page-size":t.limit,layout:"total,prev,pager,next,sizes,jumper",total:t.total},on:{"size-change":t.handleSizeChange,"current-change":t.handleCurrentChange}})],1)},o=[],n=(i("4de4"),i("d81d"),{created:function(){this.fetchPageData(1,10)},mounted:function(){this.queryAllStationName()},data:function(){return{delVisible:!1,msg:"",delarr:[],multipleSelection:[],total:0,current:1,limit:10,pages:"0",stationNameList:"",stationCondition:{stationName:"",status:""},tableData:[{id:"",stationNo:"",stationName:"",status:""}],insertForm:{stationNo:"",stationName:""},editForm:{stationNo:"",equipmentNo:"",status:""},editFormVisible:!1,insertFormVisible:!1}},methods:{onSubmit:function(){this.fetchPageData(1,10)},handleSelect:function(t){console.log(t)},querySearch1:function(t,e){var i=this.stationNameList,a=t?i.filter(this.createFilter1(t)):i;e(a)},createFilter1:function(t){return function(e){return 0===e.value.toLowerCase().indexOf(t.toLowerCase())}},queryAllStationName:function(){var t=[],e=this;this.$axios.get("http://localhost:8181/mesStation/queryAllStationName").then((function(i){t=i.data.map((function(t){return{value:t}})),console.log(t),e.stationNameList=t}))},stateFormat:function(t,e){return"1"==t.status?"运行中":"0"==t.status?"等待中":"故障"},deleteRow:function(){var t=this;this.$axios.delete("http://localhost:8181/mesStation/deleteBySelectIds/"+this.delarr).then((function(e){console.log(e.data),"删除成功"==e.data?t.reload():alert("删除失败")})),this.delarr=[],this.delVisible=!1},handleDelete:function(t,e){this.idx=t,this.msg=e,this.delarr.push(this.msg.id),this.delVisible=!0,console.log(this.delarr)},deleteAll:function(){this.delVisible=!0;for(var t=this.multipleSelection.length,e=0;e<t;e++)this.delarr.push(this.multipleSelection[e].id);console.log(this.delarr)},handleInsert:function(){this.insertFormVisible=!0},handleEdit:function(t,e){this.editFormVisible=!0,this.editForm=Object.assign({},e),this.editForm.index=t},handleCancel:function(t){this.editFormVisible=!1},Insert:function(t){var e=this;this.$axios.post("http://localhost:8181/mesStation/addStation",this.insertForm).then((function(t){console.log(t.data),"添加成功"==t.data?e.reload():alert(t.data)})),this.editFormVisible=!1},handleUpdate:function(t){var e=this;this.$axios.put("http://localhost:8181/mesStation/updateStation",this.editForm).then((function(t){console.log(t.data),"修改成功"==t.data?e.reload():alert("修改失败")})),this.editFormVisible=!1},typeIndex:function(t){var e=this;return(e.current-1)*e.limit+t+1},fetchPageData:function(t,e){var i=this;this.$axios.post("http://localhost:8181/mesStation/queryByList/"+t+"/"+e,this.stationCondition).then((function(t){console.log(t.data.data),i.tableData=t.data.data,i.total=t.data.total,i.pages=t.data.pages}))},handleSizeChange:function(t){var e=this;e.limit=t,e.fetchPageData(e.current,e.limit)},handleCurrentChange:function(t){var e=this;e.current=t,e.fetchPageData(e.current,e.limit)},handleSelectionChange:function(t){this.multipleSelection=t}},inject:["reload"]}),l=n,s=(i("097e"),i("2877")),r=Object(s["a"])(l,a,o,!1,null,"32b697fb",null);e["default"]=r.exports},7688:function(t,e,i){}}]);