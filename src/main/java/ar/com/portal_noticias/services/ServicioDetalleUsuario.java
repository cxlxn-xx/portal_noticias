package ar.com.portal_noticias.services;

import ar.com.portal_noticias.dao.IUsuariosDao;
import ar.com.portal_noticias.entities.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("servicioUsuario")
public class ServicioDetalleUsuario implements UserDetailsService {

    @Autowired
    private IUsuariosDao usuarioDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuarios usuario = usuarioDao.findByUsuario(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return User.builder()
                .username(usuario.getUsuario())
                .password(usuario.getClave())
                .authorities(List.of(new SimpleGrantedAuthority("ROLE_" + usuario.getRol().getDescripcion())))
                .build();
    }
}