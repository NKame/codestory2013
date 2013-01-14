package nk.rdb;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import org.stringtree.json.JSONReader;
import org.stringtree.json.JSONWriter;

/**
 * Bon, visiblement ils sont rats sur l'envoi des énoncés, on va persister ça.
 */
public class RdbManager implements ServletContextListener {
	private DataSource ds;

	public RdbManager() {
	}

	public static RdbManager instance(ServletContext sc) {
		return (RdbManager) sc.getAttribute(RdbManager.class.getName());
	}

	/**
	 * Stocke l'objet o. Attention, la classe de l'objet détermine la clef :-). Ne stocke pas null, ça fera plaisir
	 * à @BeRewt.
	 * 
	 * @param id
	 * @param o
	 * @return true si le stockage est modifié par l'opération
	 */
	public <C> boolean stocke(String id, C o) {
		if (o != null) {
			try (Connection con = ds.getConnection();) {
				JSONWriter writer = new JSONWriter(true);
				final PreparedStatement ps = con
						.prepareStatement("REPLACE objets SET valeur=?, classe=?, id=?");
				ps.setClob(1, new StringReader(writer.write(o)));
				ps.setString(2, o.getClass().getCanonicalName());
				ps.setString(3, id);

				final int nb = ps.executeUpdate();
				return nb > 0;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return false;
	}

	/**
	 * Renvoie un object précémment stocké, null s'il n'est pas en base.
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <C> C recupere(Class<C> clazz, String id) {
		try (Connection con = ds.getConnection();) {

			final PreparedStatement ps = con.prepareStatement("SELECT valeur FROM objets WHERE classe=? AND id=?");
			ps.setString(1, clazz.getCanonicalName());
			ps.setString(2, id);

			C result = null;
			final ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				final Clob clob = rs.getClob(1);
				try (final Reader stream = clob.getCharacterStream();) {
					final JSONReader reader = new JSONReader();
					final StringWriter sw = new StringWriter();
					char[] tampax = new char[8192];
					int nb = stream.read(tampax, 0, tampax.length);
					while (nb > 0) {
						sw.write(tampax, 0, nb);
						nb = stream.read(tampax, 0, tampax.length);
					}
					Map<String, Object> map = (Map<String, Object>) reader.read(sw.toString());
					result = construitDepuis(map);
				} catch (IOException e) {
					// là je crois qu'il faut s'en taper... c'est que la base s'est barrée
				}
			}
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Coder dans la nuit, c'est pas bon.
	 * Bon, là on ne gère rien, faut pas déc.... non plus.
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private <C> C construitDepuis(Map<String, Object> map) {
		String clazzName = (String) map.get("class");
		// JSONTree stocke sous la forme "class foo.bar.Qix"
		clazzName = clazzName.substring(clazzName.indexOf(' ') + 1);
		try {
			Class<C> clazz = (Class<C>) Class.forName(clazzName);
			C result = (C) clazz.newInstance();
			
			for(Map.Entry<String, Object> prop : map.entrySet()) {
				final String key = prop.getKey();
				if(!"class".equals(key) && prop.getValue() != null) {
					final Method m = clazz.getMethod(setter(key), prop.getValue().getClass());
					m.invoke(result, prop.getValue());
				}
			}
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private String setter(String key) {
		final char[] chars = key.toCharArray();
		chars[0] = Character.toUpperCase(chars[0]);
		return new StringBuilder("set").append(chars).toString();
	}

	public <C> boolean existe(Class<C> clazz, String id) {
		try (Connection con = ds.getConnection();) {

			final PreparedStatement ps = con
					.prepareStatement("SELECT count(*) FROM objets WHERE classe=? AND id=?");
			ps.setString(1, clazz.getCanonicalName());
			ps.setString(2, id);

			boolean result = false;
			final ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1) == 1;
			}
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		ds = null;
		arg0.getServletContext().removeAttribute(this.getClass().getName());
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/codestory");
			creeTables();
		} catch (NamingException e) {
			throw new RuntimeException("Elle est où ma base ?", e);
		}
		arg0.getServletContext().setAttribute(this.getClass().getName(), this);
	}

	private void creeTables() {
		try (Connection con = ds.getConnection();) {
			final Statement st = con.createStatement();
			final ResultSet rs = st
					.executeQuery("SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME='objets'");
			boolean exist = false;
			if (rs.next()) {
				exist = rs.getInt(1) == 1;
			}
			rs.close();
			if (!exist) {
				st.executeUpdate("CREATE TABLE objets (classe VARCHAR(255) NOT NULL, id VARCHAR(255) NOT NULL, valeur TEXT NOT NULL, "
						+ "PRIMARY KEY (classe, id))");
			}
			st.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}