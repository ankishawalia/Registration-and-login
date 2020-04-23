package com.userInterface;

import com.userInterface.userInterface;
import java.util.ArrayList;

public interface userWal {
	public static String addUserDetails(userInterface user) {
		// TODO Auto-generated method stub
		return null;
	}

	public static userInterface checkLoginDetails(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public static ArrayList<userInterface> getAllTheUserDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	public userInterface getUserById(Integer id);

	public boolean updateUserById(userInterface user);

	public boolean deleteUserById(Integer id);

}
