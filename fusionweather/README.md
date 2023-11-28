# Swagger generated server

CSE Spring MVC Server

## Overview

The code of this module is automatically generated based on the swagger.yaml file provided by the user。The generated
code can generally be divided into following categories：

1，`main Method` in class `com.service.fusionweather.FusionweatherApplication.java`。

2，`com.service.fusionweather.controller.FusionweatherImpl.java` intercepts user's requests, analyze inputs parameters,
and delegate handlers to the class `FusionweatherImplDelegate.java` through `springmvc annotation`.

3，`com.service.fusionweather.controller.FusionweatherImplDelegate.java` is an implementation class of `handler` where
user can implement their own business logic.

5，`com.service.fusionweather.entity`. All classes in this package are the definitions defined in swagger.yaml, it's
similar to the `MODEL` in `SpringMVC`

6，`resource` directory defines some configuration files, including log4j configuration, microservice configuration and
swagger protocol files.

## GOVERNANCE TEST

if you want isolate designated services, choose isolation governance; if you want limitation current servcie one
interface, choose circuitBreaker.

* isolation test

fusionweather server config:

```yaml
servicecomb:
  matchGroup:
    AllOperation: |
      matches:
        # usually, it's not necessary set, only multiple services have the same interface, 1.11.3-2021.0.x effect.
        - serviceName: "forecast"
          apiPath:
            prefix: "/"
  instanceIsolation:
    AllOperation: |
      minimumNumberOfCalls: 1
      slidingWindowSize: 2
      slidingWindowType: COUNT_BASED
      waitDurationInOpenState: 10000   # isolation time, default 60000ms
      failureRateThreshold: 20
```

how to test:

First refresh web, all data is normal, then open exception switch for forecast, refresh web, there have no forecast
data, refresh more times, there will show `INSTANCE ISOLATED`.

* circuitBreaker test

fusionweather server config:

```yaml
servicecomb:
  matchGroup:
    AllOperation: |
      matches:
        - apiPath:
            prefix: "/fusionweather/governanceTest"
  circuitBreaker:
    AllOperation: |
      minimumNumberOfCalls: 1
      slidingWindowSize: 2
      slidingWindowType: COUNT_BASED
      waitDurationInOpenState: 10000   # isolation time, default 60000ms
      failureRateThreshold: 20
```

how to test:

First refresh web and curl http://localhost:10392/fusionweather/governanceTest, both have data return, then curl
curl http://localhost:10392/fusionweather/governanceTest?errorTest=true until return circuitBreaker is open, curl
http://localhost:10392/fusionweather/governanceTest have no data return, but refresh web, have data to show.

if config apiPath setting `prefix: "/"`, both curl http://localhost:10392/fusionweather/governanceTest and refresh web
have no data return.

* rateLimited test

forecast server config:

```yaml
servicecomb:
  matchGroup:
    AllOperation: |
      matches:
        - apiPath:
            prefix: "/"
  rateLimiting:
    AllOperation: |
      rate: 1
      limitRefreshPeriod: 1000
```

fast refresh web, forecast will have no data return and show `TOO MANY REQUESTS!`

* faultInjection test

governance center setting forecast service faultInjection rule, refresh web, forecast have no data return.

* retry test

arrange weather and weather-beta service, refresh web, supersede return different data, setting `randomException.enabled=true`
then weather-beta will have no data return, web will supersede show `no weather data!` and weather data.

fusionweather add retry config:

```yaml
servicecomb:
  matchGroup:
    AllOperation: |
      matches:
        - apiPath:
            prefix: "/"
  retry:
    AllOperation: |
      maxAttempts: 3
```

then refresh web, always display weather data.

> **NOTE**:  **make sure the configuration in bootstrap.yaml is correct.**