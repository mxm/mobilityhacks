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


query = make_query(locationEndpoint, {
    'input' : 'S+U Hermannstr'
})
pretty_print(query['stopLocationOrCoordLocation'][0])

hermann_id = query['stopLocationOrCoordLocation'][0]['StopLocation']['extId']
print(hermann_id)


query = make_query(locationEndpoint, {
    'input' : 'U Kottbusser Tor'
})
pretty_print(query['stopLocationOrCoordLocation'][0])

kotti = query['stopLocationOrCoordLocation'][0]['StopLocation']['extId']
print(kotti)

print("---")

query = make_query("trip", {
    'originExtId' : hermann_id,
    'destExtId' : kotti,
    'date' : '2016-12-05',
    'time' : '14:00'
})

pretty_print(
    query
)

print("har")

destination = query['Trip'][0]['LegList']['Leg'][0]['Destination']
print(destination['name'])
print(destination['time'])

origin = query['Trip'][0]['LegList']['Leg'][0]['Origin']
print(origin['name'])
print(origin['time'])