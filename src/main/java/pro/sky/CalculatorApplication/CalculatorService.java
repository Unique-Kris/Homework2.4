package pro.sky.CalculatorApplication;

public interface CalculatorService {
    String hello();

    Integer plus(Integer num1, Integer num2);

    Integer minus(Integer num1, Integer num2);

    Integer multiply(Integer num1, Integer num2);

    Integer divide(Integer num1, Integer num2);
}