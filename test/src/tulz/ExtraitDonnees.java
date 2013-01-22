package tulz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import nk.assistance.IO;

import org.stringtree.json.JSONReader;

public class ExtraitDonnees {

	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		try {
			final String jsonString = IO.readText(new InputStreamReader(new FileInputStream("jeu.json"), "UTF-8"));
			JSONReader jr = new JSONReader();
			final List<Map<String, Object>> tableau = (List<Map<String, Object>>) jr.read(jsonString);

			int i = 0;
			for (Map<String, Object> requete : tableau) {
				Writer fw = new OutputStreamWriter(new FileOutputStream("test/src/nk/enonces/jajascript/rl" + i
						+ ".txt"), "utf-8");
				fw.write((String) requete.get("postBody"));
				fw.close();
				++i;
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
