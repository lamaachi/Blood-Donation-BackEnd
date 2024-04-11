package org.restapi.minprojetrest.Service;

import org.restapi.minprojetrest.Model.AppUser;

import java.util.List;

public interface UserService {
    List<AppUser> getAllUSers();

    void removeuser(Long id);
}
