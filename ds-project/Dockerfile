FROM centos:8

COPY target/classes/ .

ENV ADMIN_PORTAL=/root/ds-project/target/classes/portals/admin/grpc/GRPCServer

RUN yum update -y
RUN dnf install java-11-openjdk-devel -y
RUN yum install epel-release -y
RUN yum install snapd -y
RUN ln -s /var/lib/snapd/snap /snap
RUN snap install mosquitto -y

ENTRYPOINT [ "java", "-jar", "${ADMIN_PORTAL}" ]

EXPOSE 9090