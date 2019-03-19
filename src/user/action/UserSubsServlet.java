package user.action;

import user.model.Publish;
import user.service.IUserLoginService;
import user.service.IUserSubsService;
import user.serviceImpl.UserLoginServiceImpl;
import user.serviceImpl.UserSubsServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;

public class UserSubsServlet extends HttpServlet {
    private IUserSubsService iUserSubsService = new UserSubsServiceImpl();

    private IUserLoginService iUserService=new UserLoginServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("subs")) {
            sub(request, response);
        }
        if (action.equals("mySubs")) {
            mySubs(request, response);
        }
        if (action.equals("cancel")) {
            cancel(request, response);
        }
    }
    private void sub(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int type = Integer.parseInt(request.getParameter("type"));
        String userId = request.getParameter("userId");


        if (iUserSubsService.sub(userId, type)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", userId);

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

            for (int i = 0; i < pub.size(); i++)
            {
                if (pub.get(i).getPublishcolumnsId() == 1) {
                    pub1.add(pub.get(i));
                }
                if (pub.get(i).getPublishcolumnsId() == 2) {
                    pub2.add(pub.get(i));
                }
                if (pub.get(i).getPublishcolumnsId() == 3) {
                    pub3.add(pub.get(i));
                }
                if (pub.get(i).getPublishcolumnsId() == 4) {
                    pub4.add(pub.get(i));
                }
            }
            session.setAttribute("pub1", pub1);
            session.setAttribute("pub2", pub2);
            session.setAttribute("pub3", pub3);
            session.setAttribute("pub4", pub4);
            session.setAttribute("sub1", sub1);
            session.setAttribute("sub2", sub2);
            session.setAttribute("sub3", sub3);
            session.setAttribute("sub4", sub4);
            response.sendRedirect("/websites/user/userWelcome.jsp");
        }
    }
    private void mySubs(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String userId = request.getParameter("userId");
        List<Integer> integerList = new ArrayList<Integer>();
        integerList = iUserService.isSubs(userId);

        HttpSession session = request.getSession(true);
        session.setAttribute("userId", userId);


        boolean sub1 = false, sub2 = false, sub3 = false, sub4 = false;
        sub1 = integerList.contains(1);
        sub2 = integerList.contains(2);
        sub3 = integerList.contains(3);
        sub4 = integerList.contains(4);

        session.setAttribute("sub1", sub1);
        session.setAttribute("sub2", sub2);
        session.setAttribute("sub3", sub3);
        session.setAttribute("sub4", sub4);

        List<Publish> pub = new ArrayList<Publish>();
        pub = iUserService.showAllPubs();
        List<Publish> pub1 = new ArrayList<Publish>();
        List<Publish> pub2 = new ArrayList<Publish>();
        List<Publish> pub3 = new ArrayList<Publish>();
        List<Publish> pub4 = new ArrayList<Publish>();

        Date logoutTime = iUserSubsService.logoutTime(userId);
        for (int i = 0; i < pub.size(); i++) {
            if (pub.get(i).getPublishcolumnsId() == 1 && pub.get(i).getPublishTime().after(logoutTime)) {
                pub1.add(pub.get(i));
            }
            if (pub.get(i).getPublishcolumnsId() == 2 && pub.get(i).getPublishTime().after(logoutTime)) {
                pub2.add(pub.get(i));
            }
            if (pub.get(i).getPublishcolumnsId() == 3 && pub.get(i).getPublishTime().after(logoutTime)) {
                pub3.add(pub.get(i));
            }
            if (pub.get(i).getPublishcolumnsId() == 4 && pub.get(i).getPublishTime().after(logoutTime)) {
                pub4.add(pub.get(i));
            }
        }
        session.setAttribute("pub1", pub1);
        session.setAttribute("pub2", pub2);
        session.setAttribute("pub3", pub3);
        session.setAttribute("pub4", pub4);

        response.sendRedirect("/websites/user/userSubs.jsp");
    }

    private void cancel(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String userId = request.getParameter("userId");
        int type = Integer.parseInt(request.getParameter("type"));

        if (iUserSubsService.cancel(userId, type)) {
            List<Integer> integerList = new ArrayList<Integer>();
            integerList = iUserService.isSubs(userId);

            HttpSession session = request.getSession(true);
            session.setAttribute("userId", userId);


            boolean sub1 = false, sub2 = false, sub3 = false, sub4 = false;
            sub1 = integerList.contains(1);
            sub2 = integerList.contains(2);
            sub3 = integerList.contains(3);
            sub4 = integerList.contains(4);

            session.setAttribute("sub1", sub1);
            session.setAttribute("sub2", sub2);
            session.setAttribute("sub3", sub3);
            session.setAttribute("sub4", sub4);

            List<Publish> pub = new ArrayList<Publish>();
            pub = iUserService.showAllPubs();
            List<Publish> pub1 = new ArrayList<Publish>();
            List<Publish> pub2 = new ArrayList<Publish>();
            List<Publish> pub3 = new ArrayList<Publish>();
            List<Publish> pub4 = new ArrayList<Publish>();

            Date logoutTime = iUserSubsService.logoutTime(userId);
            for (int i = 0; i < pub.size(); i++) {
                if (pub.get(i).getPublishcolumnsId() == 1 && pub.get(i).getPublishTime().after(logoutTime)) {
                    pub1.add(pub.get(i));
                }
                if (pub.get(i).getPublishcolumnsId() == 2 && pub.get(i).getPublishTime().after(logoutTime)) {
                    pub2.add(pub.get(i));
                }
                if (pub.get(i).getPublishcolumnsId() == 3 && pub.get(i).getPublishTime().after(logoutTime)) {
                    pub3.add(pub.get(i));
                }
                if (pub.get(i).getPublishcolumnsId() == 4 && pub.get(i).getPublishTime().after(logoutTime)) {
                    pub4.add(pub.get(i));
                }
            }
            session.setAttribute("pub1", pub1);
            session.setAttribute("pub2", pub2);
            session.setAttribute("pub3", pub3);
            session.setAttribute("pub4", pub4);
            response.sendRedirect("/websites/user/userSubs.jsp");
        }

    }
}
