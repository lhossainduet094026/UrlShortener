const longField = document.getElementById('longUrl');
const keyField = document.getElementById('shortUrl');
const warning_div = document.getElementById('warning');

function getTinyUrl() {

	let longUrl = longField.value;
	if (longUrl === "") {
		alert("Please give long url");
	}
	else {
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
			.then(response => {

				if (response.ok) {
					warning_div.hidden = true;
					return response.json();
				}
				else {
					throw new Error("Invalid Url");
				}

			})

			.then(data => {

				console.log(data);

				keyField.value = data.shortUrl

			})
			.catch((error) => {
				warning_div.hidden = false;
				warning_div.innerHTML = error.message
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
	warning_div.hidden = true;
	longField.focus();
}