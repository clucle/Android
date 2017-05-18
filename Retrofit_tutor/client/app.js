var express = require('express');

var http = require('http');
var path = require('path');

var app = express();

app.set('port', process.env.PORT || 3000);

app.get('/', function(req, res){
	res.sendFile(__dirname + '/index.html');
});

http.createServer(app).listen(app.get('port'), function(){
	console.log('Express server listeneing on port ' + app.get('port'));
})