package HelloApp;

import org.omg.CORBA.ORB;

public class HelloImpl extends HelloPOA{
    private ORB orb;
    public void setORB(ORB orb_val) {
        orb = orb_val;
    }

    @Override
    public String sayHello() {
        return "hello from the other side~";
    }

    @Override
    public void shutdown() {
        orb.shutdown(false);
    }
}
