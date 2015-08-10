<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
<head><title>Simple jsp page</title></head>
<body>
    <h3>Exception:</h3>
    <s:property value="exception"/>

    <h3>Stack trace:</h3>
    <pre>
        <s:property value="exceptionStack"/>
    </pre>
    
    <br/>
    <s:fielderror fieldName="age">xx</s:fielderror>
    <br/>
    <s:property value="errors.age[0]"/>
    <br/>
    <s:debug></s:debug>
</body>
</html>