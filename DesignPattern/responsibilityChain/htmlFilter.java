package responsibilityChain;

public class htmlFilter implements Filter {

	@Override
	public String doFilter(String msg) {
		String r = msg.replace("<", "[").replace(">", "]");
		return r;
	}

}
