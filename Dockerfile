FROM ubuntu:latest as build

# Atualiza o repositório de pacotes
RUN echo "Atualizando repositório de pacotes..."
RUN apt-get update

# Instala o JDK 17
RUN echo "Instalando OpenJDK 17..."
RUN apt-get install openjdk-17-jdk -y

# Copia o código-fonte para o contêiner
COPY . .

# Instala o Maven e constrói o projeto
RUN echo "Instalando Maven e construindo o projeto..."
RUN apt-get install maven -y
RUN mvn clean install

# Estágio final
FROM openjdk:17-jdk-slim

# Expõe a porta 80
EXPOSE 80

# Copia o arquivo JAR construído anteriormente
COPY --from=build /target/*.jar app.jar

# Inicia a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
