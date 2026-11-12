package ar.com.portal_noticias.controller;

import ar.com.portal_noticias.entities.Temas;
import ar.com.portal_noticias.services.ITemasServices;
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

@WebMvcTest(TemasController.class)
@AutoConfigureMockMvc(addFilters = false)
public class TemasControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ITemasServices entityService;

    @Test
    public void testGetAllTemas() throws Exception {

        Temas tema1 = new Temas();
        tema1.setId(1);
        tema1.setNombre("Fútbol");
        tema1.setEstado("ACTIVO");

        Temas tema2 = new Temas();
        tema2.setId(2);
        tema2.setNombre("Economía");
        tema2.setEstado("ACTIVO");

        List<Temas> temas = Arrays.asList(tema1, tema2);


        given(entityService.getAll()).willReturn(temas);


        mockMvc.perform(get("/api/temas")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].nombre").value("Fútbol"))
                .andExpect(jsonPath("$[1].nombre").value("Economía"));
    }
}