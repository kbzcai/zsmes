(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-10df1f6a"],{6569:function(t,e,a){},"69dd":function(t,e,a){"use strict";a.r(e);var s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"app-container",staticStyle:{background:"#2d3a4b"}},[a("el-row",{staticClass:"row-margin",attrs:{gutter:12}},[a("el-col",{attrs:{span:6}},[a("el-card",{staticClass:"custom-header",attrs:{shadow:"never"}},[a("div",{attrs:{slot:"header"},slot:"header"},[a("span",[t._v("生产数据")])]),a("div",{style:{height:"400px"},attrs:{id:"chart1"}}),t._t("content"),a("div",{style:{height:"400px",marginTop:"20px"},attrs:{id:"chart2"}})],2)],1),a("el-col",{attrs:{span:12}},[a("el-card",{staticClass:"custom-header",attrs:{shadow:"never"}},[a("div",{attrs:{slot:"header"},slot:"header"},[a("span",[t._v(t._s(t.title))])]),t._t("content")],2)],1),a("el-col",{attrs:{span:6}},[a("el-card",{staticClass:"custom-header",attrs:{shadow:"never"}},[a("div",{attrs:{slot:"header"},slot:"header"},[a("span",[t._v("设备状态")])]),t._t("content")],2)],1)],1)],1)},n=[],r=a("313e"),i={data:function(){return{}},methods:{initCharts:function(){this.chart1=r.init(document.getElementById("chart1"),"dark"),this.chart2=r.init(document.getElementById("chart2"),"dark"),this.setOptions()},setOptions:function(){this.chart1.setOption({title:{text:"某站点用户访问来源",subtext:"纯属虚构",left:"center"},tooltip:{trigger:"item"},legend:{orient:"vertical",left:"left"},series:[{name:"访问来源",type:"pie",radius:"50%",data:[{value:1048,name:"搜索引擎"},{value:735,name:"直接访问"},{value:580,name:"邮件营销"},{value:484,name:"联盟广告"},{value:300,name:"视频广告"}],emphasis:{itemStyle:{shadowBlur:10,shadowOffsetX:0,shadowColor:"rgba(0, 0, 0, 0.5)"}}}]}),this.chart2.setOption({title:{text:"某站点用户访问来源",subtext:"纯属虚构",left:"center"},tooltip:{trigger:"item"},legend:{orient:"vertical",left:"left"},series:[{name:"访问来源",type:"pie",radius:"50%",data:[{value:1048,name:"搜索引擎"},{value:735,name:"直接访问"},{value:580,name:"邮件营销"},{value:484,name:"联盟广告"},{value:300,name:"视频广告"}],emphasis:{itemStyle:{shadowBlur:10,shadowOffsetX:0,shadowColor:"rgba(0, 0, 0, 0.5)"}}}]})}},mounted:function(){this.initCharts()}},l=i,o=(a("dd85"),a("2877")),d=Object(o["a"])(l,s,n,!1,null,null,null);e["default"]=d.exports},dd85:function(t,e,a){"use strict";a("6569")}}]);