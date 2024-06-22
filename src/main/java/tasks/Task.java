package tasks;

import java.util.List;

public class Task {

    private String message;
    private List<Subtask> listSubtask;

    public void getMessage() {
        System.out.println(message);
        if(listSubtask != null) {
            for (Subtask st : listSubtask) st.getMessage();
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Subtask> getListSubtask() {
        return listSubtask;
    }

    public void setListSubtask(List<Subtask> listSubtask) {
        this.listSubtask = listSubtask;
    }
}
