<html>
    <body>
		<form action = "slide_show" method = "GET">
		    <h2>Presentation ${presentation.name}</h2>
		    <p>Slide #${current_slide}</p>
		    <table border = "1">
                <tr>
                    <th>Image id</th>
                    <th>Hash code</th>
                    <th>Type</th>
                    <th>Size</th>
                    <th>Tag</th>
                    <th>Date of creation</th>
                    <th>Length</th>
                </tr>
                <tr>
                    <td>${image.id}</td>
                    <td>${image.hash}</td>
                    <td>${image.type}</td>
                    <td>${image.size}</td>
                    <td>${image.tag}</td>
                    <td>${image.dateOfCreation}</td>
                    <td>${image.length}</td>
                </tr>
             </table>
            <input type = "hidden" value = "${presentation.id}" name = "presentation">
            <input type = "hidden" value = "${current_slide}" name = "current_slide">
		    <input type = "submit" value = "Next slide" name = "param">
		</form>
    </body>
</html>
