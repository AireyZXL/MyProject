package cn.tedu.comment.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.comment.pojo.Admin;
import cn.tedu.comment.pojo.Order;
import cn.tedu.comment.pojo.POI;
import cn.tedu.comment.service.AdminService;
import cn.tedu.comment.service.OrderService;
/**
 * 
 * @author lDZ
 * @Date   2017年7月11日
 */
@Controller//下载报表
public class TableController extends BaseController{
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private AdminService adminService;
	

	//店铺管理员下载平台销售数据
	@RequestMapping("/vendor/vdsaletablelist")
	public String vendorSaleload(Model model,HttpSession session){
		Admin admin = (Admin) session.getAttribute("sessionadmin");
		String vendorId = adminService.findVendorByName(admin.getUsername());
		//查询该商铺所有订单
		List<Order> orderList = orderService.findOrderByVid(vendorId);
		
		model.addAttribute("vendorId", vendorId);
		model.addAttribute("orderList", orderList);
		return "/backend/vendor/vendorSaleList";
	}
	

	//平台管理员下载平台销售数据（销售额前20的商家）
	@RequestMapping("/sysadmin/admin/adsaletablelist")
	public String adminSaleload(Model model,HttpSession session){
		//查询当日所有商铺订单
		List<POI> poiList = orderService.findPois();
		
		model.addAttribute("poiList", poiList);
		return "/backend/sysadmin/admin/adminSaleList";
	}
		
	@RequestMapping("/vendor/vendorloadtable")//下载报表的拦截命令
	public String Loadtable(String vendorId,Date startdate,Date enddate,Model model){
		List<POI> poiList =  orderService.findPOIByVid(vendorId,startdate,enddate);
		
		Workbook wb = new HSSFWorkbook();//创建excel工作台
		//CreationHelper createHelper = wb.getCreationHelper();
		Sheet sheet = wb.createSheet("new sheet");//创建一个表
	    
		sheet.setColumnWidth(0, 5000);
		 // 给工作表列定义列宽(实际应用自己更改列数)  
        for (int i = 1; i < 8; i++) {  
            sheet.setColumnWidth(i, 3000);  
        } 
		
		//创建报表样式
		CellStyle cellStyle = wb.createCellStyle();
		
	    //创建第一行 报表信息
	    Row row = sheet.createRow(0);
	    row.setHeight((short)400);//设置行高
	    Cell cell = row.createCell(0);//创建第1个单元格
	    cell.setCellValue("商家名:");
	    cell = row.createCell(1);//创建第二个单元格
	    cell.setCellValue(poiList.get(0).getVendorName());
	    
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    cell = row.createCell(2);//创建三个单元格
	    cell.setCellValue("查询时间");
	    cell = row.createCell(3);//创建四个单元格
	    cell.setCellValue(sdf.format(new Date()));//查询时间
	    
	    // 设置单元格字体  
        Font font = wb.createFont();  
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);  
        font.setFontName("宋体");  
        font.setFontHeight((short) 200);  
        cellStyle.setFont(font); 
        cellStyle.setAlignment(CellStyle.ALIGN_CENTER); //设置居中
	  
        //创建表头，第二行
	    row = sheet.createRow(1);
	    row.setHeight((short)400);//设置行高
	    cell = row.createCell(0);//创建第1个单元格
	    cell.setCellValue("日期");
	    cell.setCellStyle(cellStyle);
	    
	    cell = row.createCell(1);//创建第2个单元格
	    cell.setCellValue("日订单总数");
	    cell.setCellStyle(cellStyle);
	    
	    cell = row.createCell(2);//创建第3个单元格
	    cell.setCellValue("日成交总额");//查询时间
	    cell.setCellStyle(cellStyle);
	    
	    cell = row.createCell(3);//创建第4个单元格
	    cell.setCellValue("单均消费额");//查询时间
	    cell.setCellStyle(cellStyle);
	    
	    cell = row.createCell(4);//创建第5个单元格
	    cell.setCellValue("环境评分");//查询时间
	    cell.setCellStyle(cellStyle);
	    
	    cell = row.createCell(5);//创建第6个单元格
	    cell.setCellValue("口味评分");//查询时间
	    cell.setCellStyle(cellStyle);
	    
	    cell = row.createCell(6);//创建第7个单元格
	    cell.setCellValue("服务评分");//查询时间
	    cell.setCellStyle(cellStyle);
	    
	    POI p = null;
		for(int i=1;i<=poiList.size();i++){
			p = poiList.get(i-1);
			row = sheet.createRow(i+1);//创建第三行
			cell = row.createCell(0);//创建第1个单元格
		    cell.setCellValue(sdf.format(p.getDate()));//日期
		    
		    cell = row.createCell(1);//创建第2个单元格
		    cell.setCellValue(p.getOrdernum());//日订单数
		    
		    cell = row.createCell(2);//创建第3个单元格
		    cell.setCellValue(p.getOrderMoney());//日成交总额
		    
		    cell = row.createCell(3);//创建第4个单元格
		    cell.setCellValue(p.getAvgprice());//订单平均金额
		    
		    cell = row.createCell(4);//创建第5个单元格
		    cell.setCellValue(p.getEnvironment());//环境评分

		    cell = row.createCell(5);//创建第6个单元格
		    cell.setCellValue(p.getTaste());//口味评分
		    
		    cell = row.createCell(6);//创建第7个单元格
		    cell.setCellValue(p.getService());//服务评分
		}
		
		Long d = System.currentTimeMillis();
		String fileName = "d:/comment"+d+".xls";//设定文件名
		
		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			wb.write(fileOut);//生成报表
			fileOut.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		model.addAttribute("fileName", fileName);
		return "redirect:/vendor/vdsaletablelist";//返回订单报表下载页面
	    
	}
	
}
