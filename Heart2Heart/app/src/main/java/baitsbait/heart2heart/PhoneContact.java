package baitsbait.heart2heart;

/**
 * Created by jessica2 on 2/20/16.
 */

/**
 * Created by theadoralau on 2/20/16.
 */
public class PhoneContact {
    private String name;
    private String number;

    public PhoneContact(String name, String number)
    {
        this.name=name;
        this.number = number;
    }

    public String getName()
    {
        return name;
    }
    public String getNumber()
    {
        return number;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }
}
