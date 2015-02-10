##dogTracker##

A web application to visualize simulated motion of trackers implanted in dog collars (and get my feet wet with Spring MVC).

###Installation instructions###

- Clone the repo `git clone https://github.com/thezelus/dogTracker.git`
- In the project directory run `mvn -U clean install`
- Under `/trackingServer/target` and `/viewServer/target` corresponding war files can be found
- Deploy those files in tomcat webapps directory to run the project
- Properties files can be found under expanded war directories under classpath

Default **trackingServer.properties** (/webapps/trackingServer/WEB-INF/classes)

```
xLower = 10
xUpper = 780
yLower = 10
yUpper = 580
rfidCount = 100
dataUpdatePeriod = 2000
```
Where 
- (`xLower`, `xUpper`), (`yLower`, `yUpper`) define the range of x and y values for a position 
- `rfidCount` defines number of trackers to be generated for simulation
- `dataUpdatePeriod` defines the time interval in millisecond for the change in data values to simulate motion

Default **viewServer.properties** (/webapps/viewServer/WEB-INF/classes)

```
trackingServer.BaseUrl=http://localhost:8080/trackingServer
trackingServer.StatusPath=/status
trackingServer.IdPath=/data/id
trackingServer.AllIdsPath=/data/ids
outboundRequestIntervalInMilliseconds=2000
```
Where `outboundRequestIntervalInMilliseconds` defines the time interval between the request sent out to trackingServer for fresh data.

###API Documentation###

Tracking server API has following end points

**Note**: All GET calls to this API require `Accept` header with value `application/json`.
This can be easily accomplished using some REST client like [Postman](http://www.getpostman.com)

####Status####

Returns server status

- Method: `GET`

- URL: `/status`

- Header: `Accept` with value `application/json`

- Response: JSON array of id values
```
{
    "status": "Server is running",
    "current": "2015-02-10T03:27:26.656Z"
}
```

####Get Ids####

Returns all the ids for the trackers that are present in the datasource in a JSON response format

- Method: `GET`

- URL: `/data/ids`

- Header: `Accept` with value `application/json`

- Response: JSON array of id values
```
[
    "id44",
    "id25",
    "id19",
    "id77",
    "id64",
    "id38"
]
```

####Get tracker data for id####

Returns data associated with the given tracker id in a JSON format, otherwise returns error response

- Method: `GET`

- URL: `/data/id/{id}`

- Header: `Accept` with value `application/json`

- Response: 

---> For valid id:

```
{
    "id": "id2",
    "xCoordinate": 500,
    "yCoordinate": 79,
    "heartRate": 135,
    "bodyTemperatureInFahrenheit": 98.69133
}
```

---> For invalid id (that might have been removed): Response status is `410 Gone`

```
{
    "code": "INVALID_KEY_VALUE",
    "message": "Value associated with this key is null",
    "description": ""
}
```

###View Server Canvas###

View server has a dashboard that can be used to visualize the simulated motion of trackers. This can be found at
`hostname/viewServer/canvas`

The data on this view updates every 2500 millisecond

Screenshots of this page can be seen below -

![Screenshot1](https://github.com/thezelus/dogTracker/blob/master/images/screenshot1.png)

![Screenshot1](https://github.com/thezelus/dogTracker/blob/master/images/screenshot2.png)


###Design Decisions (for current release)###
- XML based deployment descriptors for supporting older versions of Servlet
- Configurable properties for web apps (trackingServer & viewServer) can be found in classpath after the war files are deployed (/webapps/trackingServer/WEB-INF/classes)
- Custom error responses when key is absent to differentiate between when key is absent and when the remote server is down
- Fault tolerance (https://github.com/Netflix/SimianArmy/wiki/Chaos-Monkey): data in the viewServer is preserved in its last state if for some reason trackingServer goes down
- In-memory data source is being used to minimize dependencies
- View server uses `/liveData` end point to get latest JSON array, this will help with future implementations for other clients or API extension

###Assumptions###
- RFId tracker receives coordinates in form of (x,y) where (0,0) is the top left corner of the canvas
- Default range for body temperature and heart rate are assumed
- To simulate motion and change in vitals, data is modified internally (in the trackingServer) using a separate thread
- Data simulation generates random x-y coordinates and vitals within the given range
- Data in client’s browser updates every 2500 milliseconds
- Canvas default size is 800px x 600px

###Todo list###
- [ ] Add more tests both unit and integration

- [ ] Use Redis as an in-memory datastore

- [ ] Protocol buffers for model generation

- [ ] Re-engineer frontend to make it more responsive

- [ ] Increase familiarity with Spring annotations

- [ ] Replace random motion model with pedestrian simulation model for generation of simulation data


###High level application architecture###
![Architecture](https://github.com/thezelus/dogTracker/blob/master/images/architecture.png)

