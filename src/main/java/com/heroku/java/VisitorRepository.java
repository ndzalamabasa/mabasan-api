package com.heroku.java;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface VisitorRepository extends JpaRepository<Visitor, UUID> {
}
