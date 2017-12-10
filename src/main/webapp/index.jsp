<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <body>
		<form action = "slide_show" method = "GET">
			<input type = "submit" value = "Create slide show" name = "param">
			<input type = "submit" value = "Show presentation" name = "param">
			<input type = "submit" value = "Show all images" name = "param">
			<input type = "submit" value = "Show all presentations" name = "param">
		</form>
		<div>${message}</div>
    </body>
</html>
