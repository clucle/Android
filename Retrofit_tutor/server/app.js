var express = require('express');

var http = require('http');
var path = require('path');

var app = express();

var bodyParser = require('body-parser');

// parse JSON inputs
app.use(bodyParser.json());
// parse URL encoded inputs
app.use(bodyParser.urlencoded());

app.set('port', process.env.PORT || 3000);

app.get('/', function(req, res){
	res.sendFile(__dirname + '/index.html');
});

app.post('/ping', function(req, res){
	res.status(200).send("pong");
});

app.post('/user/one', function(req, res){
	if (req.body.name == "clucle") {
		res.status(200).send({name: 'clucle', age: 23});
	} else if(req.body.name == "junsu") {
		res.status(200).send({name: 'junsu', age: 25});
	} else {
		res.status(501).send("ERROR");
	}
});

app.post('/user/list', function(req, res){
	res.status(200).send({users: [
		{name: 'clucle', age: 23},
		{name: 'junsu', age: 25}
	]});
});

http.createServer(app).listen(app.get('port'), function(){
	console.log('Express server listeneing on port ' + app.get('port'));
})