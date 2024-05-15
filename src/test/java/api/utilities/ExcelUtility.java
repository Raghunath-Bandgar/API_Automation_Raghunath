package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public  FileInputStream fi;
	public  FileOutputStream fo;
	public  XSSFWorkbook workbook;
	public  XSSFSheet sheet;
	public  XSSFRow row;
	public  XSSFCell cell;
	public  CellStyle style;
	  String path;
	
	public ExcelUtility(String path)
	{
		this.path=path;
	}
	
	public  int getRowCount(String sheetName) throws IOException {
		       fi = new FileInputStream(path);
		      workbook = new XSSFWorkbook(fi);
		     sheet=workbook.getSheet(sheetName);
	        int rowCount = sheet.getLastRowNum();
	        workbook.close();
	        fi.close();
	        return rowCount;
	        
	        }
	    

	    public  int getCellCount(String sheetName, int rowNum) throws IOException {
	    	 fi = new FileInputStream(path);
	    	 workbook = new XSSFWorkbook(fi);
	    	  sheet=workbook.getSheet(sheetName);
	    	  row= sheet.getRow(rowNum);
		        int cellCount = row.getLastCellNum();
		        workbook.close();
		        fi.close();
		        return cellCount;
		        
		        }
	        
	    

	    public  String getCellData( String sheetName, int rowNum, int cellNum) throws IOException {
	    	 fi = new FileInputStream(path);
	    	 workbook = new XSSFWorkbook(fi);
	    	 sheet=workbook.getSheet(sheetName);
	    	 row =sheet.getRow(rowNum);
	    	 cell= row.getCell(cellNum);
	        
	        DataFormatter formatter= new DataFormatter();
	        String data;
	        
	        try {
				data =formatter.formatCellValue(cell);
			} catch (Exception e)
	        {
	         data="";
			}
	        workbook.close();
	        fi.close();
	        return data;
	        
	        }
	        
	   
	    public  void setCellData(String sheetName, int rowNum, int cellNum, String data) throws IOException {
	        File xlfile = new File(path);
	        if(!xlfile.exists())
	        {
	        	 workbook = new XSSFWorkbook();
	        	 fo = new FileOutputStream(path);
	        	 workbook.write(fo);
	        	
	        }
	        fi = new FileInputStream(path);
	        workbook= new XSSFWorkbook(fi);
	        
	        if(workbook.getSheetIndex(sheetName)==-1)// If sheet not exists then create new sheet
	        	workbook.createSheet(sheetName);
	        sheet = workbook.getSheet(sheetName);
	        
	        if(sheet.getRow(rowNum)==null)// If row not exists then create new row
	        	sheet.createRow(rowNum);
	        row = sheet.getRow(rowNum);
	        
	        cell = row.createCell(cellNum);
	        cell.setCellValue(data);
	        fo= new FileOutputStream(path);
	        workbook.write(fo);
	        workbook.close();
	        fi.close();
	        fo.close();
	     
	    }

	    public  void fillRedColor( String sheetName, int rowNum, int cellNum) throws IOException {
	    	   fi = new FileInputStream(path) ;
	    	   workbook = new XSSFWorkbook(fi);
	    	 fo = new FileOutputStream(path);
	    	 sheet = workbook.getSheet(sheetName);
	    	    row = sheet.getRow(rowNum);
	            if (row == null) {
	                row = sheet.createRow(rowNum);
	            }
	            Cell cell = row.getCell(cellNum);
	            if (cell == null) {
	                cell = row.createCell(cellNum);
	            }
	             style = workbook.createCellStyle();
	             style.setFillForegroundColor(IndexedColors.RED.getIndex());
	             style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	            cell.setCellStyle(style);
	           
	            workbook.write(fo); 
	            workbook.close();
	            fi.close();
	            fo.close();
	        }
	    

	    public  void fillGreenColor(String filePath, String sheetName, int rowNum, int cellNum) throws IOException {
	    	   fi = new FileInputStream(path) ;
	    	   workbook = new XSSFWorkbook(fi);
	    	 fo = new FileOutputStream(path);
	    	 sheet = workbook.getSheet(sheetName);
	    	    row = sheet.getRow(rowNum);
	            if (row == null) {
	                row = sheet.createRow(rowNum);
	            }
	            Cell cell = row.getCell(cellNum);
	            if (cell == null) {
	                cell = row.createCell(cellNum);
	            }
	             style = workbook.createCellStyle();
	             style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	             style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	            cell.setCellStyle(style);
	           
	            workbook.write(fo); 
	            workbook.close();
	            fi.close();
	            fo.close();
	        }
	    
	    private  String cellToString(Cell cell) {
	        if (cell == null) {
	            return "";
	        }
	        switch (cell.getCellType()) {
	            case STRING:
	                return cell.getStringCellValue();
	            case NUMERIC:
	                return String.valueOf(cell.getNumericCellValue());
	            case BOOLEAN:
	                return String.valueOf(cell.getBooleanCellValue());
	            case BLANK:
	                return "";
	            default:
	                return "";
	        }
	    }
	}