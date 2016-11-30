var express = require('express');
var app = express();
var mongojs = require('mongojs');
var db = mongojs('resume', ['education_list', 'skill_list', 'project_list']);
var bodyParser = require('body-parser');

app.use(express.static(__dirname + '/public'));
app.use(bodyParser.json());


app.get('/education_list', function (req, res) {
    console.log('server->app.get: I received a GET request');

    db.education_list.find(function (err, docs) {
	console.log(docs);
	res.json(docs);
    });
});

app.get('/project_list', function (req, res) {
    console.log('server->app.get: I received a GET request');

    db.project_list.find(function (err, docs) {
	console.log(docs);
	res.json(docs);
    });
});

app.get('/skill_list', function (req, res) {
    console.log('server->app.get: I received a GET request');

    db.skill_list.find(function (err, docs) {
	console.log(docs);
	res.json(docs);
    });
});

















//var db = mongojs('contactlist', ['contactlist']);
app.get('/contactlist', function (req, res) {
    console.log('server->app.get: I received a GET request');

    db.contactlist.find(function (err, docs) {
	console.log(docs);
	res.json(docs);
    });
});

app.post("/contactlist", function(request, response){
    console.log("server->app.post");
    console.log(request.body);
    db.contactlist.insert(request.body, function(error, docs){
	response.json(docs);
    });
});

app.delete('/contactlist/:id', function (req, res) {
    var id = req.params.id;
    console.log(id);
    db.contactlist.remove({_id: mongojs.ObjectId(id)}, function (err, doc) {
	res.json(doc);
    });
});

app.get('/contactlist/:id', function (req, res) {
    var id = req.params.id;
    console.log(id);
    db.contactlist.findOne({_id: mongojs.ObjectId(id)}, function (err, doc) {
	res.json(doc);
    });
});

app.put('/contactlist/:id', function (req, res) {
    var id = req.params.id;
    console.log(req.body.name);
    db.contactlist.findAndModify({
	query: {_id: mongojs.ObjectId(id)},
	update: {$set: {name: req.body.name, email: req.body.email, number: req.body.number}},
	new: true}, function (err, doc) {
	    res.json(doc);
	});
});


app.listen(8080);
console.log("Server running on port 8080");