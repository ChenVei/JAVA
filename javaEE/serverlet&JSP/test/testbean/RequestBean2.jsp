<jsp:useBean id="c" scope="request" class="bean.CounterBean" />
<%= "Count:" + c.getCount() %>