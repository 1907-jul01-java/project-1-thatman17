    
FROM postgres:10
ENV POSTGRES_USER revature
ENV POSTGRES_PASSWORD p4ssw0rd
ADD schema.sql /docker-entrypoint-initdb.d
EXPOSE 5432