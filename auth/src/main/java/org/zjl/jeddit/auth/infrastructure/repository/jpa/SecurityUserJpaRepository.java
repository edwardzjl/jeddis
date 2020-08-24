package org.zjl.jeddit.auth.infrastructure.repository.jpa;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Junlin Zhou
 */
@Repository
public interface SecurityUserJpaRepository extends JpaRepository<SecurityUserEntity, Long>, JpaSpecificationExecutor<SecurityUserEntity> {

    default Optional<SecurityUserEntity> findByUsername(String username) {
        Specification<SecurityUserEntity> spec = (Specification<SecurityUserEntity>) (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get(SecurityUserEntity_.username), username);
        return findOne(spec);
    }
}
