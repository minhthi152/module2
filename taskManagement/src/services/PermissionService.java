package services;

import model.Permission;
import utils.CSVUtils;

import java.util.ArrayList;
import java.util.List;

public class PermissionService implements IPermissionService {
    public static PermissionService instance;
    public final static String PATH = "data/permissions.csv";

    private PermissionService() {
    }

    public static PermissionService getInstance() {
        if (instance == null)
            instance = new PermissionService();
        return instance;
    }

    @Override
    public List<Permission> getPermissions() {
        List<Permission> permissions = new ArrayList<>();
        List<String> lines = CSVUtils.read(PATH);
        for (String line : lines) {
            permissions.add(Permission.parsePermission(line));
        }
        return permissions;
    }

    @Override
    public Permission findById(int id) {
        List<Permission> permissions = getPermissions();
        for (Permission permission : permissions) {
            if (permission.getId() == id) {
                return permission;
            }
        }
        return null;
    }

    @Override
    public List<Permission> findByTaskId(long taskId) {
        List<Permission> result = new ArrayList<>();
        List<Permission> permissions = getPermissions();
        for (Permission permission : permissions) {
            if (permission.getTaskId() == taskId) {
                result.add(permission);
            }
        }
        return result;
    }

    @Override
    public void add(Permission newPermission) {
        List<Permission> permissions = getPermissions();
        permissions.add(newPermission);
        CSVUtils.write(PATH, permissions);
    }

    @Override
    public void update(Permission newPermission) {
        List<Permission> permissions = getPermissions();
        for (Permission permission : permissions) {
            if (permission.getId() == newPermission.getId()) {
                permission.setPermissionType(newPermission.getPermissionType());
                break;
            }
        }
        CSVUtils.write(PATH, permissions);
    }
}
