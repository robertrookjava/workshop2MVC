package blog.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Form1 {

    @Size(min = 2, max = 30, message = "Username size should be in the range [2...30]")
    private String invoer1;

    @NotNull
    @Size(min = 1, max = 50)
    private String invoer2;

    @NotNull
    @Size(min = 1, max = 50)
    private String invoer3;

    @NotNull
    @Size(min = 1, max = 50)
    private String invoer4;

    @NotNull
    @Size(min = 1, max = 50)
    private String invoer5;

    @NotNull
    @Size(min = 1, max = 50)
    private String invoer6;

    /**
     * @return the invoer1
     */
    public String getInvoer1() {
        return invoer1;
    }

    /**
     * @param invoer1 the invoer1 to set
     */
    public void setInvoer1(String invoer1) {
        this.invoer1 = invoer1;
    }

    /**
     * @return the invoer2
     */
    public String getInvoer2() {
        return invoer2;
    }

    /**
     * @param invoer2 the invoer2 to set
     */
    public void setInvoer2(String invoer2) {
        this.invoer2 = invoer2;
    }

    /**
     * @return the invoer3
     */
    public String getInvoer3() {
        return invoer3;
    }

    /**
     * @param invoer3 the invoer3 to set
     */
    public void setInvoer3(String invoer3) {
        this.invoer3 = invoer3;
    }

    /**
     * @return the invoer4
     */
    public String getInvoer4() {
        return invoer4;
    }

    /**
     * @param invoer4 the invoer4 to set
     */
    public void setInvoer4(String invoer4) {
        this.invoer4 = invoer4;
    }

    /**
     * @return the invoer5
     */
    public String getInvoer5() {
        return invoer5;
    }

    /**
     * @param invoer5 the invoer5 to set
     */
    public void setInvoer5(String invoer5) {
        this.invoer5 = invoer5;
    }

    /**
     * @return the invoer6
     */
    public String getInvoer6() {
        return invoer6;
    }

    /**
     * @param invoer6 the invoer6 to set
     */
    public void setInvoer6(String invoer6) {
        this.invoer6 = invoer6;
    }

}
