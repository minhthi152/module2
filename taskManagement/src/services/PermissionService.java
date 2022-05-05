package services;

import model.Performers;
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
    public List<Performers> getPermissions() {
        List<Performers> permissions = new ArrayList<>();
        List<String> lines = CSVUtils.read(PATH);
        for (String line : lines) {
            permissions.add(Performers.parsePermission(line));
        }
        return permissions;
    }

    @Override
    public Performers findById(int id) {
        List<Performers> permissions = getPermissions();
        for (Performers permission : permissions) {
            if (permission.getId() == id) {
                return permission;
            }
        }
        return null;
    }

    @Override
    public List<Performers> findByTaskId(long taskId) {
        List<Performers> result = new ArrayList<>();
        List<Performers> permissions = getPermissions();
        for (Performers permission : permissions) {
            if (permission.getTaskId() == taskId) {
                result.add(permission);
            }
        }
        return result;
    }

    @Override
    public void add(Performers newPermission) {
        List<Performers> permissions = getPermissions();
        permissions.add(newPermission);
        CSVUtils.write(PATH, permissions);
    }

    @Override
    public void update(Performers newPermission) {
        List<Performers> permissions = getPermissions();
        for (Performers permission : permissions) {
            if (permission.getId() == newPermission.getId()) {
                permission.setPermissionType(newPermission.getPermissionType());
                break;
            }
        }
        CSVUtils.write(PATH, permissions);
    }

    @Override
    public boolean existById(int id) {
        return findById(id) != null;
    }


}
