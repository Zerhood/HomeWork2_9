package skypro.calculator.exception;

import org.springframework.stereotype.Service;

@Service
public class ExceptionHandlerImp implements ExceptionHandler {
    @Override
    public boolean matchZero(int a) {
        return a != 0;
    }

    @Override
    public String isMatchZero() {
        return "Делить на ноль нельзя!";
    }

    @Override
    public boolean matchNotNull(Object a) {
        return a != null;
    }

    @Override
    public String isNull() {
        return "Одно из полей пустое!";
    }
}