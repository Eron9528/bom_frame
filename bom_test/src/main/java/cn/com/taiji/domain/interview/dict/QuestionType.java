package cn.com.taiji.domain.interview.dict;

public enum QuestionType {

    JAVA("JAVA"),
    SPRING_BOOT("SPRINGBOOT"),
    SPRING_CLOUD("SPRINGCLOUD"),
    MYSQL("MYSQL"),
    SPRING("SPRING");

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
