# spring-mongo-poc

Steps done to install Mongo DB
1. Downloaded latest version of mongo db 
https://www.mongodb.com/dr/fastdl.mongodb.org/linux/mongodb-linux-x86_64-ubuntu1404-4.0.5.tgz/download
2. tar -zxvf mongodb-linux-*-4.0.5.tgz
3. sudo mkdir -p /data/db
4. sudo mkdir -p /var/log/mongodb
5. sudo mongod --dbpath /data/db --logpath /var/log/mongodb/mongod.log --fork



