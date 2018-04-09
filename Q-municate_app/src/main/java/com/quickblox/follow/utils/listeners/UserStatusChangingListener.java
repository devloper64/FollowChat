package com.quickblox.follow.utils.listeners;

public interface UserStatusChangingListener {

    void onChangedUserStatus(int userId, boolean online);
}