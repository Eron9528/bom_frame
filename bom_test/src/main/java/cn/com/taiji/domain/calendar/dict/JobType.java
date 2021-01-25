package cn.com.taiji.domain.calendar.dict;

public enum JobType {
    R("年假"),
    LD("白班"),
    N("夜班"),
    C("分诊"),
    AL("修改"),
    T("培训"),
    DS("白班");

    public String values;

    private JobType(String values)
    {
        this.values = values;
    }

    public String getValues()
    {
        return values;
    }

    public String getName(){
        return super.name();
    }
}
