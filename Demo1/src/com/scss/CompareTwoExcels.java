package com.scss;
 
/**
 * �ȶ�����excel��������sheet�Ƿ���ͬ �о�׼ƥ��/ģ��ƥ�����ַ�ʽ
 * @author AnndyTou
 * @Time 2018-07-17
 * @Detail  
 * */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
 
/**
 * ����RWExcel.java ��ȡ����excel��װ��ArrrayList���� ͨ�����ϵ��±���бȶ�
 */
 
public class CompareTwoExcels {
 
	private String exportExcelFilePath;
	private String WebExcelFilePath;
	private boolean isPerfectMatch;
 
	/**
	 * ���췽��
	 * 
	 * @isPerfectMatch ��ʾ�Ƿ���Ҫ��ȫƥ��
	 */
 
	public CompareTwoExcels(String exportExcelFilePath, String WebExcelFilePath, boolean isPerfectMatch) {
 
		this.exportExcelFilePath = exportExcelFilePath;
		this.WebExcelFilePath = WebExcelFilePath;
		this.isPerfectMatch = isPerfectMatch;
	}
 
	/**
	 * �߼��ȶ�
	 */
 
	public void comparedExcels(int exportExcelSheetNum, int WebExcelSheetNum) {
 
		RWExcel excel = new RWExcel(exportExcelFilePath, WebExcelFilePath);
 
		ArrayList<List> exportExcel_list = excel.ReadExcel(exportExcelSheetNum);
 
		ArrayList<List> WebExcel_list = excel.ReadAnotherExcel(WebExcelSheetNum);
		// �����ж��Ƿ���ȫƥ�䷽ʽȥƥ������excel
		if (isPerfectMatch) {
			// ��web�˻�ȡ��excel����Ϊ�ο� �ȶԵ�����excel����
			for (int i = 1; i <= WebExcel_list.size(); i++) {
				List list1 = WebExcel_list.get(i - 1);
				List list2 = exportExcel_list.get(i - 1);
 
				if (list2.equals(list1)) {
					String infos = "Success-----�����" + i + "����ȫƥ��-------�ɹ�";
					System.out.println(infos);
				} else {
					String infos = "Fail-----�����" + i + "��Web���뵼���ı���ƥ��-------ʧ��";
					System.out.println(infos);
				}
			}
 
		} else if (!isPerfectMatch) {
			// ��web�˻�ȡ��excel����Ϊ�ο� �ȶԵ�����excel����
			for (int i = 1; i <= WebExcel_list.size(); i++) {
				List list1 = WebExcel_list.get(i - 1);
				List list2 = exportExcel_list.get(i - 1);
				//����HashSet���ص� ���ܴ洢�ظ������� ���Һ��ɰ������������� ���� HashSet���Ͽ��Ժ���˳��
				Set<String> hashSet1 = new HashSet<>();
				Set<String> hashSet2 = new HashSet<>();
 
				if (list1 != null && list2 != null) {
 
					for (int q = 0; q < list1.size(); q++) {
 
						hashSet1.add((String) list1.get(q));
					}
 
					for (int v = 0; v < list2.size(); v++) {
 
						hashSet2.add((String) list2.get(v));
					}
				}
				//����
				//System.out.println(hashSet1.toString()+"=========="+hashSet2.toString());
				
				
 
				if (hashSet2.size() != hashSet1.size()) {
					System.out.println("Fail-----��" + i + "��Web���뵼���ı����Ȳ���-------ʧ��");
					
					//System.out.println(hashSet1.toString()+"=========="+hashSet2.toString());
				}else {
					if(hashSet2.equals(hashSet1)){
						
						System.out.println("Success-----��" + i + "��Web���뵼���ı���ƥ��-------�ɹ�");
					}else{
						System.out.println("Fail-----��" + i + "��Web���뵼���ı����Ȳ���-------ʧ��");
					}
					
					//System.out.println(hashSet1.toString()+"=========="+hashSet2.toString());
				}
			}
		}
	}
 
	/**
	 * ���Է���
	 */
 
	public static void main(String[] args) {
		// ��һ��excelΪweb��ץȡ��excel �ڶ���excelΪ������excel false��ʾ����׼ƥ��
		CompareTwoExcels excels = new CompareTwoExcels("D:\\345.xls", "D:\\345.xls", true);
		// ѡ��xls��sheet�±�
		excels.comparedExcels(0, 1);
 
	}
	
	/**
	 * ��װһ������ ͳ��һ���ַ�����һ��set�����еĸ���  �ڱ�class��û������֮��
	 * */
	
	public int setList(Set<String> hashSet , String str){
		
		int count = 0;
		
		//set���ϲ���ʹ��get(index)�ķ���ȡֵ
		Iterator<String> iterator = hashSet.iterator();
		
		while(iterator.hasNext()){
			
			if(str.equals(iterator.next())){
				
				count++;
			}
		}
		
		return count;
 
	}
	
	/**
	 * �Ƚ�
	 * */
 
}