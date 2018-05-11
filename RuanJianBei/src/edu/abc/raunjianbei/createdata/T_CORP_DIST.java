package edu.abc.raunjianbei.createdata;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

public class T_CORP_DIST {
	private int ORG;//主键机关代码
	private int ID;//代表分公司序列
	private int SEQ_ID;//主公司序列
	private String DIST_REG_NO;//分支机构统一社会信用代码
	private String DIST_NAME;//分支机构名称
	private String DIST_BELONG_ORG;
	private int DIST_CORP_ORG;
	private int DIST_CORP_ID;
	private int DIST_CORP_SEQ_ID;
	private String FARE_PLACE;//营业场所
	private String OPER_MAN_IDENT_NO;//负责人证件编号
	private String OPER_MAN_NAME;//负责人姓名
	private String FARE_SCOPE;//经营范围
	private String START_DATE;//成立日期
	private String CHECK_DATE;//核准日期
	private String CREATE_DATE;//创建时间
	private BufferedWriter bw;
	public T_CORP_DIST() {
		String firstname[]= {"赵","钱","孙","李","周","吴","郑","王","蒋","沈","韩","杨","曹","马","陈","苏","姜","宋"};
		String lastname1[]= {"浩","豪","好","昊","点","雷","虹","腾","彬","诺","曼","耀","瑞","虎","宝","倩","帆","朗","鹿","洲","轩","俊","雅","霞"};
		String lastname2[]= {"平","","展","睿","威","舟","","","","桐","彤","念","农","","星","倩","华","彰","","","","龙","雅","景"};
		
		String[] hubei={"武汉","黄石","十堰","襄阳","宜昌","鄂州","荆门","孝感","荆州","黄冈","咸宁","随州","恩施","仙桃","潜江","天门","神农架"}; 
        String[] town= {"东城区","西城区","南城区","北城区","解放路","友谊街","和平大道","凯旋街道","四季青街道","丁桥镇","康桥镇","进化镇","义桥镇","西溪街道","文化街道","古荡街道","留仙街道","江山镇","更楼镇","寿昌镇","大公桥社区","胜利路","八宝街","汉宜社区","黄龙镇"};
		
        File fout = new File("E:\\file\\data\\T_CORP_DIST_DATA.txt");
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(fout);
			bw = new BufferedWriter(new OutputStreamWriter(fos));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        
		for(int x=0;x<1;x++) {//省份机关代码
			String yue=null;
			String ri=null;
			ORG=876+x;
			DIST_CORP_ORG=ORG;
			Random random=new Random();
			int creditnum1=random.nextInt(10);
			
			int companynum=random.nextInt(10);
			for(int y=0;y<companynum;y++) {//每个地区公司的个数
				SEQ_ID=y+1;
				DIST_CORP_ID=SEQ_ID+1000;
				DIST_CORP_SEQ_ID=SEQ_ID;
				int creditnum2=random.nextInt(10);
				int creditnum3=(int)((Math.random()*9+1)*100000);
				
				int distnum=random.nextInt(10);
				for(int z=0;z<distnum;z++) {//每个公司分公司个数
					//主键公司序号
					ID=z+1000;
					
					//分支机构统一社会信用代码
					/*   统一社会信用代码设计为18位，使用阿拉伯数字或英文字母表示，由五个部分组成。
					 * 第一部分（第1位）：为登记管理部门代码；
					 * 第二部分（第2位）：为企业等纳税人类别代码；
					 * 第三部分（第3-8位）：为登记管理机关行政区划码；
					 * 第四部分（第9-17位）：为主体标识码；
					 * 第五部分（第18位）：为校验码，由系统自动生成。*/	
					int creditnum4=(int)((Math.random()*9+1)*100000000);
					String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
					char creditnum5=chars.charAt((int)(Math.random() * 26));
					DIST_REG_NO=""+creditnum1+creditnum2+creditnum3+creditnum4+creditnum5;
					System.out.println("信用代码："+DIST_REG_NO);
					
					//负责人证件编号
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
					OPER_MAN_IDENT_NO=""+s1+s2+yue+ri+s5;
					System.out.println("证件号："+OPER_MAN_IDENT_NO);
					
					//负责人
					int x1=random.nextInt(firstname.length);
					int y1=random.nextInt(lastname1.length);
					int z1=random.nextInt(lastname2.length);
					OPER_MAN_NAME=firstname[x1]+lastname1[y1]+lastname2[z1];
					System.out.println("负责人："+OPER_MAN_NAME);
					
					//日期
					int s6=random.nextInt(55)+1960;//公司成立年份
					int s7=random.nextInt(24);//公司成立小时
					int s8=random.nextInt(60);//公司成立分
					START_DATE=""+s6+"/"+yue+"/"+ri+" "+s7+":"+s8;
					CHECK_DATE=""+s6+"/"+yue+"/"+ri+" "+s7+":"+s8;
					CREATE_DATE=""+s6+"/"+yue+"/"+ri+" "+s7+":"+s8;
					
					//营业场所
					int n=random.nextInt(1000);
					FARE_PLACE="湖北省"+hubei[x]+town[y]+n+"号";
					System.out.println("营业场所："+FARE_PLACE);
					
					String sql="insert into T_CORP_DIST values("+ORG+", "+ID+", "+SEQ_ID+", '"+DIST_REG_NO+"', '"+DIST_NAME+"', '"+DIST_BELONG_ORG+"', "+DIST_CORP_ORG+", "+DIST_CORP_ID+", "+DIST_CORP_SEQ_ID+", '"+FARE_PLACE+"', '"+OPER_MAN_IDENT_NO+"', '"+OPER_MAN_NAME+"', '"+FARE_SCOPE+"', "+"to_date('"+START_DATE+"','yyyy-mm-dd hh24:mi')"+", "+"to_date('"+CHECK_DATE+"','yyyy-mm-dd hh24:mi')"+", "+"to_date('"+CREATE_DATE+"','yyyy-mm-dd hh24:mi')"+");";
					try {
						bw.write(sql);
						bw.newLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println(sql);
				}
				System.out.println("----------------------------------------------");
			}
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	}
	
	public static void main(String[] args) {
		new T_CORP_DIST();
	}
}
