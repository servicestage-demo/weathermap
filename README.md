[Apache ServiceComb](https://servicecomb.apache.org/) is a uncomplicated microservice developing framework, it provieds 它提供了大量开箱即用的特性，如服务注册发现、配置管理、负载均衡、容错熔断、限流降级等，可以让您快速构建微服务应用。

[华为云ServiceStage](https://www.huaweicloud.com/product/servicestage.html)提供一系列工具和平台，可以帮助用户更好的管理ServiceComb微服务应用。如下图所示，用户可以基于ServiceStage完成ServiceComb微服务应用的开发、构建、部署、运维、注册、负载均衡、限流、降级、熔断、容错、错误注入、黑白名单、灰度发布、配置管理、仪表盘等功能。

![](https://github.com/servicestage-demo/weathermap/blob/master/arch.JPG)


上图中的天气预报是一个基于ServiceComb开发的微服务应用，可以根据用户输入的城市名称查询天气情况，其中：  
1、	weathermapweb is a microservice based on node.js  
2、 fusionweather provides weather data for web UI, based on java.  
3、 forecast service provides weather forecasts for the next few days in a specified city, based on java  
4、 weather service provides current weather information in specified city, based on java  
5、	weather-beta is the newer version of weather，newly added the ultraviolet rays information, based on java

to deploy it on servicestage： [ServiceComb on ServiceStage](https://support.huaweicloud.com/bestpractice-servicestage/servicestage_bestpractice_0108.html)  
runtime interface is as shown below：

![](https://github.com/servicestage-demo/weathermap/blob/master/weathermap.JPG)
