<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Url shortener page</title>
</head>
<body>
<div style="margin-left: 100px">
		<p>Url converter</p>
	</div>
	<div>
		<form action="/api/generateShortUrl" method="post">
			<table style="with: 50%">
				<tr>
					<td>Long url:</td>
					<td><input type="text" name="longUrl"></td>
				</tr>
				<tr>
					<td>Short url:</td>
					<td><input type="text" name="shortUrl"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Get short url"></td>
				</tr>

			</table>
		</form>

	</div>
</body>
</html>