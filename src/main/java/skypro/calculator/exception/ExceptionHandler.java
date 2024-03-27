package skypro.calculator.exception;

public interface ExceptionHandler {
    boolean matchZero(int a);
    String isMatchZero();
    boolean matchNotNull(Object a);
    String isNull();
}