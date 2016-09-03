package kr.huny.domain;

/**
 * Created by dhjang on 2016-08-23.
 */
public enum MembersEnum {
    LoginOK(1), NotUserID(-1), NotUserPWD(-2), PwdFailCount(-3), LoginBlock(-4);
    private int value;

    private MembersEnum(int value)
    {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }


}
