package manager.action;

import manager.model.Publish;
import manager.service.IMService;
import manager.serviceImpl.MServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenovo on 2017/7/10.
 */
@WebServlet(name = "MServlet")
public class MServlet extends HttpServlet {
    IMService imService=new MServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        String manageid=request.getParameter("manageid");
        String publishTitle=request.getParameter("title");
        System.out.println("--do Mservlet--");
        int publishcolumnsId=Integer.parseInt(request.getParameter("type"));
        String publishContent=request.getParameter("content");
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Publish publish=new Publish(0,publishcolumnsId,publishTitle,publishContent,df.format(new Date()));
        HttpSession session=request.getSession(true);
        session.setAttribute("manageid",manageid);
        if(imService.addPublishs(publish))
            response.sendRedirect("/websites/manager/managerWelcome.jsp");
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        out.flush();
        out.close();
    }
}
