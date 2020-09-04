package com.sen.patrimoine.snpatrimoine;

import com.sen.patrimoine.snpatrimoine.controller.HeritageController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class HeritageControllerTest {

    @Autowired
    private HeritageController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}
