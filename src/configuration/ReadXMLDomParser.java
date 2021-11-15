package configuration;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

	//private static final String FILENAME = "src"+File.separator+"configuration"+File.separator+"config.xml";
	private static final String FILENAME = "src"+File.separator+"configuration"+File.separator+"config.xml";
	private static Configuration configuration;
	
	//@SuppressWarnings("unused")
	//public static void main(String[] args) throws NumberFormatException {
	public void readXML() {
		List<String> listTypes = new ArrayList<>();
		
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
			
			// Fill object
			
			listTypes.add(tiposNodeList.item(0).getTextContent());
			listTypes.add(tiposNodeList.item(1).getTextContent());
			listTypes.add(tiposNodeList.item(2).getTextContent());
			listTypes.add(tiposNodeList.item(3).getTextContent());
			configuration = new Configuration(idioma, listTypes, Integer.valueOf(timeout), Integer.valueOf(nummax), ruta);
			
			System.out.println(configuration);

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

	}

}
