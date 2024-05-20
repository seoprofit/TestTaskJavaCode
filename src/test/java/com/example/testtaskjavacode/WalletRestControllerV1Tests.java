package com.example.testtaskjavacode;

import com.example.testtaskjavacode.DAO.Wallet;
import com.example.testtaskjavacode.DTO.WalletDTO;
import com.example.testtaskjavacode.repository.WalletRepository;
import com.example.testtaskjavacode.service.WalletServiceImpl;
import com.example.testtaskjavacode.utils.LoadDatabase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.util.UUID;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest

@AutoConfigureMockMvc
class WalletRestControllerV1Tests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private WalletServiceImpl walletServiceImpl;


    @Test
    public void getAllWalletsTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/wallets")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].uuid").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.[*].amount").isNotEmpty());
    }


    @Test
    public void getNewWalletTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/addwallet")
                        .content("{\"uuid\":\"c302ea4b-5c88-413b-aa26-813baf374465\",\"amount\":5000}")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.amount").exists());
    }


    @Test
    public void getWalletBalanceTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/wallets/c302ea4b-5c88-413b-aa26-813baf374460")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.amount").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.uuid").isNotEmpty());
    }


}
