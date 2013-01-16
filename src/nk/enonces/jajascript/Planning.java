package nk.enonces.jajascript;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Planning {
	private BigInteger gain = BigInteger.ZERO;
	private List<String> path = new ArrayList<String>();

	public BigInteger getGain() {
		return gain;
	}

	public void setGain(BigInteger gain) {
		this.gain = gain;
	}

	public List<String> getPath() {
		return path;
	}

	public void setPath(List<String> path) {
		this.path = path;
	}
}
