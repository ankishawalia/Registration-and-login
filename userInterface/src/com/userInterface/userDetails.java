package com.userInterface;
import java.util.*;
import com.userInterface.userInterface;

public class userDetails {
	public static ArrayList<userInterface> userDetails;
	 public userDetails() {
		 super();
		 if (userDetails==null) {
			 userDetails= new ArrayList<userInterface>();
		 }
	 }

	public static void addUserDetails(userInterface user) {
		 userDetails.add(user);
	 }
	 
	 public static ArrayList<userInterface> getUserInfo() {
		return userDetails;
	}
	
	 
}
