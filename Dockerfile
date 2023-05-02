FROM openjdk:17-jdk-slim as app-builder
WORKDIR /tmp
COPY . .
RUN ./gradlew --no-daemon build

FROM eclipse-temurin:17-jre
ENV JAVA_OPTS_DOCKER=""
ENV JAVA_MEM_OPTS_DOCKER=""
WORKDIR /srv
COPY --from=app-builder /tmp/main/build/libs/pismo-all.jar .
CMD JAVA_OPTS="$JAVA_OPTS $JAVA_OPTS_DOCKER" \
    && JAVA_MEM_OPTS="$JAVA_MEM_OPTS $JAVA_MEM_OPTS_DOCKER" \
    && exec java $JAVA_OPTS $JAVA_MEM_OPTS -jar pismo-all.jar
