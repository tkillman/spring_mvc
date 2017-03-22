package tiles.controller;

public class MockAuthenticator implements Authenticator {
//로그인 시 abc라는 아이디로 로그인 해야 성공
	public void authenticate(String id, String password) {
		if (!id.equals("abc")) {
			throw new AuthenticationException("invalid id "+id);
		}
	}

}