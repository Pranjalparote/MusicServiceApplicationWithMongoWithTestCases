FROM openjdk:11-jdk-stretch
ADD /target/MusicService-0.0.1-SNAPSHOT.jar /src/app/music/MusicServiceWithMongo.jar
WORKDIR src/app/music
ENTRYPOINT ["java","-jar", "MusicServiceWithMongo.jar"]