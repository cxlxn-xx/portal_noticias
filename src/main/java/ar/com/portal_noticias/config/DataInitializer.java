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
    private IRolesDao rolesDao; // 👈 Inyectamos el DAO de Roles

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

            // 👇 GUARDAMOS EL ROL PRIMERO EN LA BD
            rolesDao.save(rol);

            // 2. Creamos el Usuario
            Usuarios admin = new Usuarios();
            admin.setUsuario("admin");
            admin.setClave(passwordEncoder.encode("admin123"));
            admin.setNombre("Administrador");
            admin.setEstado("ACTIVO");
            admin.setRol(rol); // Ahora el rol ya existe

            // 3. Guardamos el Usuario
            usuarioDao.save(admin);

            System.out.println("✅ USUARIO ADMIN CREADO EXITOSAMENTE");
            System.out.println("👤 Usuario: admin");
            System.out.println("🔑 Contraseña: admin123");

        }
    }
}