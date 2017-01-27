package org.beehyv.kartheek.util;

import org.beehyv.kartheek.model.FileBucket;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class FileValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		return FileBucket.class.isAssignableFrom(arg0);
	}
	
	@Override
	public void validate(Object obj, Errors errors) {
	        FileBucket file = (FileBucket) obj;
	         
	        if(file.getFile()!=null){
	            if (file.getFile().getSize() == 0) {
	                errors.rejectValue("file", "missing.file");
	            }
	        }
	    }

}
