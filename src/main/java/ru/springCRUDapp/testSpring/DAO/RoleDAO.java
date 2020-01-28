package ru.springCRUDapp.testSpring.DAO;

import ru.springCRUDapp.testSpring.model.Role;

public interface RoleDAO {

    void saveRole(Role role);

    void updateRole(Role role);

    void deleteRole(Long id);

    Role getRoleById(Long id);
}
