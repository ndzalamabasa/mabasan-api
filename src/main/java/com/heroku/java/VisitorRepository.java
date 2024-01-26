package com.heroku.java;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface VisitorRepository extends CrudRepository<Visitor, UUID> {
}
