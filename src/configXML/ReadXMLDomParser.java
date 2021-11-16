package configXML;


import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXMLDomParser {

	private static final String FILENAME = "src"+File.separator+"configXML"+File.separator+"config.xml";

	public static void main(String[] args) {

		// Instantiate the Factory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {

			// process XML securely, avoid attacks like XML External Entities (XXE)
			dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

			// parse XML file
			DocumentBuilder db = dbf.newDocumentBuilder();

			Document doc = db.parse(new File(FILENAME));

			doc.getDocumentElement().normalize();

			System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
			System.out.println("------------------------------");

			// get <staff>
			NodeList list = doc.getElementsByTagName("Configuration");
			Node node = list.item(0);
			Element element = (Element) node;

			// get text
			String idioma = element.getElementsByTagName("Idioma").item(0).getTextContent();
			NodeList tiposNodeList = element.getElementsByTagName("TipoPregunta");
			String tipo1 = tiposNodeList.item(0).getTextContent();
			String tipo2 = tiposNodeList.item(1).getTextContent();
			String tipo3 = tiposNodeList.item(2).getTextContent();
			String tipo4 = tiposNodeList.item(3).getTextContent();
			String timeout = element.getElementsByTagName("TimeoutPreguntas").item(0).getTextContent();
			String nummax = element.getElementsByTagName("NumMaxPreguntas").item(0).getTextContent();
			String ruta = element.getElementsByTagName("RutaXMLKahoots").item(0).getTextContent();

			// print text
			System.out.println("Idioma : " + idioma);
			System.out.println("Tipos de Preguntas : \n\t" + tipo1 + "\n\t" + tipo2 + "\n\t" + tipo3 + "\n\t" + tipo4);
			System.out.println("Timeout entre Preguntas : " + timeout);
			System.out.println("Numero Maximo de Preguntas : " + nummax);
			System.out.println("Ruta XML de Kahoots : " + ruta);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	}

}
