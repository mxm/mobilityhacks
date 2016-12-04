import json
from urllib.request import urlopen
from urllib.parse import urlencode
import codecs
import os

reader = codecs.getreader("utf-8")

base = "http://demo.hafas.de/openapi/vbb-proxy/"
locationEndpoint = "location.name"

generic_opts = {
    'accessId' : os.environ['BVG'],
    'format' : 'json',
}

def pretty_print(json_string):
    print(json.dumps(json_string, indent=2, separators=(',', ': ')))


def make_query(endpoint, params):
    args = generic_opts.copy()
    args.update(params)
    return json.load(reader(urlopen(base + endpoint + "?" + urlencode(args))))

def kotti_example():
    journey("S+U Hermannstr", "Potsdam Hbf", "2016-12-05", "14:00")

def journey(start, end, start_date, start_time):
    query = make_query(locationEndpoint, {
        'input' : start
    })
    #pretty_print(query['stopLocationOrCoordLocation'][0])

    hermann_id = query['stopLocationOrCoordLocation'][0]['StopLocation']['extId']
    #print(hermann_id)


    query = make_query(locationEndpoint, {
        'input' : end
    })
    #pretty_print(query['stopLocationOrCoordLocation'][0])

    kotti = query['stopLocationOrCoordLocation'][0]['StopLocation']['extId']
    #print(kotti)

    #print("---")

    query = make_query("trip", {
        'originExtId' : hermann_id,
        'destExtId' : kotti,
        'date' : start_date,
        'time' : start_time
    })

    #pretty_print(
    #    query
    #)

    #print("har")

    origin = query['Trip'][0]['LegList']['Leg'][0]['Origin']
    #print(origin['name'])
    #print(origin['time'])

    last_entry = query['Trip'][0]['LegList']['Leg'].__len__() - 1
    destination = query['Trip'][0]['LegList']['Leg'][last_entry]['Destination']
    #print(destination['name'])
    #print(destination['time'])

    return {
       'start' : origin['name'],
       'start_date' : origin['date'],
       'start_time' : origin['time'],
       'end' : destination['name'],
       'end_date' : destination['date'],
       'end_time' : destination['time']
    }


if __name__ == '__main__':
    kotti_example()