package manager.action;

import manager.model.Manager;
import manager.service.IManagerService;
import manager.serviceImpl.ManagerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ManagerServlet extends HttpServlet {
    private IManagerService iManagerService = new ManagerServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String managename = request.getParameter("manageName");
        String managesex = request.getParameter("manageSex");
        String managetel = request.getParameter("manageTel");
        String manageemail = request.getParameter("manageEmail");
        String flag = request.getParameter("flag");
        if(flag.equals("alterManager")) {
            String manageid = request.getParameter("manageId");
            Manager manager = new Manager();
            manager.setManageId(manageid);
            manager.setManageName(managename);
            manager.setManageSex(managesex);
            manager.setManageTel(managetel);
            manager.setManageEmail(manageemail);

            if(iManagerService.alterManager(manager)) {
                response.sendRedirect("/servlet/ManagerServlet?flag=showAllManagers&manageid=" + manageid);
            }
        }
        if (flag.equals("alterPassword2")) {
            alterPassword2(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        String flag = request.getParameter("flag");
        if(flag.equals("showAllManagers")){
            showAllManagers(request,response);
        }
        if(flag.equals("search")) {
            String typeid = request.getParameter("manageId");
            searchManagerByType(request,response,typeid);
        }
        if (flag.equals("alterPassword")) {
            alterPassword(request, response);
        }
    }

    private void alterPassword(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String manageid = request.getParameter("manageid");
        HttpSession session = request.getSession(true);
        session.setAttribute("managerId", manageid);
        response.sendRedirect("/websites/manager/modifyPassword.jsp");
    }

    private void alterPassword2(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String previous = request.getParameter("previous");
        String managerId = request.getParameter("managerId");
        String wrong="no";
        if (iManagerService.verifyPassword(managerId, previous)) {
            String new1 = request.getParameter("new1");
            if (iManagerService.changePassword(managerId, new1)) {
                String loginwrong = "nologinwrong";
                HttpSession session = request.getSession(true);
                session.setAttribute("wrongmanager1", loginwrong);
                response.sendRedirect("/websites/manager/managerLogin.jsp?");
                //response.sendRedirect("/websites/manager/managerWelcome.jsp?manageid="+managerId);
            }
        } else {
            wrong="yes";
            HttpSession session=request.getSession(true);
            session.setAttribute("wrongmanager",wrong);
            response.sendRedirect("/websites/manager/modifyPassword.jsp?");
            //System.out.println("原密码错误");
        }
    }

    public void searchManagerByType(HttpServletRequest request,HttpServletResponse response,String typeId) {
        List<Manager> manageList = iManagerService.searchManagerByType(typeId);
        HttpSession session = request.getSession(true);
        session.setAttribute("ManageList",manageList);

        RequestDispatcher rd = request.getRequestDispatcher("/websites/manager/alterManager.jsp");
        try {
            rd.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAllManagers(HttpServletRequest request,HttpServletResponse response) {
        List<Manager> manageList = iManagerService.getManagers();
        HttpSession session = request.getSession(true);
        session.setAttribute("ManageList",manageList);
        String manageid = request.getParameter("manageid");
        session.setAttribute("manageid",manageid);

        RequestDispatcher rd = request.getRequestDispatcher("/websites/manager/managerInformation.jsp");
        try {
            rd.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
