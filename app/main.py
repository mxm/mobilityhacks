from bottle import Bottle, run, static_file, template, request
from bvg import journey
from random import randint

app = Bottle()

static_root = "./static"

@app.route('/query')
def pool_matching():
    input = request.query
    # start requesting
    params = journey(input['start'], input['end'], input['date'], input['time'])
    params['app'] = input['app']
    params['num_people'] = randint(1, 4)
    return template("request_template.html", params)

@app.route('/')
def home():
    return static_file("index.html", root=static_root)

@app.route('/<filepath:path>')
def server_static(filepath):
    return static_file(filepath, root=static_root)

if __name__ == '__main__':
    run(app, host="0.0.0.0", port=19999)