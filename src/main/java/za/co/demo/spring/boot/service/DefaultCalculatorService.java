package za.co.demo.spring.boot.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile({"dev", "prod"})
public class DefaultCalculatorService implements CalculatorService {

    @Override
    public double calculate(int total, int correct) {
        double result = ((double) correct / total) * 100d;
        return result;
    }
}
