package com.isep.acme.repositories;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.isep.acme.controllers.ResourceNotFoundException;
import com.isep.acme.model.User;

import java.util.Optional;

@Repository
@CacheConfig(cacheNames = "users")
public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    @Caching(evict = {
            @CacheEvict(key = "#p0.userId", condition = "#p0.userId != null"),
            @CacheEvict(key = "#p0.username", condition = "#p0.username != null") })
    <S extends User> S save(S entity);

    @Override
    @Cacheable
    Optional<User> findById(Long userId);

    @Cacheable
    default User getById(final Long userId){
        final Optional<User> optionalUser = findById(userId);

        if(optionalUser.isEmpty()){
            throw new ResourceNotFoundException(User.class, userId);
        }
        if (!optionalUser.get().isEnabled()) {
            throw new ResourceNotFoundException(User.class, userId);
        }
        return optionalUser.get();
    }

    @Cacheable
    Optional<User> findByUsername(String username);


}