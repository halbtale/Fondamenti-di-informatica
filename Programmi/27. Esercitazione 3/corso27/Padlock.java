package corso27;

public class Padlock {
    private String pw;
    private boolean locked = false;

    public Padlock() {
        pw = "0000";
    }

    public Padlock(String pw) {
        this.pw = pw;
    }

    public void open(String pw) {
        if (this.pw == pw)
            this.locked = false;
    }

    public void close() {
        this.locked = true;
    }

    public void setPasswd(String oldPw, String newPw) {
        if (oldPw == pw) {
            if (newPw == null || newPw == "") {
                newPw = "0000";
            }
            pw = newPw;
        }
    }

    public String toString() {
        if (locked) {
            return "Lock state: locked";
        } else {
            return "Lock state: open";
        }
    }
}
