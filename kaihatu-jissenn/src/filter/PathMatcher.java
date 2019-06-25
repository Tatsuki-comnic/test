package filter;

public class PathMatcher {

	public static boolean matches(String path) {
		
		if (path.matches("/login.do") || 
			path.matches("/sign-up.*") ||
			path.matches("/mapback.do") ||
			path.matches("/library-address.*") ||
		    path.endsWith(".*(.css)|(.js)|(.gif)|(.png)|(.jpg)")) {
			
			return true;
		}
		
		return false;
	}
}
