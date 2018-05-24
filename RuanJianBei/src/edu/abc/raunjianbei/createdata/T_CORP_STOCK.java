package edu.abc.raunjianbei.createdata;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import edu.abc.ruanjianbei.model.bean.OneGuongSiMoneyBean;
import edu.abc.ruanjianbei.model.bean.T_CORP_STOCKBean;
/**
 * 股东/发起人信息表
 * @author user
 *
 */
public class T_CORP_STOCK {
	public int ORG;
	public int ID;//同一个公司不一样
	public int SEQ_ID;
	private String STOCK_NAME=null;
	private float STOCK_CAPI_RMB;
	private float STOCK_RATE_RMB=1.0f;
	private float STOCK_RATE_DOLLAR=0.1579f;
	private String CREATE_DATE;
	public ArrayList<T_CORP_STOCKBean> touGuRens;//所有的股东信息
	public ArrayList<OneGuongSiMoneyBean> allMenoy;//一个公司的信息
	public ArrayList<Integer> gudongid;//存一个公司的每个股东的id
	
	public T_CORP_STOCK() {
		
		int temp=0;//每个公司有多少股东
		int o=0;
		int m;
		int[] org=new int[125];//机关代码
		int id[]=new int[25];//公司类型
		String country[]= {"中国","美国","中国","法国","中国","中国","英国","中国","日本","中国","俄罗斯","中国","加拿大","中国"};//国家
		String firstname[]= {"赵","钱","孙","李","周","吴","郑","王","蒋","沈","韩","杨","曹","马","陈","苏","姜","宋"};
		String lastname1[]= {"浩","豪","好","昊","点","雷","虹","腾","彬","诺","曼","耀","瑞","虎","宝","倩","帆","朗","鹿","洲","轩","俊","雅","霞"};
		String lastname2[]= {"平","","展","睿","威","舟","","","","桐","彤","念","农","","星","倩","华","彰","","","","龙","雅","景"};
		touGuRens=new ArrayList<>();
		
		allMenoy=new ArrayList<OneGuongSiMoneyBean>();
		for(int i=0;i<10;i++)//省份
		{	
			float renjiaozonge=0;
			String yue=null;
			String ri=null;
			Random random=new Random();
			
			ORG=876+i;//主键机关代码
			
			int companynum=random.nextInt(20)+1;
			for(int j=0;j<companynum;j++) {//控制每个地区公司个数
				renjiaozonge=0;
				//主键公司序号
				SEQ_ID=j+1;
				
				int s9=random.nextInt(12)+1;
				int s10=random.nextInt(28)+1;
			
				int s6=random.nextInt(80)+1880;//公司成立年份
				int s7=random.nextInt(24);//公司成立小时
				int s8=random.nextInt(60);//公司成立分
				if(s9<10) {
					yue="0"+s9;
				}else {
					yue=""+s9;
				}
				if(s10<10) {
					ri="0"+s10;
				}else {
					ri=""+s10;
				}
				CREATE_DATE=""+s6+"/"+yue+"/"+ri+" "+s7+":"+s8;
				
				int number=random.nextInt(20)+1;//控制股东个数
				for(int index=0;index<number;index++) {//同一个公司
					//建立一个股东
					T_CORP_STOCKBean touGuRen=new T_CORP_STOCKBean();
					//主键股东序号
					ID=index+1000;
					gudongid=new ArrayList<>();//每次重新实例化，避免将所有公司的id存到同一个集合
					gudongid.add(ID);
					touGuRen.setORG(ORG);
					touGuRen.setID(ID);
					touGuRen.setSEQ_ID(SEQ_ID);
					touGuRen.setSTOCK_TYPE("自然人");
					touGuRen.setCERTIFICATE_TYPE("身份证");
					touGuRen.setSTOCK_CAPI_TYPE("人民币");
					
					//国家
					int n=random.nextInt(country.length);
					touGuRen.setCOUNTRY(country[n]);

					//名字
					int x=random.nextInt(firstname.length);
					int y=random.nextInt(lastname1.length);
					int z=random.nextInt(lastname2.length);
					STOCK_NAME=firstname[x]+lastname1[y]+lastname2[z];
					touGuRen.setSTOCK_NAME(STOCK_NAME);
			
					//身份证号
					int s1=(int)((Math.random()*9+1)*100000);
					int s2=random.nextInt(80)+1918;				
					int s3=random.nextInt(12)+1;
					int s4=random.nextInt(28)+1;
				
					if(s3<10) {
						yue="0"+s3;
					}else {
						yue=""+s3;
					}
					if(s4<10) {
						ri="0"+s4;
					}else {
						ri=""+s4;
					}
					int s5=Math.round((random.nextFloat()+1)*1000);
				
					String shenfenzheng=""+s1+s2+yue+ri+s5;
					
					touGuRen.setCREATE_DATE(CREATE_DATE);
					touGuRen.setCERTIFICATE_NO(shenfenzheng);
				
					//股东认缴
					int renjiaoe=random.nextInt(500)+20;
					//保留两位小数
					DecimalFormat   fnum  =   new  DecimalFormat("#.00");    
					String   dd=fnum.format(renjiaoe*0.1579);
					float renjiaoedollor=Float.parseFloat(dd);
				
					touGuRen.setSTOCK_RATE_RMB(STOCK_RATE_RMB);
					touGuRen.setSTOCK_RATE_DOLLAR(STOCK_RATE_DOLLAR);
					touGuRen.setSTOCK_CAPI(renjiaoe*1.0f);
					//System.out.println("股份人民币："+touGuRen.getSTOCK_CAPI());
					touGuRen.setSTOCK_CAPI_DOLLAR(renjiaoedollor);
				
					STOCK_CAPI_RMB=renjiaoe*STOCK_RATE_RMB;
					touGuRen.setSTOCK_CAPI_RMB(STOCK_CAPI_RMB);
					touGuRens.add(touGuRen);
								
					renjiaozonge=renjiaozonge+renjiaoe;
				}
				System.out.println("-------------------------------------------------");
				OneGuongSiMoneyBean oneGongSiMoney=new OneGuongSiMoneyBean();
				oneGongSiMoney.setORG(ORG);
				oneGongSiMoney.setID(gudongid);
				oneGongSiMoney.setSEQ_ID(SEQ_ID);
				oneGongSiMoney.setAllMoney(renjiaozonge);
				oneGongSiMoney.setGuDongcount(number);
				oneGongSiMoney.setChenglishijian(CREATE_DATE);
				allMenoy.add(oneGongSiMoney);
				
				//		System.out.println("总额"+renjiaozonge);
				//		System.out.println("股东:"+number);
				//		System.out.println("temp"+temp);
				//		System.out.println("number"+number);
				for(m=temp,o=0;o<number;m++,o++)
				{
					T_CORP_STOCKBean t=touGuRens.get(m);
					float bili=t.getSTOCK_CAPI()/renjiaozonge;
					//System.out.println("循环股份"+t.getSTOCK_CAPI());
					//System.out.println("比例"+bili);
				
					DecimalFormat   fnum  =   new  DecimalFormat("#0.00");
					String dd=fnum.format(bili*100);
				
					t.setSTOCK_PERCENT(dd+"%");
					//System.out.println("转化为百分比:"+t.getSTOCK_PERCENT());
				}
				temp=number+temp;
				
			}
			
		}
//		System.out.println(touGuRens.size());
		
		//将文本输出到本地
		File fout = new File("E:\\file\\data\\T_CORP_STOCK_DATA.txt");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		for(T_CORP_STOCKBean t:touGuRens)
		{
			String sql="insert into T_CORP_STOCK values("+t.getORG()+", "+t.getID()+", "+t.getSEQ_ID()+", "+"'"+t.getSTOCK_TYPE()+"', "+"'"+t.getCOUNTRY()+"', "+"'"+t.getCERTIFICATE_TYPE()+"', "+"'"+t.getCERTIFICATE_NO()+"', "+"'"+t.getSTOCK_NAME()+"', "+"'"+t.getSTOCK_CAPI_TYPE()+"', "+t.getSTOCK_CAPI()+", "+t.getSTOCK_CAPI_DOLLAR()+", "+t.getSTOCK_CAPI_RMB()+", "+"'"+t.getSTOCK_PERCENT()+"', "+t.getSTOCK_RATE_RMB()+", "+t.getSTOCK_RATE_DOLLAR()+", "+"to_date('"+t.getCREATE_DATE()+"','yyyy-mm-dd hh24:mi')); ";
			// 将写文件指针移到文件尾。
			bw.write(sql);
			bw.newLine();
			//System.out.println(sql);
		}
			bw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new T_CORP_STOCK();
		
	}
}
