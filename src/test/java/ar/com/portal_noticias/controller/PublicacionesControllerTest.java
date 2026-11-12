package ar.com.portal_noticias.controller;

import ar.com.portal_noticias.entities.Publicaciones;
import ar.com.portal_noticias.services.IPublicacionesServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PublicacionesController.class)
@AutoConfigureMockMvc(addFilters = false)
public class PublicacionesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IPublicacionesServices entityService;

    @Test
    public void testGetAllPublicaciones() throws Exception {

        Publicaciones pub1 = new Publicaciones();
        pub1.setId(1);
        pub1.setTitulo("Boca ganó el superclásico");
        pub1.setFechaPublicacion(LocalDate.of(2026, 11, 12));
        pub1.setPrioridad("ALTA");
        pub1.setEstado("PUBLICADA");

        Publicaciones pub2 = new Publicaciones();
        pub2.setId(2);
        pub2.setTitulo("La inflación bajó");
        pub2.setFechaPublicacion(LocalDate.of(2026, 11, 10));
        pub2.setPrioridad("MEDIA");
        pub2.setEstado("PUBLICADA");

        List<Publicaciones> publicaciones = Arrays.asList(pub1, pub2);


        given(entityService.getAll()).willReturn(publicaciones);


        mockMvc.perform(get("/api/publicaciones")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].titulo").value("Boca ganó el superclásico"))
                .andExpect(jsonPath("$[0].prioridad").value("ALTA"))
                .andExpect(jsonPath("$[1].titulo").value("La inflación bajó"));
    }
}