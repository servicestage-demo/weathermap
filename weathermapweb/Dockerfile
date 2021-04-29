FROM swr.ap-southeast-2.myhuaweicloud.com/huawei-cse/nodejs:1.0.0

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo "Asia/Shanghai" > /etc/timezone

WORKDIR /home/apps/
COPY ./app.js ./
COPY ./bin ./bin
COPY ./package.json ./
COPY ./public ./public
COPY ./routes ./routes
COPY ./shutdown.sh ./
COPY ./start.sh ./
COPY ./views ./views
COPY ./node_modules ./node_modules

ENTRYPOINT ["sh", "/home/apps/start.sh"]
