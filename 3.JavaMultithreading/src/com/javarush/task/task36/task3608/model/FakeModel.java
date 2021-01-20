package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.Arrays;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();
    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setUsers(new ArrayList<User>(Arrays.asList(new User[]{
            new User("Test1",1,1), new User("Test2",2,1), new User("Test3",3,3),
                new User("Test4",126,3)
        })));
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException("Unsupported operation already");
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException("Unsupported operation already");
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException("Unsupported operation already");
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException("Unsupported operation already");
    }
}
