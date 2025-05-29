async function sendPrompt() {
    const prompt = document.getElementById("prompt").value;
    const model = document.getElementById("model").value;
  
    const res = await fetch("/ask", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ prompt, model })
    });
  
    const data = await res.json();
    document.getElementById("response").innerText = data.response;
  }
  