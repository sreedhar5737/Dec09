package pack;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class ExcelData_FBLogin {

	
	public XSSFWorkbook workbook;
	
	public ArrayList<String> xdata(String Testname, String sdata) throws IOException
	{
		ArrayList<String> st=new ArrayList<String>();
		FileInputStream fis=new FileInputStream("D:\\course\\datta.xlsx");
		workbook=new XSSFWorkbook(fis);
		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase(sdata))
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
				Iterator<Row> rows=sheet.iterator();
				Row firstrow=rows.next();
				Iterator<Cell> ce=firstrow.cellIterator();
				int k=0;
				int column=0;
				while(ce.hasNext())
				{
					Cell value=ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("field"))
					{
						column=k;
					}
					k++;
				}
				while(rows.hasNext())
				{
					Row r=rows.next();
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(Testname))
					{
					Iterator<Cell> cv=r.cellIterator();
					while(cv.hasNext())
					{
						Cell c=cv.next();
						if(c.getCellTypeEnum()==CellType.STRING)
						{
							st.add(c.getStringCellValue());
						}
						else
						{
							st.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						}
					}
					}
				}
			}
		}
		return st;
	}
	
}
