package ru.orehovai.easycar.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


@Entity(tableName = "users")
public class User {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @NonNull
    @ColumnInfo(name = "name")
    private String mUserName;
    @NonNull
    @ColumnInfo(name = "password")
    private String mPassword;

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String UserName) {
        this.mUserName = UserName;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String Password) {
        this.mPassword = Password;
    }
}
