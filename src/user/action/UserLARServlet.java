package user.action;

import user.model.Publish;
import user.model.User;
import user.service.IUserLoginService;
import user.service.IUserLogoutService;
import user.serviceImpl.UserLoginServiceImpl;
import user.serviceImpl.UserLogoutServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * Created by lenovo on 2017/7/8.
 */
public class UserLARServlet extends HttpServlet {

    private IUserLoginService iUserService=new UserLoginServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String flag=request.getParameter("flag");
        if(flag.equals("UserLogin")){
                String userId=request.getParameter("userId");
                String userPassword=request.getParameter("password");
                ResultSet rs=iUserService.isLogin(userId,userPassword);
                if (iUserService.searchlogoutByUId(userId))
                {
                    IUserLogoutService iUserLogout=new UserLogoutServiceImpl();
                    iUserLogout.logout(userId);
                }
                if(iUserService.isLogin(userId,userPassword)!=null) {
                /* created by kylin */
                    List<Integer> integerList = new ArrayList<Integer>();
                    integerList = iUserService.isSubs(userId);
                    boolean sub1 = false, sub2 = false, sub3 = false, sub4 = false;
                    sub1 = integerList.contains(1);
                    sub2 = integerList.contains(2);
                    sub3 = integerList.contains(3);
                    sub4 = integerList.contains(4);

                    List<Publish> pub = new ArrayList<Publish>();
                    pub = iUserService.showAllPubs();
                    List<Publish> pub1 = new ArrayList<Publish>();
                    List<Publish> pub2 = new ArrayList<Publish>();
                    List<Publish> pub3 = new ArrayList<Publish>();
                    List<Publish> pub4 = new ArrayList<Publish>();

                    for (int i = 0; i < pub.size(); i++) {
                        if (pub.get(i).getPublishcolumnsId() == 1) pub1.add(pub.get(i));
                        if (pub.get(i).getPublishcolumnsId() == 2) pub2.add(pub.get(i));
                        if (pub.get(i).getPublishcolumnsId() == 3) pub3.add(pub.get(i));
                        if (pub.get(i).getPublishcolumnsId() == 4) pub4.add(pub.get(i));
                    }

                    HttpSession session = request.getSession(true);
                    session.setAttribute("pub1", pub1);
                    session.setAttribute("pub2", pub2);
                    session.setAttribute("pub3", pub3);
                    session.setAttribute("pub4", pub4);
                    session.setAttribute("sub1", sub1);
                    session.setAttribute("sub2", sub2);
                    session.setAttribute("sub3", sub3);
                    session.setAttribute("sub4", sub4);
            /* created by kylin */
                    session.setAttribute("userId",userId);
                    response.sendRedirect("/websites/user/userWelcome.jsp");
                }
                else
                {
                    String wrong1 = "yes";
                    HttpSession session = request.getSession(true);
                    session.setAttribute("wrong1", wrong1);
                    response.sendRedirect("/websites/user/userLogin.jsp");
                }
        }
        else if(flag.equals("UserRegister"))
        {
            String userId=request.getParameter("userId");
            String userName=request.getParameter("userName");
            String userPassword=request.getParameter("password1");
            String userSex=request.getParameter("userSex");
            String userTel=request.getParameter("userTel");
            String userEmail=request.getParameter("userEmail");
            User user=new User(userId,userName,userPassword,userSex,userTel,userEmail,"no");
            if(iUserService.addUsers(user))
            {
                response.sendRedirect("/websites/user/userLogin.jsp");
            }
            else
            {
                response.sendRedirect("/websites/user/userRegister.jsp");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String userId=request.getParameter("userId");
                /* created by kylin */
            List<Integer> integerList = new ArrayList<Integer>();
            integerList = iUserService.isSubs(userId);
            boolean sub1 = false, sub2 = false, sub3 = false, sub4 = false;
            sub1 = integerList.contains(1);
            sub2 = integerList.contains(2);
            sub3 = integerList.contains(3);
            sub4 = integerList.contains(4);

            List<Publish> pub = new ArrayList<Publish>();
            pub = iUserService.showAllPubs();
            List<Publish> pub1 = new ArrayList<Publish>();
            List<Publish> pub2 = new ArrayList<Publish>();
            List<Publish> pub3 = new ArrayList<Publish>();
            List<Publish> pub4 = new ArrayList<Publish>();

            for (int i = 0; i < pub.size(); i++) {
                if (pub.get(i).getPublishcolumnsId() == 1) pub1.add(pub.get(i));
                if (pub.get(i).getPublishcolumnsId() == 2) pub2.add(pub.get(i));
                if (pub.get(i).getPublishcolumnsId() == 3) pub3.add(pub.get(i));
                if (pub.get(i).getPublishcolumnsId() == 4) pub4.add(pub.get(i));
            }

            HttpSession session = request.getSession(true);
            session.setAttribute("pub1", pub1);
            session.setAttribute("pub2", pub2);
            session.setAttribute("pub3", pub3);
            session.setAttribute("pub4", pub4);
            session.setAttribute("sub1", sub1);
            session.setAttribute("sub2", sub2);
            session.setAttribute("sub3", sub3);
            session.setAttribute("sub4", sub4);
            /* created by kylin */
            session.setAttribute("userId",userId);
            response.sendRedirect("/websites/user/userWelcome.jsp");
        out.flush();
        out.close();
    }
}
