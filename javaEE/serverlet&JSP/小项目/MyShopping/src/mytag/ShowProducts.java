package mytag;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.bjsxt.shopping.Product;
import com.bjsxt.shopping.ProductMgr;

public class ShowProducts extends SimpleTagSupport {

	@Override
	public void doTag() throws JspException, IOException {
		List<Product> products = ProductMgr.getInstance().getProducts();
		JspWriter out = getJspContext().getOut();
		out.println("<table align='center'>	<tr><td>ID</td><td>NAME</td><td>DESCR</td><td>NORMALPRICE</td><td>MEMBERPRICE</td><td>PDATE</td></tr>");
		for(Iterator<Product> it = products.iterator(); it.hasNext();) {
			Product p = it.next();
			out.println("<tr>");
			out.println("<td>"+p.getId()+"</td>");
			out.println("<td>"+p.getName()+"</td>");
			out.println("<td>"+p.getDescr()+"</td>");
			out.println("<td>"+p.getNormalprice()+"</td>");
			out.println("<td>"+p.getMemberprice()+"</td>");
			out.println("<td>"+p.getPdate()+"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
	}
}
