import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Sample1 {
	public static void main(String[] args) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document doc = reader.read(Sample1.class.getClassLoader().getResource(
				"test.xml"));

		// 获取根节点
		Element rootElt = doc.getRootElement();
		// 获取disk节点
		Element diskElement = rootElt.element("disk");
		// 获取disk节点下的属性
		String name = diskElement.attributeValue("name");

		System.out.println(name);

		for (int i = 0; i < rootElt.nodeCount(); i++) {
			Node node = rootElt.node(i);
			if (node instanceof Element) {
				Element elementTemp = (Element) node;
				System.out.println("二级节点：" + node.getName()); // 拿到第一个二级节点的名称
				// 取得二级节点属性的值
				for (Iterator iter = elementTemp.attributeIterator(); iter.hasNext();) {
					Attribute item = (Attribute) iter.next();
					System.out.println("二级节点的：" + item.getName() + "为"
							+ item.getValue()); // 拿到二级节点的属性
				}
				// 获取二级节点的下面的子节点（三级节点）
				for (Iterator iterroot2 = elementTemp.elementIterator(); iterroot2.hasNext();) {
					Element root22 = (Element) iterroot2.next(); // 得到一个二级节点
					System.out.println("三级节点：" + root22.getName());
					System.out.println("三级节点的值：" + root22.getText()); // 获取值
					List attrList = root22.attributes(); // 获取三级节点的属性
					// 遍历获取三级节点的属性
					for (Iterator iter = attrList.iterator(); iter.hasNext();) {
						Attribute item = (Attribute) iter.next();
						System.out.println("三级节点的属性：" + item.getName()
								+ "为" + item.getValue());
					}
				}
			}
		}
	}
}
