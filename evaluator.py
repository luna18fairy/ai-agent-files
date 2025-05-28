def evaluate_responses(responses):
    # Very basic: choose the longest response
    # Replace with something smarter (e.g., GPT evaluator model, semantic comparison)
    best_model = max(responses, key=lambda k: len(responses[k]))
    return best_model, responses[best_model]
