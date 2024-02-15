package com.assignment.repo;

import com.assignment.model.BookAudit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookAuditRepo extends MongoRepository<BookAudit, String> {
}
