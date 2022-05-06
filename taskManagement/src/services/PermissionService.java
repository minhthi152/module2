package services;

import model.Performers;
import model.PermissionType;
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
    public List<Performers> getPerformers() {
        List<Performers> performers = new ArrayList<>();
        List<String> lines = CSVUtils.read(PATH);
        for (String line : lines) {
            performers.add(Performers.parsePermission(line));
        }
        return performers;
    }


    @Override
    public Performers findById(int id) {
        List<Performers> performers = getPerformers();
        for (Performers performer : performers) {
            if (performer.getId() == id) {
                return performer;
            }
        }
        return null;
    }

    @Override
    public List<Performers> findByTaskId(long taskId) {
        List<Performers> result = new ArrayList<>();
        List<Performers> performers = getPerformers();
        for (Performers performer : performers) {
            if (performer.getTaskId() == taskId) {
                result.add(performer);
            }
        }
        return result;
    }

    @Override
    public void add(Performers newPermission) {
        List<Performers> permissions = getPerformers();
        permissions.add(newPermission);
        CSVUtils.write(PATH, permissions);
    }

    @Override
    public void update(Performers newPermission) {
        List<Performers> permissions = getPerformers();
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


    public PermissionType findPermissionType(long taskId, String fullName){
        List<Performers> performers = findByTaskId(taskId);
        for (Performers performer : performers) {
            if (performer.getFullName().equals(fullName)) {
               return performer.getPermissionType();
            }
        }
        return null;
    }

    public boolean existByIdInEachTask(long taskId, int userId){
        List<Performers> performers = findByTaskId(taskId);
        for (Performers performer : performers) {
            if (performer.getUserId()==userId) {
                return true;
            }
        }
        return false;
    }


}
