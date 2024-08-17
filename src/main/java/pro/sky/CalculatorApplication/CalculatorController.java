package pro.sky.CalculatorApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    private final CalculatorServiceImpl calculatorService;

    public CalculatorController(CalculatorServiceImpl calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping(path = "/calculator")
    public String hello() {
        return calculatorService.hello();
    }

    @GetMapping(path = "/plus")
    public String plusNumbers(@RequestParam Integer num1, @RequestParam Integer num2) {
        int result = calculatorService.plus(num1, num2);
        return message(num1, num2, '*', result);
    }

    @GetMapping(path = "/minus")
    public String minusNumbers(@RequestParam Integer num1, @RequestParam Integer num2) {
        int result = calculatorService.minus(num1, num2);
        return message(num1, num2, '-', result);
    }

    @GetMapping(path = "/multiply")
    public String multiplyNumbers(@RequestParam Integer num1, @RequestParam Integer num2) {
        int result = calculatorService.multiply(num1, num2);
        return message(num1, num2, '*', result);
    }

    @GetMapping(path = "/divide")
    public String divideNumbers(@RequestParam Integer num1, @RequestParam Integer num2) {
        if (num2 == 0) {
            return "Делить на 0 нельзя";
        }
        int result = calculatorService.divide(num1, num2);
        return message(num1, num2, '/', result);
    }

    private String message(Integer num1, Integer num2, char action, int result) {
        return String.format("%d %c %d = %d", num1, action, num2, result);
    }
}