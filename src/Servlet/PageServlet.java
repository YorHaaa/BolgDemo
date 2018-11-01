package Servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author ZYP
 * @date 2018/10/31 10:46
 */

@WebServlet("/page")
public class PageServlet extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res)
    {
        Connection ct=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        int pageSize=3;  //希望每页显示记录的条数
        int pageNow=1;   //初始化当前页为第一页
        int pageCount=0; //总页数，需要通过计算得知
        int rowCount=0;  //记录总数，查表获知
        String sPageNow=req.getParameter("pageNow");  //接收传递过来的当前页面
        if(sPageNow!=null)  //若接收到非空值，将其转为整数
        {
            pageNow=Integer.parseInt(sPageNow);
        }


        try{
            PrintWriter pw=res.getWriter();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            ct=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Students","sa","密码");
            ps=ct.prepareStatement("select count(*) from [Students].[dbo].[Students]");  //获取表中记录总数
            rs=ps.executeQuery();
            while(rs.next())
            {
                rowCount=rs.getInt(1);  //获取表中记录总数
            }
            if(rowCount%pageSize==0)   //计算总页面数
            {
                pageCount=rowCount/pageSize;
            }
            else
            {
                pageCount=rowCount/pageSize+1;
            }

            ps=ct.prepareStatement("select top  "+pageSize+" * from [Students].[dbo].[Students] where id not in(select top "+pageSize*(pageNow-1)+" id from [Students].[dbo].[Students])");


            rs=ps.executeQuery();
            pw.println("<body><center>");    //将查询结果以表的形式展现
            pw.println("<table border=1");
            pw.println("<tr><th>id</th><th>name</th><th>grade</th></tr>");
            while(rs.next())
            {
                pw.println("<tr>");
                pw.println("<td>"+rs.getInt(1)+"</td>");
                pw.println("<td>"+rs.getString(2)+"</td>");
                pw.println("<td>"+rs.getString(3)+"</td>");
                pw.println("</tr>");
            }
            pw.println("</table>");
            if(pageNow==1)   //前一页超链接，当已经跳转到第一页时，页面不再改变
            {
                pw.println("<a href=fenye?pageNow="+pageNow+">"+"forward"+"</a>");
            }
            else      //未跳转到第一页时，每点击一次超链接，页面向前跳转一次
            {
                pw.println("<a href=fenye?pageNow="+(pageNow-1)+">"+"forward"+"</a>");
            }
            if(pageCount<=5)  //控制显示页数超链接的个数
            {
                for(int i=1;i<=pageCount;i++)
                {
                    pw.println("<a href=fenye?pageNow="+i+">"+i+"</a>");
                }
            }else if(pageCount-pageNow<=5)
            {
                for(int i=pageNow;i<=pageCount;i++)
                    pw.println("<a href=fenye?pageNow="+i+">"+i+"</a>");
            }else  //当页面数过多时，为了页面美观需要控制显示超链接个数
            {
                for(int i=pageNow;i<=pageNow+5;i++)
                    pw.println("<a href=fenye?pageNow="+i+">"+i+"</a>");
            }

            if(pageNow==pageCount)  //已经为最后一页时，点击后一页不再跳转
            {
                pw.println("<a href=fenye?pageNow="+pageNow+">"+"backward"+"</a>");
            }
            else
            {
                pw.println("<a href=fenye?pageNow="+(pageNow+1)+">"+"backward"+"</a>");
            }
            pw.println("</center></body>");
        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public void doPost(HttpServletRequest req, HttpServletResponse res)
    {
        this.doGet(req,res);
    }
}
