package cn.com.taiji.domain.interview.dict;

public enum QuestionType {

    JAVA("JAVA"),
    SPRING("SPRING"),
    SPRING_BOOT("SPRINGBOOT"),
    SPRING_CLOUD("SPRINGCLOUD"),
    MYSQL("MYSQL");


    public String values;

    private QuestionType(String values)
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
