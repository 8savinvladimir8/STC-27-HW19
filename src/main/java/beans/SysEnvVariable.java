package beans;

import java.io.Serializable;

/**
 * Класс {@code SysEnvVariable} представляет информацию о системной переменной среды,
 * является классом Java Bean и реализует интерфейс Serializable.
 * @author Savin Vladimir
 */
public class SysEnvVariable implements Serializable {
    private static final long serialVersionUID = 2041275512219239990L;
    private final String name;
    private final String value;

    public SysEnvVariable(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
