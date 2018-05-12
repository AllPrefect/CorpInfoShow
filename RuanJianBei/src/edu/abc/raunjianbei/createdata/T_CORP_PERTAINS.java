package edu.abc.raunjianbei.createdata;

import java.util.Random;

public class T_CORP_PERTAINS {
	private int ORG;
	private int ID;
	private int SEQ_ID;
	private String CERTIFICATE_TYPE;//证件类型
	private String PERSON_NAME;//成员姓名
	private String PERSON_TYPE;//成员职务
	private String CERTIFICATE_NO;//证件编号
	private String SELECT_TYPE;//产生方式
	private String HOLDPOST_START;//任职期限起
	private String HOLDPOST_END;//任职期限止
	private String SEX;//性别
	private int AGE;//年龄
	private String COUNTRY;//国籍
	private String CREATE_DATE;//创建日期
	
	public T_CORP_PERTAINS() {
		String[] certificate_type= {"身份证","军官证"};
		String[] person_type= {"总经理","123"};
		
		String firstname[]= {"赵","钱","孙","李","周","吴","郑","王","蒋","沈","韩","杨","曹","马","陈","苏","姜","宋"};
		String lastname1[]= {"浩","豪","好","昊","点","雷","虹","腾","彬","诺","曼","耀","瑞","虎","宝","倩","帆","朗","鹿","洲","轩","俊","雅","霞"};
		String lastname2[]= {"平","","展","睿","威","舟","","","","桐","彤","念","农","","星","倩","华","彰","","","","龙","雅","景"};
		
		String country[]= {"中国","美国","中国","法国","中国","中国","英国","中国","日本","中国","俄罗斯","中国","加拿大","中国"};//国家
		
		for(int x=0;x<1;x++) {//省份机关代码
			String yue=null;
			String ri=null;
			ORG=876+x;//主键省份机关代码
			
			Random random=new Random();
			int companynum=random.nextInt(10);
			for(int y=0;y<companynum;y++) {//每个地区公司的个数
				SEQ_ID=y+1;//主键公司序号
				
				int personnum=random.nextInt(10);
				for(int z=0;z<personnum;z++) {//每个公司的成员
					ID=z+1000;//主键成员序号
					
					//证件类型
					int cert=random.nextInt(certificate_type.length);
					CERTIFICATE_TYPE=certificate_type[cert];
					System.out.println(CERTIFICATE_TYPE);
					
					//成员姓名
					int x1=random.nextInt(firstname.length);
					int y1=random.nextInt(lastname1.length);
					int z1=random.nextInt(lastname2.length);
					PERSON_TYPE=firstname[x1]+lastname1[y1]+lastname2[z1];
					System.out.println("成员姓名："+PERSON_TYPE);
					
					//职务
					int person=random.nextInt(person_type.length);
					PERSON_TYPE=person_type[person];
					System.out.println(PERSON_TYPE);
					
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
					CERTIFICATE_NO=""+s1+s2+yue+ri+s5;
					System.out.println("证件号："+CERTIFICATE_NO);
					
					//性别
					int sex=random.nextInt(2);
					if(sex==0) {
						SEX="女";
					}else {
						SEX="男";
					}
					System.out.println(SEX);
					
					//年龄
					int age=random.nextInt(40)+30;
					AGE=age;
					System.out.println("年龄"+AGE);
					
					//国籍
					int coun=random.nextInt(country.length);
					COUNTRY=country[coun];
					System.out.println("国家："+COUNTRY);
					
					//日期
					int s6=random.nextInt(80)+1880;//公司成立年份
					int s7=random.nextInt(24);//公司成立小时
					int s8=random.nextInt(60);//公司成立分
					CREATE_DATE=""+s6+"/"+yue+"/"+ri+" "+s7+":"+s8;
					HOLDPOST_START=""+s6+"/"+yue+"/"+ri+" "+s7+":"+s8;
					
					System.out.println();
					
					String sql="insert into T_CORP_PERTAINS values()";
				}
				System.out.println("-------------------------------------------------");
			}
		}
	}
	
	public static void main(String[] args) {
		new T_CORP_PERTAINS();
	}
}
