package user.action;

import user.model.User;
import user.service.IUserLoginService;
import user.serviceImpl.UserLoginServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserAlterServlet extends HttpServlet {
    private IUserLoginService iUserService=new UserLoginServiceImpl();
    private ResultSet rs=null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String flag=request.getParameter("flag");
        if(flag.equals("alteruser")){
            String userId=request.getParameter("userId");
            String userName=request.getParameter("userName");
            String userSex=request.getParameter("userSex");
            String userTel=request.getParameter("userTel");
            String userEmail=request.getParameter("userEmail");
            if(iUserService.alterUsers(userId,userName,userSex,userTel,userEmail))
                response.sendRedirect("/websites/user/userWelcome.jsp");
        }
        else if(flag.equals("alterpassword")){
            String userId=request.getParameter("userId");
            String userPassword=request.getParameter("userPassword");
            String previous=request.getParameter("previous");
System.out.println(previous);
            String userPassword1=request.getParameter("new1");
            if(userPassword.equals(previous))
            {
                String wrong1 = "no";
                HttpSession session = request.getSession(true);
                session.setAttribute("wrong1", wrong1);
                if(iUserService.alterPassword(userId,userPassword1))
                    response.sendRedirect("/websites/user/userLogin.jsp");
            }
            else {
                String wrong="yes";
                HttpSession session=request.getSession(true);
                session.setAttribute("wrong",wrong);
                response.sendRedirect("/websites/user/modifyPassword.jsp");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String userId=request.getParameter("userId");
        String flag=request.getParameter("flag");
        List<User> userList=new ArrayList<User>();
        searchUserById(request,response,userId,userList);
        HttpSession session=request.getSession(true);
        session.setAttribute("UserList",userList);
        if(flag.equals("alteruser"))
        {
            RequestDispatcher rd=request.getRequestDispatcher("/websites/user/userModify.jsp");
            try {
                rd.forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if (flag.equals("alterpassword"))
        {
            RequestDispatcher rd=request.getRequestDispatcher("/websites/user/modifyPassword.jsp");
            try {
                rd.forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void searchUserById(HttpServletRequest request, HttpServletResponse response,String userId,List<User> userList)
    {
        rs=iUserService.searchUserByuserId(userId);
        try {
            while (rs.next()){
                String userId1=rs.getString("userId");
                String userName1=rs.getString("userName");
                String userPassword1=rs.getString("userPassword");
                String userSex1=rs.getString("userSex");
                String userTel1=rs.getString("userTel");
                String userEmail1=rs.getString("userEmail");
                String userFreeze1=rs.getString("userFreeze");
                User user=new User();
                user.setUserId(userId1);
                user.setUserName(userName1);
                user.setUserPassword(userPassword1);
                user.setUserSex(userSex1);
                user.setUserTel(userTel1);
                user.setUserEmail(userEmail1);
                user.setUserFreeze(userFreeze1);
                userList.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
