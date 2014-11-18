package za.co.demo.spring.boot.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
//@Primary
public class TestCalculatorService implements CalculatorService {

    @Override
    public double calculate(int total, int correct) {
        return 10;
    }

}
