### [中文](README_zh.md)

[Apache ServiceComb](https://servicecomb.apache.org/) is a uncomplicated microservice developing framework, it provieds massive out-of-box features, such as discovery and registry services, configuration management, load balance, fault tolerance and circuit breaker, rate limiting， which help you build microservice rapidly.  

[ServiceStage](https://www.huaweicloud.com/product/servicestage.html)provides a serires of tools and platforms to help users manage servicecomb microservice applications better. As shown below, users can develop, construct, deploy, operate， maintain， register their applications and set loadbalance, rate limiting, downgrade, circuitbreaker, fault tolerance, black/white list, fault injection, grayscale, dashboard and so on.

![](https://github.com/servicestage-demo/weathermap/blob/master/arch.JPG)

weather forecast shown above is a microservice applicaiton based on ServiceComb, which can check the weather of city user demand.  
1、	weathermapweb is a microservice based on node.js  
2、 fusionweather provides weather data for web UI, based on java.  
3、 forecast service provides weather forecasts for the next few days in a specified city, based on java  
4、 weather service provides current weather information in specified city, based on java  
5、	weather-beta is the newer version of weather，newly added the ultraviolet rays information, based on java

to deploy it on servicestage： [ServiceComb on ServiceStage](https://support.huaweicloud.com/bestpractice-servicestage/servicestage_bestpractice_0108.html)  
runtime interface is as shown below：

![](https://github.com/servicestage-demo/weathermap/blob/master/weathermap.JPG)
