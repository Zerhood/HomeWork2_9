package skypro.calculator.service;

import org.springframework.stereotype.Service;
import skypro.calculator.exception.ExceptionHandler;
import skypro.calculator.exception.IllegalArgumentEx;

import java.text.DecimalFormat;

@Service
public class CalculatorServiceImp implements CalculatorService {

    DecimalFormat format = new DecimalFormat("#,##");

    public String startMethod() {
        return "Добро пожаловать в калькулятор";
    }

    public int plusMethod(int one, int two) {
        return one + two;
    }

    public int minusMethod(int one, int two) {
        return one - two;
    }

    public int multiplyMethod(int one, int two) {
        return one * two;
    }

    public double divideMethod(int one, int two) {
        if (two == 0) {
            throw new IllegalArgumentEx("Делить на ноль нельзя!");
        }
        double result = (double) one / two;
        return Double.parseDouble(format.format(result));
    }
}