/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import java.util.HashMap;
import java.util.Map;

public class UserProfileManager {
    private static UserProfileManager instance;
    private Map<String, String> userProfiles;

    private UserProfileManager() {
        userProfiles = new HashMap<>();
    }

    public static UserProfileManager getInstance() {
        if (instance == null) {
            instance = new UserProfileManager();
        }
        return instance;
    }

    public void addUser (String userId, String userDetails) {
        userProfiles.put(userId, userDetails);
        System.out.println("User  added: " + userId);
    }

    public String getUser (String userId) {
        return userProfiles.get(userId);
    }
}