#Creado en base a la imagen de alpine con el jdk8 de oracle.
FROM frolvlad/alpine-oraclejdk8:slim

#Argumentos para la creacion del usuario y su grupo
ARG user=fenix
ARG user_dir=/home/${user}
ARG group=dev

#El que le da servicio desde enero del 2018 hasta ahora.
LABEL author=GrupoGalvan-DESA

#Creamos un usuario
RUN addgroup ${group}

#Creamos un usuario
RUN adduser -D -S -G ${group} ${user}

#Usamos ese usuario
USER ${user}

#Nos pasamos a la carpeta de trabajo
WORKDIR ${user_dir}


#<INIT>--- Variables de entorno

#Clave para encriptar la informacion del acceso, debe ser fija a 128bits
ENV ENCRYPT f3n1x3005h4sk3ll

#Usuario de la base de datos
ENV DB_USER_NAME administrador

#Contraseña de la base de datos
ENV DB_USER_PASSWORD 4q5aws9120

#URL de la base de datos
ENV DB_URL dbinstancepsql.cpcargoodwy5.us-east-1.rds.amazonaws.com

#Puerto de la base de datos
ENV DB_PORT 5432

#Nombre de la base de datos
ENV DB_NAME dbpegasus

#IP del microservico para consultar los servicios externo -como el de los contenedores-
ENV EXTERNOS_URL externos

#PUERTO del microservico para consultar los servicios externo
ENV EXTERNOS_PORT 8092

#Variables de entorno---<END>

#Copiamos la aplicacion a nuestro directorio de trabajo
ADD TicketsHLP.jar  ${user_dir}/app.jar

#Se expone el puerto 8092 del servicio
EXPOSE 8092

#Se ejecuta siempre que se inicie el contenedor
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Dspring.profiles.active=prod","/home/fenix/app.jar"]