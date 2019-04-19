import com.service.RegisterCheckImp;

public class Test {
    public static void main(String [] args){
        RegisterCheckImp rc =  new RegisterCheckImp();
        int checknum = rc.checkUserRepeat("roostss","123456");
        System.out.println(checknum);
        if(checknum > 0){
            System.out.println("注册成功");
        }else {
            System.out.println("注册失败");
        }
    }
}
