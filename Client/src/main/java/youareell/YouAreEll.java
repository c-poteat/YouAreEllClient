package youareell;

import controllers.*;

public class YouAreEll {
    MessageController messageController;
    IdController idController;
    TransactionController tt;


    public YouAreEll (TransactionController t) {
        this.tt = t;
        this.messageController = t.getMsgCtrl();
        this.idController = t.getIdCtrl();
    }
    public YouAreEll (MessageController messageController, IdController idControllerr) {
        this.messageController = messageController;
        this.idController = idControllerr;

    }

    public static void main(String[] args) {
        // hmm: is this Dependency Injection?
        YouAreEll urlhandler = new YouAreEll(
            new TransactionController(
                new MessageController(), new IdController()
        ));
        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
        urlhandler.idController.getIds();
        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
    }

    private String MakeURLCall(String s, String get, String s1) {
    return "";
    }
    public String get_ids() {
        return tt.makecall("/ids", "GET", "");
    }

    public String get_messages() {
        return MakeURLCall("/messages", "GET", "");
    }


}
