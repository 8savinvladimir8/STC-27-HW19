package beans;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Класс {@code SysEnvVarsBean} является session бином EJB без состояния
 * и выводит системные переменные среды.
 * @author Savin Vladimir
 */
@Stateless
public class SysEnvVarsBean {

    /**
     * Метод возвращает строку с разделителями, содержащую системные переменные среды.
     * @return строка с системными переменными среды.
     */
    public String getAllSysEnvVars() {
        Map<String, String> sysEnvVars = System.getenv();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : sysEnvVars.entrySet()) {
            sb.append(entry.getKey()).append(" = ").append(entry.getValue()).append('\n');
        }
        return sb.toString();
    }

    /**
     * Метод возвращает значение указанной системной переменной среды,
     * либо сообщение, что переменная не существует.
     * @param varName имя переменной среды.
     * @return строка с найденной системной переменной среды, либо сообщение, что такой переменной нет.
     */
    public String getSysEnvVar(String varName) {
        Map<String, String> sysEnvVars = System.getenv();
        if (sysEnvVars.containsKey(varName.toUpperCase())) {
            return varName.toUpperCase() + " = " + sysEnvVars.get(varName.toUpperCase());
        }
        return varName.toUpperCase() + " - variable is not exists.";
    }

    /**
     * Метод возвращает список объектов с именами и значениями системнымх переменных среды.
     * @return список объектов с именами и значениями системнымх переменных среды.
     */
    public List<SysEnvVariable> getVars() {
        List<SysEnvVariable> sysEnvVariableList = new ArrayList<>();
        System.getenv().entrySet().stream()
            .map(entry -> new SysEnvVariable(entry.getKey(), entry.getValue()))
            .collect(Collectors.toCollection(() -> sysEnvVariableList));
        return sysEnvVariableList;
    }
}
