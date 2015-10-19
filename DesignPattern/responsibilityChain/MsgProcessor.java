package responsibilityChain;

public class MsgProcessor {
	String msg;
	Filter[] filters = {new htmlFilter(), new sensitiveFilter(), new FaceFilter()};
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String process() {
		String r = msg;
		for (Filter f : filters) {
			r = f.doFilter(r);
		}
		return r;
	}
}
