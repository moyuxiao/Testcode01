package com.scss;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class RWExcel {
	
	private String filePath;
	private String anotherfilePath;
 
	
	/**
	 * ���췽��
	 * */
	
	public RWExcel(String filePath,String anotherfilePath){
		
		this.filePath = filePath;
		this.anotherfilePath = anotherfilePath;
	}
 
	/**
	 * 
	 * ��ȡexcel ��װ�ɼ���
	 * �ó�����Ҫ����һ��excel ��excel������ �����ɳ����Զ����
	 * ע�⣺�÷���ͳ�Ƶ�������Ĭ�ϵ�һ��Ϊtitle ������ͳ�Ƶ�
	 * 
	 * @return
	 * 
	 */
	// @Test
	public ArrayList<List> ReadExcel(int sheetNum) {
 
		// int column = 5;//column��ʾexcel������
 
		ArrayList<List> list = new ArrayList<List>();
 
		try {
			// ����Ҫ��ȡ��excel�ļ�д��stream
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(filePath));
			// ָ��sheet�±�Ϊ0��sheet ����һ��sheet Ҳ���԰���sheet��������Ѱ��
			HSSFSheet sheet = workbook.getSheetAt(sheetNum);
			// ��ȡsheet1�е�������
			int rowTotalCount = sheet.getLastRowNum();
			//��ȡ������
			int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
			
			//System.out.println("����Ϊ��"+rowTotalCount+"����Ϊ��"+columnCount);
 
			for (int i = 0; i <= rowTotalCount; i++) {
				// ��ȡ��i�е�row����
				HSSFRow row = sheet.getRow(i);
				
				ArrayList<String> listRow = new ArrayList<String>();
 
				for (int j = 0; j < columnCount; j++) {
					//���в���Ϊ�ж�cell��ȡ���������Ƿ�Ϊnull ����������� ����ᱨ��
					String cell = null;
					//���δnull�����""��װ�ɷ�null���ַ���
					if(row.getCell(j) == null){
						
						cell = row.getCell(j)+"";
						
						listRow.add(cell);
					//�����ȡ����cell��Ϊnull ��ֱ�Ӽ���	listRow����
					}else{
						cell = row.getCell(j).toString();
						listRow.add(cell);
					}
					// �ڵ�i�� ���λ�ȡ��i�еĵ�j��λ���ϵ�ֵ %15s��ʾǰ����15���ֽ����
					//System.out.printf("%15s", cell);
 
				}
 
				list.add(listRow);
 
				//System.out.println();
			}
 
		} catch (FileNotFoundException e) {
 
			e.printStackTrace();
		} catch (IOException e) {
 
			e.printStackTrace();
		}
 
		return list;
	}
	
	/**
	 * ��ȡ����һ��Excel �����list����
	 * */
	
	public ArrayList<List> ReadAnotherExcel(int anotherSheetNum){
		
 
		ArrayList<List> list = new ArrayList<List>();
 
		try {
			// ����Ҫ��ȡ��excel�ļ�д��stream
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(anotherfilePath));
			// ָ��sheet�±�Ϊ0��sheet ����һ��sheet Ҳ���԰���sheet��������Ѱ��
			HSSFSheet sheet = workbook.getSheetAt(anotherSheetNum);
			// ��ȡsheet1�е�������
			int rowTotalCount = sheet.getLastRowNum();
			//��ȡ������
			int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
			
			//System.out.println("����Ϊ��"+rowTotalCount+"����Ϊ��"+columnCount);
 
			for (int i = 0; i <= rowTotalCount; i++) {
				// ��ȡ��i�е�row����
				HSSFRow row = sheet.getRow(i);
				
				ArrayList<String> listRow = new ArrayList<String>();
 
				for (int j = 0; j < columnCount; j++) {
					//���в���Ϊ�ж�cell��ȡ���������Ƿ�Ϊnull ����������� ����ᱨ��
					String cell = null;
					//���δnull�����""��װ�ɷ�null���ַ���
					if(row.getCell(j) == null){
						
						cell = row.getCell(j)+"";
						
						listRow.add(cell);
					//�����ȡ����cell��Ϊnull ��ֱ�Ӽ���	listRow����
					}else{
						cell = row.getCell(j).toString();
						listRow.add(cell);
					}
					// �ڵ�i�� ���λ�ȡ��i�еĵ�j��λ���ϵ�ֵ %15s��ʾǰ����15���ֽ����
					//System.out.printf("%15s", cell);
 
				}
 
				list.add(listRow);
 
				//System.out.println();
			}
 
		} catch (FileNotFoundException e) {
 
			e.printStackTrace();
		} catch (IOException e) {
 
			e.printStackTrace();
		}
 
		return list;
	}
	
	
	/**
	 * ���Է���
	 * */
 
//	public static void main(String[] args) {
//
//		 RWExcel excel = new RWExcel("D:\\345.xls", "D:\\345.xls");
//		 
//		 ArrayList<List> list1 = excel.ReadExcel(0);
//
//		 ArrayList<List> list2 = excel.ReadAnotherExcel(1);
//		 
//		 for (List list : list1) {
//			
//			 System.out.println(list.toString());
//		}
//		 
//		 System.out.println("==========================");
//		 
//		 for (List list : list2) {
//				
//			 System.out.println(list.toString());
//		}
//	}
}