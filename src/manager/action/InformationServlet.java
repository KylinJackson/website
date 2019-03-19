package manager.action;

import manager.model.Publish;
import manager.service.IInformationService;
import manager.serviceImpl.IInformationServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "InformationServlet")
public class InformationServlet extends HttpServlet {
    //控制器调用服务层
    IInformationService iInformationService = new IInformationServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html:charset = UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println("---do post---");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        System.out.println("---do informationservlet---");
        int flag = Integer.parseInt(request.getParameter("flag"));
        System.out.println("flag = " + flag);
        searchInformationByFlag(request,response,flag);

    }

    public void searchInformationByFlag(HttpServletRequest request,HttpServletResponse response,int flag) {
        List<Publish> publishList = iInformationService.searchInformationByFlag(flag);
        HttpSession session = request.getSession(true);
        session.setAttribute("PublishList",publishList);
        RequestDispatcher rd = request.getRequestDispatcher("/websites/manager/showInformation.jsp");
        try {
            rd.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* public void showAllInformation(HttpServletRequest request,HttpServletResponse response) {
        List<Publish> publishList = iInformationService.getInformation();
        HttpSession session = request.getSession();
        session.setAttribute("PublishList",publishList);
        System.out.println(publishList);
        RequestDispatcher rd = request.getRequestDispatcher("/websites/manager/showInformation.jsp");
        try {
            rd.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
