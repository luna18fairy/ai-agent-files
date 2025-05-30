# This can be extended to score or analyze responses
def evaluate_response(response):
    return {"length": len(response), "preview": response[:30]}
