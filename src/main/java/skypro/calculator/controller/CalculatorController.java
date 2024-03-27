package skypro.calculator.controller;


import org.springframework.web.bind.annotation.*;
import skypro.calculator.exception.ExceptionHandler;
import skypro.calculator.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final CalculatorService service;
    private final ExceptionHandler handler;

    public CalculatorController(CalculatorService service,
                                ExceptionHandler handler) {
        this.service = service;
        this.handler = handler;
    }

    @GetMapping
    public String initMethod() {
        return service.startMethod();
    }

    @GetMapping("/plus")
    public String plusMethod(@RequestParam(value = "num1", required = false) Integer one,
                             @RequestParam(value = "num2", required = false) Integer two) {
        int result;
        if (handler.matchNotNull(one) && handler.matchNotNull(two)) {
            result = service.plusMethod(one, two);
        } else {
            return handler.isNull();
        }
        return one + " + " + two + " = " + result;
    }

    @GetMapping("/minus")
    public String minusMethod(@RequestParam(value = "num1", required = false) Integer one,
                              @RequestParam(value = "num2", required = false) Integer two) {
        int result;
        if (handler.matchNotNull(one) && handler.matchNotNull(two)) {
            result = service.minusMethod(one, two);
        } else {
            return handler.isNull();
        }
        return one + " - " + two + " = " + result;
    }

    @GetMapping("multiply")
    public String multiplyMethod(@RequestParam(value = "num1", required = false) Integer one,
                                 @RequestParam(value = "num2", required = false) Integer two) {
        int result;
        if (handler.matchNotNull(one) && handler.matchNotNull(two)) {
            result = service.multiplyMethod(one, two);
        } else {
            return handler.isNull();
        }
        return one + " * " + two + " = " + result;
    }

    @GetMapping("/divide")
    public String divideMethod(@RequestParam(value = "num1", required = false) Integer one,
                               @RequestParam(value = "num2", required = false) Integer two) {
        double result;
        if (handler.matchNotNull(one) && handler.matchNotNull(two)) {
            result = service.divideMethod(one, two);
        } else {
            return handler.isNull();
        }
        return one + " / " + two + " = " + result;
    }
}