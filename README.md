# spring-mongo-poc

Steps done to install Mongo DB
1. Downloaded latest version of mongo db 
https://www.mongodb.com/dr/fastdl.mongodb.org/linux/mongodb-linux-x86_64-ubuntu1404-4.0.5.tgz/download
2. tar -zxvf mongodb-linux-*-4.0.5.tgz
3. sudo mkdir -p /data/db
4. sudo mkdir -p /var/log/mongodb
5. sudo mongod --dbpath /data/db --logpath /var/log/mongodb/mongod.log --fork

Once Mongo DB server is started successfully, to login to shell 
#mongo
To see the list of the databases
>show dbs;
To create a database named as locationdb
> use locationdb;
 to drop database use 
>db.dropDatabase()

To insert data into a collection called restaurants

>db.restaurants.insert( { name: "Kimono", loc: { type: "Point",coordinates: [ 52.370451, 5.217497] } } );
>db.restaurants.insert( {name: "Shabu Shabu", loc: { type: "Point",coordinates: [51.915288,4.472786] } } ) 
> db.restaurants.insert( {name: "Tokyo Cafe", loc: { type: "Point",coordinates: [52.368736, 4.890530] } } )
To create an index based on the location information 
db.restaurants.ensureIndex ( { loc: "2dsphere" } )

Now to search with the given location 
db.restaurants.find( { loc : { $near : { $geometry : { type : "Point",coordinates: [52.338433,5.513629] } } } } )

To search with a limit on the given distance
db.retaurants.find( { loc : { $near : { $geometry : { type : "Point",coordinates: [52.338433,5.513629] }, $maxDistance : 40000 } } } )
