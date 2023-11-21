package com.example.demoargela.Repositories;

import com.example.demoargela.Models.Role;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Long> {


    @Modifying
    @Query(
            value = "DELETE FROM user_role u WHERE u.role_id = ?1",nativeQuery = true)
    void DeleteRelation(Long roleId);
}
