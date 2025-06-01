async function sendPrompt() {
  const prompt = document.getElementById("prompt").value;
  const model = document.getElementById("model").value;
  if (!prompt.trim()) return;

  appendMessage("user", prompt);
  document.getElementById("prompt").value = "";

  const response = await fetch("/ask", {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify({ prompt, model })
  });

  const data = await response.json();
  appendMessage("ai", data.response);
}

function appendMessage(sender, text) {
  const chatBox = document.getElementById("chat");
  const bubble = document.createElement("div");
  bubble.className = `chat-bubble ${sender}`;
  bubble.innerText = text;
  chatBox.appendChild(bubble);
  chatBox.scrollTop = chatBox.scrollHeight;
}
