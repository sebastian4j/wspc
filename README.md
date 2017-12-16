# wspc
java + spring boot + cloud + rabbit mq

Construir con: mvn clean package -DskipTests

boot.server: sevidor para cargar la configuración desde https://github.com/sebastian4j/java-cloud.git

boot2: aplicacion spring-boot cliente que utiliza la configuración que obtiene desde boot.server y está configurado con Spring Cloud Bus para RabbitMQ

lanzar:

java -jar boot.server/target/boot.server-0.0.1-SNAPSHOT.jar

java -jar boot2/target/boot2-0.0.1-SNAPSHOT.jar --server.port=8081

java -jar boot2/target/boot2-0.0.1-SNAPSHOT.jar --server.port=8082

...
