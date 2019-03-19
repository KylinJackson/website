package manager.action;

import manager.model.User;
import manager.service.IUserService;
import manager.serviceImpl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {
    private IUserService iUserService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String username = request.getParameter("userName");
        String userpassword = request.getParameter("userPassword");
        String usersex = request.getParameter("userSex");
        String usertel = request.getParameter("userTel");
        String useremail = request.getParameter("userEmail");

        String flag = request.getParameter("flag");
        if(flag.equals("alterUser")) {
            String userid = request.getParameter("userId");
            User user = new User();
            user.setUserId(userid);
            user.setUserName(username);
            user.setUserPassword(userpassword);
            user.setUserSex(usersex);
            user.setUserTel(usertel);
            user.setUserEmail(useremail);
            if(iUserService.alterUser(user)) {
                response.sendRedirect("/servlet/UserServlet?flag=showAllUsers");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String flag = request.getParameter("flag");

        if(flag.equals("showAllUsers")){
            showAllUsers(request,response);
        }
        else if(flag.equals("freezeUser")) {
           String id = request.getParameter("userId");
           freezeUser(request,response,id);
        }
        else if(flag.equals("cancelFreeze")) {
            String id = request.getParameter("userId");
            cancelFreeze(request,response,id);
        }
        else if(flag.equals("search")) {
            String userid = request.getParameter("userId");
            searchUserByType(request,response,userid);
        }
    }

    public void searchUserByType(HttpServletRequest request,HttpServletResponse response,String typeId) {
        List<User> userList = iUserService.searchUserByType(typeId);
        HttpSession session = request.getSession(true);
        session.setAttribute("UserList",userList);
        RequestDispatcher rd = request.getRequestDispatcher("/websites/manager/alterUser.jsp");
        try {
            rd.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAllUsers(HttpServletRequest request,HttpServletResponse response) {
        List<User> userList = iUserService.getUsers();
        HttpSession session = request.getSession(true);
        session.setAttribute("UserList",userList);
        RequestDispatcher rd = request.getRequestDispatcher("/websites/manager/userdangan.jsp");
        try {
            rd.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void freezeUser(HttpServletRequest request,HttpServletResponse response,String userId) {
        if(iUserService.freezeUserById(userId)) {
            try {
                response.sendRedirect("/servlet/UserServlet?flag=showAllUsers");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void cancelFreeze(HttpServletRequest request,HttpServletResponse response,String userId) {
        if(iUserService.cancelFreezeById(userId)) {
            try {
                response.sendRedirect("/servlet/UserServlet?flag=showAllUsers");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
