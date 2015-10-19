package responsibilityChain;

public class FaceFilter implements Filter {

	@Override
	public String doFilter(String msg) {
		String r = msg.replace(":)", "^V^");
		return r;
	}

}
