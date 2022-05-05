package services;

import model.Performers;

import java.util.List;

public interface IPermissionService {
    List<Performers> getPermissions();

    Performers findById(int id);

    List<Performers> findByTaskId(long taskId);

    void add(Performers newPermission);

    void update(Performers newPermission);

    boolean existById(int id);
}