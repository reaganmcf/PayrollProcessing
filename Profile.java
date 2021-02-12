public class Profile {
    private String name;
    private String department;
    private Date dateHired;

    public Profile(String name, String department, Date dateHired) {
        this.name = name;
        this.department = department;
        this.dateHired = dateHired;
    }

    public String getName() {
        return this.name;
    }

    public String getDepartment() {
        return this.department;
    }

    public Date getDateHired() {
        return this.dateHired;
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Profile) {
            Profile objAsProfile = (Profile) obj;
            if (objAsProfile.name.equals(this.name) && objAsProfile.department.equals(this.department)
                    && objAsProfile.dateHired.equals(this.dateHired)) {
                return true;
            }
        }
        return false;
    }
}