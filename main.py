def call_model(model_name, prompt):
    if model_name == 'OpenAI':
        return f"[OpenAI says] {prompt}"
    elif model_name == 'Claude':
        return f"[Claude replies] {prompt}"
    elif model_name == 'Gemini':
        return f"[Gemini thinks] {prompt}"
    else:
        return "Unsupported model."


