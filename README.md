本分支为天气预报的springcloud版本

基于ServiceStage部署的操作指导请参考： [ServiceComb on ServiceStage](https://support.huaweicloud.com/bestpractice-servicestage/servicestage_bestpractice_0108.html)  
天气预报运行起来后的界面如下：

![](https://github.com/servicestage-demo/weathermap/blob/master/weathermap.JPG)


本地开发注意事项：
1、index.html页面注销：83-116行、119-121行、279-397行，否则界面显示混乱；
2、weathermapweb.js文件中的proxy_port默认端口修改："30101"->"13092"；
3、weathermapweb.js文件中的opt对象中的path修改：
  'http://' + service_addr + '/fusionweather/show?city=' + req.query.city->'/fusionweather/show?city=' + req.query.city；
4、weather-2.0.js文件中achieveAllWeatherData方法中$http中的参数params增加"user":$location.search().user；
5、如果请求出现前后端跨域错误，在fusionweather的请求控制层FusionweatherImpl中增加@CrossOrigin；
