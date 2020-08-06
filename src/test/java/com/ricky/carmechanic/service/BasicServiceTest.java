package com.ricky.carmechanic.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@SpringBootTest
public class BasicServiceTest {

    Object savePoint;

    Gson gson = new GsonBuilder().create();

    @BeforeEach
    void CreateTransactionPoint () {
        savePoint = TransactionAspectSupport.currentTransactionStatus().createSavepoint();
    }

    @AfterEach
    void RollbackTransactionPoint() {
        TransactionAspectSupport.currentTransactionStatus().rollbackToSavepoint(savePoint);
    }
}
