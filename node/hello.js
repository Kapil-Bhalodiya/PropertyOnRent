// var http = require('http');

var events = require('events');
var eventEmitter = new  events.EventEmitter();

var connectionHandler = function connected(){
    console.log("Connected..!");

    eventEmitter.emit("get data");
}

eventEmitter.on('connection',connectionHandler);

eventEmitter.on('get data',function(){
    console.log("received data");
});

eventEmitter.emit('connection');

// var express = require('express');
// http.createServer(function(req,res){



//     res.end("Hello World123");
// }).listen(8081);