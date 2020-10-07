FROM java:8-jre

RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

ADD student-management.jar /app/

CMD ["java", "-Xmx200m", "-jar", "/app/student-management.jar"]

EXPOSE 8080