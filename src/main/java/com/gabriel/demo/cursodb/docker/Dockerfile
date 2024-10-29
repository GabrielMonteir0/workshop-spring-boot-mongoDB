# Usa uma imagem base do Java (OpenJDK)
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR da API para o diretório de trabalho no container
COPY target/sua-api.jar sua-api.jar

# Define a porta que a API usa
EXPOSE 8080

# Comando para executar o JAR da API
ENTRYPOINT ["java", "-jar", "sua-api.jar"]
