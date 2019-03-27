package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pojo.Page;
import pojo.User;

import service.UserService;

public class UserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
        
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");
		String opt=req.getParameter("opt");
        ApplicationContext  ctx=new ClassPathXmlApplicationContext("app*.xml");
	    UserService  uService=(UserService)ctx.getBean("userService");
	    if(opt.equals("list")){
	    	Page  page=new Page();
	    	Integer  pageNum=Integer.parseInt(req.getParameter("pageNum"));//当前页码
	    	if(pageNum.equals("")){
	    		pageNum=1;
	    	}
	    	int  size=page.getSize();	    	
	    	List<User> list=new ArrayList<User>();
	    	list=uService.getAll(pageNum,size);
	    	
	    	page.setPageNum(pageNum);
	    	page.setTotalCount(uService.getUserCount());
	    	page.setUserList(list);
	    	req.setAttribute("page", page);
	    	req.setAttribute("userList", list);
	    	req.getRequestDispatcher("index.jsp").forward(req, resp);
	    }else if(opt.equals("add")){
	    	User  user=new User();
	    	user.setUserCode(req.getParameter("userCode"));
	    	user.setUserName(req.getParameter("userName"));
	    	int num=uService.add(user);
	    	req.setAttribute("msg", num>0?"添加成功":"添加失败");
	    	req.getRequestDispatcher("UserServlet?opt=list").forward(req, resp);
	    }else if(opt.equals("update")){
	    	User  user=new User();
	    	user.setId(Integer.parseInt(req.getParameter("id")));
	    	user.setUserCode(req.getParameter("userCode"));
	    	user.setUserName(req.getParameter("userName"));
	    	int num=uService.update(user);
	    	req.setAttribute("msg", num>0?"修改成功":"修改失败");
	    	req.getRequestDispatcher("UserServlet?opt=list").forward(req, resp);
	    }else if(opt.equals("delete")){
	    	int num=uService.del(Integer.parseInt(req.getParameter("id")));
	    	req.setAttribute("msg", num>0?"删除成功":"删除失败");
	    	req.getRequestDispatcher("UserServlet?opt=list").forward(req, resp);
	    }else if(opt.equals("info")){
	        User  user=uService.getInfo(Integer.parseInt(req.getParameter("id")));
	        req.setAttribute("user", user);
	        req.getRequestDispatcher("add.jsp").forward(req, resp);
	    }
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
