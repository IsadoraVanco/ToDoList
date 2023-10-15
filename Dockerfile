# Roda em um Ubuntu
FROM ubuntu:latest AS build 

# Atualiza e instala o JDK 20
RUN apt-get update
RUN apt-get install openjdk-20-jdk -y

# Copia todo conteúdo do diretório local para o remoto
COPY . .

# Instala o Maven
RUN apt-get install maven -y
#Roda o Maven, criando os arquivos .jar na pasta target
RUN mvn clean install

# Expõe a porta 8080 para utilizar para fazer requisições
EXPOSE 8080

# Pega o arquivo .jar criado no target e transfere para app.jar
COPY --from=build /target/todolist-1.0.0.jar app.jar

#Executa os comandos "java -jar app.jar"
ENTRYPOINT ["java", "-jar", "app.jar"]
