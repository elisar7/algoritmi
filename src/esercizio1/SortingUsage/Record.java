package SortingUsage;

public class Record {

    private int idField;
    private String field1 = null;
    private int field2;
    private float field3;

    public Record (int idField, String field1, int field2, float field3){
        this.idField = idField;
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
    }

    public int getIdField() {
        return idField;
    }

    public String getField1() {
        return field1;
    }

    public int getField2() {
        return field2;
    }

    public float getField3() {
        return field3;
    }

    public String toString() {
        return ("<" + idField + "," + field1 + "," +
                field2 + "," + field3 + ">\n");
    }

}