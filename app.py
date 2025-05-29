from flask import Flask, request, render_template, jsonify
from models import call_model

app = Flask(__name__)

@app.route('/')
def home():
    return render_template('index.html')

@app.route('/ask', methods=['POST'])
def ask():
    data = request.json
    prompt = data['prompt']
    model = data['model']
    response = call_model(model, prompt)
    return jsonify({'response': response})

if __name__ == '__main__':
    app.run(debug=True)
