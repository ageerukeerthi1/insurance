
import com.cg.dao.*;
import com.cg.exceptions.LoginAndCommonException;
import com.cg.model.UserRole;

public class test {

	public static void main(String[] args) throws LoginAndCommonException {
		
		AdminDAO ob=new AdminDAO();
		UserRole obj =new UserRole("tom","india12","agent");
		int a=ob.addUser(obj);
		System.out.println(a);
		boolean f=ob.isUserExists("krish");
		boolean g=ob.isUserExists("tom");
		System.err.println(f+" "+g);
		
		
		// TODO Auto-generated method stub

	}

}