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
  name = req.param('name')
  location = req.param('location')
  desctiprion = req.param('desctiprion')
  fullDesctiprion = req.param('fullDesctiprion')
  image = req.param('image')
  Provider.create({
	name: name,
	location: location,
	desctiprion: desctiprion,
	fullDesctiprion: fullDesctiprion,
	image: image
  }).then(function(catagory) {
	res.status(201);
	res.end();
  });
});

module.exports = router;
