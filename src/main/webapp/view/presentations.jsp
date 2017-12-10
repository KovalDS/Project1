<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <body>
        <div>${message}</div>
        <form form action = "slide_show" method = "GET">
            <table border = "1">
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Hash</th>
                    <th>Images</th>
                </tr>
                <c:forEach items = "${allPresentations}" var = "presentation">
                    <tr>
                        <td>${presentation.id}</td>
                        <td>${presentation.name}</td>
                        <td>${presentation.hash}</td>
                        <td>
                            <table border = 1>
                                <tr>
                                    <th>Image id</th>
                                    <th>Image hash</th>
                                </tr>
                                <c:forEach items = "${presentation.images}" var = "image">
                                    <tr>
                                        <td>${image.id}</td>
                                        <td>${image.hash}</td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </td>
                        <td><input type = "radio" value = "${presentation.id}" name = "presentation"></td>
                    </tr>
                </c:forEach>
            </table>
            <input type = "submit" value = "Show presentation" name = "param">
            <input type = "submit" value = "Show slide by slide" name = "param">
		</form>
    </body>
</html>
