package contacts.model.contact;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Contact implements Serializable {

    protected String name;
    protected PhoneNumber phoneNumber;
    protected LocalDateTime timeOfCreation;
    protected LocalDateTime timeOfLastEdit;


    protected Contact(String name, PhoneNumber phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.timeOfCreation = LocalDateTime.now();
        this.timeOfLastEdit = LocalDateTime.now();
    }

    public abstract String nameToString();

    public void setTimeOfLastEdit() {
        this.timeOfLastEdit = LocalDateTime.now();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setTimeOfCreation(LocalDateTime timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
    }

    public List<String> getEditableFields(){
       List<String> editableFields=new ArrayList<>();
       editableFields.add("name");
       editableFields.add("phoneNumber");
       return  editableFields;
    }

    public void editField(String fieldName,String fieldValue) throws InvocationTargetException, IllegalAccessException {
        Method method[]=this.getClass().getMethods();
        System.out.println(Arrays.toString(method));
    }
}
