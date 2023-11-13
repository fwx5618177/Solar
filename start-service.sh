#!/bin/bash

# 服务目录列表
SERVICES=("service-discovery" "solar-service" "email-service")

# 启动服务的函数
start_service() {
    echo "Starting $1"
    cd $1
    if [ "$2" = "debug" ]; then
        mvn spring-boot:run &
    elif [ "$2" = "pro" ]; then
        JAR_FILE=$(ls target/*.jar)
        java -jar $JAR_FILE &
    fi
    cd ..
}

# 停止服务的函数
stop_service() {
    SERVICE_NAME=$1
    echo "Stopping $SERVICE_NAME"
    pkill -f "$SERVICE_NAME"
}

# 处理不同的命令
case "$1" in
    debug|pro)
        # 终止正在运行的服务实例
        for SERVICE in ${SERVICES[@]}; do
            stop_service $SERVICE
        done
        # 确保所有服务都已打包
        if [ "$1" = "pro" ]; then
            mvn clean package -DskipTests
        fi
        # 按顺序启动每个服务
        for SERVICE in ${SERVICES[@]}; do
            start_service $SERVICE $1
        done
        ;;
    stop)
        # 仅停止服务
        for SERVICE in ${SERVICES[@]}; do
            stop_service $SERVICE
        done
        ;;
    *)
        echo "Unknown command: $1"
        ;;
esac

# 等待所有后台进程
wait
