from bottle import Bottle, run, static_file, template

app = Bottle()

static_root = "./static"

@app.route('/query/<name>/<start>/<end>/<date>/<time>/<app>')
def request(**params):
    # start requesting

    return template("request_template.html", params)

@app.route('/')
def home():
    return static_file("index.html", root=static_root)

@app.route('/<filepath:path>')
def server_static(filepath):
    return static_file(filepath, root=static_root)

if __name__ == '__main__':
    run(app, host="0.0.0.0", port=19999)