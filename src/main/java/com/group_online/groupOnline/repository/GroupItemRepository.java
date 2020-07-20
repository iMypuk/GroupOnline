package com.group_online.groupOnline.repository;

import com.group_online.groupOnline.model.GroupItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupItemRepository extends JpaRepository<GroupItem, Long> {

    List<GroupItem> findByUserUsername(String username);
}
