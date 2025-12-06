# ===============================================
# ESTÁGIO 1: COMPILAÇÃO (BUILD)
# ===============================================
# Usa uma imagem base que já tem o Java e o Maven instalados
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo de dependências (pom.xml) primeiro para otimizar o cache do Docker
COPY pom.xml .

# Baixa as dependências e as armazena em cache
RUN mvn dependency:go-offline

# Copia o restante do código-fonte
COPY src ./src

# Compila o projeto e gera o JAR executável no diretório target/
RUN mvn package -DskipTests

# ===============================================
# ESTÁGIO 2: IMAGEM FINAL (PRODUÇÃO)
# ===============================================
# Usa uma imagem base JRE (Java Runtime Environment) menor e mais segura
FROM eclipse-temurin:21-jre-alpine

# Define o argumento ARTIFACT_NAME (o nome do seu JAR)
ARG ARTIFACT_NAME=payment-0.0.1-SNAPSHOT.jar 

# Define a porta que o Spring Boot usa
EXPOSE 8080

# Cria um diretório de trabalho para a aplicação
WORKDIR /opt/app

# Copia o JAR compilado do estágio 'build' para a imagem final
COPY --from=build /app/target/$ARTIFACT_NAME app.jar

# Define o ponto de entrada para rodar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]