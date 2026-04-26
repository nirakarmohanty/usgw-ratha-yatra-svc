# Builder stage: use Maven + JDK to compile and package the app
FROM maven:3.8.8-eclipse-temurin-17 AS builder
WORKDIR /workspace

# Copy dependency descriptors first for better layer caching
COPY pom.xml ./
# If you use the Maven wrapper, uncomment the following lines and adjust as needed:
# COPY mvnw ./
# COPY .mvn .mvn

# Copy source and build (skip tests for faster image builds)
COPY src ./src
RUN mvn -B -DskipTests package

# Runtime stage: smaller JRE image
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /workspace/target/*.jar ./app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]

