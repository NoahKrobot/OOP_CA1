import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class MyTableModel implements TableModel
{
    public ArrayList<Activity> getActivities() {
        return activities;
    }

    public void setActivities(ArrayList<Activity> activities) {
        this.activities = activities;
    }

    ArrayList<Activity> activities;
    public MyTableModel(ArrayList<Activity> listOfActivities)
    {
        activities = listOfActivities;
    }


    @Override
    public int getRowCount() {
        return activities.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int columnIndex)
    {
        switch(columnIndex)
        {
            case 0:
                return "Type";
            case 1:
                return "Date";

            case 2:
                return "Distance";

            case 3:
                return "Duration";

            case 4:
                return "Heart Rate";

            case 5:
                return "Intensity";

            case 6:
                return "Calories Burned";

        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Activity act = activities.get(rowIndex);
        switch(columnIndex)
        {
            case 0:
                return act.getType_of_activity();
            case 1:
                return act.getDate();

            case 2:
                return act.getDistance_km();

            case 3:
                return act.getDuration_min();

            case 4:
                return act.getAvg_heart_rate();

            case 5:
                return act.getIntensity();

            case 6:
                return act.getCaloriesBurnt();

        }
        return "";
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
