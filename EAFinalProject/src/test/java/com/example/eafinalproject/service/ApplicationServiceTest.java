package com.example.eafinalproject.service;

import com.example.eafinalproject.controller.ApplicationController;
import com.example.eafinalproject.entities.Application;
import com.example.eafinalproject.repository.ApplicationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@WebMvcTest(ApplicationController.class)
@ActiveProfiles("test")
public class ApplicationServiceTest {

    @MockBean
    private ApplicationRepository applicationRepository;

    @MockBean
    private ApplicationService applicationService;

    @Test
    public void testGetApplication() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Application application = objectMapper.readValue(new File("src/test/resources/jsonFiles/Application.json"),Application.class);
        Mockito.when(applicationRepository.findById(anyInt())).thenReturn(Optional.ofNullable(application));
        Application application1 = applicationService.getApplication(1);
        Assertions.assertThat(application.equals(application1));
    }

    @Test
    public void testSaveApplication() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Application application = objectMapper.readValue(new File("src/test/resources/jsonFiles/Application.json"),Application.class);
        Mockito.when(applicationRepository.save(Mockito.any())).thenReturn(application);
        Application application1 = applicationService.save(application);
        Assertions.assertThat(application.equals(application1));
    }

    @Test
    public void testDeleteApplication() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Application application = objectMapper.readValue(new File("src/test/resources/jsonFiles/Application.json"),Application.class);
        doNothing().when(applicationRepository).deleteById(anyInt());
        applicationService.deleteApplication(anyInt());
        verify(applicationRepository, VerificationModeFactory.times(0)).deleteById(anyInt());
    }



}
