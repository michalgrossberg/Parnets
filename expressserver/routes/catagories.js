var express = require('express');
var router = express.Router();
var models = require('../models');
var sequelize = models.sequelize;
var Catagory = models.Catagory;

router.get('/all', function(req, res) {
  Catagory.findAll().then(function (catagories) {
		res.send(catagories);
	});
});
	
router.get('/:name', function(req, res) {
  name = req.param('name')
  Catagory.findOne({
	  where : { name: name }
	}).then(function (catagory) {
		res.send(catagory);
	});
});

router.post('/register', function(req, res) {
  name = req.param('name')
  image = req.param('image')
  Catagory.create({
	  name: name,
	  image: image
  }).then(function(catagory) {
	res.status(201);
	res.end();
  });
});

module.exports = router;
