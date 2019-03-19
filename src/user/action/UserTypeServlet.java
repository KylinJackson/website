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
import java.util.ArrayList;
import java.util.List;

/*
 * Created by kylin on 17-7-11.
 */
public class UserTypeServlet extends HttpServlet {
    IUserTypeService iUserTypeService = new UserTypeServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String flag = request.getParameter("flag");
        if (flag.equals("Type")) {
            type(request, response);
        }

    }

    private void type(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int type = Integer.parseInt(request.getParameter("type"));
        String userId = request.getParameter("userId");
        List<Publish> publishList = new ArrayList<>();
        publishList = iUserTypeService.showArticlesByType(type);

        HttpSession session = request.getSession(true);
        session.setAttribute("publishList", publishList);
        session.setAttribute("userId", userId);
        session.setAttribute("type", publishList.get(0).getPublishcolumnsId());
        response.sendRedirect("/websites/user/showType.jsp");

    }
}
