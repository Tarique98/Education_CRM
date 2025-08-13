package in.sp.main.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.sp.main.EducationCrmProjectApplication;
import in.sp.main.entities.User;
import in.sp.main.entities.user.UserRepository;

@Service
public class UserService 
{

    private final EducationCrmProjectApplication educationCrmProjectApplication;
	@Autowired
	private UserRepository userRepository;

    UserService(EducationCrmProjectApplication educationCrmProjectApplication) {
        this.educationCrmProjectApplication = educationCrmProjectApplication;
    }
	
	public void registerUserService(User user)
	{
		userRepository.save(user); 
	}
	
	public boolean loginUserService(String email,String password)
	{
		User user = userRepository.findByEmail(email);
		if(user!= null)
		{
			return password.equals(user.getPassword());
		}
		else
		{
			return false;
		}
	}
	
	
}
