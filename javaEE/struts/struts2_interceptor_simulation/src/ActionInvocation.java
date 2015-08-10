import java.util.ArrayList;
import java.util.List;


public class ActionInvocation {
	List<Interceptor> interceptors = new ArrayList<>();
	Action a = new Action();
	int index = -1;
	public ActionInvocation() {
		interceptors.add(new FirstInterceptor());
		interceptors.add(new SecondInterceptor());
	}
	public void invoke() {
		index++;
		if (index >= interceptors.size()) {
			a.execute();
		} else {
			interceptors.get(index).intercept(this);
		}
	}
}
