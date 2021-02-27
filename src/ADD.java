
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;



public class ADD {
    private SwingWorker<Void, Integer> worker;
    private static String Path ,fileSeparator = System.getProperty("file.separator");
    private static File FEingang, FAusgang;
    private JLabel LNotif = new JLabel("hallo");

    public ADD() {
        JFrame frame = new JFrame("Go express");
        initializeWorker();

        worker.execute();
      
        JButton stop = new JButton("STOP");
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                worker.cancel(true);
            }
        });

        JButton button = new JButton("Start");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                initializeWorker();
                worker.execute();
            }
        });
        
        frame.add(button);
        frame.add(stop);
        frame.add(LNotif);
        frame.setLayout(new FlowLayout());
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void initializeWorker() {
        worker = new SwingWorker<Void, Integer>() {

            @Override
            protected Void doInBackground() throws Exception {
                int i = 0;
                while (!isCancelled()) {
                    i++;
                   publish(i); 
                    
                    
                   
                }
                return null;
            }

            @Override
            protected void process(List<Integer> chunks) {
            	
           
                
                //##################################################################################
                try {
                Path = new File(ClassLoader.getSystemClassLoader().getResource(".").getPath()).getAbsolutePath().replace("%20", " ");
               
                  LNotif.setText(Path);
				  FEingang = new File(Path+ fileSeparator + "Eingang" + fileSeparator);
				  FAusgang = new File(Path+ fileSeparator + "Ausgang" + fileSeparator);
		          FEingang.mkdir();
		          FAusgang.mkdir();
         	   String [] T = FEingang.list();
					
				  if (T.length > 0)
				  {
					  File myObj = new File(Path+ fileSeparator + "Eingang" + fileSeparator+T[0]);
					  Scanner myReader = new Scanner(myObj, "UTF-8");
					 
					  SimpleDateFormat formatter= new SimpleDateFormat("dd.MM.yyyy");
					  Date date = new Date(System.currentTimeMillis());
					  String  Datum = formatter.format(date);
					
					  String fname = T[0].substring(0,T[0].lastIndexOf("."));
	
					  
					  while (myReader.hasNextLine())
					  {
						  myReader.nextLine();
						  String ddd = system sate ; util


						
						  String data = myReader.nextLine();
						  String[] x = data.split(";");

						  
						  //####################################################################################
						  // create new `Document`
		            	    DocumentBuilder builder = DocumentBuilderFactory.newInstance()
		            	            .newDocumentBuilder();
		            	    Document dom =  builder.newDocument();

		            	    // first create root element
		            	   
		            	    
		            	    Element root =  dom.createElement("GAImportRecord");
		            	    dom.appendChild((Node) root);
		            	    
		            	    
		            	    // now create child elements (name, email, phone)
		            	    Element KDNR = dom.createElement("KDNR");
		            	    KDNR.setTextContent("34078");
		            	    root.appendChild(KDNR);
		            	    
		            	    Element UserName = dom.createElement("UserName");
		            	    UserName.setTextContent("felix@garnelio.de");
		            	    root.appendChild(UserName);
		            	    
		            	    Element AbsFirma = dom.createElement("AbsFirma");
		            	    AbsFirma.setTextContent("Natureholic GMBH");
		            	    root.appendChild(AbsFirma);
		            	    
		            	    Element AbsStrasse = dom.createElement("AbsStrasse");
		            	    AbsStrasse.setTextContent("Fürstenwalderweg 7");
		            	    root.appendChild(AbsStrasse);
		            		
		            	    Element AbsLKZ = dom.createElement("AbsLKZ");
		            	    AbsLKZ.setTextContent("D");
		            	    root.appendChild(AbsLKZ);

		            	    Element AbsPLZ = dom.createElement("AbsPLZ");
		            	    AbsPLZ.setTextContent("68309");
		            	    root.appendChild(AbsPLZ);

		            	    Element AbsOrt = dom.createElement("AbsOrt");
		            	    AbsOrt.setTextContent("Mannheim");
		            	    root.appendChild(AbsOrt);

		            	    Element EmpfFirma = dom.createElement("EmpfFirma");
		            	    EmpfFirma.setTextContent(x[1]+" "+x[2]);
		            	    root.appendChild(EmpfFirma);

		            	    Element EmpfTelLand = dom.createElement("EmpfTelLand");
		            	    EmpfTelLand.setTextContent("0");
		            	    root.appendChild(EmpfTelLand);

		            	    Element EmpfTel = dom.createElement("EmpfTel");
		            	    EmpfTel.setTextContent("0"+x[10]);
		            	    root.appendChild(EmpfTel);
		            	    
		            	    Element EmpfEmail = dom.createElement("EmpfEmail");
		            	    EmpfEmail.setTextContent(x[9]);
		            	    root.appendChild(EmpfEmail);

		            	    Element EmpfStrasse = dom.createElement("EmpfStrasse");
		            	    EmpfStrasse.setTextContent(x[4]);
		            	    root.appendChild(EmpfStrasse);

		            	    Element EmpfHnr = dom.createElement("EmpfHnr");
		            	    EmpfHnr.setTextContent(x[5]);
		            	    root.appendChild(EmpfHnr);

		            	    Element EmpfLKZ = dom.createElement("EmpfLKZ");
		            	    EmpfLKZ.setTextContent(x[8]);
		            	    root.appendChild(EmpfLKZ);

		            	    Element EmpfPLZ = dom.createElement("EmpfPLZ");
		            	    EmpfPLZ.setTextContent(x[6]);
		            	    root.appendChild(EmpfPLZ);

		            	    Element EmpfOrt = dom.createElement("EmpfOrt");
		            	    EmpfOrt.setTextContent(x[7]);
		            	    root.appendChild(EmpfOrt);

		            	    Element AbholZeitVon = dom.createElement("AbholZeitVon");
		            	    AbholZeitVon.setTextContent("19:00");
		            	    root.appendChild(AbholZeitVon);


		            	    Element AbholZeitBis = dom.createElement("AbholZeitBis");
		            	    AbholZeitBis.setTextContent("18:00");
		            	    root.appendChild(AbholZeitBis);


		            	    Element AbholDatum = dom.createElement("AbholDatum");
		            	    AbholDatum.setTextContent(Datum);
		            	    root.appendChild(AbholDatum);


		            	    Element KZSelbstAnl = dom.createElement("KZSelbstAnl");
		            	    KZSelbstAnl.setTextContent("0");
		            	    root.appendChild(KZSelbstAnl);

		            	    Element AnzahlPack = dom.createElement("AnzahlPack");
		            	    AnzahlPack.setTextContent("1");
		            	    root.appendChild(AnzahlPack);


		            	    Element Gewicht = dom.createElement("Gewicht");
		            	    Gewicht.setTextContent("1.40");
		            	    root.appendChild(Gewicht);

		            	    Element Service = dom.createElement("Service");
		            	    Service.setTextContent("0");
		            	    root.appendChild(Service);

	

		            	    // write DOM to XML file
		            	    
		            	    Transformer tr = TransformerFactory.newInstance().newTransformer();
		            	    tr.setOutputProperty(OutputKeys.INDENT, "yes");
		            	    tr.transform(new DOMSource(dom), new StreamResult(new File(Path+ fileSeparator + "Ausgang" + fileSeparator+fname+".xml")));
		            	  
					  }
					
					  myReader.close();
					  myObj.delete();
				  }}catch (Exception e) {
					// TODO: handle exception
			
				}
              
				  //##################################################################################
            }


	
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ADD());
    }

}