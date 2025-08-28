FROM openjdk:21-slim

WORKDIR /app

COPY . .

RUN find . -name "*.java" -exec javac {} +

CMD ["/bin/bash"]