# Co-authored by Luna

from router import get_best_response


def main():
    user_input = input("You: ")
    best_response = get_best_response(user_input)
    print("AI:", best_response)