package model;

public enum PermissionType {
    READ, UPDATE, DELETE;

    public static PermissionType parsePermissionType(int value) {
        for (PermissionType permissionType : values()) {
            if (permissionType.ordinal() == value)
                return permissionType;
        }
        throw new IllegalArgumentException(value + "permission type  invalid");
    }
}
