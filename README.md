# Jpa Test project

Start Azure SQL Server on Docker

```shell
docker run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=Test@2020' -e 'MSSQL_PID=Express' -e 'MSSQL_PID=Developer' \ 
-p 1433:1433 -d mcr.microsoft.com/azure-sql-edge:latest
```
