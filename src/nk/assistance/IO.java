package nk.assistance;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringWriter;

public class IO {
	public static String readText(InputStream pIs) {
		String result = null;
		try (InputStream is = pIs; ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
			byte[] tampax = new byte[8192];
			int nb = is.read(tampax, 0, tampax.length);
			while (nb > 0) {
				baos.write(tampax, 0, nb);
				nb = is.read(tampax, 0, tampax.length);
			}
			result = new String(baos.toByteArray(), "UTF-8");
		} catch (IOException e) {
			// we're doomed
			throw new RuntimeException(e);
		}
		return result;
	}

	public static String readText(Reader pR) {
		String result = null;
		try (Reader r = pR; StringWriter sw = new StringWriter();) {
			char[] tampax = new char[8192];
			int nb = r.read(tampax, 0, tampax.length);
			while (nb > 0) {
				sw.write(tampax, 0, nb);
				nb = r.read(tampax, 0, tampax.length);
			}
			result = sw.toString();
		} catch (IOException e) {
			// we're doomed
			throw new RuntimeException(e);
		}
		return result;
	}
}
