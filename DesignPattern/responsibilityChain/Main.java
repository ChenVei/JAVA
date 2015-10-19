package responsibilityChain;

public class Main {

	public static void main(String[] args) {
		String msg = "´ó¼ÒºÃ:)£¬<script>£¬sensitive";
		MsgProcessor mp = new MsgProcessor();
		mp.setMsg(msg);
		String result = mp.process(); 
		System.out.println(result);
	}

}
