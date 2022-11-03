package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.OwnerService;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {
	
	private final RecoveryRoomService recoveryService;
	
	 @Autowired
	    public RecoveryRoomController(RecoveryRoomService recoveryService) {
	        this.recoveryService = recoveryService;
	}
	 
	private static final String VIEWS_RECOVERY_ROOMS_CREATE_OR_UPDATE_RECOVERY_ROOM_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm.jsp";
	
	@ModelAttribute("recoveryRoomTypes")
    public List<RecoveryRoomType> populateRecoveryRoomTypes() {
        return this.recoveryService.getAllRecoveryRoomTypes();
    }
	
	@GetMapping(value="/create")
	public ModelAndView createRoom() {
	       	ModelAndView mav = new ModelAndView(VIEWS_RECOVERY_ROOMS_CREATE_OR_UPDATE_RECOVERY_ROOM_FORM);
	        mav.addObject("recovery_room", new RecoveryRoom());
	        return mav;
	   }
	
	@PostMapping("/create")
	public ModelAndView processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result) throws DuplicatedRoomNameException {
		ModelAndView mav;
	    if (result.hasErrors()) {
	       mav = new ModelAndView(VIEWS_RECOVERY_ROOMS_CREATE_OR_UPDATE_RECOVERY_ROOM_FORM);
	       mav.addObject("recovery_room", recoveryRoom);
	       mav.addObject("types", recoveryService.getAllRecoveryRoomTypes());
	        } else {
	            this.recoveryService.save(recoveryRoom);
	            mav = new ModelAndView("welcome");
	        }
	        return mav;
	    }
    
}
