package com.sebastian.boot2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
interface CatRepository extends JpaRepository<Cat, Long> {

}