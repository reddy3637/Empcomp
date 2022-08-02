FROM openjdk:11
EXPOSE 8088
ADD target/Emp-Comp-0.0.1-SNAPSHOT.jar Emp-Comp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Emp-Comp-0.0.1-SNAPSHOT.jar"]
