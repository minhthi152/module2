package services;

import model.Performers;
import model.PermissionType;

import java.util.List;

public interface IPermissionService {

    List<Performers> getPerformers();

    Performers findById(int id);

    List<Performers> findByTaskId(long taskId);

    void add(Performers newPermission);

    void update(Performers newPermission);

    boolean existById(int id);

    PermissionType findPermissionType(long taskId, String fullName);
}