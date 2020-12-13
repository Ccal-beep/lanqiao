import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.FileOutputStream;


public class CreateXL {
    /** Excel 文件要存放的位置，假定在F盘下*/
    public static String outputFile = "F:\\test.xls";
    public static void main(String argv[]) {
        try {
            // 创建新的Excel 工作簿
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 在Excel工作簿中建一工作表，其名为缺省值
            // 如要新建一名为"效益指标"的工作表，其语句为：
            HSSFSheet sheet = workbook.createSheet("学生成绩");
            // 在索引0的位置创建行（最顶端的行）
            HSSFRow row = sheet.createRow((short)0);
			HSSFRow row1 = sheet.createRow((short)1);
			HSSFRow row2 = sheet.createRow((short)2);
			HSSFRow row3 = sheet.createRow((short)3);
            //在索引0的位置创建单元格（左上端）
            HSSFCell cell01 = row.createCell((short)0);
			HSSFCell cell02 = row.createCell((short)1);
            
            // 在单元格中输入一些内容
            cell01.setCellValue("科目");
			cell02.setCellValue("分数");

			
			 HSSFCell cell11 = row1.createCell((short)0);
			 HSSFCell cell12 = row1.createCell((short)1);
			 cell11.setCellValue("语文");
			 cell12.setCellValue("98");

			 HSSFCell cell21 = row2.createCell((short)0);
			 HSSFCell cell22 = row2.createCell((short)1);
			 cell21.setCellValue("数学");
			 cell22.setCellValue("100");

			 HSSFCell cell31 = row3.createCell((short)0);
			 HSSFCell cell32 = row3.createCell((short)1);
			 cell31.setCellValue("英语");
			 cell32.setCellValue("99");


            // 新建一输出文件流
            FileOutputStream fOut = new FileOutputStream(outputFile);
            // 把相应的Excel 工作簿存盘
            workbook.write(fOut);
            fOut.flush();
            // 操作结束，关闭文件
            fOut.close();
            System.out.println("文件生成...");
        } catch (Exception e) {
            System.out.println("已运行 xlCreate() : " + e);
        }
    }
}