const longField = document.getElementById('longUrl');
const keyField = document.getElementById('shortUrl');
function getTinyUrl() {
	let longUrl = longField.value;
	if (longUrl === "") {
		alert("Please give long url");
	}
	else {
		//code for json fetch
		const data = {
			longUrl: longUrl,
		};

		fetch('http://localhost:8080/api/generateShortUrl', {
			method: 'POST',
			headers: {
				"Content-Type": "application/json; charset=UTF-8",
			},
			body: JSON.stringify(data),
		})
			.then(response => response.json())
			.then(data => {

				console.log(data);
				keyField.value = data.shortUrl
			})
			.catch((error) => {
				//console.error('Error:', error);
			});
	}
}

function redirect() {
	const keyField = document.getElementById('shortUrl');
	let shortUrl = keyField.value;
	console.log(shortUrl);
	fetch('http://localhost:8080/api/getLongUrl/' + shortUrl, { mode: 'no-cors' }, {

		headers: {
			"Content-Type": "text/html; charset=UTF-8"
		},
	}).then(response => response.json())
		.then(data => {
			console.log(data);
			window.open(data.longUrl);
		})
		.catch((error) => {
			console.error('Error:', error);
		});
}

function ClearFields() {

     longField.value = "";
     keyField.value = "";
     
     longField.focus();
}