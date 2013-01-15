package nk.rdb;

import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.Map;

public class AerosolEvian {
	/**
	 * Coder dans la nuit, c'est pas bon. Bon, là on ne gère rien, faut pas déc.... non plus.
	 * 
	 * @param map
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <C> C rehydrate(Map<String, Object> map) {
		String clazzName = (String) map.get("class");
		// JSONTree stocke sous la forme "class foo.bar.Qix"
		clazzName = clazzName.substring(clazzName.indexOf(' ') + 1);
		try {
			Class<C> clazz = (Class<C>) Class.forName(clazzName);
			return rehydrate(map, clazz);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static <C> C rehydrate(Map<String, Object> map, Class<C> clazz) {
		try {
			C result = (C) clazz.newInstance();

			for (Map.Entry<String, Object> prop : map.entrySet()) {
				final String key = prop.getKey();
				if (!"class".equals(key) && prop.getValue() != null) {
					Method m = null;
					try {
						m = clazz.getMethod(setter(key), prop.getValue().getClass());
						m.invoke(result, prop.getValue());
					} catch (NoSuchMethodException e) {
						m = clazz.getMethod(setter(key), BigInteger.class);
						m.invoke(result, BigInteger.valueOf(((Number) prop.getValue()).longValue()));
					}
				}
			}
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static String setter(String key) {
		final char[] chars = key.toCharArray();
		chars[0] = Character.toUpperCase(chars[0]);
		return new StringBuilder("set").append(chars).toString();
	}
}
