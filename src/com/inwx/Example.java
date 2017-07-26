package com.inwx;

import com.inwx.model.ArrayElement;
import com.inwx.model.Element;
import com.inwx.model.MapElement;
import org.apache.xmlrpc.XmlRpcException;

import java.io.FileInputStream;
import java.util.Properties;
import java.net.MalformedURLException;

public class Example {

	public static void main(String args[]) throws Exception {
		System.out.println("Starting INWX Java example..." + "\n");
		
		// configuration
		Properties config = new Properties(System.getProperties());
		if (args.length > 0) {
			config.load(new FileInputStream(args[0]));
		}
		String username = config.getProperty(Connector.class.getPackage().getName() + ".username");
		String password = config.getProperty(Connector.class.getPackage().getName() + ".password");

		String domain = args.length >= 2 ? args[1] : "inwx-meets-java.de";
	
		System.out.println("conecting as " + username);
		Connector connector = new Connector();
		if(connector.login(username,password)) {
		
			// check a domain
			ArrayElement myDomains = connector.checkDomain(domain);
			for(Element item : (Element[]) myDomains.getArray()) {
				MapElement _item = (MapElement) item;
				System.out.println("tld: " + _item.get("tld").toString());
				System.out.println("name: " + _item.get("name").toString());
				System.out.println("domain: " + _item.get("domain").toString());
				System.out.println("status: " + _item.get("status").toString());
				System.out.println("price: " + _item.get("price").toString());
			}
			System.out.println();
			
			// list all nameserver domains
			ArrayElement domains = connector.getAllNS();
			for(Element item : (Element[]) domains.getArray()) {
				MapElement _item = (MapElement) item;
				System.out.println(_item.get("domain")+":"+_item.get("type"));
			}
			
			//connector.getNS("inwx.de");
			
			// logout
			connector.logout();
			System.out.println("\n" + "logout");
		}
		else {
			System.out.println("login failed");
		}
	}
}
