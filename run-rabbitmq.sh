#!/bin/bash

# 定义容器名称和镜像名称
CONTAINER_NAME=my-rabbitmq-instance
IMAGE_NAME=my-rabbitmq

# 用户名和密码
RABBITMQ_USER=myuser
RABBITMQ_PASSWORD=mypassword

# 检查是否已有同名容器运行
if [ $(docker ps -a -f name=$CONTAINER_NAME | grep -w $CONTAINER_NAME | wc -l) -gt 0 ]; then
  echo "停止并移除已存在的容器 $CONTAINER_NAME..."
  docker stop $CONTAINER_NAME
  docker rm $CONTAINER_NAME
fi

# 构建RabbitMQ Docker镜像
echo "构建Docker镜像 $IMAGE_NAME..."
docker build -t $IMAGE_NAME .

# 运行RabbitMQ容器
echo "运行新的RabbitMQ容器 $CONTAINER_NAME..."
docker run -d \
  --name $CONTAINER_NAME \
  -p 5672:5672 \
  -p 15672:15672 \
  -e RABBITMQ_DEFAULT_USER=$RABBITMQ_USER \
  -e RABBITMQ_DEFAULT_PASS=$RABBITMQ_PASSWORD \
  $IMAGE_NAME

echo "RabbitMQ容器 $CONTAINER_NAME 已成功运行。"
