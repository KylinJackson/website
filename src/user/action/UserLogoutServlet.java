package user.action;

import user.service.IUserLogoutService;
import user.serviceImpl.UserLogoutServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kylin on 17-7-9.
 */
public class UserLogoutServlet extends HttpServlet {
    IUserLogoutService iUserLogoutService = new UserLogoutServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String userId = request.getParameter("userId");
        if (iUserLogoutService.logout(userId)) {
            response.sendRedirect("/websites/user/userLogin.jsp");
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
    }
}
