package user.action;

import user.model.Publish;
import user.service.IUserTypeService;
import user.serviceImpl.UserTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserLinkServlet extends HttpServlet {
    IUserTypeService iUserTypeService = new UserTypeServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String userId = request.getParameter("userId");
        int publishId = Integer.parseInt(request.getParameter("publishId"));

        Publish publish = iUserTypeService.showArticlesById(publishId);

        HttpSession session = request.getSession(true);
        session.setAttribute("publish", publish);
        session.setAttribute("userId", userId);
        response.sendRedirect("/websites/user/showPublish.jsp");
    }
}
