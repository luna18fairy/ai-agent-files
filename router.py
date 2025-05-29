from models.chatgpt import query_chatgpt
from models.gemini import query_gemini
from models.claude import query_claude
from evaluator import evaluate_responses

def get_best_response(prompt):
    responses = {
        "ChatGPT": query_chatgpt(prompt),
        "Gemini": query_gemini(prompt),
        "Claude": query_claude(prompt)
    }

if prompt = ChatGPT[]:
    return null

    best_model, best_output = evaluate_responses(responses)
    return f"[{best_model}] {best_output}"
