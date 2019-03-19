package user.action;

import user.model.Complain;
import user.model.Reply;
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
import java.util.List;

public class UserComplainServlet extends HttpServlet {
    private IUserLoginService iUserService=new UserLoginServiceImpl();
    private ResultSet rs=null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String complainuserId=request.getParameter("complainuserId");
        String complainTitle=request.getParameter("complainTitle");
        String complainContent=request.getParameter("complainContent");
        Complain complain=new Complain(0,complainuserId,complainTitle,complainContent);
        //提交投诉内容
        if(iUserService.addComplains(complain))
            //添加投诉信息
            response.sendRedirect("/websites/user/userWelcome.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String complainuserId=request.getParameter("userId");
        String flag=request.getParameter("flag");
        if (flag.equals("reply")){
            //跳转到收件箱，显示收件箱的投诉反馈。
            //根据投诉人的用户ID来查找管理员反馈的信息。
            List<Reply> replyList=iUserService.searchReplyByUId(complainuserId);
            HttpSession session=request.getSession(true);
            session.setAttribute("ReplyList",replyList);
            RequestDispatcher rd=request.getRequestDispatcher("/websites/user/userComplainreceive.jsp");
            rd.forward(request,response);
        }
        if (flag.equals("sent"))
        {
            //跳转到发件箱，显示已发的投诉。
            //根据投诉人的用户ID来查找数据库中的投诉信息。
            List<Complain> complainList=iUserService.searchSentByUId(complainuserId);
            HttpSession session=request.getSession(true);
            session.setAttribute("SentList",complainList);
            RequestDispatcher rd=request.getRequestDispatcher("/websites/user/userComplainsent.jsp");
            rd.forward(request,response);
        }
        if (flag.equals("complain"))
        {
            //欢迎界面跳转过来，判断为投诉。
            HttpSession session=request.getSession(true);
            session.setAttribute("userId",complainuserId);
            RequestDispatcher rd=request.getRequestDispatcher("/websites/user/userComplainmail.jsp");
            rd.forward(request,response);
        }
        if (flag.equals("showcomplain"))
        {
            //判断是否为点击投诉标题，跳转到显示投诉内容的界面。
            int complainId=Integer.parseInt(request.getParameter("complainId"));
            //根据投诉消息的ID号来查找数据库中内容，返回Javabeen类型。
            Complain complain=iUserService.searchSentByCId(complainId);
            HttpSession session=request.getSession(true);
            session.setAttribute("Complain",complain);
            response.sendRedirect("/websites/user/showsentContent.jsp");
        }
        if (flag.equals("showreply"))
        {
            //判断是否为点击反馈标题，跳转到显示反馈内容的界面。
            int replyId=Integer.parseInt(request.getParameter("replyId"));
            //根据管理员反馈消息的ID号来查找数据库中内容，返回Javabeen类型。
            Reply reply=iUserService.searchReplyByRId(replyId);
            HttpSession session=request.getSession(true);
            session.setAttribute("Reply",reply);
            response.sendRedirect("/websites/user/showreplyContent.jsp");
        }
        if (flag.equals("complainMail")) {
            String userId = request.getParameter("userId");
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", userId);
            response.sendRedirect("/websites/user/userComplain.jsp");
        }
    }
}
