import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/users")
public class MyRestController {

    @RequestMapping(value="/{userId}", method=RequestMethod.GET)
    public User getUser(@PathVariable Long userId) {
    	User user = new User();
    	user.setUserName("admin");
    	user.setPassword("password");
    	
        return user;
    }

    @RequestMapping(value="/{user}/customers", method=RequestMethod.GET)
    List<Customer> getUserCustomers(@PathVariable Long user) {
        // ...

        return null;
    }

    @RequestMapping(value="/{user}", method=RequestMethod.DELETE)
    public User deleteUser(@PathVariable Long user) {
        // ...

        return null;
    }

}
