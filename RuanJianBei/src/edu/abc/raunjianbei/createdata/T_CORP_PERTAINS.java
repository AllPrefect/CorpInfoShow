package edu.abc.raunjianbei.createdata;

import java.util.Random;

public class T_CORP_PERTAINS {
	private int ORG;
	private int ID;
	private int SEQ_ID;
	private String CERTIFICATE_TYPE;//֤������
	private String PERSON_NAME;//��Ա����
	private String PERSON_TYPE;//��Աְ��
	private String CERTIFICATE_NO;//֤�����
	private String SELECT_TYPE;//������ʽ
	private String HOLDPOST_START;//��ְ������
	private String HOLDPOST_END;//��ְ����ֹ
	private String SEX;//�Ա�
	private int AGE;//����
	private String COUNTRY;//����
	private String CREATE_DATE;//��������
	
	public T_CORP_PERTAINS() {
		String[] certificate_type= {"���֤","����֤"};
		String[] person_type= {"�ܾ���","123"};
		
		String firstname[]= {"��","Ǯ","��","��","��","��","֣","��","��","��","��","��","��","��","��","��","��","��"};
		String lastname1[]= {"��","��","��","�","��","��","��","��","��","ŵ","��","ҫ","��","��","��","ٻ","��","��","¹","��","��","��","��","ϼ"};
		String lastname2[]= {"ƽ","","չ","�","��","��","","","","ͩ","ͮ","��","ũ","","��","ٻ","��","��","","","","��","��","��"};
		
		String country[]= {"�й�","����","�й�","����","�й�","�й�","Ӣ��","�й�","�ձ�","�й�","����˹","�й�","���ô�","�й�"};//����
		
		for(int x=0;x<1;x++) {//ʡ�ݻ��ش���
			String yue=null;
			String ri=null;
			ORG=876+x;//����ʡ�ݻ��ش���
			
			Random random=new Random();
			int companynum=random.nextInt(10);
			for(int y=0;y<companynum;y++) {//ÿ��������˾�ĸ���
				SEQ_ID=y+1;//������˾���
				
				int personnum=random.nextInt(10);
				for(int z=0;z<personnum;z++) {//ÿ����˾�ĳ�Ա
					ID=z+1000;//������Ա���
					
					//֤������
					int cert=random.nextInt(certificate_type.length);
					CERTIFICATE_TYPE=certificate_type[cert];
					System.out.println(CERTIFICATE_TYPE);
					
					//��Ա����
					int x1=random.nextInt(firstname.length);
					int y1=random.nextInt(lastname1.length);
					int z1=random.nextInt(lastname2.length);
					PERSON_TYPE=firstname[x1]+lastname1[y1]+lastname2[z1];
					System.out.println("��Ա������"+PERSON_TYPE);
					
					//ְ��
					int person=random.nextInt(person_type.length);
					PERSON_TYPE=person_type[person];
					System.out.println(PERSON_TYPE);
					
					//���֤��
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
					System.out.println("֤���ţ�"+CERTIFICATE_NO);
					
					//�Ա�
					int sex=random.nextInt(2);
					if(sex==0) {
						SEX="Ů";
					}else {
						SEX="��";
					}
					System.out.println(SEX);
					
					//����
					int age=random.nextInt(40)+30;
					AGE=age;
					System.out.println("����"+AGE);
					
					//����
					int coun=random.nextInt(country.length);
					COUNTRY=country[coun];
					System.out.println("���ң�"+COUNTRY);
					
					//����
					int s6=random.nextInt(80)+1880;//��˾�������
					int s7=random.nextInt(24);//��˾����Сʱ
					int s8=random.nextInt(60);//��˾������
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
