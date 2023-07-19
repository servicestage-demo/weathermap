FROM 100.125.0.27:20202/op_svc_cse/openjdk-x86_64:17-1.2.0

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo "Asia/Shanghai" > /etc/timezone

WORKDIR /home/apps/
ADD target/weather-beta-2.0.0.jar .
ADD start.sh .

ENTRYPOINT ["sh", "/home/apps/start.sh"]
