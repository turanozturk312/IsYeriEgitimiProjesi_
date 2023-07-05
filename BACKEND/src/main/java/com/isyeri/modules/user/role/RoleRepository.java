package com.isyeri.modules.user.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(collectionResourceRel = "roller",path = "roller")
@CrossOrigin
public interface RoleRepository extends JpaRepository<Role,Long> {
}
