#!/usr/bin/env groovy

def services = ["service-discovery", "solar-service", "email-service"]

def startService(service, mode) {
    println "Starting $service"
    def dir = new File(service).absolutePath
    def cmd
    if (mode == "debug") {
        cmd = "mvn spring-boot:run -Drun.jvmArguments=\"-Dspring.application.name=$service\""
    } else if (mode == "pro") {
        def jarFile = new File(dir, "target").listFiles().find { it.name.endsWith(".jar") }
        cmd = "java -jar -Dspring.application.name=$service ${jarFile}"
    }
    try {
        def process = cmd.execute(null, new File(dir))
        // 等待几秒钟以确保服务成功启动
        Thread.sleep(5000)
        if (process.alive) {
            println "$service started successfully."
        } else {
            println "$service failed to start."
        }
    } catch (Exception e) {
        println "Failed to start $service: $e.message"
    }
}

def killService(service) {
    println "Stopping $service"
    "pkill -f $service".execute()
}

if (args.length == 0) {
    println "Error: No arguments provided. Please specify 'debug', 'pro', or 'stop'."
    System.exit(1)
}

// 根据不同模式处理服务
switch (args[0]) {
    case "debug":
    case "pro":
        services.each { killService(it) }
        if (args[0] == "pro") {
            "mvn clean package -DskipTests".execute()
        }
        services.each { startService(it, args[0]) }
        break
    case "stop":
        services.each { killService(it) }
        break
    default:
        println "Unknown command: ${args[0]}"
}
