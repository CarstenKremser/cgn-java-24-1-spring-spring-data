package de.carstenkremser.neuefische.asterix;

import de.carstenkremser.neuefische.asterix.model.Character;
import de.carstenkremser.neuefische.asterix.repo.CharacterRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class CharacterIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CharacterRepo characterRepo;


    @Test
    public void getAll_whenCalledInitially_returnsEmptyList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/asterix/characters"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

    @Test
    public void getCharacterById_whenCalledWith1_returnsCharacter1() throws Exception {
        Character character1 = new Character(
                "1",
                "Character1Name",
                99,
                "Character1Profession");
        characterRepo.save(character1);

        mockMvc.perform(MockMvcRequestBuilders.get("/asterix/characters/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("""
                            {
                                "id":"1",
                                "name":"Character1Name",
                                "age":99,
                                "profession":"Character1Profession"
                            }
                        """));
    }

}
