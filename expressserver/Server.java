
class Provider {
	int id;
	String name;
	String location;
	String desctiprion;
	String fullDesctiprion;
	byte[] image;
}

class Catagory {
	int id;
	String name;
	byte[] image;
}

enum UserType{
	CUSTOMER, PROVIDER
}

class User {
	int id;
	String firstName, lastName, email, password;
	UserType type;
}

interface Server {
	// POST /catagories/register
	void createCatagory(Catagory catagory);
	// GET /catagories/:name
	Catagory getCatagory(String name);
	// GET /catagories/all
	Catagory[] getCatagories();
	// POST /providers/register
	void createProvider(Provider catagory);
	// GET /providers/:name
	Provider getProvider(String name);
	// GET /providers/all
	Provider[] getProviders();
	// POST /users/register
	void createUser(User user);
	// GET /users/login/:email/:password
	User login(string email, string password);
}
