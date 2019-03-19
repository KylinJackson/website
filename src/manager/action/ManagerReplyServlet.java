package manager.action;

import manager.service.IMService;
import manager.serviceImpl.MServiceImpl;
import user.model.Complain;
import user.model.Reply;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by lenovo on 2017/7/10.
 */
@WebServlet(name = "ManagerReplyServlet")
public class ManagerReplyServlet extends HttpServlet {
    IMService imService=new MServiceImpl();
    ResultSet rs=null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        String flag=request.getParameter("flag");
        if(flag.equals("addreply")){
            int replycomplainId=Integer.parseInt(request.getParameter("replycomplainId"));
            String replyuserId=request.getParameter("replyuserId");
            String replyTitle=request.getParameter("replyTitle");
            String replyContent=request.getParameter("replyContent");
            Reply reply=new Reply(0,replycomplainId,replyuserId,replyTitle,replyContent);
            if(imService.addReplys(reply))
                response.sendRedirect("/websites/manager/managerWelcome.jsp");
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("UTF-8");
        String flag=request.getParameter("flag");
        if(flag.equals("reply"))
        {
            List<Reply> replyList=imService.getReplys();
            HttpSession session=request.getSession(true);
            session.setAttribute("ReplyList",replyList);
            response.sendRedirect("/websites/manager/showReplys.jsp");
        }
        else if(flag.equals("receive"))
        {
            List<Complain> complainList=imService.getComplains();
            HttpSession session=request.getSession(true);
            session.setAttribute("ComplainList",complainList);
            response.sendRedirect("/websites/manager/showComplains.jsp");

        }
        else if (flag.equals("showcomplain"))
        {
            //判断是否为点击投诉标题，跳转到显示投诉内容的界面。
            int complainId=Integer.parseInt(request.getParameter("complainId"));
            //根据投诉消息的ID号来查找数据库中内容，返回Javabeen类型。
            Complain complain=imService.searchSentByCId(complainId);
            HttpSession session=request.getSession(true);
            session.setAttribute("Complain",complain);
            response.sendRedirect("/websites/manager/showcomplainContent.jsp");
        }
        else if (flag.equals("showreply"))
        {
            //判断是否为点击反馈标题，跳转到显示反馈内容的界面。
            int replyId=Integer.parseInt(request.getParameter("replyId"));
            //根据管理员反馈消息的ID号来查找数据库中内容，返回Javabeen类型。
            Reply reply=imService.searchReplyByRId(replyId);
            HttpSession session=request.getSession(true);
            session.setAttribute("Reply",reply);
            response.sendRedirect("/websites/manager/showreplyContent.jsp");
        }

        out.flush();
        out.close();
    }
}
