###Design Decisions (for current release)###
- XML based deployment descriptors for supporting older versions of Servlet
- Configurable properties for web apps (trackingServer & viewServer) can be found in classpath after the war files are deployed (/webapps/trackingServer/WEB-INF/classes)
- Custom error responses when key is absent to differentiate between when key is absent and when the server is down
- Fault tolerance (https://github.com/Netflix/SimianArmy/wiki/Chaos-Monkey): data in the viewServer is preserved last state if for some reason trackingServer goes down
- In-memory data source is being used to minimize dependencies
- View server uses `/liveData` end point to get latest JSON array, this will help in future implementations for other client implementations or API extension

###Assumptions###
- RFId tracker receives coordinates in form of (x,y) where (0,0) is the top left corner of the canvas
- Default range for body temperature and heart rate are assumed
- To simulate motion and change in vitals, data is modified internally (in the trackingServer) using a separate thread
- Data simulation generates random x-y coordinates and vitals within the given range
- Data in client’s browser updates every 2500 milliseconds
- Canvas default size is 800px x 600px

###Todo list###
[ ] Add more tests both unit and integration
[ ] Use Redis as an in-memory datastore
[ ] Protocol buffers for model generation
[ ] Re-engineer frontend to make it more responseive
[ ] Increase familiarity with Spring annotations
[ ] Replace random motion model with pedestrian simulation model for generation of simulation data


###High level application architecture###
![Architecture](https://github.com/thezelus/dogTracker/blob/master/images/architecture.png)

