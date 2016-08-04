package com.razorthink.webdesign.testcase;

import static org.junit.Assert.*;

import org.junit.Test;

import com.razorthink.webdesign.dao.LoginUser;

public class LoginUserTest {

	@Test
	public void test() {
		
		String username="umesh0910";
		String password="umeshkumar";
		String user=LoginUser.loginUser(username, password);
		assertEquals("umesh0910",user);
	}

}
