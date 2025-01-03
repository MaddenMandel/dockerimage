FROM openjdk:17-jdk-slim
VOLUME /tmp

COPY target/springboot-prometheus-grafana-0.0.1-SNAPSHOT.jar /app/app.jar
COPY env/opentelemetry-javaagent.jar /app/opentelemetry-javaagent.jar
COPY env/otel-collector-config.yaml /app/otel-config.yaml

WORKDIR /app

# 设置 ENTRYPOINT，指向正确的 OTLP HTTP 端口
ENTRYPOINT ["java", \
            "-javaagent:/app/opentelemetry-javaagent.jar", \
            "-Dotel.exporter=otlp", \
            "-Dotel.exporter.otlp.endpoint=http://otel-collector:4318", \
            "-Dotel.exporter.otlp.protocol=http/protobuf", \
            "-Dotel.service.name=springboot-prometheus-grafana", \
            "-Dotel.debug=true", \
            "-jar", "app.jar"]