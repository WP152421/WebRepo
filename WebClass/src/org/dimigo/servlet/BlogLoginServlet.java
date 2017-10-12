package org.dimigo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dimigo.vo.UserVO;

/**
 * Servlet implementation class BlogLoginServlet
 */
@WebServlet("/bloglogin")
public class BlogLoginServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#HttpServlet()
    */
   public BlogLoginServlet() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      response.getWriter().append("Served at: ").append(request.getContextPath());
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      response.setContentType("text/html;charset=utf-8");
      PrintWriter out = response.getWriter();

      request.setCharacterEncoding("utf-8");
      String id = request.getParameter("id");
      String pwd = request.getParameter("pwd");
      System.out.printf("id : %s, pwd : %s", id, pwd);

      if ("test@naver.com".equals(id)) {
         // 세션에 사용자 생성
         HttpSession session = request.getSession();
         UserVO user = new UserVO();
         user.setId(id);
         user.setName("이유진");
         user.setNickname("이유진");

         session.setAttribute("user", user);

         RequestDispatcher rd = request.getRequestDispatcher("myblog/myblog.jsp");
         rd.forward(request, response);
      } else {
         request.setAttribute("msg", "error");
         RequestDispatcher rd = request.getRequestDispatcher("myblog/myblog.jsp");
         rd.forward(request, response);
      }
      out.close();
   }
}