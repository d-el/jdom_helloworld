package jdom;

import org.jdom.*;
import org.jdom.input.*;
import java.io.*;
import java.util.List;
 
public class jdom {
 
	public static void main(String[] args) {
        try {
            SAXBuilder parser = new SAXBuilder();
            FileReader fr = new FileReader("otherFiles/STM32F100.svd");
            Document rDoc = parser.build(fr);
            
            System.out.println(rDoc.getRootElement().getName());
            Element rootElement = rDoc.getRootElement();
            
            List<Element> childrenRoot = rootElement.getChildren();
            System.out.println();
            for (int i = 0; i < childrenRoot.size(); ++i) {
                System.out.println("\t" + childrenRoot.get(i).getName());
            }
            
            Element peripheral = childrenRoot.get(9);	//peripherals
            List<Element> children1 = peripheral.getChildren();
            for (int i = 0; i < children1.size(); ++i) {
            	Element p = children1.get(i);
            	System.out.println("\t\t" + p.getChild("name").getText());
            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
