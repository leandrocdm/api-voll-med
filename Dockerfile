# Define a imagem base como OpenJDK 17
FROM openjdk:17-jdk

# Define o diretório de trabalho no contêiner
WORKDIR /app

# Copia o arquivo JAR da aplicação para o contêiner
COPY target/*.jar app.jar

# Comando a ser executado quando o contêiner iniciar
CMD ["java", "-jar", "app.jar"]
