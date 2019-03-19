package manager.action;

import manager.service.ILoginService;
import manager.serviceImpl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        // 从登录页面传递过来的直
        String manageid = request.getParameter("manageId");
        String pwd = request.getParameter("password");
        String loginwrong = "nologinwrong";
        //控制器调用服务层
        ILoginService iLoginService = new LoginServiceImpl();
        if(iLoginService.isLogin(manageid,pwd)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("manageid",manageid);
            response.sendRedirect("/websites/manager/managerWelcome.jsp");
        }
        else {
            loginwrong = "yesloginwrong";
            HttpSession session = request.getSession(true);
            session.setAttribute("wrongmanager1", loginwrong);
            response.sendRedirect("/websites/manager/managerLogin.jsp");
        }
        out.flush();
        out.close();
    }
}