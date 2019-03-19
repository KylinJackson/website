package manager.action;

import manager.model.Publish;
import manager.service.IInformationService;
import manager.serviceImpl.IInformationServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ShowInformationServlet extends HttpServlet {
    IInformationService iInformationService = new IInformationServiceImpl();
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String flag = request.getParameter("num");
        searchInformationByNum(request,response,Integer.parseInt(flag));
        out.flush();
        out.close();
    }

    public void searchInformationByNum(HttpServletRequest request,HttpServletResponse response,int flag) {
        List<Publish> publishList = iInformationService.searchInformationByNum(flag);
        HttpSession session = request.getSession(true);
        session.setAttribute("PublishList",publishList);
        RequestDispatcher rd = request.getRequestDispatcher("/websites/manager/showContent.jsp");
        try {
            rd.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
