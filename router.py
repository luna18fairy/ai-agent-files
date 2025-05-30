from flask import render_template, request, jsonify
from main import call_model

def register_routes(app):
    @app.route('/')
    def home():
        return render_template('index.html')

    @app.route('/ask', methods=['POST'])
    def ask():
        data = request.json
        prompt = data.get('prompt')
        model = data.get('model')
        response = call_model(model, prompt)
        return jsonify({'response': response})

