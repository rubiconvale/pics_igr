FROM ubuntu
MAINTAINER tallred@picsauditing.com

RUN apt-get update
RUN apt-get install openjdk-7-jre-headless -y
RUN mkdir -p /opt/app

WORKDIR /opt/app

ADD ./target/oauth-authentication-1.0.0.jar /opt/app/service.jar
ADD /src/main/resources/config.properties /opt/app/config.properties

EXPOSE 9056
ENTRYPOINT java -Dext.properties.dir=/opt/app -jar /opt/app/service.jar
