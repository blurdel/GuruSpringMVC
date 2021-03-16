package guru.spring.services.mapservices;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import guru.spring.domain.DomainObject;
import guru.spring.domain.User;
import guru.spring.services.UserService;


@Service
@Profile("map")
public class UserServiceImpl extends AbstractMapService implements UserService {

	
	@Override
	public List<DomainObject> listAll() {
		return super.listAll();
	}
	
	@Override
	public User getById(Integer id) {
		return (User) super.getById(id);
	}

	@Override
	public User saveOrUpdate(User obj) {
		return (User) super.saveOrUpdate(obj);
	}

	@Override
    public void delete(Integer id) {
        super.delete(id);
    }
	
}
