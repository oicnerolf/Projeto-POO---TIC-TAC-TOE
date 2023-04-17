
package ProjetoDisciplina;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Persistencia {
	private XStream xStream = new XStream(new DomDriver());
	private static Persistencia persistencia = null;

	private Persistencia() {

	}

	public static Persistencia getPersistencia() {
		if (persistencia == null) {
			persistencia = new Persistencia();
		}
		return persistencia;
	}

	public void salvarCentral(Central central) {
		File arquivo = new File("central.xml");
		String xml = xStream.toXML(central);

		try {
			arquivo.createNewFile();
			PrintWriter gravar = new PrintWriter(arquivo);
			gravar.print(xml);
			gravar.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Central recuperarCentral() {
		File arquivo = new File("central.xml");
		if (arquivo.exists()) {
			try {
				FileInputStream r = new FileInputStream(arquivo);
				return (Central) xStream.fromXML(r);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return new Central();
	}
}
