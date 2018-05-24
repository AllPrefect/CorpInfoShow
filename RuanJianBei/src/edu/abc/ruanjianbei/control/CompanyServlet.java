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

import edu.abc.ruanjianbei.model.bean.ChildrenBean;
import edu.abc.ruanjianbei.model.bean.T_CORPBean;
import edu.abc.ruanjianbei.model.bean.TouziBean;
import edu.abc.ruanjianbei.model.bean.TouziDataBean;
import edu.abc.ruanjianbei.model.dao.CompanyDao;
import edu.abc.ruanjianbei.model.dao.CompanyDaoImpl;

@WebServlet("/CompanyServlet")
public class CompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CompanyDao companydao;
    
    public CompanyServlet() {
        super();
        companydao=new CompanyDaoImpl();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String methodName = request.getParameter("method");
		System.out.println("CompanyServlet:"+methodName);
		switch (methodName) {
		case "searchAll":
			searchAll(request,response);
			break;
		case "searchName":
			searchName(request,response);
			break;
		case "touzizupu":
			touzizupu(request,response);
			break;
		case "showrelation":
			showrelation(request,response);
			break;
		default:
			break;
		}
	}
	/*
	 * ��������Ĺ�˾����ѯ��˾����Ϣ
	 */
	protected void searchAll(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String name = request.getParameter("CorpName");
		T_CORPBean companymeg=companydao.searchOneCompany(name);
		request.setAttribute("companymeg", companymeg);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	/*
	 * ������˾��ģ��ƥ��
	 */
	protected void searchName(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String name = request.getParameter("CorpName");
		ArrayList<T_CORPBean> companys = companydao.selectByCompanyName(name);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(companys);
		
		//����jsonArray����
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/javascript");
		response.getWriter().print(jsonString);
	}
	/*
	 * ��ʾͶ�������У�Ͷ����Ϣ
	 */
	protected void touzizupu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String CORP_NAME = request.getParameter("CORP_NAME");
		System.out.println(CORP_NAME);
		ArrayList<ChildrenBean> GuDongRen=companydao.selectGuDongRenByCompanyName(CORP_NAME);
		ArrayList<ChildrenBean> GuDongCom=companydao.selectGuDongComByCompanyName(CORP_NAME);
		
		ArrayList<TouziBean> data=new ArrayList<>();
		TouziBean touzi1=new TouziBean("����Ͷ��",GuDongCom);
		TouziBean touzi2=new TouziBean("�ɶ�",GuDongRen);
		data.add(touzi1);
		data.add(touzi2);
		
		TouziDataBean alldata=new TouziDataBean(CORP_NAME,data);
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(alldata);
		System.out.println(jsonString);
		//����jsonArray����
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/javascript");
		response.getWriter().print(jsonString);
	}
	/*
	 * ��ʾ��˾���ɶ�֮������ƹ�ϵ
	 */
	protected void showrelation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
