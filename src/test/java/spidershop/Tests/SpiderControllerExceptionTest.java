package spidershop.Tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest(classes = com.spidershop.SpidershopApplication.class)
@AutoConfigureMockMvc
public class SpiderControllerExceptionTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenInvalidSpiderDto_thenReturnsBadRequest() throws Exception {
        String invalidJson = "{\"name\":\"\",\"age\":-1}";

        mockMvc.perform(post("/api/spiders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidJson))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.age").exists());
    }
}
