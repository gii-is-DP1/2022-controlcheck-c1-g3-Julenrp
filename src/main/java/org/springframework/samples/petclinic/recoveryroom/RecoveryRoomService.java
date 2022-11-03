package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RecoveryRoomService {
	
	private final RecoveryRoomRepository recoveryRepository;
	
	@Autowired
	public RecoveryRoomService(RecoveryRoomRepository recoveryRepository) {
		this.recoveryRepository = recoveryRepository;
	}
	
    public List<RecoveryRoom> getAll(){
        return recoveryRepository.findAll();
    }

    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return recoveryRepository.findAllRecoveryRoomTypes();
    }

    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return recoveryRepository.findRecoveryRoomByName(typeName);
    }

    public RecoveryRoom save(RecoveryRoom p) throws DuplicatedRoomNameException {
        return recoveryRepository.save(p);       
    }
   

    
}
