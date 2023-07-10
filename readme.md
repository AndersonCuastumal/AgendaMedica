# Agenda Médica

## Descripción
Se desarrollo una aplicación web de una agenda médica utilizando Java, Spring Boot y una base de datos relacional (MySQL). La aplicación permite gestionar pacientes, médicos y citas médicas.

1. Características generales de interfaz:

    ### Inicio de sesión
    Esta captura de pantalla muestra la página de inicio de sesión de la aplicación. Se requiere ingresar un correo electrónico y una contraseña válidos para acceder a los servicios, los serivicios brindados son diferentes para los roles administrador y paciente. 
    ![Login](/imagenes_administrador/Login.png)

    ### Listado de Pacientes
    En esta captura de pantalla, se muestra el listado de todos los pacientes registrados en la base de datos. La lista se presenta con paginación para facilitar la navegación.
    ![Listado pacientes](/imagenes_administrador/Home_Admin.png)


    ### Registrar Nuevo Paciente
    Aquí se puede ver la interfaz para registrar un nuevo paciente en la aplicación. 
    ![Registrar nuevo paciente](/imagenes_administrador/crear_paciente.png)

    ### Editar Paciente
    En esta captura de pantalla se muestra la funcionalidad de edición de un paciente.
    ![editar paciente](/imagenes_administrador/editar_paciente.png)


    ### Eliminar Paciente
    La función de eliminar pacientes permite eliminar de la base de datos un paciente en específico. En esta captura se muestra la confirmación de eliminación del paciente.
    ![eliminar paciente](/imagenes_administrador/eliminar_paciente.png)

    ### Listado de Medicos
    En esta captura de pantalla, se muestra el listado de todos los medicos registrados en la base de datos. La lista se presenta con paginación para facilitar la navegación.
    ![Listado medicos](/imagenes_administrador/Lista_medicos.png)

    ### Registrar Nuevo medico
    Aquí se puede ver la interfaz para registrar un nuevo medico en la aplicación. 
    ![Registrar nuevo medico](/imagenes_administrador/crear_medico.png)

    ### Editar medico
    En esta captura de pantalla se muestra la funcionalidad de edición de un medico.
    ![editar medico](/imagenes_administrador/editar_medico.png)


    ### Eliminar Medico
    La función de eliminar medicos permite eliminar de la base de datos un medico en específico. En esta captura se muestra la confirmación de eliminación del medico.
    ![eliminar medico](/imagenes_administrador/eliminar_medico.png)

    ### Listado de citas
    En esta captura de pantalla, se muestra el listado de citas registradas correspondiente por cada medico o paciente. 
    ![Listado citas](/imagenes_user/home_paciente_perfil.png)

    ### Solicitar Cita Medica
    Aquí se puede ver la interfaz para agendar una cita medica dependiendo del dia y el medico se obtendran diferentes horarios disponibles. 
    ![Registrar cita](/imagenes_administrador/crear_cita.png)

    ### Editar Cita Medica
    En esta captura de pantalla se muestra la funcionalidad de edición de citas.
    ![editar cita](/imagenes_administrador/editar_Cita.png)


    ### Cancelar cita
    La función de cancelar citas permite eliminar de la base de datos dicha cita por lo tanto el medico y paciente no tendran dicha cita en su listado. En esta captura se muestra la confirmación de cancelar cita.
    ![cancelar cita](/imagenes_user/cancelar_cita.png)



    Estas capturas de pantalla ofrecen una visión general de las diferentes funcionalidades de la aplicación.

    ## Funcionalidades
    La aplicación consta de los siguientes roles y funcionalidades: 

    ### Rol de Administrador
    - Autenticación de usuarios: El administrador puede iniciar sesión en la aplicación utilizando su correo electrónico y contraseña.
    - Gestión de pacientes: El administrador puede crear, consultar, modificar, activar e inactivar pacientes.
    - Gestión de médicos: El administrador puede crear, consultar, modificar, activar e inactivar médicos.
    - Gestión de citas: El administrador puede crear, consultar, modificar y cancelar citas de todos los pacientes.

    ### Rol de Paciente
    - Autenticación de usuarios: El paciente puede iniciar sesión en la aplicación utilizando su correo electrónico y contraseña.
    - Consulta de disponibilidad de citas: El paciente puede ver la disponibilidad de citas por cada médico.
    - Solicitud de citas: El paciente puede solicitar una cita con un médico.
    - Cancelación de citas: El paciente puede cancelar sus citas.


2. Características:

	2.1. Packaging: Jar, War
	2.2. Lenguaje de programacion: JAVA 8
	2.3. Motor BD: MySQL
	2.3. Framework: Spring Boot
	2.4. Proyecto: Maven 
	2.5. Frontend:thymeleaf
	2.6. Acceso BD: JPA
	2.7. Dependencias: Validation, SprinBoot Security, Spring Web,Thymeleaf,Spring Data JPA, MySQL Driver,Lombok,Spring Boot DevTools


3. Instalación:
	3.1. Descargar repositorio y Extraer los archivos contenidos en el "AgendaMedica-master.rar"
	3.2. Mediante el panel de control de MySQL Workbench configurar una nueva conexion.
    3.3. Ingresar credenciales de la base de datos user: root y password: admin
	3.4. Establecer conexion con la base de datos en MySQL Workbench y luego cargar o importar la base de datos "agendaDB.sql".
	3.5. Con el archivo ejecutable .jar "centro_medico_agenda.jar" es posible lanzar la aplicación de forma local dando doble CLICK sobre el archivo  o "abrir con" => "Java(TM) Platform SE binary".
	3.6. Abrir buscador (Chrome,Firefox,etc..) y pegar la ruta: "http://localhost:8080/". 
	3.7. Finalmente, La aplicación iniciara. 

4. Configuraciòn DB:
    4.1. ![paso 1](/imagenes_DB/paso1.png)
    4.2. ![paso 2](/imagenes_DB/paso2.png)
    4.3. ![paso 3](/imagenes_DB/paso3.png)
    4.4. ![paso 4](/imagenes_DB/paso4.png)
    4.5. ![paso 5](/imagenes_DB/paso5.png)
    4.6. ![paso 6](/imagenes_DB/paso6.png)
    4.7. ![paso 7](/imagenes_DB/paso7.png)


5. Consideraciones:
	5.1. Verificar antes de ejecutar el archivo ".jar" que el archivo "aplication.propierties" se encuentre en el mismo directorio.
	5.2. Verificar que la base de datos ".sql"se haya cargado exitosamente con todos sus datos.
    5.3. Metodo extra para ejecutar el archivo .jar "centro_medico_agenda.jar", se abre la consola en la carpeta raìz donde se encuentra el archivo y se ejecuta el comando: java -jar .\centro_medico_agenda.jar

## Contribución

Es posible crear nuevas características de valor a este proyecto donde el perfil medico pueda ser capaz de modificar, y cancelar citas medicas, este perfil tambien podria encargarse de gestionar sus propios horarios, crear, editar, consultar y eliminar. 

## Credenciales de inicio de sesión
### Perfil Administrador
- Correo: admin@admin.com
- Contraseña: 12345
### Perfil Paciente
- Correo: andres@email.com
- Contraseña: 12345

## Credeciales Base de datos MySQL
- user: root
- password: admin

## Contacto

Si tienes alguna pregunta o comentario, puedes contactarme a través de ander.ch95@gmail.com o [LinkedIn](https://www.linkedin.com/in/andersoncuastumal/).
