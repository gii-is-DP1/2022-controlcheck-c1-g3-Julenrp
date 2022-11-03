package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer>{

    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);
    //List<RecoveryRoomType> findAllRecoveryRoomTypes();
    //RecoveryRoomType getRecoveryRoomType(String name);
    
//    @Query("SELECT r FROM RecoveryRoomService r")
//	List<RecoveryRoom> findAll();
    
    @Query("SELECT r FROM RecoveryRoomType r WHERE r.name = ?1")
    RecoveryRoomType findRecoveryRoomByName(String name);
    
    @Query("SELECT r FROM RecoveryRoomType r")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
}
