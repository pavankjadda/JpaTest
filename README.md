# Jpa Test project

This is a simple project to test JPA with MS SQL Server running on Docker.
## Prerequisites
- Docker installed on your machine
- JDK 25 installed
- Maven installed

## Run MS SQL Server on Docker
1. First, create a Docker volume to persist the database data:

```shell
docker volume create docker_mssql_volume
```

2. Then run the following command to start the MS SQL Server container
```

```shell
docker run  --platform linux/amd64 --restart always  -e "ACCEPT_EULA=Y" -e "MSSQL_SA_PASSWORD=Test#12345" -v docker_mssql_volume:/var/opt/mssql -p 1433:1433 -d --name pres_mssql mcr.microsoft.com/mssql/server:2022-latest
```