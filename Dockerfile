# Use OpenJDK 21 (matches your project Java version)
FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Give mvnw execute permission
RUN chmod +x mvnw

# Build the jar using Maven wrapper
RUN ./mvnw clean package -DskipTests

# Expose default Spring Boot port
EXPOSE 8080

# Run the Spring Boot app
CMD ["java", "-jar", "target/MyPortfolioWebsite-0.0.1-SNAPSHOT.jar"]