/******************************************************
 *
 * City component
 * Requires jQuery
 * Author  : 13082338, SUNING
 * Time    : 2013
 * Modified: 2014-02-08
 *
 ******************************************************/
/**
 * 业务js压缩
 */
var ECity=ECity||{};ECity.setting={};ECity.setting.data={cookie:{cookieKey:"SN_CITY",cookieVale:"",hostName:"",cityOuterSepatator:"|",cityInnerSeparator:"_",cookiePath:"",cookieTime:"",cookieDomain:"",oldCookieCityKey:"cityId",oldCookieDistrictKey:"districtId",oldCookieCityValue:"",oldCookieDistrictValue:"",hostDomain:"",protocol:"",port:"",root:"",protocolSepatator:"//",portSepatator:":",root:"/ip-web"},url:{cookieUrl:"",cityArrayUrl:"",districtArrayUrl:"",districtUrl:"",lesUrl:""},flag:{user:"1",sys:"2",sys_user:"3"},type:{pc:"pc",pcd:"pcd"},city:{cityArray:[],cityType:"",cityInfo:{}},init:function(uicityType){var data=ECity.setting.data;var cookie=data.cookie;var url=data.url;var city=data.city;var type=data.type;cookie.hostName=document.location.hostname;cookie.hostDomain=document.location.hostname;cookie.protocol=document.location.protocol;cookie.port=document.location.port;var currentDate=new Date();currentDate.setFullYear(currentDate.getFullYear()+1);cookie.cookieTime="; expires = "+currentDate.toUTCString();cookie.cookiePath="; path = /";if(cookie.hostName.indexOf(".suning.com")!=-1){cookie.cookieDomain="; domain =.suning.com";cookie.hostName=cookie.protocol+"//ipservice.suning.com"}else{if(cookie.hostName.indexOf(".cnsuning.com")!=-1){cookie.cookieDomain="; domain =.cnsuning.com";if(cookie.hostName.indexOf("pre")!=-1){cookie.hostName=cookie.protocol+"//ipservicepre.cnsuning.com"}else{cookie.hostName=cookie.protocol+"//ipservicesit.cnsuning.com"}}else{cookie.cookieDomain+=cookie.hostName;cookie.hostName="http://localhost:8080/ip-web"}}url.cookieUrl=cookie.hostName+"/ipQuery.do?";url.provinceArrayUrl=cookie.hostName+"/provinceList-";url.cityArrayUrl=cookie.hostName+"/cityList-";url.districtArrayUrl=cookie.hostName+"/districtList-";url.districtUrl=cookie.hostName+"/districtDetail-";url.lesUrl=cookie.hostName+"/cityAndDistrict-";url.provinceAndCityUrl=cookie.hostName+"/provinceAndCity-";city.cityType=uicityType?type.pc:type.pcd}};ECity.setting.util={equalsByPCD:function(obj_1,obj_2){if(!obj_1||!obj_2){return false}if(obj_1.provinceMDMId==obj_2.provinceMDMId&&obj_1.cityMDMId==obj_2.cityMDMId&&obj_1.districtCommerceId==obj_2.districtCommerceId){return true}return false},equalsByPC:function(obj_1,obj_2){if(!obj_1||!obj_2){return false}if(obj_1.provinceMDMId==obj_2.provinceMDMId&&obj_1.cityMDMId==obj_2.cityMDMId){return true}return false},isEmpty:function(obj){if(!obj){return true}for(var name in obj){if(typeof obj[name]!="undefined"){return false}}return true},equalsByCD:function(cityId,districtId,cityArray){if(!cityId){return null}if(!districtId){return null}if(!cityArray||cityArray.length==0){return null}for(var city in cityArray){if(cityId===cityArray[city].cityCommerceId&&districtId===cityArray[city].districtCommerceId){return cityArray[city]}}return null},equalsByC:function(cityId,cityArray){if(!cityId){return null}if(!cityArray||cityArray.length==0){return null}for(var city in cityArray){if(cityId===cityArray[city].cityCommerceId){return cityArray[city]}}return null},convertToOut:function(cityInfo){if(!cityInfo||this.isEmpty(cityInfo)){return null}var cityInfoTemp={};cityInfoTemp.province={};cityInfoTemp.city={};cityInfoTemp.district={};cityInfoTemp.province.id=cityInfo.provinceMDMId;cityInfoTemp.province.cid=cityInfo.provinceCommerceId;cityInfoTemp.province.name=cityInfo.provinceName;cityInfoTemp.city.id=cityInfo.cityMDMId;cityInfoTemp.city.cid=cityInfo.cityCommerceId;cityInfoTemp.city.lesId=cityInfo.cityLESId;cityInfoTemp.city.name=cityInfo.cityName;cityInfoTemp.district.id=cityInfo.districtMDMId;cityInfoTemp.district.cid=cityInfo.districtCommerceId;cityInfoTemp.district.lesId=cityInfo.districtLESId;cityInfoTemp.district.name=cityInfo.districtName;return cityInfoTemp},convertToIn:function(cityInfoTemp){if(!cityInfoTemp||this.isEmpty(cityInfoTemp)){return null}var cityInfo={};if(cityInfoTemp.province&&!this.isEmpty(cityInfoTemp.province)){cityInfo.provinceMDMId=cityInfoTemp.province.id;cityInfo.provinceCommerceId=cityInfoTemp.province.cid;cityInfo.provinceName=cityInfoTemp.province.name}if(cityInfoTemp.city&&!this.isEmpty(cityInfoTemp.city)){cityInfo.cityMDMId=cityInfoTemp.city.id;cityInfo.cityCommerceId=cityInfoTemp.city.cid;cityInfo.cityLESId=cityInfoTemp.city.lesId;cityInfo.cityName=cityInfoTemp.city.name}if(cityInfoTemp.district&&!this.isEmpty(cityInfoTemp.district)){cityInfo.districtMDMId=cityInfoTemp.district.id;cityInfo.districtLESId=cityInfoTemp.district.lesId;cityInfo.districtCommerceId=cityInfoTemp.district.cid;cityInfo.districtName=cityInfoTemp.district.name}return cityInfo}};ECity.IPCookie=(function(){var data=ECity.setting.data;var util=ECity.setting.util;var cookie=data.cookie;var flag=data.flag;var type=data.type;var city=data.city;var url=data.url;var cityOnLoadEventQueue=[];function addCityOnLoad(func){cityOnLoadEventQueue=cityOnLoadEventQueue.concat(func)}var provinceOnLoadEventQueue=[];function addProvinceOnLoad(func){provinceOnLoadEventQueue=provinceOnLoadEventQueue.concat(func)}var cityListOnLoadEventQueue=[];function addCityListOnLoad(func){cityListOnLoadEventQueue=cityListOnLoadEventQueue.concat(func)}var districtListOnLoadEventQueue=[];function addDistrictListOnLoad(func){districtListOnLoadEventQueue=districtListOnLoadEventQueue.concat(func)}var showCity=function(callback){findCookie();if(cookie.cookieValue){analyzeCookie()}checkLesId();var cityObject={};if(cookie.oldCookieCityValue){if(cookie.oldCookieDistrictValue){cityObject=util.equalsByCD(cookie.oldCookieCityValue,cookie.oldCookieDistrictValue,city.cityArray);if(cityObject){city.cityInfo=cityObject;if(!util.equalsByPCD(cityObject,city.cityArray[0])){changeCookie();addCookie()}if(typeof callback=="function"){callback(util.convertToOut(city.cityInfo))}}else{getCookie(callback)}}else{cityObject=util.equalsByC(cookie.oldCookieCityValue,city.cityArray);if(cityObject){city.cityInfo=cityObject;addOldCookie();if(!util.equalsByPCD(cityObject,city.cityArray[0])){changeCookie();addCookie()}if(typeof callback=="function"){callback(util.convertToOut(city.cityInfo))}}else{getCookie(callback)}}}else{if(city.cityArray&&city.cityArray.length!=0){city.cityInfo=city.cityArray[0];addOldCookie();if(typeof callback=="function"){callback(util.convertToOut(city.cityInfo))}}else{getCookie(callback)}}};var changeCity=function(cityInfoTemp,callback){if(cityInfoTemp&&!util.isEmpty(cityInfoTemp)){city.cityInfo=util.convertToIn(cityInfoTemp)}changeCookie();addOldCookie();addCookie();if(typeof callback=="function"){callback(util.convertToOut(city.cityInfo))}};var findCookie=function(){var cookieStr=document.cookie;if(!cookieStr){return}var oldCookieCity=cookieStr.match(RegExp("(^| )"+cookie.oldCookieCityKey+"=([^;]*)(;|$)"));var oldCookieDistrict=cookieStr.match(RegExp("(^| )"+cookie.oldCookieDistrictKey+"=([^;]*)(;|$)"));var cookies=cookieStr.match(RegExp("(^| )"+cookie.cookieKey+"=([^;]*)(;|$)"));if(oldCookieCity&&oldCookieCity[2]&&oldCookieCity[2].length!=0){cookie.oldCookieCityValue=decodeURIComponent(oldCookieCity[2])}if(oldCookieDistrict&&oldCookieDistrict[2]&&oldCookieDistrict[2].length!=0){cookie.oldCookieDistrictValue=decodeURIComponent(oldCookieDistrict[2])}if(cookies&&cookies[2]&&cookies[2].length!=0){cookie.cookieValue=decodeURIComponent(cookies[2])}};var getCookie=function(callback){addCityOnLoad(callback);if(cityOnLoadEventQueue.length==1){getCityInfor(callback)}};var getCityInfor=function(callback){var cookieUrl=url.cookieUrl;if(cookie.oldCookieCityValue){cookieUrl+=cookie.oldCookieCityKey+"="+cookie.oldCookieCityValue;if(cookie.oldCookieDistrictValue){cookieUrl+="&"+cookie.oldCookieDistrictKey+"="+cookie.oldCookieDistrictValue}}$.ajax({type:"GET",url:cookieUrl,cache:true,async:false,dataType:"jsonp",jsonpCallback:"cookieCallback",success:function(cookieJson){var cityArrayTemp=[];if(cookie.oldCookieCityValue){if(cookie.oldCookieDistrictValue){cookieJson.flag=flag.user;cookieJson.count=1}else{cookieJson.flag=flag.sys_user;cookieJson.count=0}}else{cookieJson.flag=flag.sys;cookieJson.count=0}city.cityInfo=cookieJson;if(city.cityArray&&city.cityArray.length!=0){changeCookie()}else{cityArrayTemp.push(cookieJson);city.cityArray=cityArrayTemp}addCookie();if(cookie.oldCookieCityValue&&cookie.oldCookieDistrictValue&&cookie.oldCookieDistrictValue!=cookieJson.districtCommerceId){addOldCookie()}if(!cookie.oldCookieCityValue||!cookie.oldCookieDistrictValue){addOldCookie()}if(typeof callback=="function"){for(var aFunc in cityOnLoadEventQueue){cityOnLoadEventQueue[aFunc](util.convertToOut(city.cityInfo))}cityOnLoadEventQueue=[]}}})};var analyzeCookie=function(){var cookieValue=cookie.cookieValue;if(!cookieValue){return}var cityArrayTemp=cookieValue.split(cookie.cityOuterSepatator);var cityArray=[];var length=cityArrayTemp.length;for(var i=0;i<length;i++){var data=cityArrayTemp[i].split(cookie.cityInnerSeparator);var cityTemp={};cityTemp.provinceMDMId=data[0];cityTemp.provinceLESId=data[0];cityTemp.provinceCommerceId="";cityTemp.provinceName=scriptData.provinces[data[0]];cityTemp.cityLESId=data[1];cityTemp.cityMDMId=data[2];cityTemp.cityCommerceId=data[3];cityTemp.cityName=scriptData.cities[data[2]];cityTemp.districtLESId=data[4];cityTemp.districtMDMId="";cityTemp.districtCommerceId=data[5];cityTemp.districtName=scriptData.districts[data[5]];cityTemp.flag=data[6];cityTemp.count=data[7];cityArray.push(cityTemp)}city.cityArray=cityArray};var checkLesId=function(){var cityArray=city.cityArray;if(!cityArray||cityArray.length==0){return}var length=cityArray.length;for(var i=0;i<length;i++){var data=cityArray[i];if(data.provinceMDMId==data.cityLESId){if(cookie.cookieValue){var date=new Date();date.setTime(date.getTime()-10000);cookieTemp=cookie.cookieKey+"="+encodeURIComponent("");cookieTemp+="; expires = "+date.toGMTString();cookieTemp+=cookie.cookiePath;cookieTemp+=cookie.cookieDomain;document.cookie=cookieTemp;cookieCity=cookie.oldCookieCityKey+"="+encodeURIComponent("");cookieCity+="; expires = "+date.toGMTString();cookieCity+=cookie.cookiePath;cookieCity+=cookie.cookieDomain;document.cookie=cookieCity;cookie.oldCookieCityValue="";cookieDistrict=cookie.oldCookieDistrictKey+"="+encodeURIComponent("");cookieDistrict+="; expires = "+date.toGMTString();cookieDistrict+=cookie.cookiePath;cookieDistrict+=cookie.cookieDomain;document.cookie=cookieDistrict;cookie.oldCookieDistrictValue="";city.cityArray=null;break}}}};var addOldCookie=function(){var cityArray=city.cityArray;if(!cityArray||cityArray.length==0){return}cookie.oldCookieCityValue=cityArray[0].cityCommerceId;cookie.oldCookieDistrictValue=cityArray[0].districtCommerceId;var cookieCity="";var cookieDistrict="";cookieCity=cookie.oldCookieCityKey+"="+encodeURIComponent(cookie.oldCookieCityValue);cookieCity+=cookie.cookieTime;cookieCity+=cookie.cookiePath;cookieCity+=cookie.cookieDomain;document.cookie=cookieCity;cookieDistrict=cookie.oldCookieDistrictKey+"="+encodeURIComponent(cookie.oldCookieDistrictValue);cookieDistrict+=cookie.cookieTime;cookieDistrict+=cookie.cookiePath;cookieDistrict+=cookie.cookieDomain;document.cookie=cookieDistrict};var addCookie=function(){var cityArray=city.cityArray;var cookieTemp="";var cookieValueTemp="";if(!cityArray||cityArray.length==0){return}var length=cityArray.length;for(var i=0;i!=length;i++){cookieValueTemp+=cityArray[i].provinceMDMId;cookieValueTemp+=cookie.cityInnerSeparator;cookieValueTemp+=cityArray[i].cityLESId;cookieValueTemp+=cookie.cityInnerSeparator;cookieValueTemp+=cityArray[i].cityMDMId;cookieValueTemp+=cookie.cityInnerSeparator;cookieValueTemp+=cityArray[i].cityCommerceId;cookieValueTemp+=cookie.cityInnerSeparator;cookieValueTemp+=cityArray[i].districtLESId;cookieValueTemp+=cookie.cityInnerSeparator;cookieValueTemp+=cityArray[i].districtCommerceId;cookieValueTemp+=cookie.cityInnerSeparator;cookieValueTemp+=cityArray[i].flag;cookieValueTemp+=cookie.cityInnerSeparator;cookieValueTemp+=cityArray[i].count;if(i==length-1){break}cookieValueTemp+=cookie.cityOuterSepatator}cookie.cookieValue=cookieValueTemp;cookieTemp=cookie.cookieKey+"="+encodeURIComponent(cookie.cookieValue);cookieTemp+=cookie.cookieTime;cookieTemp+=cookie.cookiePath;cookieTemp+=cookie.cookieDomain;document.cookie=cookieTemp};var changeCookie=function(){var cityArray=city.cityArray;var cityType=city.cityType;var cityInfo=city.cityInfo;if(util.isEmpty(cityInfo)||!cityArray||util.isEmpty(cityArray[0])){return}var cityArrayTemp=[];var city_1=cityArray[0];var city_2=cityArray[1];var city_3=cityArray[2];if(cityType==type.pc){if(city_1.flag==flag.sys){cityInfo.flag=flag.sys_user;cityInfo.count=0;cityArrayTemp.push(cityInfo);city.cityArray=cityArrayTemp;return}if(city_1.flag==flag.sys_user){if(util.equalsByPC(cityInfo,city_1)){return}else{if(util.equalsByPC(cityInfo,city_2)){cityArrayTemp.push(city_2);if(!util.isEmpty(city_3)){cityArrayTemp.push(city_3)}city.cityArray=cityArrayTemp;return}else{if(util.equalsByPC(cityInfo,city_3)){cityArrayTemp.push(city_3);cityArrayTemp.push(city_2);city.cityArray=cityArrayTemp;return}else{cityInfo.flag=flag.sys_user;cityInfo.count=0;cityArrayTemp.push(cityInfo);if(!util.isEmpty(city_2)){cityArrayTemp.push(city_2);if(!util.isEmpty(city_3)){cityArrayTemp.push(city_3)}}city.cityArray=cityArrayTemp;return}}}}if(city_1.flag==flag.user){if(util.equalsByPC(cityInfo,city_1)){return}else{if(util.equalsByPC(cityInfo,city_2)){cityArrayTemp.push(city_2);cityArrayTemp.push(city_1);if(!util.isEmpty(city_3)){cityArrayTemp.push(city_3)}city.cityArray=cityArrayTemp;return}else{if(util.equalsByPC(cityInfo,city_3)){cityArrayTemp.push(city_3);cityArrayTemp.push(city_1);cityArrayTemp.push(city_2);city.cityArray=cityArrayTemp;return}else{cityInfo.flag=flag.sys_user;cityInfo.count=0;cityArrayTemp.push(cityInfo);cityArrayTemp.push(city_1);if(!util.isEmpty(city_2)){cityArrayTemp.push(city_2)}city.cityArray=cityArrayTemp;return}}}}}else{if(city_1.flag==flag.sys){cityInfo.flag=flag.user;cityInfo.count=1;cityArrayTemp.push(cityInfo);city.cityArray=cityArrayTemp;return}if(city_1.flag==flag.sys_user){if(util.equalsByPCD(cityInfo,city_1)){city_1.count++;city_1.flag=flag.user;return}else{if(util.equalsByPCD(cityInfo,city_2)){city_2.count++;cityArrayTemp.push(city_2);if(!util.isEmpty(city_3)){cityArrayTemp.push(city_3)}city.cityArray=cityArrayTemp;return}else{if(util.equalsByPCD(cityInfo,city_3)){city_3.count++;cityArrayTemp.push(city_3);cityArrayTemp.push(city_2);city.cityArray=cityArrayTemp;return}else{cityInfo.flag=flag.user;cityInfo.count=1;cityArrayTemp.push(cityInfo);if(!util.isEmpty(city_2)){cityArrayTemp.push(city_2);if(!util.isEmpty(city_3)){cityArrayTemp.push(city_3)}}city.cityArray=cityArrayTemp;return}}}}if(city_1.flag==flag.user){if(util.equalsByPCD(cityInfo,city_1)){city_1.count++;return}else{if(util.equalsByPCD(cityInfo,city_2)){city_2.count++;cityArrayTemp.push(city_2);cityArrayTemp.push(city_1);if(!util.isEmpty(city_3)){cityArrayTemp.push(city_3)}city.cityArray=cityArrayTemp;return}else{if(util.equalsByPCD(cityInfo,city_3)){city_3.count++;cityArrayTemp.push(city_3);cityArrayTemp.push(city_1);cityArrayTemp.push(city_2);city.cityArray=cityArrayTemp;return}else{cityInfo.flag=flag.user;cityInfo.count=1;cityArrayTemp.push(cityInfo);cityArrayTemp.push(city_1);if(!util.isEmpty(city_2)){cityArrayTemp.push(city_2)}city.cityArray=cityArrayTemp;return}}}}}};var getRemoteCityArray=function(mdmId,callback){addCityListOnLoad(callback);if(cityListOnLoadEventQueue.length==1){getCityListInfo(mdmId,callback)}};var getCityListInfo=function(mdmId,callback){var cityUrl=url.cityArrayUrl+mdmId+"_20150401-cityListCallback.htm";$.ajax({type:"GET",url:cityUrl,cache:true,async:true,dataType:"jsonp",jsonp:false,jsonpCallback:"cityListCallback",success:function(cityArrayJson){var cityArrayTemp=[];cityArrayTemp=cityArrayJson.cities;var cityArray=[];var length=cityArrayTemp.length;for(var i=0;i!=length;i++){var cityObject={};cityObject.name=cityArrayTemp[i].name;cityObject.id=cityArrayTemp[i].mdmId;cityObject.cid=cityArrayTemp[i].commerceId;cityObject.lesId=cityArrayTemp[i].lesId;cityObject.pinyin=cityArrayTemp[i].pinyin.charAt(0);cityObject.defaultId=cityArrayTemp[i].defaultDistrictMdmId;cityArray.push(cityObject)}if(typeof callback=="function"){for(var aFunc in cityListOnLoadEventQueue){cityListOnLoadEventQueue[aFunc](cityArray)}cityListOnLoadEventQueue=[]}}})};var getRemoteDistrictArray=function(mdmId,callback){addDistrictListOnLoad(callback);if(districtListOnLoadEventQueue.length==1){getDistrictListInfor(mdmId,callback)}};var getDistrictListInfor=function(mdmId,callback){var districtUrl=url.districtArrayUrl+mdmId+"_20150401-districtListCallback.htm";$.ajax({type:"GET",url:districtUrl,cache:true,async:true,dataType:"jsonp",jsonp:false,jsonpCallback:"districtListCallback",success:function(districtArrayJson){var cityArrayTemp=[];cityArrayTemp=districtArrayJson.districts;var cityArray=[];var length=cityArrayTemp.length;for(var i=0;i!=length;i++){var cityObject={};cityObject.name=cityArrayTemp[i].name;cityObject.id=cityArrayTemp[i].mdmId;cityObject.cid=cityArrayTemp[i].commerceId;cityObject.lesId=cityArrayTemp[i].lesId;cityObject.pinyin=cityArrayTemp[i].pinyin.charAt(0);cityArray.push(cityObject)}if(typeof callback=="function"){for(var aFunc in districtListOnLoadEventQueue){districtListOnLoadEventQueue[aFunc](cityArray)}districtListOnLoadEventQueue=[]}}})};var getRemoteProvinceArray=function(callback){addProvinceOnLoad(callback);if(provinceOnLoadEventQueue.length==1){getProvinceListInfor(callback)}};var getProvinceListInfor=function(callback){var provinceUrl=url.provinceArrayUrl+"provinceListCallback.htm";$.ajax({type:"GET",url:provinceUrl,cache:true,async:true,dataType:"jsonp",jsonp:false,jsonpCallback:"provinceListCallback",success:function(provinceArrayJson){var cityArrayTemp=[];cityArrayTemp=provinceArrayJson.provinces;var cityArray=[];var length=cityArrayTemp.length;for(var i=0;i!=length;i++){var cityObject={};cityObject.name=cityArrayTemp[i].name;cityObject.id=cityArrayTemp[i].mdmId;cityObject.cid=cityArrayTemp[i].commerceId;cityObject.pinyin=cityArrayTemp[i].pinyin.charAt(0);cityObject.defaultId=cityArrayTemp[i].defaultCityMdmId;cityArray.push(cityObject)}if(typeof callback=="function"){for(var aFunc in provinceOnLoadEventQueue){provinceOnLoadEventQueue[aFunc](cityArray)}provinceOnLoadEventQueue=[]}}})};var getRemoteDistrict=function(mdmId,callback){var districtUrl=url.districtUrl+mdmId+"_20150401-districtCallback.htm";$.ajax({type:"GET",url:districtUrl,cache:true,async:true,dataType:"jsonp",jsonp:false,jsonpCallback:"districtCallback",success:function(districtJson){var districtObject={};if(typeof callback=="function"){districtObject.id=districtJson.mdmId;districtObject.cid=districtJson.commerceId;districtObject.lesId=districtJson.lesId;districtObject.name=districtJson.name;callback(districtObject)}}})};var getProvinceAndCityByCityId=function(cityId,callback){var getProvinceAndCityUrl=url.provinceAndCityUrl+cityId+"-provinceandcityCallBack.htm";$.ajax({type:"GET",url:getProvinceAndCityUrl,cache:true,async:true,dataType:"jsonp",jsonp:false,jsonpCallback:"provinceandcityCallBack",success:function(provinceandcityJson){var provinceAndCityJsonObject={};var provinceAndCityObject={};if(typeof callback=="function"){provinceAndCityObject.pMdmId=provinceandcityJson.pMdmId;provinceAndCityObject.pName=provinceandcityJson.pName;provinceAndCityObject.cMdmId=provinceandcityJson.cMdmId;provinceAndCityObject.cCommerceId=provinceandcityJson.cCommerceId;provinceAndCityObject.cName=provinceandcityJson.cName;provinceAndCityJsonObject.provinceAndCity=provinceAndCityObject;callback(provinceAndCityJsonObject)}}})};return{showCity:showCity,setCity:changeCity,getRemoteDistrict:getRemoteDistrict,getRemoteDistrictArray:getRemoteDistrictArray,getRemoteCityArray:getRemoteCityArray,getRemoteProvinceArray:getRemoteProvinceArray,getProvinceAndCityByCityId:getProvinceAndCityByCityId}}());ECity.API={init:function(type){ECity.setting.data.init(type)},ipCookie:ECity.IPCookie,util:ECity.setting.util,getCity:function(callback){this.ipCookie.showCity(callback)},setCity:function(cityInfo,callback){this.ipCookie.setCity(cityInfo,callback)},getDataCity:function(){var cityArray=ECity.setting.data.city.cityArray;var cityObject={};if(cityArray&&!this.util.isEmpty(cityArray[0])){cityObject=this.util.convertToOut(cityArray[0])}return cityObject},getLastUsedCities:function(){var cityArray=ECity.setting.data.city.cityArray;var cityInfoList=[];if(cityArray){for(var index in cityArray){cityInfoList.push(this.util.convertToOut(cityArray[index]))}}return cityInfoList},getCityId:function(){var cityArray=ECity.setting.data.city.cityArray;if(cityArray&&!this.util.isEmpty(cityArray[0])){return cityArray[0].cityCommerceId}return""},getDistrictId:function(){var cityArray=ECity.setting.data.city.cityArray;if(cityArray&&!this.util.isEmpty(cityArray[0])){return cityArray[0].districtCommerceId}return""},getDistrict:function(districtId,callback){this.ipCookie.getRemoteDistrict(districtId,callback)},getDistrictList:function(cityId,callback){this.ipCookie.getRemoteDistrictArray(cityId,callback)},getCityList:function(provinceId,callback){this.ipCookie.getRemoteCityArray(provinceId,callback)},getProvinceList:function(callback){this.ipCookie.getRemoteProvinceArray(callback)},getProvinceAndCityByCityId:function(cityId,callback){this.ipCookie.getProvinceAndCityByCityId(cityId,callback)}};

(function($) {

    'use strict';
    if (!jQuery) {
        throw new Error("The plugin requires jQuery")
    }
    var Methods = function() {
        if (this instanceof Methods == false) {
            return new Methods();
        }
    }
    Methods.prototype = {
        // 初始化
        init: function(elements, options) {
            this.eles = elements;
            this.opts = options;
            this.flag = true;
            this.render();
        },
        render: function() {
            var that = this
            this.setTemps(function(o){
                that.getCity(o)
            })
        },
        // 设置模版方法
        setTemps: function(fn) {
            var that = this;
            var eles = this.eles;
            var opts = this.opts;
            // 设置模版,并绑定data到dom上。
            // $city,包裹整个结构
            var style = '<style id="ui-city-style">' +
                'ul,li,p,h3,h5,em,b,i,span,a{ margin: 0; padding: 0; }' +
                'ul,li { list-style: none; }' +
                '.clearfix:after{ content:"."; display:block; height:0; clear:both; visibility:hidden}' +
                '.clearfix{ zoom:1}' +
                '.ui-city a,' +
                '.ui-city a:visited{ line-height:14px; color:#333; text-decoration: none; outline: none; cursor: pointer;}' +
                '.ui-city a:hover { text-decoration:none; }' +
                '.ui-city { display:inline-block;*dispplay:inline;*zoom:1; font-size: 12px; position: relative; z-index: 0}' +
                '.ui-city .dn { display: none; }' +
                '.ui-city .db { display: block; }' +
                '.ui-city .dib { display: inline-block; }' +
                '.ui-city .arr { display: inline-block; width: 0; height:0; border-color: #bbb transparent transparent; border-width: 5px; border-style: solid dashed dashed; font-size: 0; line-height: 0; overflow: hidden; }' +
                '.ui-city a.ui-city-toggle:hover { color:#333;}' +
                '.ui-city-toggle { display:inline-block; border: 1px solid #bbb; padding:6px 5px 6px 6px; color: #000;background: #fff; position: relative; z-index: 100}' +
                '.ui-city-toggle .address-placement {font-style: normal; float: left;}' +
                '.ui-city-toggle span { padding-right: 5px}' +
                '.ui-city-toggle span:hover {color: #333;}' +
                '.ui-city-toggle .arr { margin-right:5px;position: relative; top:5px; float: left;}' +
                '.ui-city-group { display:none; position: absolute;background: #fff; left: 0; top:27px;border: 1px solid #ccc; margin-top:-1px; width: 420px; z-index: 99; box-shadow: 0 0 6px #ddd;padding-top:5px;}' +
                '.ui-city-group .ui-city-close  { position: absolute;right: 0;top: 0;padding: 5px 10px;overflow: hidden;}' +
                '.ui-city-group .ui-city-close i { font: 700 14px/1.5 simsun;margin-left:-4px; color: #aaa}' +
                '.ui-city-group-header { padding-top: 10px;  }' +
                '.ui-city-group-header p { padding-left:15px; margin-bottom: 10px; }' +
                '.ui-city-group-header .address-title { }' +
                '.ui-city-group-header .address-item {clear:both; }' +
                '.ui-city-group-header .address-item a,' +
                '.ui-city-group-header .address-item a:visited{ display: inline-block;zoom:1; padding-top: 4px; padding-left: 5px; padding-bottom: 4px; margin-right: 10px; border: 1px solid #bbb; }' +
                '.ui-city-group-header .address-item a:hover {  background: #f90; color: #fff;border:1px solid #f90; }' +
                '.ui-city-group-header .address-item a span { padding-right:5px}' +
                '.ui-city-group-content { margin: 10px 10px 0 10px; background:#fff;}' +
                '.ui-city-group-content .nav-tabs { padding-left: 6px  }' +
                '.ui-city-group-content .nav-tabs li {float: left; position: relative; z-index:2;border: 1px solid #ccc; height: 26px;background:#fff;margin-right: 6px; margin-bottom:0; cursor: pointer; }' +
                '.ui-city-group-content .nav-tabs li p { padding: 6px 10px 6px 10px;border:1px solid #fff; }' +
                '.ui-city-group-content .nav-tabs li a,' +
                '.ui-city-group-content .nav-tabs li a:visited{ color: #999;float: left}' +
                '.ui-city-group-content .nav-tabs li .arr { position: relative; top: 3px;left: 5px;font-size: 0; line-height: 0;}' +
                '.ui-city-group-content .nav-tabs li.current { border: 2px solid #ffb84e; border-bottom:none; z-index: 4;}' +
                '.ui-city-group-content .nav-tabs li.current p { padding: 6px 10px 5px 10px; position: relative; z-index: 4; border:none; }' +
                '.ui-city-group-content .nav-tabs li.current .arr { border-color:  transparent transparent #f90; border-style:  dashed dashed solid; top:-2px; }' +
                '.ui-city-group-content .nav-tabs li.current a,' +
                '.ui-city-group-content .nav-tabs li.current a:visited{ display:inline-block; color: #333; }' +
                '.ui-city-group-content .nav-tabs li.active a,' +
                '.ui-city-group-content .nav-tabs li.active a:visited{ display:inline-block; color: #333; }' +
                '.ui-city-group-content .tab-content { border-top: 2px solid #ffb84e;top:-2px;  position: relative; z-index: 3}' +
                '.ui-city-group-content .tab-content .tab-panel { display: none; padding-top: 3px; padding-bottom: 15px; background: #fff;padding-left: 8px }' +
                '.ui-city-group-content .tab-content .tab-panel.active { display: block;}' +
                '.ui-city-group-content .tab-content li:after { content:"."; display:block; height:0; clear:both; visibility:hidden }' +
                '.ui-city-group-content .tab-content li { *zoom:1;}' +
                '.ui-city-group-content .tab-content li span {display:inline-block;width: 98px;}' +
                '.ui-city-group-content .tab-content li a,' +
                '.ui-city-group-content .tab-content li a:visited { display:inline-block; background:#fff;margin: 2px; padding: 5px; color:#000; }' +
                '.ui-city-group-content .tab-content li a:hover { background: #f90; color: #fff;}' +
                '.ui-city-group-content .tab-content li a.on,' +
                '.ui-city-group-content .tab-content li a.on:visited { background: #f90;color: #fff; }' +
                '.ui-city-group-content .tab-content .pr-panel li a{ }' +
                '.ui-city.active { z-index: 10}' +
                '.ui-city.active a.ui-city-toggle { border: 1px solid #ccc;background:#fff;border-bottom:none;box-shadow: 0 -1px 1px #ddd}' +
                '.ui-city.active a.ui-city-toggle:hover { color: #333; background: #fff; text-decoration: none;}' +
                '.ui-city.active a.ui-city-toggle .arr{ border-color:  transparent transparent #f90; border-style:  dashed dashed solid; top:0; }' +
                '.ui-city.active .ui-city-group { display: block; }' +
                '.ui-city .arr {transition:All .2s ease;-webkit-transition:All .2s ease;-moz-transition:All .2s ease;-o-transition:All .2s ease;-ms-transition:All .2s ease;}' +
                '</style>'
            if ($('#ui-city-style').size() == 0) {
                $('body').prepend($(style))
            };
            var $city = $('<div class="ui-city"></div>')

            // $toggle 控制整个开关
            // 阻止a链接跳转！
            $('a', that.eles).live('click', function() {
                    return false;
                })
                // 加入默认城市
            var $toggle;
            this.getInfo = {};
            this.changeFlag = !0;
            this.queryInfo = function(cb) {
                if (opts.cityId != '' && opts.cityId != undefined) {
                    opts.city = true
                    that.getInfoByCityid(opts.cityId, function(data) {
                        cb(data)
                        setTimeout(function(){fn(data)},10)
                    })
                } else {
                    that.getAddressByDefault(function(data) {
                        cb(data)
                        setTimeout(function(){fn(data)},10)
                    })
                }
            }
            this.queryInfo(function(data) {
                var province = data.province
                var city = data.city
                var district = data.district
                var pinfo = [province.id, province.cid,'', province.name].join(',')
                var cinfo = [city.id, city.cid,district.lesId, city.name].join(',')
                var dinfo = [district.id, district.cid,district.lesId, district.name].join(',')
                var id = province.id

                that.getInfo = data;
                if (/^10$|^20$|^30$|^320$/.test(id)) {
                    if (!!opts.city) {
                        $toggle = $('<a href="###" class="ui-city-toggle" hidefocus="true"><em class="address-placement"><span id="provinceName" class="pr dn"  role=' + pinfo + '>' + province.name + '</span><span id="citybName" class="ct"  role=' + cinfo + '>' + city.name + '</span></em><b class="arr"></b></a>');
                    } else {
                        $toggle = $('<a href="###" class="ui-city-toggle" hidefocus="true"><em class="address-placement"><span id="provinceName" class="pr dn"  role=' + pinfo + '>' + data.province.name + '</span><span class="ct" id="citybName" role=' + cinfo + '>' + city.name + '</span><span id="districtName" class="ds" role=' + dinfo + '>' + district.name + '</span></em><b class="arr"></b></a>');
                    }
                } else {
                    if (!!opts.city) {
                        $toggle = $('<a href="###" class="ui-city-toggle" hidefocus="true"><em class="address-placement"><span id="provinceName" class="pr"  role=' + pinfo + '>' + province.name + '</span><span id="citybName" class="ct"  role=' + cinfo + '>' + city.name + '</span></em><b class="arr"></b></a>');
                    } else {
                        $toggle = $('<a href="###" class="ui-city-toggle" hidefocus="true"><em class="address-placement"><span id="provinceName" class="pr"  role=' + pinfo + '>' + province.name + '</span><span id="citybName" class="ct"  role=' + cinfo + '>' + city.name + '</span><span id="districtName" class="ds" role=' + dinfo + '>' + district.name + '</span></em><b class="arr"></b></a>');
                    }
                }
                $city.append($toggle)
                $(eles).append($city);
                // $group 包裹隐藏的内容;
                that.openPanel(opts, data)
            })
        },
        openPanel: function(opts, data) {
            var that = this
            var $city = $(this.eles).find('.ui-city')
            $city.one('click.open', function(e) {
                var event = e || event
                if (event) event.stopPropagation()
                that.getAllDetail(opts, data)
                $(this).addClass('active');
                return false;
            })
        },
        closePanel: function() {
            var that = this
            var $city = $(this.eles).find('.ui-city')
            var $close = $(this.eles).find('.ui-city-close')
            $close.on('click.close', function(e) {
                var event = e || event
                if (event) event.stopPropagation()
                $city.removeClass('active');
                return false;
            })
            $(document).not(this).on('click.close', function() {
                if (!$city.hasClass('active')) {
                    return;
                }
                $city.removeClass('active')
                return false;
            })
        },
        // 点击开始重新选择
        getAllDetail: function(opts, data) {
            var that = this
            var eles = this.eles;
            var province = data.province
            var city = data.city
            var district = data.district
            var pinfo = [province.id, province.cid,'',province.name,province.defaultId].join(',')
            var cinfo = [city.id, city.cid,city.lesId, city.name,city.defaultId].join(',')
            var dinfo = [district.id, district.cid,district.lesId, district.name].join(',')
            var id = province.id
            var $city = $(this.eles).find('.ui-city')
            var $toggle = $city.find('.ui-city-toggle')
            var $group = $('<div class="ui-city-group"></div>')
            var $close = $('<a class="ui-city-close" href="###"><i>&gt;</i><i>&lt;</i></a>')
            $group.append($close)
                // $header 常用地址
            var $header = $('<div class="ui-city-group-header"><p class="address-title">常用地址：</p></div>')
            var $item = $('<p class="address-item"></p>')
            if (!!opts.used && !opts.city) {
                that.getUsedAddress(function(data) {
                    if (!data) {
                        return;
                    };
                    $.each(data, function(k, v) {
                            if (k == 0) {
                                return;
                            };
                            if(v != null){
                                var province = v.province
                                var city = v.city
                                var district = v.district
                                var pinfo = [province.id, province.cid,'',province.name,province.defaultId].join(',')
                                var cinfo = [city.id, city.cid,city.lesId, city.name,province.defaultId].join(',')
                                var dinfo = [district.id, district.cid, district.lesId,district.name].join(',')
                                $item.append($('<a href="###"><span class="pr dn" role=' + pinfo + '>' + province.name + '</span><span class="ct" role=' + cinfo + '>' + city.name + '</span><span class="ds"  role=' + dinfo + '>' + district.name + '</span></a>'))
                            }
                        })
                        // @修改，如果没有常用地址，不显示常用地址文案
                    $header.append($item)
                    if (!!opts.used && !opts.city && data.length > 1) {
                        $group.prepend($header);
                    };
                })

            }
            // $content 主内容选择区域。
            var $content = $('<div class="ui-city-group-content"></div>')
                // 判断是否只选得到市
            if (!opts.city) {
                var $navTabs = $('<ul class="nav-tabs clearfix"><li id="provinceShow" class="active"  role=' + pinfo + '><p><a href="###">' + province.name + '</a><b class="arr"></b></p></li><li id="citybShow" class="active"  role=' + cinfo + ',' + city.defaultId + '><p><a href="###">' + city.name + '</a><b class="arr"></b></p></li><li id="districtShow" class="active current" role=' + dinfo + ',' + district.defaultId + '><p><a href="###">' + district.name + '</a><b class="arr"></b></p></li></ul>')
            } else {
                var $navTabs = $('<ul class="nav-tabs clearfix"><li id="provinceShow" class="active" role=' + pinfo + '><p><a href="###">' + province.name + '</a><b class="arr"></b></p></li><li id="citybShow" class="active current" role=' + cinfo + ',' + city.defaultId + '><p><a href="###">' + city.name + '</a><b class="arr"></b></p></li></ul>')
            }
            var $tabContent = $('<div class="tab-content"></div>');
            var $prPanel = $('<ul class="tab-panel pr-panel"></ul><ul class="tab-panel ct-panel"><li>正在加载中...</li></ul><ul class="tab-panel ds-panel active"><li></li></ul>')
            that.setInfo = that.getInfo
                // 判断是否根据区域来排列省份
            if (!!opts.state) {
                var $li = $('<li></li>')
                $prPanel.eq(0).append($li);
                that.getProvinceList(function(allProvinces) {
                    $.each(allProvinces, function(k, v) {
                    	var pinfo = [v.id,v.cid,'',v.name,v.defaultId].join(',')
                        if (v.id == that.getInfo.province.id) {
                            $prPanel.children(':eq(0)').append('<span><a href="###" class="on" role=' + pinfo + '>' + v.name + '</a></span>')
                        } else {
                            $prPanel.children(':eq(0)').append('<span><a href="###" role=' + pinfo + '>' + v.name + '</a></span>')
                        }
                    })
                    $tabContent.append($prPanel);
                    that.getProvinces($city, $item, $toggle, $tabContent, $navTabs, $prPanel, $header, $group, function() {
                        return that.getCities($navTabs, $tabContent, $prPanel, $city, $toggle, function() {
                            return that.getDistricts($navTabs, $tabContent, $toggle, $city, function() {
                                return that.setDetailAddress($toggle, $navTabs, $tabContent, $city);
                            })
                        })
                    });
                })
            } else {}
            $content.append($navTabs);
            $content.append($tabContent);
            $group.append($content);
            $city.append($group);
            // 加入到dom里
            $(eles).append($city);
            // 主动关闭
            that.closePanel()
                // 省市区选项卡切换事件；
            $navTabs.find('li').each(function(i) {
                $(this).on('click', function(e) {
                    if ($(this).hasClass('active')) {
                        $(this).addClass('current').siblings().removeClass('current')
                        $tabContent.children(':eq(' + i + ')').addClass('active').siblings().removeClass('active')
                    };
                    return false;
                })
            })
            if (!!opts.used && !opts.city) {
                    that.setAddressByUsed($item, $toggle, $city, $prPanel, $tabContent, $navTabs, $header, $group)
            }
        },
        // 获得全部省直辖市;
        getProvinces: function($city, $item, $toggle, $tabContent, $navTabs, $prPanel, $header, $group, cb) {
            var that = this;
            var opts = this.opts;
            // 打开城市控件！
            $city.on('click', function(event) {
                if (event) event.stopPropagation();
                $(this).addClass('active');
                // 重新获得常用地址 
                if (typeof $item !== undefined) {
                    $item.html('')
                };
                that.getUsedAddress(function(data) {
                    if (!data) {
                        return;
                    };

                    $.each(data, function(k, v) {
                        if (k == 0) {
                            return;
                        };
                        var province = v.province
                        var city = v.city
                        var district = v.district
                        var pinfo = [province.id, province.cid,'',province.name,province.defaultId].join(',')
                        var cinfo = [city.id, city.cid,city.lesId,city.name,province.defaultId].join(',')
                        var dinfo = [district.id, district.cid,district.lesId, district.name].join(',')
                        $item.append($('<a href="###"><span class="pr dn" role=' + pinfo + '>' + province.name + '</span><span class="ct" role=' + cinfo + '>' + city.name + '</span><span class="ds"  role=' + dinfo + '>' + district.name + '</span></a>'))
                    })
                    $header.append($item)
                    if (!!opts.used && !opts.city && data.length > 1) {
                        $group.prepend($header);
                    };

        })
		// 点击常用地址设置地址！
                if (!!opts.used && !opts.city) {
                    that.setAddressByUsed($item, $toggle, $city, $prPanel, $tabContent, $navTabs, $header, $group)
                }
             
        // 重新渲染省市区 
        return false
    })
                
            cb()
        },

        setAddressByUsed: function($item, $toggle, $city, $prPanel, $tabContent, $navTabs, $header, $group) {
            var that = this;
            var opts = this.opts;
            $city.off('click.setDefaultAddress').on('click.setDefaultAddress', '.address-item a',function(event) {
                if (event) event.stopPropagation()
                var $clone = $(this).clone();
                var pr = $clone.find('.pr').attr('role');
                var ct = $clone.find('.ct').attr('role');
                var ds = $clone.find('.ds').attr('role');
                var prs = pr.split(',')
                var cts = ct.split(',')
                var dss = ds.split(',')
                    // 判断是否是直辖市 
                if (!/^10\,|^20\,|^30,|^320\,/.test(pr)) {
                    $clone.find('span:hidden').removeClass('dn')
                };
                that.setInfo.province = {
                    id: prs[0],
                    cid: prs[1],
                    name: prs[3]
                }
                that.setInfo.city = {
                    id: cts[0],
                    cid: cts[1],
                    lesId:cts[2],
                    name: cts[3]
                }
                that.setInfo.district = {
                    id: dss[0],
                    cid: dss[1],
                    lesId:dss[2],
                    name: dss[3]
                }
                $toggle.find('em').html($clone.children())
                $city.removeClass('active');
                // 向cookie中写入一个城市！
                that.setDefaultAddress(that.setInfo, function(data) {
                        if ($.type(opts.changeCb) == "function") {
                            return opts.changeCb(data);
                        }
                    })
                    // 使用常用地址设置地址后，重新渲染省市区,重复区域需要优化
                var getInfo = that.getInfo
                var province = getInfo.province
                var city = getInfo.city
                var district = getInfo.district
                var pinfo = [province.id, province.cid, '',province.name, province.defaultId].join(',')
                var cinfo = [city.id, city.cid,city.lesId, city.name, city.defaultId].join(',')
                var dinfo = [district.id, district.cid,district.lesId, district.name, district.defaultId].join(',')
                if (!opts.city) {
                    $navTabs.html('<li class="active"  role=' + pinfo + '><p><a href="###">' + province.name + '</a><b class="arr"></b></p></li><li class="active"  role=' + cinfo + '><p><a href="###">' + city.name + '</a><b class="arr"></b></p></li><li class="active current" role=' + dinfo + '><p><a href="###">' + district.name + '</a><b class="arr"></b></p></li>')
                } else {
                    $navTabs.html('<li class="active" role=' + pinfo + '><p><a href="###">' + province.name + '</a><b class="arr"></b></p></li><li class="active current" role=' + cinfo + '><p><a href="###">' + city.name + '</a><b class="arr"></b></p></li>')
                }
                $prPanel.removeClass('active').eq(2).addClass('active')

                if (!!opts.state) {
                    var $li = $('<li></li>')
                    $prPanel.eq(0).html('').append($li);
                    that.getProvinceList(function(allProvinces) {
                        $.each(allProvinces, function(k, v) {
                            var info = [v.id, v.cid,'', v.name, v.defaultId].join(',')
                            if (v.id == province.id) {
                                $prPanel.children(':eq(0)').append('<span><a href="###" class="on" role=' + info + '>' + v.name + '</a></span>')
                            } else {
                                $prPanel.children(':eq(0)').append('<span><a href="###" role=' + info + '>' + v.name + '</a></span>')
                            }
                        })
                        $tabContent.append($prPanel);
                        that.getProvinces($city, $item, $toggle, $tabContent, $navTabs, $prPanel, $header, $group, function() {
                            return that.getCities($navTabs, $tabContent, $prPanel, $city, $toggle, function() {
                                return that.getDistricts($navTabs, $tabContent, $toggle, $city, function() {
                                    return that.setDetailAddress($toggle, $navTabs, $tabContent, $city);
                                })
                            })
                        });
                    })
                } else {}

                $navTabs.find('li').each(function(i) {
                    $(this).on('click', function(e) {
                        if ($(this).hasClass('active')) {
                            $(this).addClass('current').siblings().removeClass('current')
                            $tabContent.children(':eq(' + i + ')').addClass('active').siblings().removeClass('active')
                        };
                        return false;
                    })
                })
                return false;;
            })
        },
        // 获得市
        getCities: function($navTabs, $tabContent, $prPanel, $city, $toggle, cb) {
            var that = this;
            var opts = this.opts
            var citiesPanel = $tabContent.find('.ct-panel li')
            var districtsPanel = $tabContent.find('.ds-panel li')
            $tabContent.find('.pr-panel a').on('click', function(event) {
                    if (event) event.stopPropagation()
                    $navTabs.children(':eq(1)').find('a').html('请选择市').end().end().children(':eq(2)').removeClass('active').find('a').html('请选择县区');
                    $(this).addClass('on').parent().siblings().find('a').removeClass('on');
                    var role = $(this).attr('role');
                    var roles = role.split(',')
                    that.setInfo.province = {
                        id: roles[0],
                        cid: roles[1],
                        name: roles[3],
                        lesId:roles[2]
                    }
                    var mid = roles[0]
                    var did = roles[4]
                    var text = $(this).text()
                    citiesPanel.html('')
                    that.getCityById(mid, function(data) {
                        $.each(data, function(k, v) {
                        	var cinfo = [v.id,v.cid,v.lesId,v.name,v.defaultId].join(',')
                            if (v.id == that.getInfo.city.id) {
                                citiesPanel.append('<span><a href="###" class="on" role=' + cinfo + '>' + v.name + '</a></span>')
                            } else {
                                citiesPanel.append('<span><a href="###" role=' + cinfo + '>' + v.name + '</a></span>')
                            }
                        })
                        cb()
                            // 判断是否是直辖市，如果是直辖市跳过选择市标签
                        if (data.length !== 1) {
                            $navTabs.children(':eq(1)').addClass('active current');
                            $tabContent.find('.pr-panel').removeClass('active').end().find('.ct-panel').addClass('active');
                        } else {

                            if (!!opts.city) {
                                $city.removeClass('active')
                            }
                            var info = [data[0].id + ',' + data[0].cid + ',' + data[0].name + ',' + data[0].defaultId].join(',')
                            $navTabs.children(':eq(1)').attr('role', info ).find('a').text(text)
                            that.setInfo.city = {
                                id: data[0].id,
                                cid: data[0].cid,
                                name: data[0].name,
                                lesId:data[0].lesId
                            }

                            that.getDefaultDistrict(data[0].defaultId, function(data) {
                                that.setInfo.district = {
                                    id: data.id,
                                    cid: data.cid,
                                    name: data.name,
                                    lesId:data.lesId
                                }
                                if (!!opts.city) {
                                    that.setDefaultAddress(that.setInfo, function(data) {
                                        var pr = $toggle.find('span:eq(0)')
                                        var ct = $toggle.find('span:eq(1)')
                                        pr.attr('role', that.setInfo.province.id + ',' + that.setInfo.province.cid + ',' + that.setInfo.province.name).text(that.setInfo.province.name)
                                        ct.attr('role', that.setInfo.city.id + ',' + that.setInfo.city.cid + ',' + that.setInfo.city.name+','+that.setInfo.province.lesId).text(that.setInfo.city.name)
                                        pr.text() == ct.text() && $.trim(pr) != '吉林' ? $toggle.find('.pr').addClass('dn') : $toggle.find('.pr').removeClass('dn')
                                    })
                                }
                                if ($.type(opts.cityCb) == "function") {
                                    opts.cityCb(that.getInfo);
                                }
                                $navTabs.children(':eq(1)').removeClass('active')
                            })
                        }
                    })

                    if (/^10\,|^20\,|^30,|^320\,/.test(mid + ',')) {
                        that.changeFlag = !!0;
                        if (!opts.city) {
                            $navTabs.children().eq(1).removeClass('active current').end().eq(2).addClass('current')
                            $tabContent.find('.pr-panel').removeClass('active').end().find('.ds-panel').addClass('active');
                            that.getDistrictsById(did, function(data) {
                                districtsPanel.html('');
                                $.each(data, function(k, v) {
                                	var info = [v.id,v.cid,v.lesId,v.name,v.defaultId].join(',')
                                    districtsPanel.append('<span><a href="###" role=' + info + '>' + v.name + '</a></span>')
                                })
                                if ($.type(opts.cityCb) == "function") {
                                    opts.cityCb(that.getInfo);
                                }
                                that.setDetailAddress($toggle, $navTabs, $tabContent, $city)
                            })
                            $navTabs.children(':eq(0)').addClass('active').removeClass('current')
                        }
                    } else {
                        $navTabs.children(':eq(0)').removeClass('current')
                    }
                    $navTabs.children(':eq(0)').attr('role', role).find('a').text(text)
                    return false;
                })
                // 第一次加载执行,初始化默认地址
            var mid = that.getInfo.province.id
            var cid = that.getInfo.city.id
            that.getCityById(mid, function(data) {
                citiesPanel.html('');
                $.each(data, function(k, v) {
                		var info = [v.id,v.cid,v.lesId,v.name,v.defaultId].join(',')
                        if (v.id == that.getInfo.city.id) {
                            citiesPanel.append('<span><a href="###" class="on" role=' + info + '>' + v.name + '</a></span>')
                        } else {
                            citiesPanel.append('<span><a href="###" role=' + info + '>' + v.name + '</a></span>')
                        }
                    })
                    // 判断是否是直辖市，如果是直辖市跳过选择市标签
                if (data.length == 1) {
                    $navTabs.children().eq(1).removeClass('active current')
                    $navTabs.children().eq(2).addClass('current')
                    $tabContent.find('.pr-panel').removeClass('active').end().find('.ds-panel').addClass('active');
                } else {
                    $navTabs.children(':eq(1)').addClass('active');
                }
                if (!!opts.city) {
                    if (data.length == 1) {
                        $navTabs.children(':eq(0)').addClass('active current').siblings().removeClass('active current')
                        $tabContent.children(':eq(0)').addClass('active').siblings().removeClass('active')
                    } else {
                        $tabContent.children(':eq(1)').addClass('active').siblings().removeClass('active')
                    }
                }
                cb()
            })
            that.getDistrictsById(cid, function(data) {
                districtsPanel.html('');
                $.each(data, function(k, v) {
                	var info = [v.id,v.cid,v.lesId,v.name,v.defaultId].join(',')
                    if (v.id == that.getInfo.district.id) {
                        districtsPanel.append('<span><a href="###" class="on" role=' + info + '>' + v.name + '</a></span>')
                    } else {
                        districtsPanel.append('<span><a href="###" role=' + info + '>' + v.name + '</a></span>')
                    }
                })
                that.setDetailAddress($toggle, $navTabs, $tabContent, $city)
            })
        },
        // 获得地区
        getDistricts: function($navTabs, $tabContent, $toggle, $city, cb) {
            var that = this;
            var opts = this.opts;
            var districtsPanel = $tabContent.find('.ds-panel li')
            $tabContent.find('.ct-panel a').on('click', function(event) {
                that.changeFlag = !!0;
                if (event) event.stopPropagation();
                $(this).addClass('on').parent().siblings().find('a').removeClass('on');
                var role = $(this).attr('role');
                that.setInfo.city = {
                    id: role.split(',')[0],
                    cid: role.split(',')[1],
                    lesId:role.split(',')[2],
                    name: role.split(',')[3]
                }
                var mid = role.split(',')[0];
                var text = $(this).text();
                if (!opts.city) {
                    $navTabs.children(':eq(2)').find('a').html('请选择县区')
                    districtsPanel.html('');
                    that.getDistrictsById(mid, function(data) {
                        $.each(data, function(k, v) {
                        	var info = [v.id,v.cid,v.lesId,v.name,v.defaultId].join(',')
                            if (v.id == that.getInfo.district.id) {
                                districtsPanel.append('<span><a href="###" class="on" role=' + info + '>' + v.name + '</a></span>')
                            } else {
                                districtsPanel.append('<span><a href="###" role=' + info + '>' + v.name + '</a></span>')
                            }
            })
            cb()
            if ($.type(opts.cityCb) == "function") {
              opts.cityCb(that.getInfo);
            }
          })
          $tabContent.find('.ct-panel').removeClass('active').end().find('.ds-panel').addClass('active')
          $navTabs.children(':eq(1)').addClass('active').removeClass('current').attr('role', role).find('a').text(text).end().end().children(':eq(2)').addClass('active current')

                } else {
                    var id = role.split(',')[4];
                    that.getDefaultDistrict(id, function(data) {
                        $city.removeClass('active')
                        that.setInfo.district = {
                            id: data.id,
                            cid: data.cid,
                            name: data.name,
                            lesId:data.lesId
                        }
                        $navTabs.children(':eq(1)').attr('role', role).find('a').text(text)
                        var pr = $navTabs.find('a:eq(0)').text();
                        var ct = $navTabs.find('a:eq(1)').text();
                        var ds = that.setInfo.district.name;
                        pr == ct && $.trim(pr) != '吉林' ? $toggle.find('.pr').addClass('dn') : $toggle.find('.pr').removeClass('dn')
                        $toggle.find('.pr').text(pr).end().find('.ct').text(ct)
                        that.setDefaultAddress(that.setInfo, function(data) {
                            var pr = $toggle.find('span:eq(0)')
                            var ct = $toggle.find('span:eq(1)')
                            var info = that.setInfo
                            var province = info.province
                            var city = info.city
                            var pinfo = [province.id, province.cid, province.name,''].join(',')
                            var cinfo = [city.id, city.cid, city.name,'',city.lesId].join(',')
                            pr.attr('role', pinfo).text(province.name).removeClass('dn')
                            ct.attr('role', cinfo).text(city.name)
                        })
                        if ($.type(opts.cityCb) == "function") opts.cityCb(that.getInfo);
                    })
                }

                return false;
            })

        },
        // 设置最终地址；
        setDetailAddress: function($toggle, $navTabs, $tabContent, $city) {
            var that = this;
            var opts = this.opts
            $tabContent.find('.ds-panel a').on('click', function(event) {
                if (event) event.stopPropagation()
                $city.removeClass('active')
                $(this).addClass('on').parent().siblings().find('a').removeClass('on');
                var role = $(this).attr('role')
                var roles = role.split(',')
                that.setInfo.district = {
                    id: roles[0],
                    cid: roles[1],
                    lesId:roles[2],
                    name: roles[3]
                }
                var mid = roles[0];
                var text = $(this).text();
                var pr = $navTabs.find('a:eq(0)').text()
                var ct = $navTabs.find('a:eq(1)').text()
                var ds = $navTabs.find('a:eq(2)').text()
                var info = that.getInfo
                var province = info.province
                var city = info.city
                var district = info.district
                var pinfo = [province.id, province.cid, province.name].join(',')
                var cinfo = [city.id, city.cid, city.name,'',city.lesId].join(',')
                var dinfo = [district.id, district.cid, district.name,'',district.lesId].join(',')
                $navTabs.children(':eq(2)').attr('role', role).find('a').text(text)
                pr == ct && $.trim(pr) != '吉林' ? $toggle.find('.pr').addClass('dn') : $toggle.find('.pr').removeClass('dn')
                $toggle.find('.pr').attr('role', pinfo).text(pr).end().find('.ct').attr('role', cinfo).text(ct).end().find('.ds').attr('role', dinfo).text(text)
                    // 向cookie中写入一个城市！
                that.setDefaultAddress(that.setInfo, function(data) {
                    if ($.type(opts.distCb) != "function" || $.type(opts.changeCb) != "function") {
                        return
                    }

                    if (that.changeFlag == false) {
                        opts.changeCb(data)
                        that.changeFlag = true
                    } else {
                        opts.distCb(data)
                    }

                })
                return false
            })
        },
        // 根据获取默认的地址;
        getAddressByDefault: function(cb) {
            ECity.API.getCity(function(data) {
                return cb(data)
            })
        },
        // 获取常用地址
        getUsedAddress: function(cb) {
            var data = ECity.API.getLastUsedCities()
            return cb(data)
        },
        // 获取省列表
        getProvinceList: function(cb) {
            ECity.API.getProvinceList(function(data) {
                return cb(data)
            })
        },
        // 根据mid获取城市信息
        getCityById: function(id, cb) {
            ECity.API.getCityList(id, function(data) {
                return cb(data)
            })
        },
        // 根据mid获取区县信息
        getDistrictsById: function(id, cb) {
            ECity.API.getDistrictList(id, function(data) {
                return cb(data)
            })
        },
        // 写入一个城市信息到cookie
        setDefaultAddress: function(data, cb) {
            ECity.API.setCity(data, function(data) {
                return cb(data)
            })
        },
        getDefaultDistrict: function(id, cb) {
            ECity.API.getDistrict(id, function(data) {
                return cb(data)
            })
        },
        getCity: function(data) {
            var that = this;
            that.opts.getCity(data)
        },
        getInfoByCityid: function(id, cb) {
            ECity.API.getProvinceAndCityByCityId(id, function(data) {
                var all = data.provinceAndCity
                var o = {}
                o.province = {
                    id: all.pMdmId,
                    cid: all.pMdmId,
                    name: all.pName
                }
                o.city = {
                    id: all.cMdmId,
                    cid: all.cCommerceId,
                    name: all.cName
                }
                o.district = {
                    id: '',
                    cid: '',
                    name: ''
                }
                cb(o)
            })
        }

    }

    // API
    window.mCity = {};
    mCity.API = {};
    mCity.API.getCity = function(cb) {
        ECity.API.getCity(function(data) {
            return cb(data)
        })
    }
    mCity.API.getCityId = function() {
        ECity.API.getCityId()
    };
    mCity.API.getDistrictId = function() {
        ECity.API.getDistrictId()
    };

    /***********
   * @配置参数
   * @city 是否只显示到市，默认为flase，显示到区县;
   * @state 是否按照地区排列，默认为flase，不按照地区排列，功能暂时未实现;
   * @used 是否显示常用地址，默认为true，显示常用地址，如果city为true，used必为fasle，此处的配置参数失效;
   * @cityCb 点击城市之后的 callback 默认为无！第一个参数是cookie中存在的当前的省市区的信息；
   * @distCb 点击区县之后的 callback 默认为无！第一个参数是cookie中存在的当前的省市区的信息；

   ***********/
    var defaults = {
        city: false,
        state: true,
        used: true,
        cityCb: $.noop,
        distCb: $.noop,
        getCity: $.noop,
        changeCb: $.noop,
        cityId: ''
    };

  // 备用！开发中，根据环境判断hostName
  var host = document.location.host;
  var hostDomain = document.location.hostname;
  var protocol = document.location.protocol;
  var port = document.location.port;
  var root = '/ip-web';
  
  var hostName;
//  if (/\.suning\.com/ig.test(host)||/\.cnsuning\.com/ig.test(host)) {
//      hostName = protocol+'//'+hostDomain;
////	  hostName ='http://localhost:8080/ip-web';
//  }else {
//	  hostName = protocol+'//'+hostDomain+':'+port+root;
//  };
  if (/\.cnsuning\.com/ig.test(host)) {
	  if(host.indexOf("pre")!=-1){
		  hostName = protocol+'//ipservicepre.cnsuning.com';
//		  hostName = "http://localhost:8080/ip-web";
	  }else{
		  hostName = protocol+'//ipservicesit.cnsuning.com';
	  }
  } else if (/\.suning\.com/ig.test(host)) {
    hostName = protocol+'//ipservice.suning.com';
  } else {
	  hostName = 'http://localhost:8080/ip-web';
  };
  $.fn.mCity = function(opt) {
    var that = this;
    $.when($.ajax({
    		      url: hostName+'/cityMap_20150401.jsonp',
    		      dataType: 'script',
    		      cache: true
    		    })).then(function() {
      try{
        ECity.API.init(opt.city?opt.city:defaults.city);
      }catch(e){};
      return that.each(function() {
        var opts = $.extend({}, defaults, opt);
        Methods().init(this, opts);
      })
    })
  }
})(jQuery)
