package ru.orehovai.easycar.model;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("Select * from users")
    List<User> getUsers();

}
