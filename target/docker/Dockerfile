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
ENV DB_USER_NAME postgres

#Contraseña de la base de datos
ENV DB_USER_PASSWORD desa2018rrollo

#URL de la base de datos
ENV DB_URL 192.168.70.166

#Puerto de la base de datos
ENV DB_PORT 5433

#Nombre de la base de datos
ENV DB_NAME desarrollo

#IP del microservico para consultar los servicios externo -como el de los contenedores-
ENV EXTERNOS_URL externos

#PUERTO del microservico para consultar los servicios externo
ENV EXTERNOS_PORT 8091

#Variables de entorno---<END>

#Copiamos la aplicacion a nuestro directorio de trabajo
ADD TicketsHLP 1.0-SNAPSHOT.jar  ${user_dir}/app.jar

#Se expone el puerto 8091 del servicio
EXPOSE 8091

#Se ejecuta siempre que se inicie el contenedor
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Dspring.profiles.active=prod","/home/fenix/app.jar"]