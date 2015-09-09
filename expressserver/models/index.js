
var Sequelize = require('sequelize');
var sequelize = new Sequelize('appdb', null, null, {
	dialect: "sqlite",
	storage: ":memory:"
});

var Catagory = sequelize.define('Catagory', {
	name: Sequelize.STRING,
	image: Sequelize.BLOB('tiny')
});

var Provider = sequelize.define('Provider', {
	name: Sequelize.STRING,
	location: Sequelize.STRING,
	desctiprion: Sequelize.STRING,
	fullDesctiprion: Sequelize.TEXT,
	image: Sequelize.BLOB('tiny')
});

var User = sequelize.define('User', {
	firstName: Sequelize.STRING,
	lastName: Sequelize.STRING,
	email: Sequelize.STRING,
	password: Sequelize.STRING,
	type: Sequelize.ENUM('CUSTOMER', 'PROVIDER')
});

Catagory.hasMany(Provider, {as: 'Providers'});
sequelize.sync();

module.exports = { 
	sequelize: sequelize,
	Provider: Provider,
	Catagory: Catagory,
	User: User
};