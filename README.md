[Apache ServiceComb](https://servicecomb.apache.org/)是一个简单易用的微服务开发框架，它提供了大量开箱即用的特性，如服务注册发现、配置管理、负载均衡、容错熔断、限流降级等，可以让您快速构建微服务应用。

[华为云ServiceStage](https://www.huaweicloud.com/product/servicestage.html)提供一系列工具和平台，可以帮助用户更好的管理ServiceComb微服务应用。如下图所示，用户可以基于ServiceStage完成ServiceComb微服务应用的开发、构建、部署、运维、注册、负载均衡、限流、降级、熔断、容错、错误注入、黑白名单、灰度发布、配置管理、仪表盘等功能。

![](https://github.com/servicestage-demo/weathermap/blob/master/arch.JPG)

上图中的天气预报是一个基于ServiceComb开发的微服务应用，可以根据用户输入的城市名称查询天气情况，其中：  
0、 本分支为weather的springcloud版本。  
1、 其他功能与java-chassis相同  
2、 servicestage暂不支持对spring cloud应用的直接服务治理，需通过动态配置实现。

基于ServiceStage部署的操作指导请参考： [ServiceComb on ServiceStage](https://support.huaweicloud.com/bestpractice-servicestage/servicestage_bestpractice_0108.html)  
天气预报运行起来后的界面如下：

![](https://github.com/servicestage-demo/weathermap/blob/master/weathermap.JPG)
