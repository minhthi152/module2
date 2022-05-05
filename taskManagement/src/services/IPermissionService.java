package services;

import model.Permission;

import java.util.List;

public interface IPermissionService {
    List<Permission> getPermissions();

    Permission findById(int id);

    List<Permission> findByTaskId(long taskId);

    void add(Permission newPermission);

    void update(Permission newPermission);
}
