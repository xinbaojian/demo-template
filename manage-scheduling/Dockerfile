FROM java:8-211

ADD ./target/manage-scheduling.jar /

ENV JAVA_OPTS="-Xms128m -Xmx512m"
VOLUME /tmp
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /manage-scheduling.jar"]