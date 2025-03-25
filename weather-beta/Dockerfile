FROM openjdk:8u181-jdk-alpine

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo "Asia/Shanghai" > /etc/timezone

WORKDIR /home/apps/
ADD target/weather-beta-2.0.0.jar .
ADD start.sh .
RUN echo version:1.0.1 > /home/apps/version.txt

ENTRYPOINT ["sh", "/home/apps/start.sh"]
