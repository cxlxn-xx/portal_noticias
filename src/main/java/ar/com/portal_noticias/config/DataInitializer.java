package ar.com.portal_noticias.config;

import ar.com.portal_noticias.dao.IRolesDao;
import ar.com.portal_noticias.dao.IUsuariosDao;
import ar.com.portal_noticias.entities.Roles;
import ar.com.portal_noticias.entities.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private IUsuariosDao usuarioDao;

    @Autowired
    private IRolesDao rolesDao; 

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Verificamos si el usuario admin ya existe
        if (usuarioDao.findByUsuario("admin").isEmpty()) {

            // 1. Creamos el Rol
            Roles rol = new Roles();
            rol.setDescripcion("ADMIN");
            rol.setNivel(1);

          
            rolesDao.save(rol);

            
            Usuarios admin = new Usuarios();
            admin.setUsuario("admin");
            admin.setClave(passwordEncoder.encode("admin123"));
            admin.setNombre("Administrador");
            admin.setEstado("ACTIVO");
            admin.setRol(rol);

            usuarioDao.save(admin);

            System.out.println("USUARIO ADMIN CREADO EXITOSAMENTE");
            System.out.println(" Usuario: admin");
            System.out.println(" Contraseña: admin123");

        }
    }
}
