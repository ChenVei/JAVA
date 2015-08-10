package com.bjsxt.shopping.reports;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.bjsxt.shopping.util.DB;

public class ShowProductSalesServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShowProductSalesServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CategoryDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
		
		String iniPath = getInitParameter("iniPath");
		
		saveAsFile(chart, iniPath + "/productsales.jpg", 500, 400);
		createBingGraph(iniPath);
		
System.out.println(iniPath + "/productsales.jpg" + " OK.generated!!");
		
		getServletContext().getRequestDispatcher("/admin/showproductsaleschart.jsp").forward(request, response);
		//return;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
		
		System.out.println("WTF...........");
	}

	private void createBingGraph(String iniPath) {

		//设置饼图数据集
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		Connection conn = DB.getConn();
		String sql = "select productid,sum(pcount),name from salesitem s "
				+ "join product p on s.productid = p.id group by productid";
		ResultSet rs = DB.executeQuery(conn, sql);
		try {
			while (rs.next()) {
				// 放入数据
				dataset.setValue(rs.getString(3), rs.getInt(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRs(rs);
			DB.closeConn(conn);
		}
		
		//通过工厂类生成JFreeChart对象
		JFreeChart chart = ChartFactory.createPieChart3D("ProductSalesChart", dataset, true, true, false);
		chart.addSubtitle(new TextTitle("2010年度"));
		saveAsFile(chart, iniPath + "/productsales_pie.jpg", 500, 400);
System.out.println(iniPath + "/productsales_pie" + " OK.generated!!");		
	}


	public static CategoryDataset createDataset() {
		// 创建数据源
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		Connection conn = DB.getConn();
		String sql = "select productid,sum(pcount),name from salesitem s "
				+ "join product p on s.productid = p.id group by productid";
		ResultSet rs = DB.executeQuery(conn, sql);
		try {
			while (rs.next()) {
				// 放入数据
				dataset.addValue(rs.getInt(2), ""+rs.getInt(1), rs.getString(3)+"("+rs.getInt(1)+")");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.closeRs(rs);
			DB.closeConn(conn);
		}

		return dataset;
	}

	public static JFreeChart createChart(CategoryDataset dataset) {
		// create the chart..
		JFreeChart chart = ChartFactory.createBarChart("ProductSalesChart",// 标题
				"X轴",// x轴
				"Y轴",// y轴
				dataset,// 数据
				PlotOrientation.VERTICAL,// 定位，VERTICAL：垂直
				false,// 是否显示图例注释(对于简单的柱状图必须是false)
				false,// 是否生成工具//没用过
				false);// 是否生成URL链接//没用过
		// 周围的背景色
		chart.setBackgroundPaint(Color.white);
		// 设置字体，否则会显示乱码
		Font font = new Font("宋体", 10, 20);
		TextTitle title = chart.getTitle();
		// 设置标题字体
		title.setFont(font);
		// 得到一个参考
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		// 生成图片的背景色
		plot.setBackgroundPaint(Color.white);
		// 行线的颜色
		plot.setRangeGridlinePaint(Color.BLACK);
		// 刻度字体
		plot.getDomainAxis().setTickLabelFont(font);
		// X轴名称字体
		plot.getDomainAxis().setLabelFont(font);

		// LayeredBarRenderer lbr = new LayeredBarRenderer();//(BarRenderer)类：
		// //void setSeriesBarWidth(int series,double width)
		// 设定每个分类的宽度（注意设置不要使某分类被覆盖）
		// lbr.setSeriesBarWidth(1,0.1);

		// 设置显示整数
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();

		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		// 设置上部空白
		rangeAxis.setUpperMargin(0.15);
		// 设置y轴名称字体
		rangeAxis.setLabelFont(font);

		CategoryItemRenderer renderer = plot.getRenderer();
		renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		// renderer.setDrawOutlines(true);//是否折线数据点根据不同数据使用不同的形状
		// renderer.setSeriesShapesVisible(0, true);
		renderer.setSeriesItemLabelsVisible(0, Boolean.TRUE);

		CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);// 倾斜45度

		BarRenderer renderer1 = new BarRenderer();// 设置柱子的相关属性
		// 设置柱子宽度
		// renderer1.setMaximumBarWidth(0.9);
		// renderer1.setMaximumBarWidth(0.10000000000000001D); //宽度
		// 设置柱子高度
		renderer1.setMinimumBarLength(0.5);
		// 设置柱子边框颜色
		// renderer1.setBaseOutlinePaint(Color.BLACK);
		// 设置柱子边框可见
		// renderer1.setDrawBarOutline(true);
		// 设置每个地区所包含的平行柱的之间距离，数值越大则间隔越大，图片大小一定的情况下会影响柱子的宽度，可以为负数
		renderer1.setItemMargin(0.1);
		// 是否显示阴影
		renderer1.setShadowVisible(false);
		// 阴影颜色
		// renderer1.setShadowPaint(Color.white);
		plot.setRenderer(renderer1);
		plot.setBackgroundAlpha((float) 0.5); // 数据区的背景透明度（0.0～1.0）
		// 设置柱的透明度
		// plot.setForegroundAlpha(1.0f);
		// 设置图形的宽度
		CategoryAxis caxis = plot.getDomainAxis();
		// 设置图形右边的空白
		// caxis.setUpperMargin(0.2);
		// 设置左边的空白
		// caxis.setLowerMargin(0.2);

		return chart;
	}

	public static void saveAsFile(JFreeChart chart, String outputPath,
			int weight, int height) {
		FileOutputStream out = null;
		try {
			File outFile = new File(outputPath);
			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdirs();
			}
			out = new FileOutputStream(outputPath);
			// 保存为PNG文件
			ChartUtilities.writeChartAsPNG(out, chart, weight, height);
			// 保存为JPEG文件
			// ChartUtilities.writeChartAsJPEG(out, chart, 500, 400);
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// do nothing
				}
			}
		}
	}

}
