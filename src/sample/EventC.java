package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class EventC {
    private final SimpleStringProperty eventName;
    private final SimpleStringProperty eventDate;
    private final SimpleStringProperty eventTask;
    private final SimpleStringProperty taskTime;
    private final SimpleStringProperty taskNote;

    public EventC(String eventName, String eventDate, String eventTask, String taskTime,String taskNote) {
        this.eventName = new SimpleStringProperty(eventName);
        this.eventDate = new SimpleStringProperty(eventDate);
        this.eventTask = new SimpleStringProperty(eventTask);
        this.taskTime = new SimpleStringProperty(taskTime);
        this.taskNote = new SimpleStringProperty(taskNote);
    }

    public  String getEventName() { return eventName.get(); }
    public void setEventName(String tmpName) { eventName.set(tmpName); }

    public String getEventDate() { return eventDate.get(); }
    public void setEventDate(String tmpDate) { eventDate.set(tmpDate); }

    public  String getEventTask() { return eventTask.get(); }
    public void setEventTask(String tmpTask) { eventName.set(tmpTask); }


    public String getTaskTime() { return taskTime.get(); }
    public void setTaskTime(String tmpTime) { taskTime.set(tmpTime); }

    public String getTaskNote() { return taskNote.get(); }
    public void setTaskNote(String tmpNote) { taskNote.set(tmpNote); }

    public static TableView tblEvent = new TableView();
    public static ObservableList<EventC>eventData = FXCollections.observableArrayList(
    );

}



