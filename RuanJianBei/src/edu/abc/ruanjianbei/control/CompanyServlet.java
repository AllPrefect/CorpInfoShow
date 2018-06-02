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
		case "corpzupu":
			corpzupu(request,response);
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
	 * ��ʾͶ�������е�Ͷ����Ϣ
	 */
	protected void touzizupu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String CORP_NAME = request.getParameter("CORP_NAME");
		System.out.println("Ͷ�����ײ�ѯ��˾���ƣ�"+CORP_NAME);
		String companyLevel=request.getParameter("companyLevel");
		String stockLevel=request.getParameter("stockLevel");
		System.out.println("�ɶ��㼶��"+stockLevel);
		System.out.println("����Ͷ�ʲ㼶��"+companyLevel);

		//�洢��ѯ������������
		ArrayList<ChildrenBean> allData=new ArrayList<>();
		//����ǰ��ҳ�棬�Ƿ��в㼶��ϵ
		ChildrenBean flagcom=new ChildrenBean();
		
		//��ӽڵ�����
		ArrayList<ChildrenBean> node=levelNode(CORP_NAME);
		allData.addAll(node);
		
		//��ѯ���˹ɶ��㼶��Ϣ
		ArrayList<ChildrenBean> firstStockLevelData=new ArrayList<>();
		//�洢ÿ�������ĸ��˹ɶ�����
		ArrayList<ChildrenBean> stockData=new ArrayList<>();
		firstStockLevelData=companydao.selectGuDongRenByCompanyName("�ɶ�",CORP_NAME);
		stockData=searchStock(firstStockLevelData,CORP_NAME, firstStockLevelData, Integer.parseInt(stockLevel));
		allData.addAll(stockData);
		
		//��ѯ��˾�ɶ��㼶��Ϣ
		ArrayList<ChildrenBean> firstCompayLevelData=new ArrayList<>();
		//�洢ÿ�������Ĺ�˾�ɶ�����
		ArrayList<ChildrenBean> companyData=new ArrayList<>();
		firstCompayLevelData =companydao.selectGuDongComByCompanyName("����Ͷ��",CORP_NAME);
		companyData=searchCompany(firstCompayLevelData,firstCompayLevelData, Integer.parseInt(companyLevel));
		allData.addAll(companyData);
		
//		switch(companyLevel) 
//		{
//			case "һ��":
//				//ͨ�������Ĺ�˾����������øù�˾�Ĺɶ�
//				firstCompayLevelData =companydao.selectGuDongComByCompanyName("����Ͷ��",CORP_NAME);
//				ArrayList<ChildrenBean> node=levelNode(CORP_NAME);
//				allData.addAll(node);
//				allData.addAll(firstCompayLevelData);
//				break;
//			case "����":
//				ArrayList<ChildrenBean> secondCompanyLevelData=new ArrayList<>();
//				//�ڶ�����ʾ������Ҫ���ϵ�һ�����ж���Ͷ�ʹ�˾������
//				firstCompayLevelData = companydao.selectGuDongComByCompanyName("����Ͷ��",CORP_NAME);
//				allData.addAll(levelNode(CORP_NAME));
//				//��ѯ�ڶ���ɶ�������
//				ArrayList<ChildrenBean> CompayLevelData=companydao.selectGuDongComByCompanyName("����Ͷ��",CORP_NAME);
//				//�Լ�����ÿһ����˾��ѯ���ù�˾����Ͷ�ʵĹ�˾
//				for (ChildrenBean childrenBean : CompayLevelData) {
//					secondCompanyLevelData=companydao.selectGuDongComByCompanyName(childrenBean.getId(), childrenBean.getId());
//					System.out.println("��ѯ���Ķ���Ͷ�ʵڶ������ݣ�"+secondCompanyLevelData.toString());
//					//�ڵ�һ�����ݵĻ����ϣ����ϵڶ������Ͷ�ʵĹ�˾������
//					firstCompayLevelData.addAll(secondCompanyLevelData);
//				}
//				//�ж��Ƿ�û�и���������ˣ��ǣ�������������ӱ�־
//				if(secondCompanyLevelData.isEmpty()) {
//					flagcom.setValue("false");
//				}
//				allData.addAll(firstCompayLevelData);
//				break;
//		}
//		switch(stockLevel) {
//			case "һ��":
//				firstStockLevelData=companydao.selectGuDongRenByCompanyName("�ɶ�",CORP_NAME);
//				allData.addAll(firstStockLevelData);
//				break;
//			case "����":
//				ArrayList<ChildrenBean> secondStockLevelData=new ArrayList<>();
//				firstStockLevelData=companydao.selectGuDongRenByCompanyName("�ɶ�",CORP_NAME);
//				ArrayList<ChildrenBean> StockLevelData=firstStockLevelData;
//				for (ChildrenBean childrenBean : StockLevelData) {
//					secondStockLevelData=companydao.selectGuDongByname(CORP_NAME,childrenBean.getId() , childrenBean.getId());
//					firstStockLevelData.addAll(secondStockLevelData);
//				}
//				if(secondStockLevelData.isEmpty()) {
//					ChildrenBean flag=new ChildrenBean("false", "", "");
//					firstStockLevelData.add(flag);
//				}
//				allData.addAll(firstStockLevelData);
//				firstStockLevelData=companydao.selectGuDongRenByCompanyName("�ɶ�",CORP_NAME);
//				stockData=searchStock(CORP_NAME, firstStockLevelData, 1);
//				allData.addAll(firstStockLevelData);
//				allData.addAll(stockData);
//				break;
//			case "����":
//				firstStockLevelData=companydao.selectGuDongRenByCompanyName("�ɶ�",CORP_NAME);
//				stockData=searchStock(CORP_NAME, firstStockLevelData, 2);
//				allData.addAll(firstStockLevelData);
//				allData.addAll(stockData);
//				break;
//		}
		
//		allData.add(flagcom);
		ToJSONString(response, allData);
		
	}

	/*
	 * ���Ͷ�����׽ڵ���Ϣ
	 */
	public ArrayList<ChildrenBean> levelNode(String CORP_NAME) {
		ArrayList<ChildrenBean> node=new ArrayList<>();
		ChildrenBean root=new ChildrenBean(CORP_NAME, "", "");
		ChildrenBean root1=new ChildrenBean("�ɶ�", CORP_NAME, "");
		ChildrenBean root2=new ChildrenBean("����Ͷ��", CORP_NAME, "");
		node.add(root);
		node.add(root1);
		node.add(root2);
		return node;
	}
	/*
	 *�����ҵ���׽ڵ���Ϣ 
	 */
	public ArrayList<ChildrenBean> corpLevelNode(String CORP_NAME){
		ArrayList<ChildrenBean> node=new ArrayList<>();
		ChildrenBean root=new ChildrenBean(CORP_NAME, "", "");
		ChildrenBean root1=new ChildrenBean("�ɶ�", CORP_NAME, "");
		ChildrenBean root2=new ChildrenBean("����Ͷ��", CORP_NAME, "");
		ChildrenBean root3=new ChildrenBean("�߹�", CORP_NAME, "");
		ChildrenBean root4=new ChildrenBean("��������", CORP_NAME, "");
		ChildrenBean root5=new ChildrenBean("��Ժ����", CORP_NAME, "");
		ChildrenBean root6=new ChildrenBean("��ʷ�ɶ�", CORP_NAME, "");
		ChildrenBean root7=new ChildrenBean("��ʷ����", CORP_NAME, "");
		node.add(root);
		node.add(root1);
		node.add(root2);
		node.add(root3);
		node.add(root4);
		node.add(root5);
		node.add(root6);
		node.add(root7);
		return node;
	}
	/*
	 * ����ѯ��������ת��Ϊjson��ʽ����ǰ̨
	 */
	protected void ToJSONString(HttpServletResponse response, ArrayList<ChildrenBean> stockData) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ObjectMapper mapper=new ObjectMapper();
		String jsonString =mapper.writeValueAsString(stockData);
		System.out.println("��ѯ����json����"+jsonString);
		//����jsonArray����
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/javascript");
		response.getWriter().print(jsonString);
		
	}
	/*
	 * ��ʾ��ҵ������Ϣ
	 */
	protected void corpzupu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String CORP_ORG = request.getParameter("CORP_ORG");
		String CORP_SEQ_ID = request.getParameter("CORP_SEQ_ID");
		System.out.println("��ҵ���ף�"+CORP_ORG+","+CORP_SEQ_ID);
		String CORP_NAME = request.getParameter("CORP_NAME");
		System.out.println("��ҵ���׹�˾����"+CORP_NAME);
		//�洢��ѯ������������Ϣ
		ArrayList<ChildrenBean> allData=new ArrayList<>();
		
		
		ArrayList<ChildrenBean> CompayLevelData=companydao.selectGuDongComByCompany("����Ͷ��", CORP_NAME, Integer.parseInt(CORP_ORG), Integer.parseInt(CORP_SEQ_ID));
		ArrayList<ChildrenBean> StockLevelData=companydao.selectGuDongRenByCompany("�ɶ�", CORP_NAME, Integer.parseInt(CORP_ORG), Integer.parseInt(CORP_SEQ_ID));
		
		System.out.println("��һ��ɶ�����"+StockLevelData);
		
		allData.addAll(searchStock(StockLevelData,CORP_NAME,StockLevelData,2));
		allData.addAll(searchCompany(CompayLevelData,CompayLevelData,3));
		//��ӽڵ���Ϣ
		allData.addAll(corpLevelNode(CORP_NAME));
		
		ToJSONString(response, allData);
		
	}
	/*
	 * ͨ���ݹ��ѯ���˹ɶ��㼶����
	 */
	public ArrayList<ChildrenBean> searchStock(ArrayList<ChildrenBean> stockLevelData,String CORP_NAME,ArrayList<ChildrenBean> leveldata,int level){
		//�洢һ�����Ϣ
		ArrayList<ChildrenBean> levelData=new ArrayList<>();
		//�洢һ���ڵ�����Ϣ
		ArrayList<ChildrenBean> levelDataOne=new ArrayList<>();
		if(level<=0) {
			System.out.println("�ݹ����!");
		}else {
			for (ChildrenBean childrenBean : leveldata) {
				levelDataOne=companydao.selectGuDongByname(CORP_NAME,childrenBean.getId() , childrenBean.getId());
				levelData.addAll(levelDataOne);
			}
			stockLevelData.addAll(levelData);
			searchStock(stockLevelData,CORP_NAME,levelData, (level-1));
		}
		return stockLevelData;
	}
	/*
	 * ͨ���ݹ��ѯ��˾�ɶ��㼶����
	 */
	public ArrayList<ChildrenBean> searchCompany(ArrayList<ChildrenBean> companyLevelData,ArrayList<ChildrenBean> leveldata,int level){
		ArrayList<ChildrenBean> levelData=new ArrayList<>();
		ArrayList<ChildrenBean> levelDataOne=new ArrayList<>();
		//���ݹ鵽�ڶ������
		if(level<=0) {
			System.out.println("�ݹ����!");
		}else {
			for (ChildrenBean childrenBean : leveldata) {
				levelDataOne=companydao.selectGuDongComByCompanyName(childrenBean.getId(), childrenBean.getId());
				levelData.addAll(levelDataOne);
			}
			companyLevelData.addAll(levelData);
			searchCompany(companyLevelData,levelData,(level-1));
		}
		
		return companyLevelData;
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
