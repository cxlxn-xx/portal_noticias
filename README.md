
# Portal de Noticias 

El sistema permite gestionar Usuarios, Roles, Autores, Especialidades, Temas y Publicaciones (incluyendo sus Links, Tags, Archivos e Imágenes). 


#### Diagrama de Clases
diagrama creado en https://www.planttext.com/
<img width="1841" height="562" alt="diagrama_portal" src="https://github.com/user-attachments/assets/4b2f4407-ad5b-4e4e-a1a0-eadeb58b3df4" />



**El sistema fue diseñado contemplando dos perfiles:**
Perfil Público (portal/publico`): Página de inicio donde se pueden ver  las últimas noticias publicadas
Perfil Restringido (login/portal/admin`): Panel de administración protegido


#### Maquetación de un Proyecto Web
Se utilizó una implementación MVC Modelo-Vista-Controlador con Spring Boot, cumpliendo con las siguientes capas:
   "entities": Modelocon anotaciones JPA (relaciones OneToMany, ManyToOne, ManyToMany).
   "dao": Interfaces para el acceso a datos (JpaRepository).
   "services" e "servicesimp": Lógica de negocio e inyección de dependencias.
   "controller": Controladores REST y controladores de vistas

####  capas del Back End
Se implementaron 12 entidades:
*   Roles, Usuarios.
*   Autores, Especialidades, Teléfonos, Emails.
*   Temas, Publicaciones, PublicacionAutores (para relación Muchos a Muchos), Links, Archivos, Imágenes, Tags.

####  Front End
El Front End se desarrolló con el motor de plantillas Thymeleaf y Bootstrap 5
   "login.html": Formulario de inicio de sesión.
   "publico/index.html": Vista pública con las tarjetas de noticias.
   "admin/lista.html": Tabla de administración para gestionar publicaciones.
   "admin/publicacion-form.html": Formulario para dar de alta nuevas noticias.

#### Integración
La integración incluyó la configuración de **Spring Security**, donde se implementó un "UserDetailsService"
personalizado para buscar usuarios en la base de datos y se encriptaron las contraseñas con BCrypt, tambien se configuró un "DataInitializer" 
que genera el usuario "admin" inicial de forma automática.


##  Tecnologías Utilizadas
*   **Lenguaje:** Java 17
*   **Framework:** Spring Boot 3.2.5 (Web, Data JPA, Security)
*   **Base de Datos:** MySQL
*   **Motor de Plantillas:** Thymeleaf + Bootstrap 5
*   **Testing:** JUnit 5, Mockito, MockMvc
*   **Empaquetado:** Maven

#### Prueba (Perfil Restringido)
El sistema crea automáticamente este usuario al iniciar por primera vez:

Usuario: admin

Clave: admin123
