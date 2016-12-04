from bottle import Bottle, run, static_file, template, request
from bvg import journey
from random import randint

app = Bottle()

static_root = "./static"

@app.route('/query')
def pool_matching():
    # start requesting
    try:
        input = request.query
        params = journey(input['start'], input['end'], input['date'], input['time'])
        params['app'] = input['app']
        params['num_people'] = randint(1, 5)
        return template("request_template.html", params)
    except:
        return home(error=True)

@app.route('/')
def home(error=False):
    return static_file("index.html", root=static_root)

@app.route('/<filepath:path>')
def server_static(filepath):
    return static_file(filepath, root=static_root)

if __name__ == '__main__':
    run(app, host="localhost", port=19999, server='cherrypy')