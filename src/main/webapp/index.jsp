<html>
    <body>
		<form action = "slide_show" method = "GET">
			<input type = "submit" value = "Create Slide Show" name = "param">
			<input type = "submit" value = "Show Presentation" name = "param">
			<input type = "submit" value = "Show slide by slide" name = "param">
		</form>
		
		<form action = "slide_show" method = "GET">
			<div>
				<input type = "date" required name = "first_date">
				<input type = "date" required name = "second_date">
				<input type = "submit" value = "Find by date" name = "param">
			</div>
		</form>
		<form action = "slide_show" method = "GET">
			<div>
				<input type = "number" required name = "lower_bound">
				<input type = "number" required name = "higher_bound">
				<input type = "submit" value = "Find by size" name = "param">
			</div>
		</form>
		<form action = "slide_show" method = "GET">
			<div>
				<input type = "text" required name = "tag">
				<input type = "submit" value = "Find by tag" name = "param">
			</div>
		</form>
		<form action = "slide_show" method = "GET">
			<input type = "submit" value = "Sort by date" name = "param">
			<input type = "submit" value = "Sort by size" name = "param">
			<input type = "submit" value = "Sort by tag" name = "param">
		</form>
		<form action = "slide_show" method = "GET">
        	<input type = "submit" value = "Get total size" name = "param">
        </form>
		${message}
    </body>
</html>
