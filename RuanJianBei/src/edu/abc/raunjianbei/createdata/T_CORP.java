package edu.abc.raunjianbei.createdata;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Random;

import edu.abc.ruanjianbei.model.bean.OneGuongSiMoneyBean;
import edu.abc.ruanjianbei.model.bean.T_CORPBean;
import edu.abc.ruanjianbei.model.bean.T_CORP_STOCKBean;

public class T_CORP {
	private T_CORP_STOCK guDong;//应用股东表
	
	private int ORG;//一个公司唯一
	private int ID;//随机产业
	private int SEQ_ID;//每个总公司递增
	private String REG_NO;//每个公司唯一
	private	String CORP_NAME;
	private	String ADDR;
	private	String BELONG_ORG;
	private	String BELONG_DIST_ORG;
	private	String BELONG_TRADE;
	private	String ECON_KIND;
	private	String ADMIT_MAIN;
	private	String START_DATE;
	private	String CHECK_DATE;
	private	String OPER_MAN_IDENT_NO;
	private	String OPER_MAN_NAME;
	private	String CORP_STATUS;
	private	float REG_CAPI;
	private	String FARE_TERM_START;
	private	String FARE_TERM_END;
	private	String FARE_SCOPE;
	private	String UNI_SCID;
	private	String TEL;
	private	String WEB_URL;
	private	String EMAIL;
	private	int PRAC_PERSON_NUM;
	private	String ORG_INST_CODE;
	private	String TAXPAY_NUM;
	private	String STAFF_SIZE;
	private	String ENGLISH_NAME;
	private	String FORMER_NAME;
	private	String CREATE_DATE;
	private	int CREATE_ORG;
	
	
	private int gongsixvhao;
	//存所有股东
	private ArrayList<T_CORP_STOCKBean> touGuRens;
	//存所有公司的总金额
	private ArrayList<OneGuongSiMoneyBean> allMenoy;
	//存一个公司的股东人数
	private ArrayList<T_CORP_STOCKBean> oneGongSiGuDongCount;
	//定义一个集合存所有主公司
	private ArrayList<T_CORPBean> allZhuGongSi;

	public static void main(String[] args) throws Exception {
		new T_CORP();
	}
	
	public T_CORP() throws Exception {
		BufferedOutputStream  out=new BufferedOutputStream(new FileOutputStream("E:\\file\\data\\T_CORP_DATA.txt"));
		
		//实例化股东表
		guDong=new T_CORP_STOCK();
		touGuRens=guDong.touGuRens;
		allMenoy=guDong.allMenoy;
		
		oneGongSiGuDongCount=new ArrayList<>();
		allZhuGongSi=new ArrayList<>();
		
		String[] zimu= {"A","B,","C","D","E","F","G","H","I","J","K","L",
				"M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		String xiaozimu= "abcdefghijklmnopqrstuvwxyz";
		String[] sheng= {"北京市","上海市","天津市","重庆市","黑龙江省","吉林省",
				"辽宁省","江苏省","山东省","安徽省","河北省","河南省","湖北省",
				"湖南省","江西省","陕西省","山西省","四川省","青海省","海南省",
				"广东省","贵州省","浙江省","福建省","台湾省","甘肃省","云南省"};
		String[] shi= {"成都市","杭州市","武汉市","重庆市","南京市","天津市",
				"苏州市","西安市","长沙市","沈阳市","青岛市","郑州市","大连市","东莞市","宁波市"};
		String[] qv= {"渝中区","江北区","沙坪坝区","九龙坡区","南岸区","大渡口区","渝北区","巴南区",
				"北碚区","涪陵区","万州区","长寿区","黔江区","大足区","綦江区","南川区","永川区","江津区","合川区"};
		String[] jiedao= {"长安街","南京路","淮海路","王府井大街","中央大街","转经路","平江路","南大街","屯溪老街","老街",
				"北大街","滨海路","衡山路"};
		String hao;
		String[] hangye1= {"软件","信息技术","电信","互联网信息","计算机服务","计算机系统","数据处理","卫星传输"};
		String[] hangye2= {"居民服务","其他服务","修理和服务","专业技术服务","技术检测","租赁"};
		String[] jingyingfanwei1= {"计算机软件开发、","销售及相关产品培训，","计算机应用服务，","线路、","管道、","设备安装，","电子产品及通信设备技术服务，","电子仪器的生产与销售，","电子计算机及配件、"};
		String[] jingyingfanwei2= {"五金、","交电、","百货、","化工原料及产品、","汽车、","建筑材料销售，","商品信息咨询，"};
		String[] jingyingfanwei3= {"互联网科技,","医疗器械，","本地生活，","广告文化，","游戏，","金融服务，","商贸，","建筑"};
		String[] gongsimingcenghouzui;
		
		String[] gongsidalei= {"内资公司","外资公司","合资公司"};
		String guanlijv="工商管理局";
		
		int tal=0;
		for(int i=0;i<10;i++)//省份
		{
			ORG=876+i;
		//	System.out.println("机关代号；"+ORG);
			gongsixvhao=1;
			Random ran=new Random();
			
			int number=0;
			for(OneGuongSiMoneyBean o:allMenoy)
			{
				if(o.getORG()==ORG)
				{
					number++;
				}
			}
			tal=tal+number;
			System.out.println("每个省公司数量"+number);
			for(int index=0;index<number;index++)//每个省下有多少公司
			{
				T_CORPBean gongsi=new T_CORPBean();				
				ID=1000+index;
		//		System.out.println("类型："+ID);
				
				SEQ_ID=gongsixvhao;
		//		System.out.println("公司序号："+SEQ_ID);
				gongsixvhao++;
				Double dd=Math.random();
				String q10=dd.toString().substring(2, 12);
				dd=Math.random();
				String q7=dd.toString().substring(2, 9);
				int randindex=ran.nextInt(26);
				REG_NO=q10+q7+zimu[randindex];
		//		System.out.println("信用代码："+REG_NO);
				int shengindex=ran.nextInt(sheng.length);
				int hangye1index=ran.nextInt(hangye1.length);
				CORP_NAME=sheng[shengindex]+hangye1[hangye1index]+"有限公司";
		//		System.out.println("企业名称："+CORP_NAME);
				int shiindex=ran.nextInt(shi.length);
				int qvindex=ran.nextInt(qv.length);
				int jiedaoindex=ran.nextInt(jiedao.length);
				int qvhao=ran.nextInt(500);
				ADDR=shi[shiindex]+qv[qvindex]+jiedao[jiedaoindex]+qvhao+"号";
		//		System.out.println("企业地址："+ADDR);
				BELONG_ORG=shi[shiindex]+guanlijv;
		//		System.out.println("登记机关："+BELONG_ORG);
				BELONG_DIST_ORG=shi[shiindex]+qv[qvindex];
		//		System.out.println("所属地区:"+BELONG_DIST_ORG);
				int hangye2index=ran.nextInt(hangye2.length);
				BELONG_TRADE=hangye1[hangye1index]+"和"+hangye2[hangye2index]+"业";
		//		System.out.println("所属行业："+BELONG_TRADE);
				ECON_KIND="有限责任公司";
		//		System.out.println("公司类型："+ECON_KIND);
				int gongsidaleiindex=ran.nextInt(2);
				ADMIT_MAIN=gongsidalei[gongsidaleiindex];
		//		System.out.println("公司大类："+ADMIT_MAIN);
				int chenglinian=ran.nextInt(80)+1880;
				int chengliyue=ran.nextInt(12)+1;
				int chengliri=ran.nextInt(28)+1;
				String yue,ri;
				if(chengliyue<10) {
					yue="0"+chengliyue;
				}else {
					yue=""+chengliyue;
				}
				if(chengliri<10) {
					ri="0"+chengliri;
				}else {
					ri=""+chengliri;
				}
		//		START_DATE=chenglinian+"/"+yue+"/"+ri;
		//		System.out.println("成立日期："+START_DATE);
		//		int heizunnian=chenglinian+ran.nextInt(15)+1;
		//		CHECK_DATE=heizunnian+"/"+yue+"/"+ri;
		//		System.out.println("核准日期："+CHECK_DATE);
				int gongSiGuDongcount=0;
	
		//		float gongSi
				for(OneGuongSiMoneyBean one:allMenoy)
				{
					if(one.getORG()==ORG && one.getSEQ_ID()==SEQ_ID)
					{
						gongSiGuDongcount=one.getGuDongcount();
						REG_CAPI=one.getAllMoney();
						CREATE_DATE=one.getChenglishijian();
						break;
					}
				}
	//			System.out.println("公司股东："+gongSiGuDongcount);
				for(T_CORP_STOCKBean oneGuDong:touGuRens)
				{
					if(oneGuDong.getORG()==ORG && oneGuDong.getSEQ_ID()==SEQ_ID)
					{
						oneGongSiGuDongCount.add(oneGuDong);
					}
					if(oneGongSiGuDongCount.size()==gongSiGuDongcount)
					{
						break;
					}
				}
	//			System.out.println("公司股东人数："+oneGongSiGuDongCount.size());
				String faRenBiaoHao;
				String faRenMingCeng;
				int faRenIndex=ran.nextInt(gongSiGuDongcount);
				faRenBiaoHao=oneGongSiGuDongCount.get(faRenIndex).getCERTIFICATE_NO();
				faRenMingCeng=oneGongSiGuDongCount.get(faRenIndex).getSTOCK_NAME();
				OPER_MAN_IDENT_NO=faRenBiaoHao;
				OPER_MAN_NAME=faRenMingCeng;
		//		System.out.println("法人编号："+OPER_MAN_IDENT_NO);
		//		System.out.println("法人名称："+OPER_MAN_NAME);
				CORP_STATUS="0"+(ran.nextInt(4)+1);
		//		System.out.println("经营状态："+CORP_STATUS);
		//		System.out.println("注册资金:"+REG_CAPI);
		//		FARE_TERM_START=START_DATE;
		//		System.out.println("经营期限起："+FARE_TERM_START);
				FARE_TERM_END="长期";
		//		System.out.println("经营期限止："+FARE_TERM_END);
				int jingyingfanwei1index=ran.nextInt(jingyingfanwei1.length);
				int jingyingfanwei2index=ran.nextInt(jingyingfanwei2.length);
				int jingyingfanwei3index=ran.nextInt(jingyingfanwei3.length);
				FARE_SCOPE=hangye1[hangye1index]+"，"+jingyingfanwei1[jingyingfanwei1index]+jingyingfanwei2[jingyingfanwei2index]+jingyingfanwei3[jingyingfanwei3index];
				FARE_SCOPE=FARE_SCOPE.substring(0, FARE_SCOPE.length()-1)+"等";
		//		System.out.println("经营范围："+FARE_SCOPE);
				dd=Math.random();
				String q11=dd.toString().substring(2, 13);
				String q4=dd.toString().substring(2, 6);
				String q15=q11+q4;
				UNI_SCID=q15;
		//		System.out.println("注册号："+UNI_SCID);
				dd=Math.random();
				String q3=dd.toString().substring(2, 5);
				String h7=dd.toString().substring(2, 9);
				TEL=q3+"-"+h7;
		//		System.out.println("电话："+TEL);
				StringBuffer zhongjianzifu = new StringBuffer();
				for(int zhongjian=0;zhongjian<(ran.nextInt(10)+5);zhongjian++)
				{				
					zhongjianzifu.append(xiaozimu.charAt(ran.nextInt(xiaozimu.length())));
				}
				WEB_URL="www."+zhongjianzifu.toString()+".com.cn";
		//		System.out.println("官网:"+WEB_URL);
				EMAIL="jxsw@"+zhongjianzifu+".com.cn";
		//		System.out.println("邮箱："+EMAIL);
				PRAC_PERSON_NUM=ran.nextInt(400)+100;
		//		System.out.println("从业人数："+PRAC_PERSON_NUM);
				dd=Math.random();
				String q8=dd.toString().substring(2, 10);
				ORG_INST_CODE=q8+"-"+ran.nextInt(10);
		//		System.out.println("组织机构代码:"+ORG_INST_CODE);
				TAXPAY_NUM=REG_NO;
		//		System.out.println("纳税人识别号："+TAXPAY_NUM);
				STAFF_SIZE="100-499人";
		//		System.out.println("人员规模："+STAFF_SIZE);
				StringBuffer danci = new StringBuffer();
				for(int dancishuliang=0;dancishuliang<ran.nextInt(3)+3;dancishuliang++)
				{
					for(int zhongjian=0;zhongjian<(ran.nextInt(5)+5);zhongjian++)
					{				
						danci.append(xiaozimu.charAt(ran.nextInt(xiaozimu.length())));
					}
					danci.append(' ');
				}
				ENGLISH_NAME=danci.toString();
		//		System.out.println("英文名："+ENGLISH_NAME);
				FORMER_NAME="null";
		//		System.out.println("曾用名："+FORMER_NAME);
		//		System.out.println("创建时间:"+CREATE_DATE);
				String time=CREATE_DATE;
				String[] caifen1=time.split(" ");
				
				String[] caifen2=caifen1[0].split("/");
				int shengheinian=Integer.parseInt(caifen2[0]);
				int shengheiyue=Integer.parseInt(caifen2[1]);
				int shengheiri=Integer.parseInt(caifen2[2]);
				
				START_DATE=caifen1[0];				
		//		System.out.println("成立日期"+START_DATE);
				
				CHECK_DATE=shengheinian+(ran.nextInt(15)+1)+"/"+yue+"/"+ri;
		//		System.out.println("核准日期："+CHECK_DATE);
				FARE_TERM_START=caifen1[0];
		//		System.out.println("经营期限起："+FARE_TERM_START);
				
				
				CREATE_ORG=ORG;
		//		System.out.println("创建机构代码："+CREATE_ORG);
				oneGongSiGuDongCount.clear();
		//		System.out.println("长度："+oneGongSiGuDongCount.size());
			
				//封装单个公司
				T_CORPBean zhugongsi=new T_CORPBean();
				zhugongsi.setORG(ORG);
				zhugongsi.setID(ID);
				zhugongsi.setSEQ_ID(SEQ_ID);
				zhugongsi.setREG_NO(REG_NO);
				zhugongsi.setCORP_NAME(CORP_NAME);
				zhugongsi.setADDR(ADDR);
				zhugongsi.setBELONG_ORG(BELONG_ORG);
				zhugongsi.setBELONG_DIST_ORG(BELONG_DIST_ORG);
				zhugongsi.setBELONG_TRADE(BELONG_TRADE);
				zhugongsi.setECON_KIND(ECON_KIND);
				zhugongsi.setADMIT_MAIN(ADMIT_MAIN);
				zhugongsi.setSTART_DATE(START_DATE);
				zhugongsi.setCHECK_DATE(CHECK_DATE);
				zhugongsi.setOPER_MAN_IDENT_NO(OPER_MAN_IDENT_NO);
				zhugongsi.setOPER_MAN_NAME(OPER_MAN_NAME);
				zhugongsi.setCORP_STATUS(CORP_STATUS);
				zhugongsi.setREG_CAPI(REG_CAPI);
				zhugongsi.setFARE_TERM_START(FARE_TERM_START);
				zhugongsi.setFARE_TERM_END(FARE_TERM_END);
				zhugongsi.setFARE_SCOPE(FARE_SCOPE);
				zhugongsi.setUNI_SCID(UNI_SCID);
				zhugongsi.setTEL(TEL);
				zhugongsi.setWEB_URL(WEB_URL);
				zhugongsi.setEMAIL(EMAIL);
				zhugongsi.setPRAC_PERSON_NUM(PRAC_PERSON_NUM);
				zhugongsi.setORG_INST_CODE(ORG_INST_CODE);
				zhugongsi.setTAXPAY_NUM(TAXPAY_NUM);
				zhugongsi.setSTAFF_SIZE(STAFF_SIZE);
				zhugongsi.setENGLISH_NAME(ENGLISH_NAME);
				zhugongsi.setFORMER_NAME(FORMER_NAME);
				zhugongsi.setCREATE_DATE(CREATE_DATE);
				zhugongsi.setCREATE_ORG(CREATE_ORG);
				allZhuGongSi.add(zhugongsi);
				
			}
			
		}
	//	System.out.println("长度："+allZhuGongSi.size());
		//打印主公司sql语句
		for(T_CORPBean z:allZhuGongSi)
		{
			System.out.print("insert into T_CORP values( ");
			System.out.print(z.getORG()+", "+z.getID()+", "+z.getSEQ_ID()+", "+"'"+z.getREG_NO()+"', "+"'"+z.getCORP_NAME()+"', "+"'"+z.getADDR()+"', "+"'"+z.getBELONG_ORG()+"', "+"'"+z.getBELONG_DIST_ORG()+"', "+"'"+z.getBELONG_TRADE()+"', "
					+"'"+z.getECON_KIND()+"', "+"'"+z.getADMIT_MAIN()+"', "+"to_date('"+z.getSTART_DATE()+"','yyyy-mm-dd hh24:mi'), "+"to_date('"+z.getCHECK_DATE()+"','yyyy-mm-dd hh24:mi'), "+"'"+z.getOPER_MAN_IDENT_NO()+"', "+"'"+z.getOPER_MAN_NAME()+"', "
					+"'"+z.getCORP_STATUS()+"', "+z.getREG_CAPI()+", "+"to_date('"+z.getFARE_TERM_START()+"','yyyy-mm-dd hh24:mi'), "+"'"+z.getFARE_TERM_END()+"', "+"'"+z.getFARE_SCOPE()+"', "+"'"+z.getUNI_SCID()+"', "+"'"+z.getTEL()+"', "+"'"+z.getWEB_URL()+"', "
					+"'"+z.getEMAIL()+"', "+z.getPRAC_PERSON_NUM()+", "+"'"+z.getORG_INST_CODE()+"', "+"'"+z.getTAXPAY_NUM()+"', "+"'"+z.getSTAFF_SIZE()+"', "+"'"+z.getENGLISH_NAME()+"', "+z.getFORMER_NAME()+", "+"to_date('"+z.getCREATE_DATE()+"','yyyy-mm-dd hh24:mi'), "
					+z.getCREATE_ORG());
			System.out.println(" );");
			out.write(("insert into T_CORP values( "+z.getORG()+", "+z.getID()+", "+z.getSEQ_ID()+", "+"'"+z.getREG_NO()+"', "+"'"+z.getCORP_NAME()+"', "+"'"+z.getADDR()+"', "+"'"+z.getBELONG_ORG()+"', "+"'"+z.getBELONG_DIST_ORG()+"', "+"'"+z.getBELONG_TRADE()+"', "+"'"+z.getECON_KIND()+"', "+"'"+z.getADMIT_MAIN()+"', "+"to_date('"+z.getSTART_DATE()+"','yyyy-mm-dd hh24:mi'), "+"to_date('"+z.getCHECK_DATE()+"','yyyy-mm-dd hh24:mi'), "+"'"+z.getOPER_MAN_IDENT_NO()+"', "+"'"+z.getOPER_MAN_NAME()+"', "+"'"+z.getCORP_STATUS()+"', "+z.getREG_CAPI()+", "+"to_date('"+z.getFARE_TERM_START()+"','yyyy-mm-dd hh24:mi'), "+"'"+z.getFARE_TERM_END()+"', "+"'"+z.getFARE_SCOPE()+"', "+"'"+z.getUNI_SCID()+"', "+"'"+z.getTEL()+"', "+"'"+z.getWEB_URL()+"', "+"'"+z.getEMAIL()+"', "+z.getPRAC_PERSON_NUM()+", "+"'"+z.getORG_INST_CODE()+"', "+"'"+z.getTAXPAY_NUM()+"', "+"'"+z.getSTAFF_SIZE()+"', "+"'"+z.getENGLISH_NAME()+"', "+z.getFORMER_NAME()+", "+"to_date('"+z.getCREATE_DATE()+"','yyyy-mm-dd hh24:mi'), "+z.getCREATE_ORG()+" );\r\n").getBytes());
		}
		out.flush();
		out.close();
	//	System.out.println("总数量："+tal);
	}
}
