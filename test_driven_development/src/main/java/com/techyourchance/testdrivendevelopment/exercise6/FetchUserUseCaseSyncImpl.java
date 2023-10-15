package com.techyourchance.testdrivendevelopment.exercise6;

import com.techyourchance.testdrivendevelopment.exercise6.networking.FetchUserHttpEndpointSync;
import com.techyourchance.testdrivendevelopment.exercise6.networking.NetworkErrorException;
import com.techyourchance.testdrivendevelopment.exercise6.users.User;
import com.techyourchance.testdrivendevelopment.exercise6.users.UsersCache;

public class FetchUserUseCaseSyncImpl implements FetchUserUseCaseSync{

    private UsersCache mCache;
    private FetchUserHttpEndpointSync mFetchUserHttpEndpointSync;

    public FetchUserUseCaseSyncImpl(FetchUserHttpEndpointSync fetchUserHttpEndpointSync, UsersCache cache) {
        mCache = cache;
        mFetchUserHttpEndpointSync = fetchUserHttpEndpointSync;
    }

    @Override
    public UseCaseResult fetchUserSync(String userId) {
        User user = mCache.getUser(userId);
        if (user != null) {
            return new UseCaseResult(Status.SUCCESS, user);
        }
        else {
            FetchUserHttpEndpointSync.EndpointResult result;
            try {
                result = mFetchUserHttpEndpointSync.fetchUserSync(userId);
            } catch (NetworkErrorException e) {
                return new UseCaseResult(Status.NETWORK_ERROR, null);
            }
            if (result.getStatus() == FetchUserHttpEndpointSync.EndpointStatus.SUCCESS) {
                user = new User(result.getUserId(), result.getUsername());
                mCache.cacheUser(user);
                return new UseCaseResult(Status.SUCCESS, user);
            } else {
                return new UseCaseResult(Status.FAILURE, null);
            }
        }
    }
}
