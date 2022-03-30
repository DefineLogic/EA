package com.example.eafinalproject.controller;

import com.example.eafinalproject.entities.Application;
import com.example.eafinalproject.service.ApplicationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ApplicationController.class)
@ActiveProfiles("test")
public class ApplicationControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ApplicationService applicationService;


    @Test
    public void testGetApplications() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Application application = objectMapper.readValue(new File("src/test/resources/jsonFiles/Application.json"),Application.class);
        List<Application> applicationList = new ArrayList<>();
        applicationList.add(application);
        given(applicationService.getAllApplication()).willReturn(applicationList);
        mvc.perform(MockMvcRequestBuilders.get("/applications"))
                .andExpect(status().isOk());
        verify(applicationService, VerificationModeFactory.times(1)).getAllApplication();
        reset(applicationService);
    }

    @Test
    public void testGetApplication() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Application application = objectMapper.readValue(new File("src/test/resources/jsonFiles/Application.json"),Application.class);
        given(applicationService.getApplication(anyInt())).willReturn(application);
        mvc.perform(MockMvcRequestBuilders.get("/applications/{applicationId}",1))
                .andExpect(status().isOk());
        verify(applicationService, VerificationModeFactory.times(1)).getApplication(anyInt());
        reset(applicationService);
    }

    @Test
    public void testCreateApplication() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Application application = objectMapper.readValue(new File("src/test/resources/jsonFiles/Application.json"),Application.class);
        given(applicationService.save(Mockito.any())).willReturn(application);
        mvc.perform(MockMvcRequestBuilders.post("/applications")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(application)));
        verify(applicationService, VerificationModeFactory.times(1)).save(Mockito.any());
        reset(applicationService);
    }

    @Test
    public void testUpdateApplication() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Application application = objectMapper.readValue(new File("src/test/resources/jsonFiles/Application.json"),Application.class);
        given(applicationService.save(Mockito.any())).willReturn(application);
        given(applicationService.getApplication(anyInt())).willReturn(application);
        mvc.perform(MockMvcRequestBuilders.put("/applications/{applicationId}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(application)));
        verify(applicationService, VerificationModeFactory.times(1)).save(Mockito.any());
        reset(applicationService);
    }

    @Test
    public void testDeleteApplication() throws Exception {
        doNothing().when(applicationService).deleteApplication(anyInt());
        mvc.perform(MockMvcRequestBuilders.delete("/applications/{applicationId}",1));
        verify(applicationService, VerificationModeFactory.times(1)).deleteApplication(anyInt());
        reset(applicationService);
    }



}

