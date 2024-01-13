CREAR SERVICIO BACKEND JAVA / APIC:

//UserController clase

@RestController
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
      this.userService = userService;
  }

 @GetMapping("/users")
 public Integer getUserId(@RequestHeader("username") String username) {
     return userService.getUserId(username);
 }
}


//UserService clase

@Service
public class UserService {
   private List<User> users = Arrays.asList(
       new User(1, "user1"),
       new User(2, "user2"),
       new User(3, "user3")
   );

   public Integer getUserId(String username) {
       return users.stream()
           .filter(user -> user.getUsername().equals(username))
           .map(User::getId)
           .findFirst()
           .orElse(null);
   }
}


//User clase
public class User {
   private Integer id;
   private String username;

   public User(Integer id, String username) {
       this.id = id;
       this.username = username;
   }

   public Integer getId() {
       return id;
   }

   public void setId(Integer id) {
       this.id = id;
   }

   public String getUsername() {
       return username;
   }

   public void setUsername(String username) {
       this.username = username;
   }
}
