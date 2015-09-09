var express = require('express');
var router = express.Router();
var models = require('../models');
var sequelize = models.sequelize;
var User = models.Provider;
	
router.get('/login/:email/:password', function(req, res) {
  email = req.param('email')
  password = req.param('password')
  User.findOne({
	  where : { email: name, password: password }
	}).then(function (catagory) {
		res.send(catagory);
	});
});

router.post('/register', function(req, res) {
	user = req.param('user')
  User.create({
	firstName: user.firstName,
	lastName: user.lastName,
	email: user.email,
	password: user.password,
	type: type
  }).then(function(catagory) {
	res.status(201);
	res.end();
  });
});

module.exports = router;
