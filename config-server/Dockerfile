# 接收从 Maven 传递的参数
ARG JAR_FILE

# 使用Java官方镜像作为基础镜像
FROM openjdk:17

# 指定容器内的工作目录
WORKDIR /app

# 将构建产生的jar文件复制到容器内
COPY target/${JAR_FILE} app.jar

# 暴露相应端口
EXPOSE 8080

# 启动Java应用
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
