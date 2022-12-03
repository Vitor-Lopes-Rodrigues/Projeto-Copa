FROM maven:3.8.6-jdk-11

ENV JAVA_OPTS "-Dspring-boot.run.jvmArguments='-Xmx10g'"

WORKDIR /Projeto

COPY . .

EXPOSE 8080

ENV DATABASE_PASSWORD=1234
ENV DATABASE_URL=jdbc:postgresql://localhost:5432/copa
ENV DATABASE_USER=copa_user

CMD ["mvn","spring-boot:run"]