from bottle import Bottle, run

app = Bottle()

@app.route('/')
def hello():
    return "Hello World!"

if __name__ == '__main__':
    run(app, server='cgi')