module userpreferences{
	requires java.base;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.beans;
	requires java.xml.ws.annotation;
	requires org.mongodb.driver.sync.client;
	exports com.pearlin.whatflix.user.pref;
//	opens com.pearlin.whatflix.user.pref;
}