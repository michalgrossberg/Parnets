var express = require('express');
var router = express.Router();
var models = require('../models');
var sequelize = models.sequelize;
var Provider = models.Provider;

router.get('/all', function(req, res) {
  Provider.findAll().then(function (catagories) {
		res.send(catagories);
	});
});
	
router.get('/:name', function(req, res) {
  name = req.param('name')
  Provider.findOne({
	  where : { name: name }
	}).then(function (catagory) {
		res.send(catagory);
	});
});

router.post('/register', function(req, res) {
  Provider.create({
	name: req.body.name,
	location: req.body.location,
	desctiprion: req.body.desctiprion,
	fullDesctiprion: req.body.fullDesctiprion,
	image: req.body.image
  }).then(function(catagory) {
	res.status(201);
	res.end();
  });
});

module.exports = router;
