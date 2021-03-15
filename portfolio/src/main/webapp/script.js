// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/** Fetches messages from the server and adds them to the DOM. */
function loadMessages() {
	fetch('/list-messages').then(response => response.json()).then((messages) => {
		const messageListElement = document.getElementById('message-list');
		messages.forEach((message) => {
			messageListElement.appendChild(createMessageElement(message));
		})
	});
}

/** Creates an element that represents a message, including its delete button. */
function createMessageElement(message) {
	const messageElement = document.createElement('li');
	messageElement.className = 'msg sb3';

	const titleElement = document.createElement('span');
	titleElement.innerText = message.messageText;

	messageElement.appendChild(titleElement);
	return messageElement;
}

async function fetchHardCodedString() {
	const responseFromServer = await fetch('/hello-world');
	const textFromResponse = await responseFromServer.text();

	const responseContainer = document.getElementById('response-container');
	responseContainer.innerText = textFromResponse;
}

async function displayRandomMusical() {
	const response = await fetch("/random-album");
	const musicalJSON = await response.json()

	randomMusical = musicalJSON[Math.floor(Math.random() * musicalJSON.length)]

	const musicalElement = document.getElementById('musical-name');
	musicalElement.innerText = randomMusical;
}