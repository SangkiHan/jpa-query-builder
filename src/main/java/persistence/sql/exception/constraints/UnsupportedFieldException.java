package persistence.sql.exception.constraints;

import java.lang.reflect.Field;

public class UnsupportedFieldException extends RuntimeException {

    public UnsupportedFieldException(Field field) {
        super("Unsupported Field " + field.getName());
    }
}
