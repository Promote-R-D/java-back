# 기반이 될 도커 이미지 선택
FROM openjdk:17-jdk

# 작업 디렉토리 생성 및 설정
WORKDIR /app
#ARG JAR_FILE=build/libs/*.jar
# 필요한 파일 복사
COPY ./target/test.jar ./app.jar

# 애플리케이션 실행 명령어
CMD ["java", "-jar", "./app.jar"]

#FROM openjdk:17-alpine
#ARG JAR_FILE=build/libs/*.jar
#COPY ${JAR_FILE} app.jar
#ENTRYPOINT ["java","-jar","/app.jar"]