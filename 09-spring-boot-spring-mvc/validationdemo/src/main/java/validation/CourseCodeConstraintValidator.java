package validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator  implements ConstraintValidator<CourseCode,String>{

    private String coursePrefix;


    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {
        if(theCode!=null)
            return theCode.toLowerCase().startsWith(coursePrefix.toLowerCase());
        else
            return true;
    }

    @Override
    public void initialize(CourseCode theCourseCode) {
        coursePrefix=theCourseCode.value();
    }
}
