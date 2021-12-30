# First stage: complete build environment
FROM maven:3.5.0-jdk-8-alpine AS builder

# add pom.xml and source code
ADD ./pom.xml pom.xml
ADD ./src src/

# package jar
RUN mvn clean package

# Second stage: minimal runtime environment
From registry.cn-hangzhou.aliyuncs.com/huolaila-pro/java8

# copy jar from the first stage
COPY --from=builder target/tally-1.0.0-SNAPSHOT.jar tally-1.0.0-SNAPSHOT.jar

EXPOSE 8080

CMD ["java", "-jar", "tally-1.0.0-SNAPSHOT.jar"]