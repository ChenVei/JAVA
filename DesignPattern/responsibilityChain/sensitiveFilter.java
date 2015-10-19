package responsibilityChain;

public class sensitiveFilter implements Filter {

	@Override
	public String doFilter(String msg) {
		String r = msg.replace("sensitive", "insensitive");
		return r;
	}

}
