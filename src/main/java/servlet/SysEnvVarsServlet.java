package servlet;

import beans.SysEnvVarsBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Класс {@code SysEnvVarsServlet} представляет собой сервлет,
 * служащий для вывода системных переменных среды.
 * @author Savin Vladimir
 */
@WebServlet("/SysEnvVars")
public class SysEnvVarsServlet extends HttpServlet {
    @EJB
    private SysEnvVarsBean sysEnvVarsBean;

    /**
     * Метод GET - выводит все переменные либо указанную,
     * используя методы бина EJB.
     * @param req инкапсулирует всю информацию о запросе.
     * @param resp позволяет управлять ответом.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        try {
            String varName = req.getParameter("varname");
            if (varName.equals("")) {
                resp.getWriter().write(sysEnvVarsBean.getAllSysEnvVars());
            } else {
                resp.getWriter().write(sysEnvVarsBean.getSysEnvVar(varName));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод POST - выводит все переменные в виде таблицы,
     * используя JSP страницу.
     * @param req инкапсулирует всю информацию о запросе.
     * @param resp позволяет управлять ответом.
     * @throws ServletException сервлет исключение.
     * @throws IOException исключение ввода-вывода.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            getServletContext()
                    .getRequestDispatcher("/sysvars.jsp")
                    .forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
