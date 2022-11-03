package org.springframework.samples.petclinic.recoveryroom;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RecoveryRoomTypeFormatter implements Formatter<RecoveryRoomType>{

	RecoveryRoomService recoveryService;
	
    @Override
    public String print(RecoveryRoomType object, Locale locale) {
        return object.name;
    }

    @Override
    public RecoveryRoomType parse(String text, Locale locale) throws ParseException {
    	 RecoveryRoomType recoveryRoomType = recoveryService.getRecoveryRoomType(text);
         if (recoveryRoomType == null) {
             throw new ParseException("Recovery type not found: " + text, 0);
         }
         return recoveryRoomType;
     }
    
    
}
