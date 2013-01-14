package nk.rdb;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.sql.Clob;
import java.sql.SQLException;

public class RdbClob implements Clob {
	private String texte;

	public RdbClob(String texte) {
		this.texte = texte;
	}

	@Override
	public long length() throws SQLException {
		return texte.length();
	}

	@Override
	public String getSubString(long pos, int length) throws SQLException {
		return texte.substring((int) pos - 1, (int) (pos + length - 1));
	}

	@Override
	public Reader getCharacterStream() throws SQLException {
		return new StringReader(texte);
	}

	@Override
	public InputStream getAsciiStream() throws SQLException {
		try {
			return new ByteArrayInputStream(texte.getBytes("ASCII"));
		} catch (UnsupportedEncodingException e) {
			throw new SQLException(e);
		}
	}

	@Override
	public long position(String searchstr, long start) throws SQLException {
		return texte.indexOf(searchstr, (int) start - 1);
	}

	@Override
	public long position(Clob searchstr, long start) throws SQLException {
		return 0;
	}

	@Override
	public int setString(long pos, String str) throws SQLException {
		return 0;
	}

	@Override
	public int setString(long pos, String str, int offset, int len) throws SQLException {
		return 0;
	}

	@Override
	public OutputStream setAsciiStream(long pos) throws SQLException {
		return null;
	}

	@Override
	public Writer setCharacterStream(long pos) throws SQLException {
		return null;
	}

	@Override
	public void truncate(long len) throws SQLException {
	}

	@Override
	public void free() throws SQLException {
		texte = null;
	}

	@Override
	public Reader getCharacterStream(long pos, long length) throws SQLException {
		return new StringReader(getSubString(pos, (int) length));
	}
}
