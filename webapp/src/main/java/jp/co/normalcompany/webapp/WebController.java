package jp.co.normalcompany.webapp;

import jp.co.normalcompany.library.entity.Person;
import jp.co.normalcompany.library.service.DBWrapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebController {

    DBWrapper dbWrapper;

    public WebController(DBWrapper dbWrapper) {
        this.dbWrapper = dbWrapper;
    }

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> restPersons(){
        System.out.println(dbWrapper.listPerson().toString());
        return dbWrapper.listPerson();
    }
}
