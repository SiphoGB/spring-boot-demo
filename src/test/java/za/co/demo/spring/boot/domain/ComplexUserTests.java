package za.co.demo.spring.boot.domain;


import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import za.co.demo.spring.boot.TestApplication;
import za.co.demo.spring.boot.service.CalculatorService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplication.class)
@Transactional
@ActiveProfiles("test")
public class ComplexUserTests {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    public void testGetUser() {
        assertEquals(10d, calculatorService.calculate(100, 100), 0d);
    }

}
