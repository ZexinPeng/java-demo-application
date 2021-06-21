package client;

import HelloApp.Hello;
import HelloApp.HelloHelper;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public class HelloClient {
    static Hello helloImpl;
    public static void main(String args[]) {
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objRef =
                    orb.resolve_initial_references("NameService");
            NamingContextExt ncRef =
                    NamingContextExtHelper.narrow(objRef);
            helloImpl =
                    HelloHelper.narrow(ncRef.resolve_str("Hello"));
            System.out.println(helloImpl.sayHello());
            helloImpl.shutdown();
        } catch (InvalidName invalidName) {
            invalidName.printStackTrace();
        } catch (CannotProceed cannotProceed) {
            cannotProceed.printStackTrace();
        } catch (org.omg.CosNaming.NamingContextPackage.InvalidName invalidName) {
            invalidName.printStackTrace();
        } catch (NotFound notFound) {
            notFound.printStackTrace();
        }
    }
}
