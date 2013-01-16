package tulz;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import nk.assistance.IO;

/**
 * Faudra s'interroger sur les tests en container.
 */
public class PosteCommeUneLettre {
	public static void main(String[] argv) {
		try {

			// paye ton répertoire courant bien configuré
			final String md = IO.readText(new FileInputStream("doc/enonce.2.md"));
			final byte[] mdBytes = md.getBytes("UTF-8");
			
			// URL url = new URL("http://localhost:8080/enonce/2");
			URL url = new URL("http://damien.codestory.cloudbees.net/enonce/2");

			final HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("POST");			
			conn.setRequestProperty("Content-Length", String.valueOf(mdBytes.length));
			conn.setDoOutput(true);
			
			conn.connect();
			final OutputStream os = conn.getOutputStream();
			os.write(mdBytes, 0, mdBytes.length);
			os.close();
			
			System.out.println("Réponse : " + conn.getResponseCode());
			conn.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
