package edu.abc.ruanjianbei.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import edu.abc.ruanjianbei.model.bean.T_CORPBean;
import edu.abc.ruanjianbei.model.dao.CompanyDao;
import edu.abc.ruanjianbei.model.dao.CompanyDaoImpl;

@WebServlet("/Companyservlet")
public class Companyservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CompanyDao companydao;
    
    public Companyservlet() {
        super();
        companydao=new CompanyDaoImpl();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String type = request.getParameter("method");
		
		switch (type) {
		case "search":
			search(request,response);
			break;
			
		case "searchmeg":
			searchmeg(request,response);
			break;

		default:
			break;
		}
	}

	protected void searchmeg(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String name = request.getParameter("name");
		T_CORPBean companymeg=companydao.searchOneCompany(name);
		request.setAttribute("companymeg", companymeg);
		System.out.println(companymeg);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	protected void search(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String name = request.getParameter("name");
		ArrayList<T_CORPBean> companys = companydao.selectByCompanyName(name);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(companys);
		System.out.println(jsonString);
		//·µ»ØjsonArrayÊý¾Ý
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/javascript");
		response.getWriter().print(jsonString);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
