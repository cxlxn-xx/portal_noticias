package ar.com.portal_noticias.controller;

import ar.com.portal_noticias.entities.Autores;
import ar.com.portal_noticias.services.IAutoresServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AutoresController.class)
@AutoConfigureMockMvc(addFilters = false)
public class AutoresControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IAutoresServices entityService;

    @Test
    public void testGetAllAutores() throws Exception {

        Autores autor1 = new Autores();
        autor1.setId(1);
        autor1.setNombre("Juan");
        autor1.setApellido("Perez");

        Autores autor2 = new Autores();
        autor2.setId(2);
        autor2.setNombre("Maria");
        autor2.setApellido("Lopez");

        List<Autores> autores = Arrays.asList(autor1, autor2);


        given(entityService.getAll()).willReturn(autores);


        mockMvc.perform(get("/api/autores")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].nombre").value("Juan"))
                .andExpect(jsonPath("$[0].apellido").value("Perez"))
                .andExpect(jsonPath("$[1].nombre").value("Maria"));
    }
}