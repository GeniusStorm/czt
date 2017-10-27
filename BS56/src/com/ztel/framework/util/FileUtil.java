package com.ztel.framework.util;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.util.Reflection;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.ztel.app.vo.CTitle;
import com.ztel.app.vo.sys.AttachVo;

import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.BorderLineStyle;
import jxl.write.Border;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;



public class FileUtil {
	
	/*
	 *
	 *
	 *
	 *
	 **/
	 public static HashMap<String,String> uploadFile(HttpServletRequest request,HttpServletResponse response,String folderName) throws IllegalStateException, IOException {  
			//List<String> listFile=new ArrayList<String>();
			HashMap<String, String> fileNameMap=new HashMap<>();
			//创建一个通用的多部分解析器  
		       CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
	      //判断 request 是否有文件上传,即多部分请求  
		      if(multipartResolver.isMultipart(request)){  
	          //转换成多部分request    
	          MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
		          //取得request中的所有文件名  
		          Iterator<String> iter = multiRequest.getFileNames();  
		          StringBuffer dirSB = new StringBuffer(System.getProperty("web.root"));
		          dirSB.append(File.separator);
		          dirSB.append(folderName);
		          dirSB.append(File.separator);
		          SimpleDateFormat df1 = new SimpleDateFormat("yyyyMM");
		          String dateDir = df1.format(new Date());
		          dirSB.append(dateDir);
		          dirSB.append(File.separator);
		          // 创建文件夹

		         File dir = new File(dirSB.toString());
		          if (!dir.exists()) {
		              dir.mkdirs();
		          }
	          while(iter.hasNext()){  
		               //记录上传过程起始时的时间，用来计算上传时间  
	           
	              //取得上传文件  
		              MultipartFile file = multiRequest.getFile(iter.next());  
		               if(file != null){  
		            	   //取页面file对象的name属性值

		            	   String key=getFieldValueByName("fieldName",getFieldValueByName("fileItem",file)).toString();
		                 //取得当前上传文件的文件名称  
		            	   String fileName = file.getOriginalFilename();
		                   String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		                   SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		                   String newfileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
		                   
		                   if(!"".equals(fileName)){
			                   fileNameMap.put(key, folderName+"/"+dateDir+"/"+newfileName);
			                  // listFile.add(folderName+"\\"+dateDir+"\\"+newfileName);//
		                      //定义上传路径  
			                      String path =  dirSB.toString()+newfileName; 
		                          File localFile = new File(path);  
			                       file.transferTo(localFile);  
			                   }  
		               		}
		               }  
		       
		             
		           }  
		           
		  
		       
	      return fileNameMap;  
	    }  
	
	 
	 
	/**
	 * 根据属性名获取属性值

	 * */
    private static Object getFieldValueByName(String fieldName, Object o) {
        try {  
            String firstLetter = fieldName.substring(0, 1).toUpperCase();  
            String getter = "get" + firstLetter + fieldName.substring(1);  
            Method method = o.getClass().getMethod(getter, new Class[] {});  
            Object value = method.invoke(o, new Object[] {});  
            return value;  
        } catch (Exception e) {  
            //log.error(e.getMessage(),e);  
            return null;  
        }  
    } 
    
    
    private static String[] getFiledName(Object o){
    	Field[] fields=o.getClass().getDeclaredFields();
       	String[] fieldNames=new String[fields.length];
    	for(int i=0;i<fields.length;i++){
    		System.out.println(fields[i].getType());
    		fieldNames[i]=fields[i].getName();
    	}
    	return fieldNames;
    }
    private static List<String> getFiledName(Object o,List<String> needPrintFields){
    	Field[] fields=o.getClass().getDeclaredFields();
    	List<String> fieldNames=new ArrayList<String>();
    	for(int i=0;i<fields.length;i++){
    		//System.out.println(fields[i].getType());
    		if(needPrintFields.contains(fields[i].getName()))
    			fieldNames.add(fields[i].getName());
    	}
    	return fieldNames;
    }
   
    
   
    public static Object[] getFiledValues(Object o){
    	String[] fieldNames=getFiledName(o);
    	Object[] value=new Object[fieldNames.length];
    	for(int i=0;i<fieldNames.length;i++){
    		value[i]=getFieldValueByName(fieldNames[i], o);
    	}
    	return value;
    }	
    public static Object[] getFiledValues(Object o,List<String> needPrintFields){
    	List<String >fieldNames=getFiledName(o,needPrintFields);
    	Object[] value=new Object[fieldNames.size()];
    	for(int i=0;i<fieldNames.size();i++){
    		value[i]=getFieldValueByName(fieldNames.get(i), o);
    	}
    	return value;
    }
    
    public static WritableCellFormat getTitleFormat() throws WriteException
    {
    	WritableFont fontTitle = new WritableFont(WritableFont.TIMES, 12, WritableFont.NO_BOLD );  
    	//fontTitle.setColour(jxl.format.Colour.RED);  
    	WritableCellFormat formatTitle = new WritableCellFormat(fontTitle);  
    	formatTitle.setWrap(true);  
    	formatTitle.setBorder(Border.ALL, BorderLineStyle.THIN );
    	formatTitle.setAlignment(Alignment.CENTRE);
    	return formatTitle;

    }
    public static WritableCellFormat getContentFormat() throws WriteException
    {
    	WritableFont fontTitle = new WritableFont(WritableFont.TIMES, 10, WritableFont.NO_BOLD );  
    	//fontTitle.setColour(jxl.format.Colour.RED);  
    	WritableCellFormat formatTitle = new WritableCellFormat(fontTitle);  
    	formatTitle.setWrap(true);  
    	formatTitle.setAlignment(Alignment.CENTRE);
    	formatTitle.setBorder(Border.ALL, BorderLineStyle.THIN);
    	
    	return formatTitle;

    }
    
    public static <T> HashMap<String,List<T>> GetGroupList(List<T> list, String groupField)
    {
    	HashMap<String,List<T>> returnv=new HashMap<String,List<T>>();
    	
    	  for(int i = 0; i < list.size(); i++){
    		  T o=list.get(i);
    		 String code= getFieldValueByName(groupField, o).toString();
    		 if(returnv.containsKey(code))
    		 {
    			 List<T> temp=returnv.get(code);
    			 temp.add(o);
    		 }
    		 else
    		 {
    			 ArrayList<T> temp=new ArrayList<T>();
    			 temp.add(o);
    			 returnv.put(code, temp);
    		 }
    	  }
    	return returnv;
    }
    
    public static void ExportToExcel(ArrayList<?>datas,String sheetName,List<List<CTitle>> titles,List<String> needPrintFields,HttpServletResponse response) throws Exception {
    	if(datas==null)
    	{
    		return;
    	}
    	String reportTitle="";
		String fileName = System.currentTimeMillis()+"";
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", new StringBuffer("attachment").append( ";filename=" ).append(fileName).append(".xls").toString());
        WritableWorkbook book = null;
        WritableCellFormat contentFormat=getContentFormat();
        try {
        	book = Workbook.createWorkbook(response.getOutputStream());
            WritableSheet sheet = book.createSheet(sheetName, 0);
           CellView navCellView = new CellView();  

            navCellView.setAutosize(true); 
           navCellView.setSize(18);
           int  columnCount=needPrintFields.size();
           for(int j=0;j<columnCount;j++)
           {
             sheet.setColumnView(j, navCellView); 
           }
           int titlesCount=titles.size();
           for(int c=0;c<titlesCount;c++)
           {
        	   List<CTitle> temp=titles.get(c);
        	   int startC=0;
        	   for(int m=0;m<temp.size();m++)
        	   {
        		   CTitle tempTitle=temp.get(m);
        		   sheet.mergeCells(startC, c, startC+tempTitle.getColumnLines()-1, c);
        		   sheet.addCell(new Label(startC,c , tempTitle.getTitle(),tempTitle.getFormats()));
        		   startC+=tempTitle.getColumnLines();
        	   }
           }
         
           
            
	        for(int i = 0; i < datas.size(); i++){
	        	Object o=datas.get(i);
	        	
	            Object[] objs=	getFiledValues(o,needPrintFields);
	            for(int j=0;j<objs.length;j++)
	            {
	            	String v="";
	            	if(objs[j]!=null)
	            	{
	            		v=objs[j].toString();
	            	}
	            sheet.addCell(new Label(j,i+titlesCount , v,contentFormat));
	            }
	            
	        }
	        book.write();
        }
        finally {
        	if (book != null) {
        		book.close();
        	}
        }
    }
    
	public static void ExportToExcel(ArrayList<?>datas,String sheetName,String title,List<String> needPrintFields,List<String> ColumnTitle, HttpServletResponse response) throws Exception {
    	if(datas==null)
    	{
    		return;
    	}
    	String reportTitle="";
		String fileName =  System.currentTimeMillis()+"";
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", new StringBuffer("attachment").append( ";filename=" ).append(fileName).append(".xls").toString());
        WritableWorkbook book = null;
        WritableCellFormat contentFormat=getContentFormat();
        try {
        	book = Workbook.createWorkbook(response.getOutputStream());
            WritableSheet sheet = book.createSheet(sheetName, 0);
//           CellView navCellView = new CellView();  
//
//            navCellView.setAutosize(true); 
//           navCellView.setSize(18);
           int  columnCount=needPrintFields.size();
           for(int j=0;j<columnCount;j++)
           {
             sheet.setColumnView(j, 20); 
           }
          // sheet.setColumnView(3, navCellView);
          //  sheet.setRowView(0, 500); 
        
	        //写入表头
            if(title!=null)
            {
            	reportTitle=title;
            }
            
	        for(int i = 0; i < datas.size(); i++){
	        	Object o=datas.get(i);
	        	if(i==0)
	        	{
	        		int len=getFiledName(o,needPrintFields).size();
	        		sheet.mergeCells(0, 0, len-1, 0);
	        		sheet.addCell(new Label(0,0 , reportTitle,getTitleFormat()));
	        		for(int n=0;n<ColumnTitle.size();n++)
	        		{
	        			sheet.addCell(new Label(n,1 , ColumnTitle.get(n),getTitleFormat()));
	        		}
	        	}
	        	//voName.getComponentType() o=(voName)voName.newInstance();
	        
	            Object[] objs=	getFiledValues(o,needPrintFields);
	            for(int j=0;j<objs.length;j++)
	            {
	            	String v="";
	            	if(objs[j]!=null)
	            	{
	            		v=objs[j].toString();
	            	}
	            sheet.addCell(new Label(j,i+2 , v,contentFormat));
	            }
	            
	        }
	        book.write();
        }
        finally {
        	if (book != null) {
        		book.close();
        	}
        }
    }
	public static void ExportToExcel(ArrayList<?>datas,String sheetName,String title,List<String> needPrintFields,List<String> ColumnTitle,List<String> footer, HttpServletResponse response) throws Exception {
    	if(datas==null)
    	{
    		return;
    	}
    	String reportTitle="";
		String fileName =  System.currentTimeMillis()+"";
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", new StringBuffer("attachment").append( ";filename=" ).append(fileName).append(".xls").toString());
        WritableWorkbook book = null;
        WritableCellFormat contentFormat=getContentFormat();
        try {
        	book = Workbook.createWorkbook(response.getOutputStream());
            WritableSheet sheet = book.createSheet(sheetName, 0);
//           CellView navCellView = new CellView();  
//
//            navCellView.setAutosize(true); 
//           navCellView.setSize(18);
           int  columnCount=needPrintFields.size();
           for(int j=0;j<columnCount;j++)
           {
             sheet.setColumnView(j, 20); 
           }
          // sheet.setColumnView(3, navCellView);
          //  sheet.setRowView(0, 500); 
        
	        //写入表头
            if(title!=null)
            {
            	reportTitle=title;
            }
            
	        for(int i = 0; i < datas.size(); i++){
	        	Object o=datas.get(i);
	        	if(i==0)
	        	{
	        		int len=getFiledName(o,needPrintFields).size();
	        		sheet.mergeCells(0, 0, len-1, 0);
	        		sheet.addCell(new Label(0,0 , reportTitle,getTitleFormat()));
	        		for(int n=0;n<ColumnTitle.size();n++)
	        		{
	        			sheet.addCell(new Label(n,1 , ColumnTitle.get(n),getTitleFormat()));
	        		}
	        	}
	        	//voName.getComponentType() o=(voName)voName.newInstance();
	        
	            Object[] objs=	getFiledValues(o,needPrintFields);
	            for(int j=0;j<objs.length;j++)
	            {
	            	String v="";
	            	if(objs[j]!=null)
	            	{
	            		v=objs[j].toString();
	            	}
	            sheet.addCell(new Label(j,i+2 , v,contentFormat));
	            }
	            
	            
	        }
	        
	        if(footer!=null)
            {
            for(int n=0;n<footer.size();n++)
            {
            	sheet.mergeCells( 0, 2+datas.size()+n, needPrintFields.size()-1,2+datas.size()+n);
            	sheet.addCell(new Label(0,2+datas.size()+n,footer.get(n),contentFormat));
            }
            }
	        book.write();
        }
        finally {
        	if (book != null) {
        		book.close();
        	}
        }
    }
	public static void ExportToExcelComplaint(ArrayList<?>datas,String sheetName,List<CTitle> titles,List<String> needPrintFields,String needAnalyze,HttpServletResponse response) throws Exception {
    	if(datas==null)
    	{
    		return;
    	}
    	String reportTitle="";
		String fileName = System.currentTimeMillis()+"";
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", new StringBuffer("attachment").append( ";filename=" ).append(fileName).append(".xls").toString());
        WritableWorkbook book = null;
        WritableCellFormat contentFormat=getContentFormat();
        try {
        	book = Workbook.createWorkbook(response.getOutputStream());
            WritableSheet sheet = book.createSheet(sheetName, 0);
           CellView navCellView = new CellView();  

            navCellView.setAutosize(true); 
          // navCellView.setSize(18);
           int  columnCount=titles.size();
           sheet.setColumnView(0, 14); 
//           for(int j=0;j<columnCount;j++)
//           {
//             sheet.setColumnView(j, navCellView); 
//           }
           int titlesCount=1;
//           for(int c=0;c<titlesCount;c++)
//           {
//        	   List<CTitle> temp=titles.get(c);
        	   int startC=0;
        	   for(int m=0;m<titles.size();m++)
        	   {
        		   CTitle tempTitle=titles.get(m);
        		   sheet.mergeCells(startC, 0, startC+tempTitle.getColumnLines()-1,0);
        		   sheet.addCell(new Label(startC,0 , tempTitle.getTitle(),tempTitle.getFormats()));
        		   startC+=tempTitle.getColumnLines();
        	   }
//           }
            
	        for(int i = 0; i < datas.size(); i++){
	        	Object o=datas.get(i);
	        	
	            Object[] objs=	getFiledValues(o,needPrintFields);
	            for(int j=0;j<objs.length;j++)
	            {
	            	String v="";
	            	if(objs[j]!=null)
	            	{
	            		v=objs[j].toString();
	            	}
	            	if(j==0){
	            		 sheet.addCell(new Label(j,i+titlesCount , v,contentFormat));
	            	}
	            	if(j==1){
	            		String[] strArr = objs[j].toString().split(";");
	            		if(strArr!=null&&strArr.length>0){
	            			for(int k=0;k<strArr.length;k++){
	            				sheet.addCell(new Label(j+k,i+titlesCount , strArr[k],contentFormat));
	            			}
	            		}
	            	}
	           
	            }
	            
	        }
	        book.write();
        }
        finally {
        	if (book != null) {
        		book.close();
        	}
        }
    }

}
