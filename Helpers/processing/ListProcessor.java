package Helpers.processing;

import java.util.List;
import java.util.Collections;

public class ListProcessor {
    private List<Integer> column1;
    private List<Integer> column2;

    public ListProcessor(List<Integer> column1, List<Integer> column2){
        this.column1 = column1;
        this.column2 = column2;
    }

    public void sortLists(){
        if (sizeValidation()) {
            Collections.sort(this.column1);
            Collections.sort(this.column2);
        } else {
            System.err.println("The lists you are comparing are not of the same size");
        }
    }

    public List<Integer> getColumn1() {
        return column1;
    }

    public List<Integer> getColumn2() {
        return column2;
    }

    private Boolean sizeValidation() {
        return this.column1.size() == this.column2.size();
    }
}
