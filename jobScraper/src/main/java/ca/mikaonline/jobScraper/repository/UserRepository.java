package ca.mikaonline.jobScraper.repository;

import ca.mikaonline.jobScraper.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

/*
JpaRepository built-ins:

Optional<T> findById(ID id);  // Fetch entity by ID
List<T> findAll();  // Get all records
List<T> findAllById(Iterable<ID> ids);  // Get multiple records by IDs
T save(T entity);  // Insert or update entity
List<T> saveAll(Iterable<T> entities);  // Batch insert/update
void deleteById(ID id);  // Delete by ID
void delete(T entity);  // Delete an entity
void deleteAll();  // Delete all records
long count();  // Count total records
boolean existsById(ID id);  // Check if entity exists

List<T> findAll(Sort sort);  // Get all records sorted
Page<T> findAll(Pageable pageable);  // Paginated query

void flush();  // Force synchronization with the database
<T extends S> T saveAndFlush(T entity);  // Save and flush immediately
void deleteAllInBatch();  // Delete all in one batch operation
void deleteInBatch(Iterable<T> entities);  // Delete specific entities in batch

Derived:
List<T> findByField(String field);
List<T> findByFieldAndOtherField(String field, String otherField);
List<T> findByFieldOrOtherField(String field, String otherField);
Optional<T> findFirstByOrderByFieldDesc();

Custom Queries:
@Query("SELECT j FROM Job j WHERE j.title = ?1")
List<Job> findJobsByTitle(String title);

@Query(value = "SELECT * FROM jobs WHERE title = ?1", nativeQuery = true)
List<Job> findJobsByTitleNative(String title);

 */
