FROM openjdk:17-jdk-slim
VOLUME /tmp

COPY target/springboot-prometheus-grafana-0.0.1-SNAPSHOT.jar /app/app.jar
COPY env/opentelemetry-javaagent.jar /app/opentelemetry-javaagent.jar
COPY env/otel-collector-config.yaml /app/otel-config.yaml

WORKDIR /app

ENTRYPOINT ["java", "-javaagent:/app/opentelemetry-javaagent.jar", \
            "-Dotel.exporter=otlp", \
            "-Dotel.exporter.otlp.endpoint=http://opentelemetry-collector:55680", \
            "-Dotel.service.name=springboot-prometheus-grafana", \
            "-Dotel.debug=true", \
            "-jar", "app.jar"]