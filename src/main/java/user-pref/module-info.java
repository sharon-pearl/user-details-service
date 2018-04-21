module userpreferences{
	requires java.base;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.context;
	exports com.pearlin.whatflix.user.pref;
	opens com.pearlin.whatflix.user.pref;
}